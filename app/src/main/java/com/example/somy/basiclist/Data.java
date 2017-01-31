package com.example.somy.basiclist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by somy on 17. 1. 31.
 */

public class Data {

    private ArrayList<User> datas;

    public ArrayList<User> get(){
        return datas;
    }

    public Data(){
        datas = new ArrayList<>();
        load();
    }



    private void load() {

        //construct random NANSU
        Random random = new Random();
        random.nextInt(80);

        //fill 100 user in datas
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            user.id = i + 1;
            user.name = "Mr.Hong" + user.id;

            user.age = random.nextInt(80);
            //user.age = "one of numbers in 0~79";

            Log.i("Random", "number=" + user.age);


            datas.add(user);
        }

    }



}
