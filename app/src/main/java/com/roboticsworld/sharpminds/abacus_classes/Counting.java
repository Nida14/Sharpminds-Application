package com.roboticsworld.sharpminds.abacus_classes;

import android.content.Context;

import java.util.Random;

public class Counting {

    public boolean status[] = new boolean[3]; // 0-forward, 1-backward, 2-random
    int forward,backward,random;
    int result;
    Random rand = new Random();

    public Counting()
    {
        forward=1;
        backward=100;
        random=0;
    }
    public int triger(int score, Context context)
    {
        if(this.status[0] == true) // forward counting
        {
            if(score == 0)
            {
                result = forward;
            }
            else if(score == this.forward)
            {
                sound.correct(context);
                result = ++forward;
            }
            else
            {
                //sound.wrong(context);
                result = forward;
            }
        }
        else if(this.status[1] == true) // backward counting
        {
            if(score == 0)
            {
                result = backward;
            }
            else if(score == this.backward)
            {
                sound.correct(context);
                result = --backward;
            }
            else
            {
                //sound.wrong(context);
                result = backward;
            }
        }
        else if(this.status[2] == true) // random counting
        {
            if(score == 0)
            {
                random = rand.nextInt(99)+1;
                result = random;
            }
            else if(score == this.random)
            {
                sound.correct(context);
                random = rand.nextInt(99)+1;
                result = random;
            }
            else
            {
                //sound.wrong(context);
                result = random;
            }
        }
        return result;
    }
}