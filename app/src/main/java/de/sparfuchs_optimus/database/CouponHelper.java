package de.sparfuchs_optimus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_CATEGORY;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_DESCRIPTION;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_LOCATION;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.TABLE_NAME;
import static de.sparfuchs_optimus.database.CouponContract.CREATE_COUPON;
import static de.sparfuchs_optimus.database.CouponContract.DELETE_COUPON;

/**
 * Created by bwpc on 11.01.2017.
 */

public class CouponHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DataAccessHelper.db";

    public CouponHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Access", "Coupon table created");
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_COUPON);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DELETE_COUPON);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    public void insertCoupons(){

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        List<String> locations = new ArrayList<>();
        List<String> categories = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();

        locations.add("Flynn's Inn");
        locations.add("Scruffy's");
        locations.add("Die Pinte");
        locations.add("Der Kofferraum");
        locations.add("Erdbeermund");
        locations.add("Aposto");
        locations.add("Shotz");

        categories.add("Eintritt");
        categories.add("Longdrinks");
        categories.add("Shots");
        categories.add("Bier");
        categories.add("Bier");
        categories.add("Longdrinks");
        categories.add("Shots");

        descriptions.add("Eintritt frei");
        descriptions.add("alle Longdrinks 4€");
        descriptions.add("ein Shot gratis");
        descriptions.add("1€ Rabatt");
        descriptions.add("Bier für 1,50€");
        descriptions.add("2€ Rabatt");
        descriptions.add("alle Shots 2€");

        //    values.put(COLUMN_NAME, "Flynn's Inn");
        //    values.put(COLUMN_ADDRESS, "Hirschstraße 70, 76133 Karlsruhe");
        //    values.put(COLUMN_NAME, "Scruffy's");
        //    values.put(COLUMN_ADDRESS, "Karlstraße 4, 76133 Karlsruhe");
        //   values.put(COLUMN_NAME, "Die Pinte");
        //   values.put(COLUMN_ADDRESS, "Leopoldstraße 15, 76133 Karlsruhe");
        //    values.put(COLUMN_NAME, "Der Kofferraum");
        //    values.put(COLUMN_ADDRESS, "Hirschstraße 17, 76133 Karlsruhe");
        //    values.put(COLUMN_NAME, "Erdbeermund");
        //    values.put(COLUMN_ADDRESS, "Baumeisterstraße 54, 76137 Karlsruhe");
        //    values.put(COLUMN_NAME, "Aposto");
        //    values.put(COLUMN_ADDRESS, "Waldstraße 57, 76133 Karlsruhe");
        //    values.put(COLUMN_NAME, "Shotz");
        //    values.put(COLUMN_ADDRESS, "Blumenstraße 23, 76133 Karlsruhe");

        for (int i = 0; i < locations.size(); i++){
            values.put(COLUMN_CATEGORY, categories.get(i));
            values.put(COLUMN_DESCRIPTION, descriptions.get(i));
            values.put(COLUMN_LOCATION, locations.get(i));
            db.insert(TABLE_NAME, null, values);
        }
        //    long k = db.insert(TABLE_NAME, null, values);
        //   Log.d("Database Access", "Balance updated");
        db.close();
        //    return k;
    }

    public boolean isCouponEmpty(){

        SQLiteDatabase db = getReadableDatabase();
        String count = "SELECT count(*) FROM coupon";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0){
            return false;
        }
        else return true;
    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] coloumns = {COLUMN_CATEGORY, COLUMN_DESCRIPTION, COLUMN_LOCATION};
        Cursor cursor = db.query(TABLE_NAME, coloumns, null, null, null, null, COLUMN_CATEGORY);
        return cursor;
    }



    public void refreshCouponTable(SQLiteDatabase db){
        db.execSQL(DELETE_COUPON);
        db.execSQL(CREATE_COUPON);
    }
}