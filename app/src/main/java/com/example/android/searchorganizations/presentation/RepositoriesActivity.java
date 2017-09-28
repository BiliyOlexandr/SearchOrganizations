package com.example.android.searchorganizations.presentation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.Repository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class RepositoriesActivity extends AppCompatActivity {

  private SearchPresenter searchPresenter = UsersActivity.searchPresenter;
  private RepositoryAdapter repositoryAdapter;
  private RecyclerView recyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repositories);
    recyclerView = (RecyclerView) findViewById(R.id.repo_recyclerView);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    String username = getIntent().getExtras().getString(UsersActivity.CLICKED_USER);

    searchPresenter.getRepositories(username)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(repositories -> {
          repositoryAdapter = new RepositoryAdapter(repositories);
          recyclerView.setLayoutManager(new LinearLayoutManager(this));
          recyclerView.setAdapter(repositoryAdapter);
        });
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
