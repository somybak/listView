package com.example.somy.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    TextView bn,bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bn = (TextView) findViewById(R.id.bn);
        bd = (TextView) findViewById(R.id.bd);

        //1. get intent from list

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //2. get the value from intent as the type
        int no =bundle.getInt("bn");
        String day = bundle.getString("bd");

        //set each value to widget

        bn.setText(no+"");
        bd.setText(day);

    }


}
