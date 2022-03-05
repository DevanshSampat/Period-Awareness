package com.period.awareness.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.period.awareness.R;
import com.period.awareness.VideoPlayerActivity;
import com.period.awareness.datamodels.VideoData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private ArrayList<VideoData> videoDataArrayList;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.video_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoData videoData = videoDataArrayList.get(position);
        Picasso.get().load(videoData.getImage()).into(holder.coverImage);
        holder.title.setText(videoData.getTitle());
        holder.duration.setText(videoData.getTime());
        holder.description.setText(videoData.getDescription());
        holder.coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.putExtra("url",videoData.getLink());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(videoDataArrayList == null) return 0;
        return videoDataArrayList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setVideoDataArrayList(ArrayList<VideoData> videoDataArrayList) {
        this.videoDataArrayList = videoDataArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView coverImage;
        TextView title, description, duration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.iv_video_cover);
            title = itemView.findViewById(R.id.tv_video_title);
            description = itemView.findViewById(R.id.tv_video_description);
            duration = itemView.findViewById(R.id.tv_duration);
        }
    }
}
