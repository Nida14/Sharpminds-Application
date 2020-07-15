package com.roboticsworld.sharpminds.abacus_classes;
import android.content.Context;
import android.database.Cursor;
import com.roboticsworld.sharpminds.DBHelper;
import java.util.ArrayList;

public class House5{

    public boolean status[] = new boolean[10]; // one+, two+, three+, four+, random+, one-, two-, three-, four-,random-
    DBHelper db;
    Cursor c,c2;
    int Q_count=0;
    ArrayList<Integer> aList = new ArrayList<Integer>();

    public House5(Context context){
        db = new DBHelper(context);
    }

    public ArrayList<Integer> getQuestion()
    {
        aList.clear();
        if(c == null)
        {
            if(status[0])
            {
                c = db.getHouse5Plus("1");
            }
            else if(status[1])
            {
                c = db.getHouse5Plus("2");
            }
            else if(status[2])
            {
                c = db.getHouse5Plus("3");
            }
            else if(status[3])
            {
                c = db.getHouse5Plus("4");
            }
            else if(status[4])
            {
                c = db.getHouse5Plus("random");
            }
            else if(status[5])
            {
                c = db.getHouse5Minus("1");
            }
            else if(status[6])
            {
                c = db.getHouse5Minus("2");
            }
            else if(status[7])
            {
                c = db.getHouse5Minus("3");
            }
            else if(status[8])
            {
                c = db.getHouse5Minus("4");
            }
            else if(status[9])
            {
                c = db.getHouse5Minus("random");
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
