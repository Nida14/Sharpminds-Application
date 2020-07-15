package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.os.Bundle;
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

public class HouseOfTenAddFragment extends Fragment{
    @Nullable

    Fragment fragment;
    LinearLayout h10_plus1,h10_plus2,h10_plus3,h10_plus4,h10_plus5,h10_plus6,h10_plus7,h10_plus8,h10_plus9,h10_random_plus;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_house_of_ten_add, container, false);

        h10_plus1 = view.findViewById(R.id.h10_plus1);
        h10_plus2 = view.findViewById(R.id.h10_plus2);
        h10_plus3 = view.findViewById(R.id.h10_plus3);
        h10_plus4 = view.findViewById(R.id.h10_plus4);
        h10_plus5 = view.findViewById(R.id.h10_plus5);
        h10_plus6 = view.findViewById(R.id.h10_plus6);
        h10_plus7 = view.findViewById(R.id.h10_plus7);
        h10_plus8 = view.findViewById(R.id.h10_plus8);
        h10_plus9 = view.findViewById(R.id.h10_plus9);
        h10_random_plus = view.findViewById(R.id.h10_random_plus);

        h10_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_plus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_random_plus.setOnClickListener(new View.OnClickListener() {
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
