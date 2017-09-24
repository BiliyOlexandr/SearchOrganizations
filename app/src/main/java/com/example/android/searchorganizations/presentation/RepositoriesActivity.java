package com.example.android.searchorganizations.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.searchorganizations.R;

public class RepositoriesActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_repositories);
    getActionBar().show();
  }
}
