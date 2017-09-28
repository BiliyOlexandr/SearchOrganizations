package com.example.android.searchorganizations.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.UserInfo;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {

  private List<UserInfo> userList;
  private SearchPresenter searchPresenter;

  UserAdapter(SearchPresenter searchPresenter) {
    userList = new ArrayList<>();
    this.searchPresenter = searchPresenter;
  }

  @Override public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
    return new UsersViewHolder(view);
  }

  @Override public void onBindViewHolder(UsersViewHolder holder, int position) {
    UserInfo currentUser = userList.get(position);
    Picasso.with(holder.itemView.getContext())
        .load(currentUser.getPicture())
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(holder.imageUser);
    holder.nameUser.setText(currentUser.getName());
    holder.locationUser.setText(currentUser.getLocation());
    holder.blogUser.setText(currentUser.getBlog());

    holder.itemView.setOnClickListener(v -> {
      if (searchPresenter != null) {
        searchPresenter.onUserClicked(currentUser.getName());
      }
    });
  }

  @Override public int getItemCount() {
    return userList.size();
  }

  void addUser(UserInfo userInfo) {
    userList.add(userInfo);
    notifyItemInserted(userList.indexOf(userInfo));
  }

  void clear() {
    userList.clear();
  }

  static class UsersViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageUser;
    private final TextView nameUser;
    private final TextView locationUser;
    private final TextView blogUser;

    UsersViewHolder(View itemView) {
      super(itemView);
      imageUser = (ImageView) itemView.findViewById(R.id.user_image_view);
      nameUser = (TextView) itemView.findViewById(R.id.user_name);
      locationUser = (TextView) itemView.findViewById(R.id.user_location);
      blogUser = (TextView) itemView.findViewById(R.id.user_blog);
    }
  }
}
