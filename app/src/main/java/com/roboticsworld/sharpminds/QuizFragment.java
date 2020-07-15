package com.roboticsworld.sharpminds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.nio.BufferUnderflowException;

public class QuizFragment extends Fragment {
    Button btnEasy,btnMedium,btnDifficult;
    TextView tvScore,tvWrong;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);


        btnEasy = view.findViewById(R.id.btn_easy);
        btnMedium = view.findViewById(R.id.btn_medium);
        btnDifficult = view.findViewById(R.id.btn_difficult);

        tvScore = view.findViewById(R.id.score);
        tvWrong = view.findViewById(R.id.wrong);
        //Retrieve the value
//        Bundle bundle = getActivity().getIntent().getExtras();
        Bundle bundle = getArguments();
        if(bundle == null)
        {
            tvScore.setText("Score: 0");
            tvWrong.setText("Wrong Answers: 0");
        }
        else
        {
            tvScore.setText("Score: " + bundle.getString("Score").toString());
            tvWrong.setText("Wrong Answers " + bundle.getString("Wrong").toString());
        }


        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionFragment questionFragment = new QuestionFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Value", btnEasy.getText().toString());
                questionFragment.setArguments(bundle);

                //Inflate the fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, questionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionFragment questionFragment = new QuestionFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Value", btnMedium.getText().toString());
                questionFragment.setArguments(bundle);

                //Inflate the fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, questionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnDifficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionFragment questionFragment = new QuestionFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Value", btnDifficult.getText().toString());
                questionFragment.setArguments(bundle);

                //Inflate the fragment
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, questionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
    private void swapQuestionFragment(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new QuestionFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
