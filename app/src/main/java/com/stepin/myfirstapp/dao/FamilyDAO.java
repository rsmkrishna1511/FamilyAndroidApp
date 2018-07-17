package com.stepin.myfirstapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.stepin.myfirstapp.model.Family;

import java.util.ArrayList;
import java.util.List;

public class FamilyDAO extends SQLiteOpenHelper {

    public FamilyDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "familyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.print("DB Creating...");
        String sql = "CREATE TABLE family (" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT Not Null," +
                "address TEXT," +
                "website TEXT," +
                "email TEXT," +
                "phone INTEGER," +
                "rating REAL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Family> getFamilyDtl(){
        List<Family> familyList = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from family", null);

        while(cursor.moveToNext()){
            System.out.print("DB Fetcing...");
            Integer id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String website = cursor.getString(cursor.getColumnIndex("website"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            Integer phone = cursor.getInt(cursor.getColumnIndex("phone"));
            Double rating = Double.valueOf(cursor.getFloat(cursor.getColumnIndex("rating")));

            Family family = new Family(id, name, email, website, phone, address, rating);
            familyList.add(family);
        }

        return familyList;
    }

    public void insert(Family family){
        System.out.print("DB Inserting...");
        SQLiteDatabase database = getWritableDatabase();
        database.insert("family",null,family.getContent());
    }

    public void remove(Family selected) {
        SQLiteDatabase database = getWritableDatabase();

        String[] ids = {selected.getId()+""};
        database.delete("family","id = ?",ids);
    }
}
