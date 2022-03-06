package com.period.awareness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.period.awareness.adapters.NgoListAdapter;
import com.period.awareness.datamodels.NgoInformation;
import com.period.awareness.datamodels.NgoModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NGOList extends Fragment {
    public NgoListAdapter adapter= new NgoListAdapter(new ArrayList<NgoInformation>());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_n_g_o_list, container, false);
//        TextView textView = v.findViewById(R.id.text_view);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://makethon-app.herokuapp.com/").
                addConverterFactory(GsonConverterFactory.create()).build();
        RestApi restApi = retrofit.create(RestApi.class);
        Call<NgoModel> call = restApi.getNgoList();
        call.enqueue(new Callback<NgoModel>() {
            @Override
            public void onResponse(Call<NgoModel> call, Response<NgoModel> response) {
                if(!response.isSuccessful()){
                    Log.v("response not successfull", String.valueOf(response.code()));
                    return;
                }
                NgoModel li = response.body();
                ArrayList<NgoInformation> list_Ngo =(ArrayList<NgoInformation>) li.getNgos();
                Log.v("success", response.body().getSuccess());
                adapter.updateList(list_Ngo);
                for (NgoInformation ngo : list_Ngo) {
                    Log.v("funding", ngo.getFunding());
                    Log.v("name", ngo.getName());
                    Log.v("location", ngo.getLocation());
                }

            }

            @Override
            public void onFailure(Call<NgoModel> call, Throwable t) {
                Log.v("error", t.getMessage());
            }
        });
        return v;
    }
}