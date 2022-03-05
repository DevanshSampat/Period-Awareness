package com.period.awareness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ChatFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chat, container, false);
        Bundle bundle= this.getArguments();
        String student_id,teacher_id;
        if(bundle!=null){
            if(bundle.get("student_id")!=null) {
                student_id = (String) bundle.get("student_id");
                Log.v("Student_id",student_id);
                Toast.makeText(getContext(), student_id, Toast.LENGTH_SHORT).show();
            }else{
                teacher_id = bundle.getString("teacher_id");
                Toast.makeText(getContext(), teacher_id, Toast.LENGTH_SHORT).show();
            }
        }
        return  v;
    }
}