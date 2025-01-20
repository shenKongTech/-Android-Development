package com.example.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"这是一个测试广播",Toast.LENGTH_SHORT).show();
    }
    
}