package com.example.android.searchorganizations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SearchOrganizationsActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_organizations);
    EditText myEditText = (EditText) findViewById(R.id.search_edit_text);


  }

}
  //getSupportActionBar().show();
