package com.period.awareness;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PeriodProductInformation extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_period_product_information, container, false);
        Button go_to_video_fragment = v.findViewById(R.id.go_to_video_fragment);
        Button go_video_fragment = v.findViewById(R.id.go_video_fragment);

        return v;
    }
    @Override
    public void onClick(View v) {
        Log.v("onclick","inside the onclick v");
        // Create new fragment and transaction
        Fragment newFragment = new Videos();
        // consider using Java coding conventions (upper first char class names!!!)
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.main_activity, newFragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}