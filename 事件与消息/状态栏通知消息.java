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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.os.Build;
import android.app.NotificationChannel;
import androidx.core.app.NotificationCompat;


public class MainActivity extends Activity
{   
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button =findViewById(R.id.bt1);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
				{
					String channel_id="Default_channel";
					CharSequence channel_name="默认频道";
					int important=NotificationManager.IMPORTANCE_DEFAULT;
					NotificationChannel channel=new NotificationChannel(channel_id,channel_name,important);
					NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
					manager.createNotificationChannel(channel);
				}
				NotificationCompat.Builder noti=new NotificationCompat.Builder(MainActivity.this,"Default_channel");
				noti.setContentTitle("你收到一个新消息");
				noti.setContentText("点击查看");
				noti.setAutoCancel(true);
				//在部分设备，如红米K系列手机中，设置的小图标不显示，只显示应用图标
				noti.setSmallIcon(R.drawable.chat);
				noti.setDefaults(NotificationCompat.DEFAULT_SOUND);
				noti.setWhen(System.currentTimeMillis());
				Intent intent=new Intent(MainActivity.this,Message.class);
				PendingIntent pending=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
				noti.setContentIntent(pending);
				NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
				manager.notify(0x11,noti.build());
				
		     }
	     });
	}
}
			
	