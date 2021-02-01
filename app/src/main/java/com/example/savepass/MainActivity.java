package com.example.savepass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin")&&
                password.getText().toString().equals("admin")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                      MainActivity.this
                    );
                    builder.setIcon(R.drawable.ic_baseline_check_24);
                    builder.setTitle("Login Succes");
                    builder.setMessage("Welocme to SavePass");

                    builder.setNegativeButton("Next", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            addPassword();
                        }

                    });
                    AlertDialog alertDialog =  builder.create();
                    alertDialog.show();

                }else{
                    Toast.makeText(getApplicationContext(),"Invaild Username or Password",Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void addPassword(){
        Intent intent = new Intent(this, addPassword.class);
        startActivity(intent);
    }
}