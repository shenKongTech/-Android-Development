package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import android.view.*;
import android.content.Intent;
import com.example.application.BackActivity;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


public class MainActivity extends Activity
{   
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=findViewById(R.id.bt1);
	    button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(MainActivity.this,"你触发了单击事件",Toast.LENGTH_SHORT).show();
			}
		});
		button.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v,MotionEvent event)
			{
				if(event.getAction()==MotionEvent.ACTION_DOWN)
				{
					Toast.makeText(MainActivity.this,"你按下了按钮",Toast.LENGTH_SHORT).show();
				}
				if(event.getAction()==MotionEvent.ACTION_UP)
				{
					Toast.makeText(MainActivity.this,"你释放了按钮",Toast.LENGTH_SHORT).show();
				}
				return false;
			}
		});
    }
}