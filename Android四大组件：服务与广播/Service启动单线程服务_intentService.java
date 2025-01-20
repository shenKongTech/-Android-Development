package com.example.application;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.app.IntentService;
import android.widget.Toast;

public class intentService extends IntentService 
{
    public intentService()
	{
		super("intentService");
	}
	@Override
	public void onHandleIntent(Intent intent)
	{
		int i;
		Toast.makeText(this,"单线程服务已启动",Toast.LENGTH_SHORT).show();
		for(i=0;i<10;i++)
		{
		}
		Toast.makeText(this,"服务状态："+i,Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this,"单线程服务已自动销毁",Toast.LENGTH_SHORT).show();
	}
	
}