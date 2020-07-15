package com.roboticsworld.sharpminds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LearningFragment extends Fragment {
    LinearLayout countingLayout,addsubLayout,houseOfFiveAddLayout,houseOfFiveSubLayout,houseOfTenAddLayout,houseOfTenSubLayout,familyAddLayout,familySubLayout,multiplicationLayout,divisionLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning, container, false);

        countingLayout = view.findViewById(R.id.counting);
        countingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapCountingFragment();
            }
        });

        addsubLayout = view.findViewById(R.id.add_sub);
        addsubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAddSubFragment();
            }
        });


        houseOfFiveAddLayout = view.findViewById(R.id.house_of_five_add);
        houseOfFiveAddLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapHouseOfFiveAddFragment();
            }
        });

        houseOfFiveSubLayout = view.findViewById(R.id.house_of_five_sub);
        houseOfFiveSubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapHouseOfFiveSubFragment();
            }
        });


        houseOfTenAddLayout = view.findViewById(R.id.house_of_ten_add);
        houseOfTenAddLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapHouseOfTenAddFragment();
            }
        });

        houseOfTenSubLayout = view.findViewById(R.id.house_of_ten_sub);
        houseOfTenSubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapHouseOfTenSubFragment();
            }
        });


        familyAddLayout = view.findViewById(R.id.family_add);
        familyAddLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFamilyAddFragment();
            }
        });

        familySubLayout = view.findViewById(R.id.family_sub);
        familySubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapFamilySubFragment();
            }
        });

        multiplicationLayout = view.findViewById(R.id.multiplication);
        multiplicationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapMultiplicationFragment();
            }
        });

        divisionLayout = view.findViewById(R.id.division);
        divisionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapDivisionFragment();
            }
        });
        return view;
    }
    private void swapCountingFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new CountingFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapAddSubFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new AddSubFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapHouseOfFiveAddFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HouseOfFiveAddFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapHouseOfFiveSubFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HouseOfFiveSubFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapHouseOfTenAddFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HouseOfTenAddFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapHouseOfTenSubFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new HouseOfTenSubFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapFamilyAddFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new FamilyAddFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapFamilySubFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new FamilySubFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapMultiplicationFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new MultiplicationFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void swapDivisionFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new DivisionFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
