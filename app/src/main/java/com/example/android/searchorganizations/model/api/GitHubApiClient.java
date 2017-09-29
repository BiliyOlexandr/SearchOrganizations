package com.example.android.searchorganizations.model.api;

import com.example.android.searchorganizations.model.Repository;
import com.example.android.searchorganizations.model.UserInfo;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubApiClient {
  private static final String URL = "https://api.github.com/";

  private static final String ORGANIZATION_FILTER = "type:organization";
  private static final int DEFAULT_ITEMS_ON_PAGE = 3; // Limit caused by github requests limit

  private GitHubApi mApiInterface;

  public GitHubApiClient() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    mApiInterface = retrofit.create(GitHubApi.class);
  }

  public PublishSubject<UserInfo> searchOrganization(String searchText) {
    PublishSubject<UserInfo> userObserver = PublishSubject.create();

    // Parse users info using userinfo request
    mApiInterface.getUsers(DEFAULT_ITEMS_ON_PAGE, ORGANIZATION_FILTER + "+" + searchText)
        .subscribeOn(Schedulers.newThread())
        .subscribe(searchResult ->
            Observable.range(0, searchResult.getItems().size())
            .flatMap(position -> mApiInterface.getUserInfo( // fetching user information
                searchResult.getItems().get(position).getLogin()))
            // Notify subscribers about each parsed user
            .subscribe(userObserver::onNext, userObserver::onError, userObserver::onComplete));

    return userObserver;
  }

  public Observable<List<Repository>> getRepositories(String login) {
    return mApiInterface.getUserRepositories(login);
  }

}
