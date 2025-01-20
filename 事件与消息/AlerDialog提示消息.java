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


public class MainActivity extends Activity
{   
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button=findViewById(R.id.bt1);
		Button button1=findViewById(R.id.bt2);
		Button button2=findViewById(R.id.bt3);
		Button button3=findViewById(R.id.bt4);
		//普通按钮对话框
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				AlertDialog alert=new AlertDialog.Builder(MainActivity.this).create();
				alert.setTitle("今日天气");
				alert.setIcon(R.drawable.rain);
				alert.setMessage("今天下雨，出门记得带伞哦～");
				alert.setButton(DialogInterface.BUTTON_POSITIVE,"好的",new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i)
					{
						Toast.makeText(MainActivity.this,"雨总会停，阳光总会出现！",Toast.LENGTH_SHORT).show();
					}
				});
				alert.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i)
					{
						Toast.makeText(MainActivity.this,"我下次还会提醒你的！",Toast.LENGTH_SHORT).show();
					}
				});
				alert.show();
			}
		});
		
		//普通列表项对话框(AIDE PRO软件问题，普通列表项对话框无法显示)
		
		button1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final String[] str= new String[]
				{"语文","数学","英语","物理","政治","化学"};
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("考试科目");
				builder.setMessage("请选择你的考试科目");
				builder.setItems(str,new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i)
					{
						Toast.makeText(MainActivity.this,"你选择了："+str[i]+"！",Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();
			}
		});
		//单选列表项对话框
		button2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				final String str[]= new String[]
				{"语文","数学","英语","物理","化学","生物"};
				AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
				alert.setTitle("选择你最喜欢的科目吧");
				alert.setSingleChoiceItems(str,0,new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i)
					{
						Toast.makeText(MainActivity.this,"看来你最喜欢"+str[i],Toast.LENGTH_SHORT).show();
					}
				});
				alert.show();
			}
		});
		//多选列表项对话框
		button3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				final String str[]=new String[]
				{
					"旅游","画画","书法","音乐","舞蹈","写作","篮球"
				};
				final boolean id[]={false,false,false,false,false,false,false};
				
				builder.setTitle("请选择你的兴趣爱好");
				builder.setMultiChoiceItems(str,id,new DialogInterface.OnMultiChoiceClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i,boolean b)
					{
						id[i]=b;
					}
				});
				builder.setPositiveButton("确定",new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface face,int i)
					{
						String data="";
						for(int k=0;k<id.length;k++)
						{
							if(id[k]==true)
							{
								data+=str[k]+" ";
							}
						}
						if(!data.equals(""))
						{Toast.makeText(MainActivity.this,"你的兴趣爱好竟然是："+data+"!",
						Toast.LENGTH_SHORT).show();
						}
						if(data.equals(""))
						{
							Toast.makeText(MainActivity.this,"你居然没有兴趣爱好！",Toast.LENGTH_SHORT).show();
						}
					}
				});
				builder.show();
			}
			
			
		});
    }
}