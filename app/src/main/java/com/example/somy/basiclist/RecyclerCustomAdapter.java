package com.example.somy.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by somy on 17. 1. 31.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter <RecyclerCustomAdapter.CustumViewHolder>{

    ArrayList<User> datas;
    //get data
    int itemLayout;

    public RecyclerCustomAdapter(ArrayList datas, int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;

    }


    //construct view and save to holder. Just construct and carry. not save
    @Override
    public CustumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent,false);
                // context
        CustumViewHolder cv = new CustumViewHolder(view);
        return cv;
    }


    // Instead of getview in listView
    @Override
    public void onBindViewHolder(CustumViewHolder holder, int position) {
        User user = datas.get(position);
        //Textview should be defined already
        holder.txtid.setText(user.id+"");
        holder.txtn.setText(user.name);
        holder.txta.setText(user.age+"");

    }


    /*
    // Instead of getview in listView
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
    */


    //Total data number
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //construct view holder. need to inherit

    public class CustumViewHolder extends RecyclerView.ViewHolder{

        TextView txtid, txtn,txta;

        public CustumViewHolder(View view) {

            super(view);
            txtid = (TextView) view.findViewById(R.id.txtid);
            txtn= (TextView) view.findViewById(R.id.txtn);
            txta= (TextView) view.findViewById(R.id.txta);
        }
    }


}
