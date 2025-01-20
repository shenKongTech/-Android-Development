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
	    button.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v,MotionEvent event)
			{
				Toast toast= Toast.makeText(MainActivity.this,
				"今天是下雨天，天气冷，出门记得要多穿些衣服哦～",Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM,0,0);
				LinearLayout linear=(LinearLayout)toast.getView();
				ImageView imageView=new ImageView(MainActivity.this);
				imageView.setImageResource(R.drawable.rain);
				linear.addView(imageView,0);
				TextView textView=(TextView)toast.getView().findViewById(R.id.tv1);
				toast.show();
				return true;
			}
		});
    }
}