package com.linbin.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.content_main);

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    EventBus.getDefault().post(new WhateverEvent("EventBus 现实"));
                    EventBus.getDefault().post(new Test("Test 现实"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }


    public  void onEventMainThread(WhateverEvent event){
        if (event != null){
            bt.setText(event.getMessage());
        }
    }

}
