package com.example.administrator.threadpoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = "MainActivity";
    private Button threadBtn,runnableBtn,callableBtn;

    private static int threadCount1,threadCount2,threadCount3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        threadBtn.setOnClickListener(this);
        runnableBtn.setOnClickListener(this);
        callableBtn.setOnClickListener(this);
    }

    private void initView(){
        threadBtn = findViewById(R.id.thread_type);
        runnableBtn = findViewById(R.id.runnable_type);
        callableBtn = findViewById(R.id.callable_type);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.thread_type:
                MyThread thread = new MyThread();
                threadCount1++;
                thread.setName("MyThread "+threadCount1);
                thread.start();
                break;
            case R.id.runnable_type:
                MyRunnable runnable = new MyRunnable();
                Thread thread1 = new Thread(runnable);
                threadCount2++;
                thread1.setName("MyRunnable "+threadCount2);
                thread1.start();

                break;
            case R.id.callable_type:
                FutureTask<String> task = new FutureTask<String>(new MyCallable());
                Thread thread2 = new Thread(task);
                threadCount3++;
                thread2.setName("FutureTask "+threadCount3);
                thread2.start();
                Log.v(TAG,thread2.getName()+" isDone:"+task.isDone()+"  isCancelled: "+task.isCancelled());
                try {
                    String result = task.get();
                    Log.v(TAG,thread2.getName()+" isDone:"+task.isDone()+"  isCancelled: "+task.isCancelled()+"  get: "+result);

                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
    }

}
