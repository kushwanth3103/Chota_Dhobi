package com.example.chotadhobi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.chotadhobi.studentHelper.COLUMN_MOB;
import static com.example.chotadhobi.studentHelper.DATABASE_NAME;
import static com.example.chotadhobi.studentHelper.DATABASE_VERSION;
import static com.example.chotadhobi.studentHelper.TABLE_NAME;

public class studentClothesHelper extends SQLiteOpenHelper
{
    public static final  int DATABASEC_VERSION=1;
    public static final String DATABASEC_NAME="studentclothesdb";
    public static final String TABLEC_NAME="studentclothesTable";
    public static final String COLUMNC_ID="idc";
    public static final String COLUMNC_REG="reg_no";
    public static final String COLUMNC_QAUNTITY="quantity_no";
    //public static final String COLUMNC_TIME="time";

    public studentClothesHelper(Context context) {
        super(context,DATABASEC_NAME,null,DATABASEC_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String CREATE_TABLE="CREATE TABLE "+ TABLEC_NAME +"("+ COLUMNC_ID +" INTEGER PRIMARY KEY,"+ COLUMNC_REG + " TEXT,"+ COLUMNC_QAUNTITY +" TEXT,"+ COLUMNC_TIME +" TEXT)";
        String CREATE_TABLE="CREATE TABLE "+ TABLEC_NAME +"("+ COLUMNC_ID +" INTEGER PRIMARY KEY,"+ COLUMNC_REG + " TEXT,"+ COLUMNC_QAUNTITY +" TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLEC_NAME);
        onCreate(db);
    }
    public void insertStudentClothes(String reg,String quantity)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMNC_REG,reg);
        values.put(COLUMNC_QAUNTITY,quantity);
        //values.put(COLUMNC_TIME,time);
        db.insert(TABLEC_NAME,null,values);
        db.close();
    }


    public List<String> getAllStudentsClothes()
    {
        List<String> list=new ArrayList<>();
        String selectQuery="SELECT * FROM "+TABLEC_NAME;
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
    /*public List<String> getTime()
    {
        List<String> time=new ArrayList<>();
        String selectQuery="SELECT * FROM "+ TABLEC_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if(cursor.moveToFirst())
        {
            do{
                time.add(cursor.getString(3));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return time;
    }*/

}
