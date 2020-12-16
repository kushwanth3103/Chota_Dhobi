package com.example.chotadhobi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class studentHelper extends SQLiteOpenHelper
{
    public static final  int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="studentdb";
    public static final String TABLE_NAME="studentTable";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_REG="reg";
    public static final String COLUMN_MOB="mob";


    public studentHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+ TABLE_NAME +"("+ COLUMN_ID +" INTEGER PRIMARY KEY,"+ COLUMN_REG + " TEXT,"+ COLUMN_MOB +" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertStudent(String reg,String mob)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_REG,reg);
        values.put(COLUMN_MOB,mob);
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public List<String> getAllStudents()
    {
        List<String> list=new ArrayList<>();
        String selectQuery="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do{
                list.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
    public List<String> getAllStudentsPass()
    {
        List<String> list=new ArrayList<>();
        String selectQuery="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do{
                list.add(cursor.getString(2));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }


}
