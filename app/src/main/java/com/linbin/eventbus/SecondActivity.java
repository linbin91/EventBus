package com.linbin.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import de.greenrobot.event.EventBus;

/**
 * Created by linbin_dian91 on 2016/3/16.
 */
public class SecondActivity extends Activity {

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        bt = (Button) findViewById(R.id.bt);
        bt.setText("text");


        EventBus.getDefault().register(this);
    }

    public  void onEventMainThread(Test event){
        if (event != null){
            bt.setText(event.getMessage());
        }
    }
}
