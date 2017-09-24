package com.example.android.searchorganizations.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.searchorganizations.R;
import com.example.android.searchorganizations.model.Repository;
import java.util.List;

class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {

  private List<Repository> repositoryList;

  public RepositoryAdapter(List<Repository> repositoryList) {
    this.repositoryList = repositoryList;
  }

  @Override public RepositoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Repository currentRepository = repositoryList.get(position);
    holder.nameRepository.setText(currentRepository.getName());
    holder.descriptionRepository.setText(currentRepository.getDescription());
  }

  @Override public int getItemCount() {
    return repositoryList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameRepository;
    private final TextView descriptionRepository;

    ViewHolder(View itemView) {
      super(itemView);
      nameRepository = (TextView) itemView.findViewById(R.id.repository_name);
      descriptionRepository = (TextView) itemView.findViewById(R.id.repository_description);
    }
  }
}
