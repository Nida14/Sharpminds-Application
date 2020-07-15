package com.roboticsworld.sharpminds.abacus_classes;

import android.content.Context;
import android.database.Cursor;

import com.roboticsworld.sharpminds.DBHelper;

import java.util.ArrayList;

public class House10{

    public boolean status[] = new boolean[20]; // one+, two+, three+, four+, five+, six+, seven+, eight+, nine+, random+, one-, two-, three-, four-, five-, six-, seven-, eight-, nine-, random-
    DBHelper db;
    Cursor c,c2;
    int Q_count=0;
    ArrayList<Integer> aList = new ArrayList<Integer>();

    public House10(Context context){
        db = new DBHelper(context);
    }

    public ArrayList<Integer> getQuestion()
    {
        aList.clear();
        if(c == null)
        {
            if(status[0])
            {
                c = db.getHouse10Plus("1");
            }
            else if(status[1])
            {
                c = db.getHouse10Plus("2");
            }
            else if(status[2])
            {
                c = db.getHouse10Plus("3");
            }
            else if(status[3])
            {
                c = db.getHouse10Plus("4");
            }
            else if(status[4])
            {
                c = db.getHouse10Plus("5");
            }
            else if(status[5])
            {
                c = db.getHouse10Plus("6");
            }
            else if(status[6])
            {
                c = db.getHouse10Plus("7");
            }
            else if(status[7])
            {
                c = db.getHouse10Plus("8");
            }
            else if(status[8])
            {
                c = db.getHouse10Plus("9");
            }
            else if(status[9])
            {
                c = db.getHouse10Plus("random");
            }
            else if(status[10])
            {
                c = db.getHouse10Minus("1");
            }
            else if(status[11])
            {
                c = db.getHouse10Minus("2");
            }
            else if(status[12])
            {
                c = db.getHouse10Minus("3");
            }
            else if(status[13])
            {
                c = db.getHouse10Minus("4");
            }
            else if(status[14])
            {
                c = db.getHouse10Minus("5");
            }
            else if(status[15])
            {
                c = db.getHouse10Minus("6");
            }
            else if(status[16])
            {
                c = db.getHouse10Minus("7");
            }
            else if(status[17])
            {
                c = db.getHouse10Minus("8");
            }
            else if(status[18])
            {
                c = db.getHouse10Minus("9");
            }
            else if(status[19])
            {
                c = db.getHouse10Minus("random");
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
