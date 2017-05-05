package com.example.android.newloginapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 31-01-2017.
 */
public class DataBaseHelperConnector extends SQLiteOpenHelper {


    private static final int Version =1;

    private static final String firstName="FIRST_NAME";
    private static final String lastName="LAST_NAME";
    private static final String email="EMAIL";
    private static final String phone="PHONE";
    private static final String address1="ADDRESS1";
    private static final String address2="ADDRESS2";
    private static final String username="USERNAME";
    private static final String password="PASSWORD";
    private static final String databaseName="FORM";
    private static final String tableName="USER_RECORDS";
    private static final String id = "ID";




    public DataBaseHelperConnector(Context context) {
        super(context, databaseName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSQL = "CREATE TABLE " + tableName + " (" + id +" INTEGER NOT NULL PRIMARY KEY, " + firstName +" TEXT, " + lastName
                + " TEXT, " +email + " TEXT, " + phone + " TEXT, " + address1 + " TEXT, " + address2 + " TEXT, " + username +" TEXT, " + password +" TEXT)";
        sqLiteDatabase.execSQL(createTableSQL);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addRecord(String firstname, String lastname, String emailAddress, String phones, String add1, String add2,String usename , String pass ) {
        String insertSQL = "INSERT INTO " + tableName + " (" + firstName + ", " + lastName + " ," + email + " ," + phone + " ," + address1 + " ," + address2 + "," + username + "," + password +")"
                + "VALUES" + " ('" + firstname + "', '" + lastname + "', '" + emailAddress + "', '" + phones + "', '" + add1 + "', '" + add2 + "','" + usename + "','" + pass + "')" ;
        SQLiteDatabase dataBase = this.getWritableDatabase();
        dataBase.execSQL(insertSQL);
        dataBase.close();
    }


    public List<String> getRecord(String uname, String pword) {
        List<String> recordList = new ArrayList<String>();
        SQLiteDatabase dataBase = this.getReadableDatabase();
        String getSQL = "SELECT * FROM " + tableName + " WHERE " + username + " = '" + uname + "' AND " + password + " = '" + pword + "'";
        Cursor cursor = dataBase.rawQuery(getSQL , null);
        cursor.moveToFirst();
        String fName = cursor.getString(1);
        String lName = cursor.getString(2);
        recordList.add(fName);
        recordList.add(lName);
        dataBase.close();
        return recordList;
    }



}
