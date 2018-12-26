package com.example.administrator.threadpoll;

import android.util.Log;

public class MyRunnable implements Runnable {
    private final static String TAG = "MyRunnable";
    @Override
    public void run() {
        try {
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"  start");
            Thread.sleep(10000);
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"  start");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
