package com.example.application;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.content.ComponentName;
import android.widget.Toast;
import java.net.ConnectException;

public class myBinderService extends Service 
{
	int count=0;
	boolean isStop=false;
    private MyBinder myBinder=new MyBinder();
	//创建一个类，实现返回服务器状态功能
	class MyBinder extends Binder
	{
		public int getCount()
		{
			return count;
		}
	}
    public myBinderService(){}
	@Override
	public IBinder onBind(Intent intent)
	{
		Toast.makeText(this,"服务已绑定",Toast.LENGTH_SHORT).show();
		return myBinder;
	}
	@Override
	public void onCreate() 
	{
		Toast.makeText(this,"服务已启动",Toast.LENGTH_SHORT).show();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				while(!isStop)
				{
					try
					{
						Thread.sleep(1000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					count++;
				}
			}
		}).start();
	 }
	@Override
	public boolean onUnbind(Intent intent)
	{
		Toast.makeText(this,"服务已解除绑定",Toast.LENGTH_SHORT).show();
		return true;
	}
	@Override
	public void onRebind(Intent intent)
	{
		Toast.makeText(this,"服务已重新绑定",Toast.LENGTH_SHORT).show();
		super.onRebind(intent);
	}
	@Override
	public void onDestroy()
	{
		Toast.makeText(this,"服务已销毁",Toast.LENGTH_SHORT).show();
		isStop=true;
	}
	
}