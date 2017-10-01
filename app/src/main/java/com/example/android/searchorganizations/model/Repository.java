package com.example.android.searchorganizations.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {

  @SerializedName("name") @Expose private String mName;
  @SerializedName("description") @Expose private String mDescription;

  public Repository(String mName, String mDescription) {
    this.mName = mName;
    this.mDescription = mDescription;
  }

  public String getName() {
    return mName;
  }

  public String getDescription() {
    return mDescription;
  }
}
