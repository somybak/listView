package com.example.somy.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {

    ArrayList<User> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        datas = data.get();

        // 1. get list view
        RecyclerView rc = (RecyclerView) findViewById(R.id.rc);

        //2. construct adapter
        CardAdapter rcv = new CardAdapter(datas, this);

        //change to screen

        //3. setting adaper on listview
        rc.setAdapter(rcv);

        //4. layout manager
        rc.setLayoutManager(new LinearLayoutManager(this));








    }
}
