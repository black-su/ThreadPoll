package com.example.administrator.threadpoll;

import android.util.Log;

public class MyThread extends Thread {
    private final static String TAG = "MyThread";
    private static int index = 0;

    @Override
    public void run() {
        super.run();
        try {
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"  start");
            Thread.sleep(10000);
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"  start");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
