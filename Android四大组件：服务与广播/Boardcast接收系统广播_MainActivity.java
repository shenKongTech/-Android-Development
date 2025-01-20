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


public class MainActivity extends Activity
{   
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ConnectivityManager conn=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
	    NetworkInfo network = conn.getActiveNetworkInfo();
		if(network!=null &&network.isConnected())
		{
			Toast.makeText(MainActivity.this,"网络已连接",Toast.LENGTH_SHORT).show();
		}
		else
	    {
			Toast.makeText(MainActivity.this,"网络未连接",Toast.LENGTH_LONG).show();
		}
    }
}

