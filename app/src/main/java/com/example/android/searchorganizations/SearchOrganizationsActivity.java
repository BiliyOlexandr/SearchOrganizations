package com.example.android.searchorganizations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchOrganizationsActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_organizations);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    findViewById(R.id.search_edit_text).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        getSupportActionBar().hide();
      }
    });
  }

}
