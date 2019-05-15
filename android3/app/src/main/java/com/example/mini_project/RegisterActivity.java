package com.example.mini_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Data.DBManagement;
import Model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText username, password, birthday, name;
    private Button register;
    private  DBManagement db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
        db = new DBManagement(this);
        username = findViewById(R.id.et_reg_username);
        password = findViewById(R.id.et_reg_password);
        birthday = findViewById(R.id.et_reg_birth);
        name = findViewById(R.id.et_name);
        register= findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addUser(new User(username.getText().toString(),password.getText().toString(),birthday.getText().toString(),name.getText().toString()));
                Toast.makeText(RegisterActivity.this,"Add complete",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
