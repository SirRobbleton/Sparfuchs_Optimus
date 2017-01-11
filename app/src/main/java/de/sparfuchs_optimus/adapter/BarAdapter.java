package de.sparfuchs_optimus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.sparfuchs_optimus.model.Bar;
import de.sparfuchs_optimus.R;

/**
 * Created by bwpc on 11.01.2017.
 */

public class BarAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public BarAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object){
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return list.size()  ;
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent){
        View row = view;
        BarHolder barHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.bar, parent, false);
            barHolder = new BarHolder();
            barHolder.tv_name = (TextView)row.findViewById(R.id.tv_name);
            barHolder.tv_address = (TextView)row.findViewById(R.id.tv_address);
            row.setTag(barHolder);
        }
        else{
            barHolder = (BarHolder) row.getTag();
        }
        Bar bar = (Bar) getItem(position);
        barHolder.tv_name.setText(bar.getName());
        barHolder.tv_address.setText(bar.getAddress());

        return row;
    }

    static class BarHolder{
        TextView tv_name, tv_address;
    }
}
