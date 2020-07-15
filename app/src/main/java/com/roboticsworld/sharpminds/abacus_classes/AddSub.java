package com.roboticsworld.sharpminds.abacus_classes;

import android.content.Context;
import android.database.Cursor;

import com.roboticsworld.sharpminds.DBHelper;

import java.util.ArrayList;

public class AddSub{

    public boolean status[] = new boolean[6]; // 0-counting, 1-five, 2-six, 3-seven, 4-eight, 5-nine
    DBHelper db;
    Cursor c,c2;
    int Q_count=0;
    ArrayList<Integer> aList = new ArrayList<Integer>();

    public AddSub(Context context){
        db = new DBHelper(context);
    }

    public ArrayList<Integer> getQuestion()
    {
        aList.clear();
        if(c == null)
        {
            if(status[0])
            {
                c = db.getAddSub("1234");
            }
            else if(status[1])
            {
                c = db.getAddSub("5");
            }
            else if(status[2])
            {
                c = db.getAddSub("6");
            }
            else if(status[3])
            {
                c = db.getAddSub("7");
            }
            else if(status[4])
            {
                c = db.getAddSub("8");
            }
            else if(status[5])
            {
                c = db.getAddSub("9");
            }
            c.moveToFirst();
        }
        if(!c.isAfterLast())
        {
            for(int i=0;i<c.getInt(1);i++)
            {
                aList.add(c.getInt(i+2));
            }
            this.Q_count++;
            c.moveToNext();
        }
        else
        {
            aList.clear();
        }
        return aList;
    }

    public String get_Q_count()
    {
        return this.Q_count+"/"+this.c.getCount();
    }
}