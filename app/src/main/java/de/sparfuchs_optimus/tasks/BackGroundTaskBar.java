package de.sparfuchs_optimus.tasks;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import de.sparfuchs_optimus.R;
import de.sparfuchs_optimus.adapter.BarAdapter;
import de.sparfuchs_optimus.database.BarHelper;
import de.sparfuchs_optimus.model.Bar;

import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_ADDRESS;
import static de.sparfuchs_optimus.database.BarContract.BalanceEntry.COLUMN_NAME;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BackGroundTaskBar extends AsyncTask<String, Bar, String> {

    public Context ctx;
    public BarAdapter barAdapter;
    public Activity activity;
    public ListView listView;

    public BackGroundTaskBar(Context ctx)
    {
        this.ctx = ctx;
        activity = (Activity)ctx;
    }

    @Override
    public String doInBackground(String... params){

        String method = params[0];
        BarHelper dbHelper = new BarHelper(ctx);

        if(method.equals("show_bars")){

            listView = (ListView) activity.findViewById(R.id.bar_list);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.getInformation(db);
            barAdapter = new BarAdapter(ctx, R.layout.bar);
            String name, address;
            while(cursor.moveToNext())
            {
                name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));

                Bar bar = new Bar(name, address);
                publishProgress(bar);
            }
            return "show_bars";
        }

        else if(method.equals("delete_bars")){

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbHelper.refreshBarTable(db);
        }

        return null;
    }

    @Override
    public void onProgressUpdate(Bar... values){
        barAdapter.add(values[0]);
    }

    @Override
    public void onPostExecute(String result){
        if (result.equals("show_bars")){
            listView.setAdapter(barAdapter);
        }
        else Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }
}