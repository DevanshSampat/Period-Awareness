package com.period.awareness.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.period.awareness.NGOList;
import com.period.awareness.PeriodInformation;
import com.period.awareness.R;
import com.period.awareness.VideoPlayerActivity;
import com.period.awareness.datamodels.NgoInformation;
import com.period.awareness.datamodels.VideoData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NgoListAdapter extends RecyclerView.Adapter<NgoListAdapter.ViewHolder> {
    private ArrayList<NgoInformation> ngoList;
    private Context context;

    public void updateList(ArrayList<NgoInformation> new_ngoList){
       this.ngoList = new_ngoList;
       notifyDataSetChanged();
    }
    public NgoListAdapter(ArrayList<NgoInformation> ngoList){
        this.ngoList = ngoList;
    }
    @NonNull
    @Override
    public NgoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new NgoListAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.ngo_information,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NgoListAdapter.ViewHolder holder, int position) {
        NgoInformation data = ngoList.get(position);
        holder.name.setText(data.getName());
        holder.location.setText(data.getLocation());
        holder.funding.setText(data.getFunding());
        holder.contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Your request has been sent!"+data.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.v("size", String.valueOf(ngoList.size()));
        return ngoList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, funding;
        CardView cardview;
        Button contact_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          name = itemView.findViewById(R.id.name);
          contact_btn = itemView.findViewById(R.id.contact_btn);
          cardview = itemView.findViewById(R.id.cardview);
          location = itemView.findViewById(R.id.location);
          funding = itemView.findViewById(R.id.funding);
        }
    }
}
