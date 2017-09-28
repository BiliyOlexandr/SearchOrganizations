package com.example.android.searchorganizations.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.UserInfo;

public class UsersActivity extends AppCompatActivity implements SearchViewCallbacks {
  public static final String CLICKED_USER = "Clicked user";
  public static SearchPresenter searchPresenter; // the simplest singletone

  private UserAdapter userAdapter;
  private RecyclerView recyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_organizations);
    Button searchButton = (Button) findViewById(R.id.search_button);

    searchPresenter = new SearchPresenter(this);
    userAdapter = new UserAdapter(searchPresenter);

    searchButton.setOnClickListener(view -> {
      // Clear list for new search
      userAdapter.clear();
      searchPresenter.onStartSearching("twit");
    });

    recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(userAdapter);
  }

  @Override public void navigateToRepositories(String username) {
    Intent intent = new Intent(this, RepositoriesActivity.class);
    intent.putExtra(CLICKED_USER, username);
    startActivity(intent);
  }

  @Override public void notifyUserObtained(UserInfo userInfo) {
    userAdapter.addUser(userInfo);
  }
}
