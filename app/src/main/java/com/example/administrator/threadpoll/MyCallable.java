package com.example.administrator.threadpoll;

import android.util.Log;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private final static String TAG = "MyCallable";
    private static int index = 0;
    @Override
    public Object call() throws Exception {
        try {
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"   start");
            Thread.sleep(10000);
            Log.v(TAG,"Thread:"+Thread.currentThread().getName()+"   end");

        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}
