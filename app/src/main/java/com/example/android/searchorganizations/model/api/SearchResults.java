package com.example.android.searchorganizations.model.api;

import com.example.android.searchorganizations.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SearchResults {

  @SerializedName("items") @Expose private List<User> mUsers = new ArrayList<>();

  public List<User> getmUsers() {
    return mUsers;
  }

  public void setmUsers(List<User> mUsers) {
    this.mUsers = mUsers;
  }
}
