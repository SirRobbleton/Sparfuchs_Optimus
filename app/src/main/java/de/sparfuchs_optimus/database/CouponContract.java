package de.sparfuchs_optimus.database;

import android.provider.BaseColumns;

import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_DESCRIPTION;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_CATEGORY;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_LOCATION;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.TABLE_NAME;

/**
 * Created by bwpc on 11.01.2017.
 */

public class CouponContract {

    public static class CouponEntry implements BaseColumns {
        public static final String TABLE_NAME = "coupon";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_LOCATION = "location";
    }

    public static final String DATE_TYPE = " TEXT";
    public static final String COMMA = ", ";

    public static final String CREATE_COUPON =
            "CREATE TABLE " + CouponEntry.TABLE_NAME + " (" +
                    CouponEntry._ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_CATEGORY + DATE_TYPE + COMMA +
                    COLUMN_DESCRIPTION + DATE_TYPE + COMMA +
                    COLUMN_LOCATION + DATE_TYPE + " );";

    public static final String DELETE_COUPON =
            "DROP TABLE IF EXISTS " + CouponEntry.TABLE_NAME + ";";
}

