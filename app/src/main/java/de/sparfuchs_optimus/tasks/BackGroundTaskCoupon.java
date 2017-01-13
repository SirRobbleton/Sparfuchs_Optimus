package de.sparfuchs_optimus.tasks;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import de.sparfuchs_optimus.R;
import de.sparfuchs_optimus.adapter.CouponAdapter;
import de.sparfuchs_optimus.database.DatabaseHelper;
import de.sparfuchs_optimus.model.Coupon;

import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_CATEGORY;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_DESCRIPTION;
import static de.sparfuchs_optimus.database.CouponContract.CouponEntry.COLUMN_LOCATION;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BackGroundTaskCoupon extends AsyncTask<String, Coupon, String> {

    public Context ctx;
    public CouponAdapter couponAdapter;
    public Activity activity;
    public ListView listView;

    public BackGroundTaskCoupon(Context ctx)
    {
        this.ctx = ctx;
        activity = (Activity)ctx;
    }

    @Override
    public String doInBackground(String... params){

        String method = params[0];
        DatabaseHelper helper = new DatabaseHelper(ctx);

        if(method.equals("show_coupons")){

            listView = (ListView) activity.findViewById(R.id.coupon_list);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor cursor = helper.getCoupons(db);
            couponAdapter = new CouponAdapter(ctx, R.layout.coupon);
            String category, description, location;
            while(cursor.moveToNext())
            {
                category = cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY));
                description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                location = cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION));

                Coupon coupon = new Coupon(category, description, location);
                publishProgress(coupon);
            }
            return "show_coupons";
        }

        else if(method.equals("delete_coupons")){
            helper.refreshCouponTable();
        }

        return null;
    }

    @Override
    public void onProgressUpdate(Coupon... values){
        couponAdapter.add(values[0]);
    }

    @Override
    public void onPostExecute(String result){
        if (result.equals("show_coupons")){
            listView.setAdapter(couponAdapter);
        }
        else Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}