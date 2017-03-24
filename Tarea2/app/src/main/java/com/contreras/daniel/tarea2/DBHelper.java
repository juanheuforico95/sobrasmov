package com.contreras.daniel.tarea2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 11/02/2017.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE = "homeworkDB.db";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_HOBBY = "hobby";
    private static final String COLUMN_FRIEND = "friend";

    public DBHelper(Context context){
        super(context,DATABASE,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String creation = "CREATE TABLE "+TABLE_NAME+
                "("+COLUMN_ID+" INTEGER PRIMARY KEY, "+
                COLUMN_FRIEND + " TEXT,"+
                COLUMN_HOBBY + " TEXT)";
        sqLiteDatabase.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String[] tables = {TABLE_NAME};
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ?", tables);
        onCreate(sqLiteDatabase);
    }

    public void save(String friendName,String hobby){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FRIEND,friendName);
        values.put(COLUMN_HOBBY,hobby);
        db.insert(TABLE_NAME,null,values);
    }

    public int find(String name){
        SQLiteDatabase db = getWritableDatabase();
        String clause = COLUMN_FRIEND+ " = ? ";
        String[] values = {name};
        Cursor c = db.query(TABLE_NAME,null,clause,values,null,null,null);
        int result = -1;

        if(c.moveToFirst()){
            result = c.getInt(0);
        }
        return result;
    }

    public int delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String clause = COLUMN_ID + " = ? ";
        String[]args ={id + ""};
        return db.delete(TABLE_NAME,clause,args);
    }

}
