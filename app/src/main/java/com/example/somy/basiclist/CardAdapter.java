package com.example.somy.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by somy on 17. 1. 31.
 */

public class CardAdapter extends RecyclerView.Adapter <CardAdapter.CustumViewHolder>{

    ArrayList<User> datas;
    //get data
    Context context; //click, animation, system resource

    public CardAdapter(ArrayList <User> datas, RecyclerCardActivity context){
        this.datas = datas;
        this.context = context;

    }


    //construct view and save to holder. Just construct and carry. not save
    @Override
    public CustumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent,false);
                // context
        CustumViewHolder cv = new CustumViewHolder(view);
        return cv;
    }


    // Instead of getview in listView
    @Override
    public void onBindViewHolder(CustumViewHolder holder, int position) {
        final User user = datas.get(position);
        holder.cv.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent (context, DetailActivity.class);
                 intent.putExtra("bn", user.id);
                 intent.putExtra("bd",user.name);

                 context.startActivity(intent);


             }
        });




        //Textview should be defined already
        holder.txtid.setText(user.id+"");
        holder.txtn.setText(user.name);
        holder.txta.setText(user.age+"");

        //cardview click listener


        //cardview animation
        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        //setting animation to view
        holder.cv.setAnimation(animation);
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
        CardView cv;

        public CustumViewHolder(View view) {

            super(view);
            txtid = (TextView) view.findViewById(R.id.txtid);
            txtn= (TextView) view.findViewById(R.id.txtn);
            txta= (TextView) view.findViewById(R.id.txta);

            cv= (CardView) view.findViewById(R.id.cv);

        }


    }


}
