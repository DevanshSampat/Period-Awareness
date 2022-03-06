package com.period.awareness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TeacherLoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_teacher_login, container, false);
        EditText teacher_id = v.findViewById(R.id.student_id);
        EditText password_edit = v.findViewById(R.id.password);
        Button login_btn = v.findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = teacher_id.getText().toString();
                String password = password_edit.getText().toString();
                if(!id.contains("Tea"))
                    Toast.makeText(getActivity(),"Enter correct id",Toast.LENGTH_SHORT).show();

                Fragment newFragment = new ChatFragment();
                Bundle bundle = new Bundle();
                bundle.putString("teacher_id",id);
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