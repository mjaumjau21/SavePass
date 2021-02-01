package com.example.savepass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.SQLDataException;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="database.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tablica";
    private static final String COLMUN_ID = "_id";
    private static final String COLMUN_APLIKACIJA = "aplikacija";
    private static final String COLMUN_URL = "url";
    private static final String COLMUN_EMAIL = "email";
    private static final String COLMUN_PASSWORD = "password";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String query =
                 "CREATE TABLE " + TABLE_NAME +
                         " ("+ COLMUN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            COLMUN_APLIKACIJA + " TEXT, " +
                            COLMUN_URL + " TEXT, " +
                            COLMUN_EMAIL + " TEXT, " +
                            COLMUN_PASSWORD + " TEXT); " ;
         db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    void dodajAplikaciju(String aplikacija,String url, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLMUN_APLIKACIJA, aplikacija);
        cv.put(COLMUN_URL, url);
        cv.put(COLMUN_EMAIL, email);
        cv.put(COLMUN_PASSWORD, password);
         long result = db.insert(TABLE_NAME,null,cv);
         if(result == -1){
             Toast.makeText(context, "Neuspješno spremanje",Toast.LENGTH_SHORT).show();
         }else {
             Toast.makeText(context,"Uspješno spremanje", Toast.LENGTH_SHORT).show();
         }


    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
