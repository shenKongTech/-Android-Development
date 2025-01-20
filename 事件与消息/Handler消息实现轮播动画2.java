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
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.NotificationManager;
import android.os.Build;
import android.app.NotificationChannel;
import androidx.core.app.NotificationCompat;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Looper;
import android.os.Messenger;


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
				MyThread myThraed=new MyThread(MainActivity.this);
				myThraed.start();
			}
		});
	}
}

class MyThread extends Thread
{
	private Context myContext;
	public MyThread(Context context)
	{
		myContext=context;
	}
	public void run()
	{
		final Handler handler;
		super.run();
		Looper.prepare();
		handler=new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				super.handleMessage(msg);
				Toast.makeText(myContext,"接受到消息:"+msg.what,Toast.LENGTH_SHORT).show();
			}
		};
		Message message=handler.obtainMessage();
		message.what=0x11;
		handler.sendMessage(message);
		Looper.loop();
	}
	
}
	