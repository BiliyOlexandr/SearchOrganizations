package com.example.android.searchorganizations.presentation;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.example.android.searchorganizations.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RepositoriesActivity extends AppCompatActivity {

  private SearchPresenter searchPresenter = UsersActivity.searchPresenter;
  private RepositoryAdapter repositoryAdapter;
  private RecyclerView recyclerView;
  private int repositoryCount = 0;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repositories);
    recyclerView = (RecyclerView) findViewById(R.id.repo_recyclerView);

    // Add nome button and set title to actionbar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle("Repositories " + "(" + repositoryCount + ")");
    }

    // Get position of selected user
    String username = getIntent().getExtras().getString(UsersActivity.CLICKED_USER);

    // Get list of Repositories
    searchPresenter.getRepositories(username)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(repositories -> {
          if (repositories.size() > 0) {
            repositoryCount = repositories.size();
            repositoryAdapter = new RepositoryAdapter(repositories);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(repositoryAdapter);
            repositoryCount = repositories.size();
            actionBar.setTitle("Repositories " + "(" + repositoryCount + ")");
          } else {
            Snackbar.make(recyclerView, R.string.string_no_any_repository, Snackbar.LENGTH_SHORT)
                .show();
            actionBar.setTitle("Repositories " + "(" + repositoryCount + ")");
          }
        });
  }

  // Return to home activity
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
