package com.example.mini_project.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mini_project.Model.AllUser;
import com.example.mini_project.R;
import com.example.mini_project.Service.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextView tvRegister, tvResult;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
        tvResult = findViewById(R.id.tv_result);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(i);

            }
        });
    }

    private void userLogin() {


        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

//        Api api = Service.getService();
//        Call<List<AllUser>> call = Api.getUsers();
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://localhost:3010/api/dev/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        Api api = retrofit.create(Api.class);
        Call<List<AllUser>> call = api.getUsers();

        call.enqueue(new Callback<List<AllUser>>() {
            @Override
                public void onResponse(Call<List<AllUser>> call, Response<List<AllUser>> response) {

                    if(!response.isSuccessful()){
                        tvResult.setText("Code: " + response.code());
                        return;
                    }

                    List<AllUser> allUsers = response.body();

                    for (AllUser alluser : allUsers){
                        String content =" ";
                        content += "username: " + alluser.getUsername() + "\n";
                        content += "password: " + alluser.getPassword() + "\n";
                        content += "fullname: " + alluser.getFullname() + "\n";
                        content += "birth: " + alluser.getBirth() + "\n";

                        tvResult.append(content);
                    }
            }

            @Override
            public void onFailure(Call<List<AllUser>> call, Throwable t) {
                  tvResult.setText(t.getMessage());
            }
        });


        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }


    }
}
