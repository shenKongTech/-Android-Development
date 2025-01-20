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


public class MainActivity extends Activity
{   
    private ImageView iv;
    int picture_id[]=new int[]
	{
		R.drawable.anim,R.drawable.anim2,R.drawable.anim3
	};
	int start=0;
	Handler handler=new Handler()
	{

		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what== 0xFF)
			{
				iv.setImageResource(picture_id[start++ %3]);
			}
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv=findViewById(R.id.iv1);
		new Timer().schedule(new TimerTask ()
		{
			@Override
			public void run()
			{
				handler.sendEmptyMessage(0xFF);
			}
		},0,1000);
		
	}
}
			
	