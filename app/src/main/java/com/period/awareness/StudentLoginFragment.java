package com.period.awareness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class StudentLoginFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_student_login, container, false);
        EditText student_id = v.findViewById(R.id.student_id);
        EditText student_name = v.findViewById(R.id.school_name);
        Button login_btn = v.findViewById(R.id.login_btn);



        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = student_id.getText().toString();
                Log.v("student_id",id);
                if(!id.contains("Stu")){
                    Toast.makeText(getActivity(),"Enter correct student id",Toast.LENGTH_SHORT).show();
                }
                Fragment newFragment = new ChatFragment();
                Bundle bundle = new Bundle();
                bundle.putString("student_id",id);
                newFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.main_activity, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        });
        return v;
    }
}