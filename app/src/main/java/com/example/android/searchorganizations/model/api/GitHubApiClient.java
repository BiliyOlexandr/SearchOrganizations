package com.example.android.searchorganizations.model.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubApiClient {
  public static final String URL = "https://api.github.com/";

  private static Retrofit getRetrofitInstance(){
    return new Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static GitHubApi getGitHubApi(){
    return getRetrofitInstance().create(GitHubApi.class);
  }

}
