package com.example.pedro_master.androidthreads;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainActivity extends Activity {

    private Handler myHandler;
    boolean gameOn;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Quantos miliseconds existem desde o UNIX epoch
        startTime = System.currentTimeMillis();

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (gameOn) {
                    long seconds = ((System.currentTimeMillis() - startTime)) / 1000;
                    Log.i("info", "seconds =" + seconds);
                }

                myHandler.sendEmptyMessageDelayed(0, 1000);
            }

        };

        gameOn = true;
        myHandler.sendEmptyMessage(0);

    }
}
