package com.roboticsworld.sharpminds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class AddSubFragment extends Fragment{

    Fragment fragment;
    LinearLayout counting,five,six,seven,eight,nine;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addsub, container, false);

        counting = view.findViewById(R.id.counting);
        five = view.findViewById(R.id.five);
        six = view.findViewById(R.id.six);
        seven = view.findViewById(R.id.seven);
        eight = view.findViewById(R.id.eight);
        nine = view.findViewById(R.id.nine);

        counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragement(v);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
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
