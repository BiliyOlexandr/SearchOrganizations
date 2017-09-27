package com.example.android.searchorganizations.presentation;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.api.GitHubApiClient;

public class RepositoriesActivity extends AppCompatActivity {

  private RepositoryAdapter repositoryAdapter;
  private GitHubApiClient gitHubApiClient;
  private RecyclerView recyclerView;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repositories);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
    }
  }
}
