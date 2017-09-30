package com.example.android.searchorganizations.presentation;

import com.example.android.searchorganizations.model.UserInfo;

interface SearchViewCallbacks {

  // Method fot transition in RepositoriesActivity
  void navigateToRepositories(String username);

  // Method for call addUser from UserAdapter
  void notifyUserObtained(UserInfo userInfo);

  void searchStarted();

  void searchStopped();



}
