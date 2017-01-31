package com.example.somy.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {


//data setting

    ArrayList<User> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Data data = new Data();
       datas = data.get();

        //1. get Recycler View
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);


        //2. Construct Adapter
       RecyclerCustomAdapter rca = new RecyclerCustomAdapter (datas, R.layout.list__holdr_item);


        //3. setting Adapter to Recycler View
        rv.setAdapter(rca);

        //4. apply Recycler View manager. setting the shape of view : grid, normal list, unbalanced grid
        rv.setLayoutManager(new LinearLayoutManager(this));




    }
}
