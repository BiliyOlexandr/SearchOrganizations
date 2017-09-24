package com.example.android.searchorganizations.model.api;

import com.example.android.searchorganizations.model.Organization;
import com.example.android.searchorganizations.model.Repository;
import com.example.android.searchorganizations.model.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubApi {

  @GET("/search/users") Observable<SearchResult<Organization>> getUsers(
      @Query("per_page") int userOnPage,
      @Query("q") String... filtersQuery); // each string represents search filter

  @GET("/users/{username}") Observable<UserInfo> getUserInfo(@Path("username") String username);

  @GET("/users/{username}/repos") Observable<SearchResult<Repository>> getUserRepositories(
      @Path("username") String username);
}
