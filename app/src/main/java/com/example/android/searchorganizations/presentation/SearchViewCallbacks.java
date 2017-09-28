package com.example.android.searchorganizations.presentation;

import com.example.android.searchorganizations.model.UserInfo;

interface SearchViewCallbacks {
  void navigateToRepositories(String username);

  void notifyUserObtained(UserInfo userInfo);
}
