package de.sparfuchs_optimus.database;

import android.provider.BaseColumns;

import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_ADDRESS;
import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_NAME;
import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.TABLE_NAME;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BarContract {

    public static class BalanceEntry implements BaseColumns {
        public static final String TABLE_NAME = "bar";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ADDRESS = "address";
    }

    public static final String DATE_TYPE = " TEXT";
    public static final String COMMA = ", ";

    public static final String CREATE_BAR =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    BalanceEntry._ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_NAME + DATE_TYPE + COMMA +
                    COLUMN_ADDRESS + DATE_TYPE + " );";

    public static final String DELETE_BAR =
            "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
}

