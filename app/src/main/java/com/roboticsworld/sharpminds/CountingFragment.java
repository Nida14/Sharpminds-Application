package com.roboticsworld.sharpminds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CountingFragment extends Fragment{
    Fragment fragment;
    LinearLayout tutorialLayout,forward_counting,backward_counting,random;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counting, container, false);
        tutorialLayout = view.findViewById(R.id.tutorial);
        forward_counting = view.findViewById(R.id.forward_counting);
        backward_counting = view.findViewById(R.id.backward_counting);
        random = view.findViewById(R.id.random);

        tutorialLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapTutorialFragment();
            }
        });

        forward_counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapForwardCountingFragment();
            }
        });

        backward_counting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapBackwardCountingFragment();
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapRandomFragment();
            }
        });
        return view;
    }
    private void swapTutorialFragment(){
        fragment = new TutorialFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapForwardCountingFragment(){
        fragment = new AbacusFragment();
        Bundle b = new Bundle();
        b.putString("key","forward_counting");
        fragment.setArguments(b);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapBackwardCountingFragment(){
        fragment = new AbacusFragment();
        Bundle b = new Bundle();
        b.putString("key","backward_counting");
        fragment.setArguments(b);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapRandomFragment(){
        fragment = new AbacusFragment();
        Bundle b = new Bundle();
        b.putString("key","random_counting");
        fragment.setArguments(b);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
