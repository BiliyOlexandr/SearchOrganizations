package com.example.android.searchorganizations.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

class SearchResult<T> {

  // This class needs for get list of Users
  @SerializedName("items") @Expose private List<T> mItems = new ArrayList<>();

  List<T> getItems() {
    return mItems;
  }
}
