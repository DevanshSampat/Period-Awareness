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

import com.period.awareness.adapters.PostAdapter;
import com.period.awareness.datamodels.CreatorData;
import com.period.awareness.datamodels.EntirePostModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ChatFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_chat, container, false);
        v.findViewById(R.id.submit_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreatorData creatorData = new CreatorData();
                creatorData.setQuestion(((EditText)v.findViewById(R.id.question)).getText().toString());
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.base_url))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RestApi restApi = retrofit.create(RestApi.class);
                Call<ResponseBody> call = restApi.createPost(creatorData);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful() && response.body()!=null) {
                            Toast.makeText(getContext(), "Question Submitted", Toast.LENGTH_SHORT).show();
                            ((EditText)v.findViewById(R.id.question)).setText("");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
        Bundle bundle= this.getArguments();
        String student_id,teacher_id;
        if(bundle!=null){
            if(bundle.get("student_id")!=null) {
                student_id = (String) bundle.get("student_id");
                Log.v("Student_id",student_id);
//                Toast.makeText(getContext(), student_id, Toast.LENGTH_SHORT).show();
            }else{
                teacher_id = bundle.getString("teacher_id");
//                Toast.makeText(getContext(), teacher_id, Toast.LENGTH_SHORT).show();
            }
        }
        Button go_to_ngo = v.findViewById(R.id.go_to_ngo);
        go_to_ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new NGOList();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.main_activity, newFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
        return  v;
    }
}