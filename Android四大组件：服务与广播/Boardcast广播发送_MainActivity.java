package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.content.Context;
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
private MyReceiver myReceiver = new MyReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=findViewById(R.id.btn1);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(".MyReceiver");
                sendBroadcast(intent);
			}
		});
    }
	@Override
	public void onResume()
	{
		super.onResume();
		IntentFilter iFliter= new IntentFilter(".MyReceiver");
		registerReceiver(myReceiver,iFliter);
	}

    
}

