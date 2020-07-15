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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.roboticsworld.sharpminds.shared_preference.shared_pref;

public class MenuFragment extends Fragment {
    LinearLayout learningLayout,quizLayout,abacusLayout,exitLayout;
    private Button buttonLogout;
    private TextView textViewUserEmail;
    FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        learningLayout = view.findViewById(R.id.learning);
        quizLayout = view.findViewById(R.id.quiz);
        abacusLayout = view.findViewById(R.id.abacus);
        exitLayout = view.findViewById(R.id.exit);

        learningLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapLearningFragment();
            }
        });
        quizLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapQuizFragment();
            }
        });
        abacusLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapAbacusFragment();
            }
        });
        exitLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapLoginFragment();
            }
        });
        return view;
    }

    private void swapLearningFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new LearningFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapQuizFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new QuizFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapAbacusFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new AbacusTestFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void swapLoginFragment(){
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        new shared_pref(getContext()).getLogOut();
        startActivity(new Intent(getContext(), Login.class));
        getActivity().finish();
    }
}
