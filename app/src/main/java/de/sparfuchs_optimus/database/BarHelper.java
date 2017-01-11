package de.sparfuchs_optimus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_ADDRESS;
import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_NAME;
import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.TABLE_NAME;
import static de.sparfuchs_optimus.database.BarContract.CREATE_BAR;
import static de.sparfuchs_optimus.database.BarContract.DELETE_BAR;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BarHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DataAccessHelper.db";

    public BarHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Access", "Bar table created");
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_BAR);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DELETE_BAR);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insertBars(){

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

    //    values.put(COLUMN_NAME, "Flynn's Inn");
    //    values.put(COLUMN_ADDRESS, "Hirschstraße 70, 76133 Karlsruhe");
    //    values.put(COLUMN_NAME, "Scruffy's");
    //    values.put(COLUMN_ADDRESS, "Karlstraße 4, 76133 Karlsruhe");
    //   values.put(COLUMN_NAME, "Die Pinte");
    //   values.put(COLUMN_ADDRESS, "Leopoldstraße 15, 76133 Karlsruhe");
    //    values.put(COLUMN_NAME, "Der Kofferraum");
    //    values.put(COLUMN_ADDRESS, "Hirschstraße 17, 76133 Karlsruhe");
    //    values.put(COLUMN_NAME, "Erdbeermund");
    //    values.put(COLUMN_ADDRESS, " Baumeisterstraße 54, 76137 Karlsruhe");
    //    values.put(COLUMN_NAME, "Aposto");
    //    values.put(COLUMN_ADDRESS, "Waldstraße 57, 76133 Karlsruhe");
    //    values.put(COLUMN_NAME, "Shotz");
    //    values.put(COLUMN_ADDRESS, "Blumenstraße 23, 76133 Karlsruhe");

        long k = db.insert(TABLE_NAME, null, values);
        Log.d("Database Access", "Balance updated");
        db.close();
        return k;
    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] coloumns = {COLUMN_NAME, COLUMN_ADDRESS};
        Cursor cursor = db.query(TABLE_NAME, coloumns, null, null, null, null, COLUMN_NAME);
        return cursor;
    }

    public void refreshBarTable(SQLiteDatabase db){
        db.execSQL(DELETE_BAR);
        db.execSQL(CREATE_BAR);
    }
}