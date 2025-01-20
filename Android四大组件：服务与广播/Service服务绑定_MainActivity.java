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
import com.example.application.myBinderService.MyBinder;



public class MainActivity extends Activity
{   
    public myBinderService.MyBinder binder;
    ServiceConnection connect=new ServiceConnection()
	{
		@Override
		public  void onServiceDisconnected(ComponentName name)
		{
			Toast.makeText(MainActivity.this,"服务未连接",Toast.LENGTH_SHORT).show();
		}
		public void onServiceConnected(ComponentName name,IBinder ibinder)
		{
			binder= (myBinderService.MyBinder) ibinder;
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Intent intent=new Intent(MainActivity.this,myBinderService.class);
		Button button1=findViewById(R.id.btn1);
		Button button2=findViewById(R.id.btn2);
		Button button3=findViewById(R.id.btn3);
		//按钮1的点击监听事件
		button1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				bindService(intent,connect,BIND_AUTO_CREATE);
			}
		});
		//按钮2的
		button2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                   unbindService(connect);
				}
			});
		//按钮3的
		button3.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                   Toast.makeText(MainActivity.this,"服务状态："+binder.getCount(),Toast.LENGTH_SHORT).show();
				}
			});
    }