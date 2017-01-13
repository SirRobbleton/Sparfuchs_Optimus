package de.sparfuchs_optimus.database;

import android.provider.BaseColumns;

import static de.sparfuchs_optimus.database.BarContract.BarEntry.COLUMN_ADDRESS;
import static de.sparfuchs_optimus.database.BarContract.BarEntry.COLUMN_NAME;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BarContract {

    public static class BarEntry implements BaseColumns {
        public static final String TABLE_NAME = "bar";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ADDRESS = "address";
    }

    public static final String DATE_TYPE = " TEXT";
    public static final String COMMA = ", ";

    public static final String CREATE_BAR =
            "CREATE TABLE " + BarEntry.TABLE_NAME + " (" +
                    BarEntry._ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME + DATE_TYPE + COMMA +
                    COLUMN_ADDRESS + DATE_TYPE + " );";

    public static final String DELETE_BAR =
            "DROP TABLE IF EXISTS " + BarEntry.TABLE_NAME + ";";
}

