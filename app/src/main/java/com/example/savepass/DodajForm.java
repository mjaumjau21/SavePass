package com.example.savepass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DodajForm extends AppCompatActivity {

    EditText aplikacija,url,email,password;
    Button button_dodaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_form);

        aplikacija = findViewById(R.id.aplikacija);
        url = findViewById(R.id.url);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        button_dodaj = findViewById(R.id.button_dodaj);
        button_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(DodajForm.this);
                dbHelper.dodajAplikaciju(
                        aplikacija.getText().toString().trim(),
                        url.getText().toString().trim(),
                        email.getText().toString().trim(),
                        password.getText().toString().trim());
            }
        });
    }
}