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

  public void setName(String name) {
    this.mName = name;
  }

  public String getDescription() {
    return mDescription;
  }

  public void setDescription(String description) {
    this.mDescription = description;
  }
}
