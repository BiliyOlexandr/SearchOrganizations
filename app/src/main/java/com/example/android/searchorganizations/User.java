package com.example.android.searchorganizations;

public class User {

  private String name;
  private String location;
  private String blog;
  private String picture;

  public  User(String name, String location, String blog, String picture){
    this.name = name;
    this.location = location;
    this.blog = blog;
    this.picture = picture;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

}
