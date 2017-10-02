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

  // Get observable to receive it in RepositoriesActivity
  Observable<List<Repository>> getRepositories(String username) {
    return gitHubApiClient.getRepositories(username);
  }

  // Method for obtaining the userInfo
  void onStartSearching(String searchText) {

    viewCallbacks.searchStarted();

    if (searchSubscription != null) {
      searchSubscription.dispose();
    }

    searchSubscription = gitHubApiClient.searchOrganization(searchText)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(userInfo -> viewCallbacks.notifyUserObtained(userInfo),
            throwable -> viewCallbacks.onError(throwable.getMessage()),
            () -> {
              // Notify view about search stopped.
              viewCallbacks.searchStopped();
            });
  }

  // Transition in RepositoriesActivity
  void onUserClicked(String name) {
    viewCallbacks.navigateToRepositories(name);
  }
}