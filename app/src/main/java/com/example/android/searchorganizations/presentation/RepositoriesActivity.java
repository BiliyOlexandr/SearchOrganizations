package com.example.android.searchorganizations.presentation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.Repository;
import com.example.android.searchorganizations.model.api.GitHubApiClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class RepositoriesActivity extends AppCompatActivity {

  private RepositoryAdapter repositoryAdapter;
  private GitHubApiClient gitHubApiClient;
  private RecyclerView recyclerView;
  private List<Repository> cache;
  Disposable subscription;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repositories);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    recyclerView = (RecyclerView)findViewById(R.id.repo_recyclerView);
    cache = new ArrayList<>();
    gitHubApiClient = new GitHubApiClient();
    String username = getIntent().getExtras().getString(UsersActivity.CLICKED_USER);

    if(subscription != null){
      subscription.dispose();
    }

    subscription = gitHubApiClient.getRepositories(username)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(repository -> {
          for(int i = 0; i < repository.size(); i++){
            cache.add(repository.get(i));
          }
          Log.e("oshibka", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + cache.size());
          repositoryAdapter.notifyDataSetChanged();
    });

    repositoryAdapter = new RepositoryAdapter(cache);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(repositoryAdapter);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
    switch (item.getItemId()){
      case android.R.id.home:
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
