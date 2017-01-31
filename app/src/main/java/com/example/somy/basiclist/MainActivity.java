package com.example.somy.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button blistView, holder, rec, bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blistView = (Button) findViewById(R.id.blistView);
        holder = (Button) findViewById(R.id.holder);
        rec = (Button) findViewById(R.id.rec);
        bc = (Button) findViewById(R.id.bc);

        blistView.setOnClickListener(listener);
        holder.setOnClickListener(listener);
        rec.setOnClickListener(listener);
        bc.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId()) {

                case R.id.blistView:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    break;

                case R.id.holder:
                    intent = new Intent(MainActivity.this, ListHolderActivity.class);
                    break;

                case R.id.rec:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;

                case R.id.bc:
                    intent = new Intent(MainActivity.this, RecyclerCardActivity.class);
                    break;

            }

            startActivity(intent);

        }

    };

}
