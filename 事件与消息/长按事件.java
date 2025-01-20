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
		ImageView image=findViewById(R.id.iv1);
		image.setOnLongClickListener(new View.OnLongClickListener()
		{
			@Override
			public boolean onLongClick(View v)
			{
				Toast.makeText(MainActivity.this,"你触发了长按事件",Toast.LENGTH_SHORT).show();
				return true;
			}
			
		});
		
    }
	
	

}