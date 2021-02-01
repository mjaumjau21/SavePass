package com.example.savepass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class addPassword extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton btnDodaj;

    DBHelper dbHelper;
    ArrayList<String> _id,aplikacija,url,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        recyclerView = findViewById(R.id.ryc);
        btnDodaj = findViewById(R.id.btnDodaj);
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addPassword.this,DodajForm.class);
                startActivity(intent);
            }
        });

        dbHelper = new DBHelper(addPassword.this);

        _id = new ArrayList<>();
        aplikacija = new ArrayList<>();
        url = new ArrayList<>();
        email= new ArrayList<>();
        password = new ArrayList<>();
    }
    void  displayData(){
        Cursor cursor = dbHelper.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"Nema podataka",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                _id.add(cursor.getString(0));
                aplikacija.add(cursor.getString(1));
                url.add(cursor.getString(2));
                email.add(cursor.getString(3));
                password.add(cursor.getString(4));
            }
        }
    }
}