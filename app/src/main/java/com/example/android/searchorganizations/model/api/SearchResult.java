package com.example.android.searchorganizations.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SearchResult<T> {

  @SerializedName("items") @Expose private List<T> mItems = new ArrayList<>();

  public List<T> getItems() {
    return mItems;
  }
}
