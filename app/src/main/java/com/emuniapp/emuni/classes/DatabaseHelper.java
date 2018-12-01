package com.emuniapp.emuni.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String TABLE_NAME1 = "catogory_table";
    public static final String TABLE_NAME2 = "product_table";
    public static final String COL_t1 = "ID";
    public static final String COL_t2 = "NAME";
    public static final String COL_t3 = "DECRIPTION";

    public static final String COLtab2_t1 = "ID";
    public static final String COLtab2_t2 = "NAME";
    public static final String COLtab2_t3 = "PRICE";
    public static final String COLtab2_t4 = "PRODUCTNUMBER";








    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
        db.execSQL("create table " + TABLE_NAME1 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DECRIPTION  TEXT)");
        db.execSQL("create table " + TABLE_NAME2+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE TEXT,PRODUCTNUMBER TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);

        onCreate(db);
    }

    public boolean insertcatogoryData(String name,String desc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_t2,name);
        contentValues.put(COL_t3,desc);
        long result = db.insert(TABLE_NAME1,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertproductData(String name,String price,String productnumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLtab2_t2,name);
        contentValues.put(COLtab2_t3,price);
        contentValues.put(COLtab2_t4,productnumber);

        long result = db.insert(TABLE_NAME2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    public boolean insertData(String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Cursor getAllcatData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1,null);
        return res;
    }
    public Cursor getAllproductData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }
    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

/*
public ArrayList getAllrecords(){
ArrayList arrayList=new ArrayList();
SQLiteDatabase db=this.getReadableDatabase();
    Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
res.moveToFirst();
while (res.isAfterLast()==false){
    arrayList.add(res.getString(res))


}


}*/

}
