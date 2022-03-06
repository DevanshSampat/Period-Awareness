package com.period.awareness;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.period.awareness.adapters.PostAdapter;
import com.period.awareness.datamodels.EntirePostModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment4 extends Fragment  implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=  LayoutInflater.from(container.getContext()).inflate(R.layout.fragment4,container,false);
        Button go_to_chat = v.findViewById(R.id.go_to_chat);
        go_to_chat.setOnClickListener(this);
        RecyclerView recyclerView = v.findViewById(R.id.rv_post);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PostAdapter());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi restApi = retrofit.create(RestApi.class);
        Call<EntirePostModel> call = restApi.getPostModel();
        call.enqueue(new Callback<EntirePostModel>() {
            @Override
            public void onResponse(Call<EntirePostModel> call, Response<EntirePostModel> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    ((PostAdapter)recyclerView.getAdapter()).setPostModelArrayList(response.body().getPostModelArrayList());
                }
            }

            @Override
            public void onFailure(Call<EntirePostModel> call, Throwable t) {

            }
        });
        return v;
    }
    @Override
    public void onClick(View v) {
        Fragment newFragment = new CheckRoleFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.main_activity, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
