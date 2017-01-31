package com.example.somy.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {


    ListView listView;

    String array[] = {"M", "T","W","Th","F","S","Su"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //1. Get listView
        listView = (ListView) findViewById(R.id.blistView);

        //2. define adapter


        CustumAdapter adapter = new CustumAdapter (array, this);

        /**
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,array
                //context,               layout            data
        );
         */

        //3. setting adapter
        listView.setAdapter(adapter);

        //4. stick listener to listview
        listView.setOnItemClickListener(listener);

    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //1.construct intent to trans detail detail - change screen
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);

            //2. setting the data to send
            intent.putExtra("bn",position+1);
            intent.putExtra("bd", array[position]);

            //call the activity
            startActivity(intent);

        }
    };
    //need item id


}
