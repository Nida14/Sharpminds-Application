package com.roboticsworld.sharpminds;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class QuestionFragment extends Fragment{
    ImageButton btnMic,btnSpeechMic;
    TextToSpeech textToSpeech;
    TextView tvQuestion,tvDifficulty;
    EditText tvAnswer;
    private TextView textViewScore;
    private TextView textViewCountDown;
    private Cursor c;
    private Button buttonConfirmNext, buttonFinish;
    DBHelper myDBHelper;
    int score,wrong;
    String value;
    String q_n_a[] = new String[2];
    private List<String> questionList;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private ColorStateList textColorDefaultCd;
    int quesIndex;
    private final static int REQUEST_CODE_SPEECH_INPUT = 1000;
    private  long COUNTDOWN_IN_MILLIS = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.questions_fragment, container, false);
        score = 0;
        wrong = 0;
        quesIndex = 0;
        btnMic = view.findViewById(R.id.mic);
        textViewScore = view.findViewById(R.id.score);
        textViewCountDown = view.findViewById(R.id.countdown);
        tvQuestion = view.findViewById(R.id.text_view_question);
        btnSpeechMic = view.findViewById(R.id.speech_mic);
        tvAnswer = view.findViewById(R.id.answer);
        textColorDefaultCd = textViewCountDown.getTextColors();
        buttonConfirmNext = view.findViewById(R.id.button_confirm_next);
        tvDifficulty = view.findViewById(R.id.difficulty);
        Bundle bundle = getArguments();
        value = bundle.getString("Value").toString();
        tvDifficulty.setText("Difficulty: " + value);
        if(value.equals("Easy")){
            COUNTDOWN_IN_MILLIS = 30000;
            textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR)
                    {
                        textToSpeech.setLanguage(Locale.ENGLISH);
                        textToSpeech.setSpeechRate(0.3f);

                    }
                }
            });
        }
        else if(value.equals("Medium")){
            COUNTDOWN_IN_MILLIS = 20000;
            textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR)
                    {
                        textToSpeech.setLanguage(Locale.ENGLISH);
                        textToSpeech.setSpeechRate(0.7f);

                    }
                }
            });
        }
        else if(value.equals("Difficult")){
            COUNTDOWN_IN_MILLIS = 10000;
        }
        setScore(score);
        //startCountDown();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextQuestion();
            }
        });
        buttonFinish = view.findViewById(R.id.button_finish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapBack();
            }
        });
        textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    //textToSpeech.setSpeechRate(0.3f);
                }
            }
        });
        btnMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText  = tvQuestion.getText().toString();
                textToSpeech.speak(getText,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        btnSpeechMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        // *********************** database code ***************************
        myDBHelper = new DBHelper(getContext());
        questionList = myDBHelper.getAllQuestions();
        Collections.shuffle(questionList);
        setTvQuestion();
        // *********************** /database code ***************************
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                startNextQuestion();
            }
        };
        startCountDown();
    }
    private void startCountDown() {
        if(countDownTimer != null){
            countDownTimer.start();
        }
    }
    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeFormatted);
        if (timeLeftInMillis < 10000) {
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }
    // method to loop through results trying to find a number
    private int getNumberFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getIntNumberFromText(str) != -1) {
                return getIntNumberFromText(str);
            }
        }
        return -1;
    }
    public void startNextQuestion(){
        int ans = 0;
        int userAns =-1;
        ans = Integer.valueOf(Integer.valueOf(q_n_a[1]));
        String tvAns = tvAnswer.getText().toString();
        if (tvAns.isEmpty()){
            userAns = -1;
        }
        else{
            userAns = Integer.valueOf(tvAns);
        }
        if (userAns == ans){
            score++;
            setScore(score);
            countDownTimer.cancel();
            tvAnswer.setText("");
        }
        else {
            wrong++;
            countDownTimer.cancel();
            tvAnswer.setText("");
        }
        setTvQuestion();
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();
    }
    private void setTvQuestion(){

        if (quesIndex != questionList.size()){
            String temp = questionList.get(quesIndex);
            q_n_a = temp.split(",");
            tvQuestion.setText(q_n_a[0]);
            quesIndex++;
        }
        else {
            Toast.makeText(getContext(),"All Question are Completed",Toast.LENGTH_SHORT).show();
            swapBack();
        }
    }
    private void setScore(int score){
        textViewScore.setText("Score: " + String.valueOf(score));
    }
    // method to convert string number to integer
    private int getIntNumberFromText(String strNum) {
        int ans = -1;
        String[] arr ={"zero","one","two","three","four","five","six","seven","eight","nine","ten"};
        for(int i=0;i<arr.length;i++)
        {
            if(strNum.equals(arr[i]))
            {
                ans = i;
                break;
            }
        }
        return ans;
    }
    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.ENGLISH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi speak something");
        try{
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && null != data){
            switch (requestCode){
                case REQUEST_CODE_SPEECH_INPUT: {
                    int intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        tvAnswer.setText(String.valueOf(intFound));
                    } else {
                        Toast.makeText(getActivity(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;
                }

            }
        }
    }
    public void swapBack()
    {
        QuizFragment quizFragment = new QuizFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Score", String.valueOf(score));
        bundle.putString("Wrong", String.valueOf(wrong));
        quizFragment.setArguments(bundle);
        //Inflate the fragment
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, quizFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}