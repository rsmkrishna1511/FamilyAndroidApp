package com.stepin.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.stepin.myfirstapp.dao.FamilyDAO;
import com.stepin.myfirstapp.model.Family;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForContextMenu(getListView());

        Button addMember = findViewById(R.id.main_list_addMember);
        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(MainActivity.this, FamilyFormActivity.class);
                startActivity(intention);
            }
        });

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> familyList, View view, int position, long id) {
                    Family family = (Family) familyList.getItemAtPosition(position);

                    Intent intention = new Intent(MainActivity.this, FamilyFormActivity.class);
                    intention.putExtra("family", family);
                    startActivity(intention);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFamilyInfo();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo listViewAdap = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Family selected = (Family) getListView().getItemAtPosition(listViewAdap.position);

        MenuItem removeItem = menu.add("Remove");
        removeItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FamilyDAO familyDAO = new FamilyDAO(MainActivity.this,null, null, 1);
                familyDAO.remove(selected);
                familyDAO.close();
                loadFamilyInfo();
                Toast.makeText(MainActivity.this, selected.getfName()+" removed",Toast.LENGTH_SHORT)
                        .show();
                return true;
            }
        });

        MenuItem editItem = menu.add("Edit");
        editItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Edit Selected",Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    private ListView getListView(){
        ListView familyView = findViewById(R.id.Family_View);
        return familyView;
    }

    private void loadFamilyInfo(){
        List<Family> familyList = new ArrayList<>();
        FamilyDAO familyDAO = new FamilyDAO(this,null, null, 1);
        familyList.addAll(familyDAO.getFamilyDtl());
        familyDAO.close();

        ArrayAdapter<Family> listFamilyAdaptor =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,familyList );

        getListView().setAdapter(listFamilyAdaptor);
    }
}
