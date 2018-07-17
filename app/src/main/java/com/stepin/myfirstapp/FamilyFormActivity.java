package com.stepin.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.stepin.myfirstapp.dao.FamilyDAO;
import com.stepin.myfirstapp.helper.ActivityHelper;
import com.stepin.myfirstapp.model.Family;

public class FamilyFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_family_form,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.Family_from_confirm){

            ActivityHelper actHelper = new ActivityHelper(this);
            Family family = actHelper.getFamilyInst();

            FamilyDAO familyDAO = new FamilyDAO(this,null ,null, 1);
            familyDAO.insert(family);

            Toast.makeText(FamilyFormActivity.this,"'"+ family.getfName()+
                    "' Info Saved "+family.getRating(),Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
