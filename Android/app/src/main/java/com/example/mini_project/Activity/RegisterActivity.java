package com.example.mini_project.Activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.mini_project.Data.DBManagement;
import com.example.mini_project.Model.MySingleton;
import com.example.mini_project.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText Username, Password, Birth;
    private EditText Fullname;
    private Button register_btn;
    private DBManagement db;
    String username, password, birth, fullname;

    String URL_POST = "http://192.168.1.23:3010/api/dev/insert";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Username = findViewById(R.id.et_reg_username);
        Password = findViewById(R.id.et_reg_password);
        Birth = findViewById(R.id.et_reg_birth);
        Fullname = findViewById(R.id.et_name);
        register_btn = findViewById(R.id.btn_register);

        db = new DBManagement(this);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = Username.getText().toString();
                password = Password.getText().toString();
                fullname = Fullname.getText().toString();
                birth = Birth.getText().toString();


                JSONObject postparam = new JSONObject();
                try {
                    postparam.put("username", "username");
                    postparam.put("password", "password");
                    postparam.put("fullname", "fullname");
                    postparam.put("birth", "birth");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL_POST, postparam, new Response.Listener()
//                    @Override
//                    public void onResponse(Object response) {
//
//                    }, new Response.ErrorListener(){
//                        @Override
//                                public void onErrorResponse(VolleyError error){
//
//                        }
//                    }
//                    {
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//                            Map<String, String> params = new HashMap<String, String>();
//                            params.put("username", username);
//                            params.put("password", password);
//                            params.put("fullname", fullname);
//                            params.put("birth", birth);
//                            return params;
//                        }
//                    };
//                  MySingleton.getInstance(RegisterActivity.this).addToRequestqueue();
//            }
//      });
//    }

