package com.period.awareness;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PeriodInformation extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= LayoutInflater.from(container.getContext()).inflate(R.layout.period_information,container,false);

        TextView pads = v.findViewById(R.id.pads);
        Button more_info = v.findViewById(R.id.more_info);
        more_info.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment newFragment = new PeriodProductInformation();
                        // consider using Java coding conventions (upper first char class names!!!)
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();

                        // Replace whatever is in the fragment_container view with this fragment,
                        // and add the transaction to the back stack
                        transaction.replace(R.id.host_fragment, newFragment);
                        transaction.addToBackStack(null);

                        // Commit the transaction
                        transaction.commit();
                    }
                }
        );
        TextView cups = v.findViewById(R.id.cups);
        TextView tampons = v.findViewById(R.id.tampons);
        return v;
    }
    @Override
    public void onClick(View v) {

    }
}
