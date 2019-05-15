package com.example.mini_project.Service;

import com.example.mini_project.Model.AllUser;
import com.example.mini_project.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("dev")
    Call<List<AllUser>> getUsers();
}
