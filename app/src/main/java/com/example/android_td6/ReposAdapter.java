package com.example.android_td6;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private Context myActivity;
    private List<Repo> mRepoList;

    public ReposAdapter(Context context, List<Repo> mRepoList) {
        this.myActivity = context;
        this.mRepoList = mRepoList;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView idView;
        public TextView nameView;
        public TextView full_nameView;
        public TextView html_urlView;



        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);

            this.idView = (TextView) itemView.findViewById(R.id.id);
            this.nameView = (TextView) itemView.findViewById(R.id.name);
            this.full_nameView = (TextView) itemView.findViewById(R.id.full_name);
            this.html_urlView = (TextView) itemView.findViewById(R.id.html_url);

        }
    }


    @NonNull
    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View repoView=inflater.inflate(R.layout.item_repo,parent,false);
        return new ViewHolder(repoView,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposAdapter.ViewHolder holder, int position) {
        Repo repo =mRepoList.get(position);

        TextView idTextView=holder.idView;
        idTextView.setText(Integer.toString(repo.getId()));

        TextView nameTextView=holder.nameView;
        nameTextView.setText(repo.getName());

        TextView fullNameTextView=holder.full_nameView;
        fullNameTextView.setText(repo.getFull_name());

        TextView htmlUrlTextView=holder.html_urlView;
        htmlUrlTextView.setText(repo.getHtml_url());
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }
}