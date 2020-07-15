package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FamilyAddFragment extends Fragment{
    @Nullable
    Fragment fragment;
    LinearLayout fam_plus9,fam_plus8,fam_plus7,fam_plus6,fam_random_plus;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_family_add, container, false);


        fam_plus6 = view.findViewById(R.id.fam_plus6);
        fam_plus7 = view.findViewById(R.id.fam_plus7);
        fam_plus8 = view.findViewById(R.id.fam_plus8);
        fam_plus9 = view.findViewById(R.id.fam_plus9);
        fam_random_plus = view.findViewById(R.id.fam_random_plus);

        fam_plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        fam_plus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        fam_plus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        fam_plus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        fam_random_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });


        return view;
    }

    public void swapAbacusFragement(View view)
    {
        fragment = new AbacusFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",getResources().getResourceEntryName(view.getId())+"");
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
