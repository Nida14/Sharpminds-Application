package com.roboticsworld.sharpminds.abacus_classes;

import android.content.Context;
import android.database.Cursor;
import com.roboticsworld.sharpminds.DBHelper;
import java.util.ArrayList;

public class Family{

    public boolean status[] = new boolean[10]; // one+, two+, three+, four+, random+, one-, two-, three-, four-,random-
    DBHelper db;
    Cursor c,c2;
    int Q_count=0;
    ArrayList<Integer> aList = new ArrayList<Integer>();

    public Family(Context context){
        db = new DBHelper(context);
    }

    public ArrayList<Integer> getQuestion()
    {
        aList.clear();
        if(c == null)
        {
            if(status[0])
            {
                c = db.getFamilyPlus("6");
            }
            else if(status[1])
            {
                c = db.getFamilyPlus("7");
            }
            else if(status[2])
            {
                c = db.getFamilyPlus("8");
            }
            else if(status[3])
            {
                c = db.getFamilyPlus("9");
            }
            else if(status[4])
            {
                c = db.getFamilyPlus("random");
            }
            else if(status[5])
            {
                c = db.getFamilyMinus("6");
            }
            else if(status[6])
            {
                c = db.getFamilyMinus("7");
            }
            else if(status[7])
            {
                c = db.getFamilyMinus("8");
            }
            else if(status[8])
            {
                c = db.getFamilyMinus("9");
            }
            else if(status[9])
            {
                c = db.getFamilyMinus("random");
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
