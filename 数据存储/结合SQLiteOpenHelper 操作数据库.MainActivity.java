package com.example.application;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.os.Environment;
import android.view.View;
import android.content.Intent;import android.util.Log;
import java.io.InputStream;
import java.io.IOException;
import android.widget.EditText;
import android.widget.Button;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
public class MainActivity extends Activity
{
	    
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
		    Button bt1=findViewById(R.id.bt1);
			Button bt2=findViewById(R.id.bt2);
			Button bt3=findViewById(R.id.bt3);
			Button bt4=findViewById(R.id.bt4);
			Button bt5=findViewById(R.id.bt5);
			Button bt6=findViewById(R.id.bt6);
			Button bt7=findViewById(R.id.bt7);
			//创建数据库
			bt1.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,1);
					SQLiteDatabase base1=helper.getWritableDatabase();
				}
				
			});
			//更新数据库
			bt2.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
                     MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
					 SQLiteDatabase base2=helper.getWritableDatabase();
					}

				});
			//插入数据
			bt3.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
                    MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
					SQLiteDatabase base2=helper.getWritableDatabase();
					ContentValues values=new ContentValues();
					values.put("id",1);
					values.put("name","李华");
					base2.insert("user",null,values);
					base2.close();
					}

				});
				//修改数据
			bt4.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
						SQLiteDatabase base2=helper.getWritableDatabase();
						ContentValues values=new ContentValues();
						values.put("name","张三");
						base2.update("user",values,"id=?",new String[]{"1"});
						base2.close();
					}

				});
			bt5.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
						SQLiteDatabase base2=helper.getWritableDatabase();
						Cursor cursor=base2.query("user",new String[]{"id","name"},"id=?",new String[]{"1"},null,null,null);
						String id=null;
						String name=null;
						while(cursor.moveToNext())
						{
							id=cursor.getString(cursor.getColumnIndex("id"));
							name=cursor.getString(cursor.getColumnIndex("name"));
							Toast.makeText(MainActivity.this,id+name,Toast.LENGTH_SHORT).show();
						}
						base2.close();
					}

				});
			bt6.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
						SQLiteDatabase base2=helper.getWritableDatabase();
						base2.delete("user","id=?",new String[]{"1"});
						base2.close();
					}

				});
			bt7.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						MySqlite helper=new MySqlite(MainActivity.this,"test_1",null,2);
						SQLiteDatabase base2=helper.getWritableDatabase();
						deleteDatabase("test_1");
						Toast.makeText(MainActivity.this,"数据库已删除",Toast.LENGTH_SHORT).show();
					}

				});
			
		}
}
