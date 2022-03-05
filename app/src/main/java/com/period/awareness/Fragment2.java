package com.period.awareness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.period.awareness.adapters.VideoAdapter;
import com.period.awareness.datamodels.VideoData;

import java.util.ArrayList;

public class Fragment2 extends Fragment {
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment2,container,false);
        recyclerView=  view.findViewById(R.id.rv_videos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new VideoAdapter());
        loadData();
        return view;
    }

    private void loadData() {
        ArrayList<VideoData> videoDataArrayList = new ArrayList<>();
        VideoData videoData = new VideoData();
        videoData.setTime("1:31");
        videoData.setTitle("The menstrual cycle animation");
        videoData.setDescription("Register for free at bettyforschools.co.uk to access our full betty for schools programme - period education for teachers of 8-12s");
        videoData.setImage("https://i.ytimg.com/an_webp/hUpMM64ClhM/mqdefault_6s.webp?du=3000&sqp=CPTyjJEG&rs=AOn4CLDec5FwMUm8s-XpsRqYvvFpyLnY7A");
        videoData.setLink("https://mvyyvq.by.files.1drv.com/y4m_UdS8wJun1AGvdGzouvOBw8UKBM49SgC3tVPYIu1uqp7xBCut_B0Z0Rzedk0vqObv4CDUAktTqlhlxIZ3gN16OMeOtCPC4bI15McmuchZr_aVMY4uP1Pam9UB3O6UHGtmJrVl9eF4CSLi-NFO7hgCuh8x9DY0HHZXOuwr0qybPe900CBBv8o9qi0qBzATd0is_TvRbrg8Le-sH2ZK9UTow");
        videoDataArrayList.add(videoData);
        ((VideoAdapter)recyclerView.getAdapter()).setVideoDataArrayList(videoDataArrayList);
    }
}
