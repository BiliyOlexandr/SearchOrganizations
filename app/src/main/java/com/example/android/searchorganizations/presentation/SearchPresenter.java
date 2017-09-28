package com.example.android.searchorganizations.presentation;

import com.example.android.searchorganizations.model.Repository;
import com.example.android.searchorganizations.model.api.GitHubApiClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

class SearchPresenter {

  private SearchViewCallbacks viewCallbacks;
  private Disposable searchSubscription;
  private GitHubApiClient gitHubApiClient;

  SearchPresenter(SearchViewCallbacks viewCallbacks) {
    this.viewCallbacks = viewCallbacks;
    gitHubApiClient = new GitHubApiClient();
  }

  Observable<List<Repository>> getRepositories(String username) {
    return gitHubApiClient.getRepositories(username);
  }

  void onStartSearching(String searchText) {
    if (searchSubscription != null) {
      searchSubscription.dispose();
    }
    searchSubscription = gitHubApiClient.searchOrganization(searchText)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userInfo -> viewCallbacks.notifyUserObtained(userInfo),
            Throwable::printStackTrace);
  }

  void onUserClicked(String name) {
    viewCallbacks.navigateToRepositories(name);
  }
}