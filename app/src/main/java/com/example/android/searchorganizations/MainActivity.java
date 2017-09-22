package com.example.android.searchorganizations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    EditText myEditText = (EditText) findViewById(R.id.search_edit_text);

  }


}
  //getSupportActionBar().show();
//getSupportActionBar().hide();