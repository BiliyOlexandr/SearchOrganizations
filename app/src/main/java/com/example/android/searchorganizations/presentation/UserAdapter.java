package com.example.android.searchorganizations.presentation;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.User;
import com.squareup.picasso.Picasso;
import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

  private List<User> userList;
  Context context;

   static class ViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageUser;
    private final TextView nameUser;
    private final TextView locationUser;
    private final TextView blogUser;


     ViewHolder(View itemView) {
      super(itemView);
       imageUser  = (ImageView) itemView.findViewById(R.id.user_image_view);
       nameUser = (TextView) itemView.findViewById(R.id.user_name);
       locationUser = (TextView) itemView.findViewById(R.id.user_location);
       blogUser = (TextView) itemView.findViewById(R.id.user_blog);
    }
  }

  public UserAdapter(Context context, List<User> userList) {
    this.userList = userList;
    this.context = context;
  }

  @Override public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    CardView mCardCiew = (CardView) LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_user, parent, false);
    return new ViewHolder(mCardCiew);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    User currentUser = userList.get(position);
    Picasso.with(context)
        .load(currentUser.getPicture())
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(holder.imageUser);
    holder.nameUser.setText(currentUser.getName());
    holder.locationUser.setText(currentUser.getLocation());
    holder.blogUser.setText(currentUser.getBlog());
  }

  @Override public int getItemCount() {
    return userList.size();
  }
}
