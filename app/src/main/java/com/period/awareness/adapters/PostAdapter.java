package com.period.awareness.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.period.awareness.R;
import com.period.awareness.datamodels.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PostModel> postModelArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostModel postModel = postModelArrayList.get(position);
        holder.question.setText(postModel.getQuestion());
    }

    @Override
    public int getItemCount() {
        if(postModelArrayList==null) return 0;
        return postModelArrayList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPostModelArrayList(ArrayList<PostModel> postModelArrayList) {
        this.postModelArrayList = postModelArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.tv_question);
        }
    }
}
