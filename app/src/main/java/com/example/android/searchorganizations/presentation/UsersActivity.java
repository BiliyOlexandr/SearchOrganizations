package com.example.android.searchorganizations.presentation;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.UserInfo;

public class UsersActivity extends AppCompatActivity implements SearchViewCallbacks {
  public static final String CLICKED_USER = "Clicked user";
  public static SearchPresenter searchPresenter; // The simplest singletone

  private UserAdapter userAdapter;
  private RecyclerView recyclerView;
  private ProgressBar progressBar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_organizations);

    EditText searchText = (EditText) findViewById(R.id.search_edit_text);

    searchPresenter = new SearchPresenter(this);
    userAdapter = new UserAdapter(searchPresenter);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);

    searchText.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
        String addStr = searchText.getText().toString();
        if (addStr.length() >= 3) {
          if (checkInternetConnection(UsersActivity.this)) {
            // Clear list for new search
            userAdapter.clear();
            searchPresenter.onStartSearching(addStr);
          } else {
            Snackbar.make(recyclerView, R.string.string_internet_connection_not_available,
                Snackbar.LENGTH_SHORT).show();
          }
        }
      }
      @Override public void afterTextChanged(Editable s) {
      }
    });
    recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(userAdapter);
  }

  // Transition in RepositoriesActivity
  @Override public void navigateToRepositories(String username) {
    Intent intent = new Intent(this, RepositoriesActivity.class);
    intent.putExtra(CLICKED_USER, username);
    startActivity(intent);
  }

  // Call addUser from UserAdapter
  @Override public void notifyUserObtained(UserInfo userInfo) {
    userAdapter.addUser(userInfo);
  }

  //Check whether internet connection is available or not
  public boolean checkInternetConnection(@NonNull Context context) {
    return ((ConnectivityManager) context.getSystemService(
        Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
  }

  // Set progressBar is visible
  @Override public void searchStarted() {
    progressBar.setVisibility(View.VISIBLE);
  }

  // Set progressBar is gone and notify user about loading stopped
  @Override public void searchStopped() {progressBar.setVisibility(View.GONE);}

  @Override public void onError(String errorText) {
    Snackbar.make(recyclerView, errorText, Snackbar.LENGTH_SHORT).show();
    searchStopped();
  }
}
