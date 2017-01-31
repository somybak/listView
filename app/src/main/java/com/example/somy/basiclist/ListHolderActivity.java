package com.example.somy.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {

    ArrayList<User> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);

            load();
        //get listview
        ListView listVh = (ListView) findViewById(R.id.listVh);

        //construct adapter
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas, this);
        // setting adapter
        listVh.setAdapter(adapter);


    }


    private void load(){

        //construct random NANSU
        Random random = new Random();
        random.nextInt(80);

        //fill 100 user in datas
        for (int i=0 ; i<100000;i++){
            User user = new User();
            user.id = i+1;
            user.name = "Mr.Hong" + user.id;

             user.age = random.nextInt(80);
            //user.age = "one of numbers in 0~79";

            Log.i("Random", "number=" + user.age);


            datas.add(user);
        }

    }

    class CustomHolderAdapter extends BaseAdapter {
        ArrayList<User> datas;
        LayoutInflater inflater;

        public CustomHolderAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        Holder holder;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
                convertView = inflater.inflate(R.layout.list__holdr_item, null);
                //
                holder = new Holder();
                holder.txtid = (TextView) convertView.findViewById(R.id.txtid);
                holder.txtn = (TextView) convertView.findViewById(R.id.txtn);
                holder.txta = (TextView) convertView.findViewById(R.id.txta);

                //none holder
                convertView.setTag(holder);
            } else{
                holder = (Holder) convertView.getTag();
            }

            //possible to reuse
            /**
            TextView txtid = (TextView) convertView.findViewById(R.id.txtid);
            TextView txtn = (TextView) convertView.findViewById(R.id.txtn);
            TextView txta = (TextView) convertView.findViewById(R.id.txta);
            */

            // get intanse from arraylist
            User user = datas.get(position);
            holder.txtid.setText(user.id+"");
            holder.txtn.setText(user.name);
            holder.txta.setText(user.age+"");
;
            return convertView;

        }
        //save memory by reusing Textview
        class Holder {
            public TextView txtid;
            public TextView txtn;
            public TextView txta;


        }


    }

}
