package com.example.android.searchorganizations.model.api;

import com.example.android.searchorganizations.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubApi {

@GET("/search/users") Call<User> getUsers();
}
