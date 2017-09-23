package com.example.android.searchorganizations.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("name") @Expose private String mName;
  @SerializedName("location") @Expose private String mLocation;
  @SerializedName("blog") @Expose private String mBlog;
  @SerializedName("picture") @Expose private String mPicture;

  public  User(String mName, String mLocation, String mBlog, String mPicture){
    this.mName = mName;
    this.mLocation = mLocation;
    this.mBlog = mBlog;
    this.mPicture = mPicture;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    this.mName = name;
  }

  public String getLocation() {
    return mLocation;
  }

  public void setLocation(String location) {
    this.mLocation = location;
  }

  public String getBlog() {
    return mBlog;
  }

  public void setBlog(String blog) {
    this.mBlog = blog;
  }

  public String getPicture() {
    return mPicture;
  }

  public void setPicture(String picture) {
    this.mPicture = picture;
  }

}
