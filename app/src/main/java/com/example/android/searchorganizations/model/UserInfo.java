package com.example.android.searchorganizations.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

  @SerializedName("login") @Expose private String mLogin;
  @SerializedName("name") @Expose private String mName;
  @SerializedName("location") @Expose private String mLocation;
  @SerializedName("blog") @Expose private String mBlog;
  @SerializedName("avatar_url") @Expose private String mPicture;

  public UserInfo(String mLogin, String mName, String mLocation, String mBlog, String mPicture) {
    this.mLogin = mLogin;
    this.mName = mName;
    this.mLocation = mLocation;
    this.mBlog = mBlog;
    this.mPicture = mPicture;
  }

  public String getLogin() {
    return mLogin;
  }

  public String getLocation() {
    return mLocation;
  }

  public String getBlog() {
    return mBlog;
  }

  public String getPicture() {
    return mPicture;
  }

  @Override public String toString() {
    return mLogin;
  }

  public String getName() {
    return mName;
  }
}
