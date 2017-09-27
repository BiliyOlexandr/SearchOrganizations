package com.example.android.searchorganizations.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.example.android.searchorganizations.model.UserInfo;
import com.example.android.searchorganizations.model.api.GitHubApiClient;
import com.example.android.searchorganizations.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

  private UserAdapter userAdapter;
  private GitHubApiClient gitHubApiClient;
  private RecyclerView recyclerView;
  private List<UserInfo> cache;
  Disposable subscription;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_organizations);

    recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
    Button searchButton = (Button) findViewById(R.id.search_button);
    searchButton.setOnClickListener(view -> {
      cache = new ArrayList<>();
      gitHubApiClient = new GitHubApiClient();

      if(subscription != null){
        subscription.dispose();
      }
      subscription = gitHubApiClient.searchOrganization("faceboo3131311k1")
          .subscribeOn(Schedulers.newThread())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(userInfo -> {
        cache.add(userInfo);
        userAdapter.notifyItemInserted(cache.indexOf(userInfo));
      });

      userAdapter = new UserAdapter(cache);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(userAdapter);
    });
  }

}
