package com.roboticsworld.sharpminds.abacus_classes;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;

import com.roboticsworld.sharpminds.R;

public class sound extends Application {

    public static MediaPlayer mp = new MediaPlayer();
    public static void correct(Context context)
    {
        mp = MediaPlayer.create(context, R.raw.correct_sound);
        mp.start();
    }

    public static void wrong(Context context)
    {
        mp = MediaPlayer.create(context, R.raw.wrong_sound);
        mp.start();
    }

    public static void reset(Context context)
    {
        mp = MediaPlayer.create(context, R.raw.reset_sound);
        mp.start();
        try {
            Thread.sleep(650);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
