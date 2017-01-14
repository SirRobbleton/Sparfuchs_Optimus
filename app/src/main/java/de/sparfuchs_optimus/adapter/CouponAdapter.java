package de.sparfuchs_optimus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.sparfuchs_optimus.model.Coupon;
import de.sparfuchs_optimus.R;

/**
 * Adapter fills Block(Row)-Layout.
 * In this case coupon.xml.
 * List will be filled with blocks by Main-Thread.
 */

public class CouponAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public CouponAdapter(Context context, int resource) {
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
        CouponHolder couponHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.coupon, parent, false);
            couponHolder = new CouponHolder();
            couponHolder.tv_category = (TextView)row.findViewById(R.id.tv_category);
            couponHolder.tv_description = (TextView)row.findViewById(R.id.tv_description);
            couponHolder.tv_location = (TextView)row.findViewById(R.id.tv_location);
            row.setTag(couponHolder);
        }
        else{
            couponHolder = (CouponHolder) row.getTag();
        }
        Coupon coupon = (Coupon) getItem(position);
        couponHolder.tv_category.setText(coupon.getCategory());
        couponHolder.tv_description.setText(coupon.getDescription());
        couponHolder.tv_location.setText(coupon.getLocation());

        return row;
    }

    static class CouponHolder{
        TextView tv_category, tv_description, tv_location;
    }
}
