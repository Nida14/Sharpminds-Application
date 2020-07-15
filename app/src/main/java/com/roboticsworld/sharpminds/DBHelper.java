package com.roboticsworld.sharpminds;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class DBHelper extends SQLiteOpenHelper {
    String path = null;
    private static String db_name = "Sharpminds.db";
    private SQLiteDatabase mydb;
    private  Context mycontext = null;
    public DBHelper(Context context)
    {
        super(context,db_name,null,11);
        this.mycontext = context;
        this.path = "/data/data/"+context.getPackageName()+"/databases/";
        try
        {
            this.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try
        {
            this.openDataBase();
        }
        catch (SQLException e)
        {
            throw e;
        }
    }
    public void createDataBase() throws IOException
    {
        boolean dbExist = checkDatabase();
        if(!dbExist)
        {
            this.getWritableDatabase();
            try
            {
                copyDatabase();
            }
            catch (IOException e)
            {
                throw new Error("Error copying database!");
            }
        }
    }
    public boolean checkDatabase()
    {
        SQLiteDatabase checkdb = null;
        try
        {
            String mypath = path+db_name;
            //checkdb = SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteAbortException e){throw e;}
        if(checkdb != null)
        {
            checkdb.close();
        }
        return checkdb != null ? true : false;
    }
    private void copyDatabase() throws IOException
    {
        InputStream myinput = mycontext.getAssets().open(db_name);
        String outFilename = path + db_name;
        OutputStream myoutput = new FileOutputStream(outFilename);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myinput.read(buffer))>0)
        {
            myoutput.write(buffer,0,length);
        }
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }
    public void openDataBase() throws SQLException
    {
        String mypath = path+db_name;
        mydb = SQLiteDatabase.openDatabase(mypath,null,SQLiteDatabase.OPEN_READONLY);

    }
    public synchronized void close()
    {
        if(mydb != null)
        {
            mydb.close();
        }
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(newVersion > oldVersion)
        {
            try
            {
                copyDatabase();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.disableWriteAheadLogging();
    }
    public Cursor getAddSub(String category)
    {
        return mydb.rawQuery("select * from addsub where type = "+category,null);
    }
    public Cursor getHouse5Plus(String category)
    {
        return mydb.rawQuery("select * from HouseOfFivePlus where type = '"+category+"'",null);
    }
    public Cursor getHouse5Minus(String category)
    {
        return mydb.rawQuery("select * from HouseOfFiveMinus where type ='"+category+"'",null);
    }
    public Cursor getHouse10Plus(String category)
    {
        return mydb.rawQuery("select * from HouseOfTenPlus where type ='"+category+"'",null);
    }
    public Cursor getHouse10Minus(String category)
    {
        return mydb.rawQuery("select * from HouseOfTenMinus where type ='"+category+"'",null);
    }
    public Cursor getFamilyPlus(String category)
    {
        return mydb.rawQuery("select * from FamilyPlus where type ='"+category+"'",null);
    }
    public Cursor getFamilyMinus(String category)
    {
        return mydb.rawQuery("select * from FamilyMinus where type ='"+category+"'",null);
    }
    public List<String> getAllQuestions() {
        List<String> questionList = new ArrayList<>();
        String temp="";
        mydb = getReadableDatabase();
        Cursor c = mydb.rawQuery("SELECT * FROM QuestionTable", null);
        if (c.moveToFirst()) {
            do {
                temp = c.getString(1)+","+c.getString(2);
                System.out.println(temp);
                questionList.add(temp);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}