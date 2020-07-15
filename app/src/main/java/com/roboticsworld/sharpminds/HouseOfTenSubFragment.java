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

public class HouseOfTenSubFragment extends Fragment{
    @Nullable

    Fragment fragment;
    LinearLayout h10_minus1,h10_minus2,h10_minus3,h10_minus4,h10_minus5,h10_minus6,h10_minus7,h10_minus8,h10_minus9,h10_random_minus;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_house_of_ten_sub, container, false);

        h10_minus1 = view.findViewById(R.id.h10_minus1);
        h10_minus2 = view.findViewById(R.id.h10_minus2);
        h10_minus3 = view.findViewById(R.id.h10_minus3);
        h10_minus4 = view.findViewById(R.id.h10_minus4);
        h10_minus5 = view.findViewById(R.id.h10_minus5);
        h10_minus6 = view.findViewById(R.id.h10_minus6);
        h10_minus7 = view.findViewById(R.id.h10_minus7);
        h10_minus8 = view.findViewById(R.id.h10_minus8);
        h10_minus9 = view.findViewById(R.id.h10_minus9);
        h10_random_minus = view.findViewById(R.id.h10_random_minus);

        h10_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_minus9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        h10_random_minus.setOnClickListener(new View.OnClickListener() {
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
