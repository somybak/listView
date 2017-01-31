package com.example.somy.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by somy on 17. 1. 31.
 */

public class CustumAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String datas[];

    public CustumAdapter(String datas[], Context context){

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // For using getView, inflater change xml layout code to java object
        this.datas = datas;

    }

    /**
     * total number of data
     * @return
     */

    @Override
    public int getCount() {
        return datas.length;
    }

    /**
     * choose list item
     * @param position
     * @return
     */

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**
     * index value of item
     * @param position
     * @return
     */


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
                            // get the data clicked

        // make layout xml in one line as a view
        if (convertView == null)
        convertView = inflater.inflate(R.layout.list_item,null);


        // make layout xml in one line as a view
        //View view = inflater.inflate(R.layout.list_item,null);
        //                                           when using more list in each list item


        TextView txtNo= (TextView) convertView.findViewById(R.id.txtNo);
        TextView txtDay= (TextView) convertView.findViewById(R.id.txtDay);
        // after inflater, can use fin


        // setting value to widget in inflater view
       txtNo.setText((position+1)+""); // => Must be 'String'
       txtDay.setText(datas[position]);

        // send the view to system
        return convertView;
    }


    // View in list Adapter
}
