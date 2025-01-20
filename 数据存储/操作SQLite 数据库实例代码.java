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
	    String name;
		int age;
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			//打开或者新建一个SQLLite数据库
            SQLiteDatabase base=openOrCreateDatabase
			("text.db",MainActivity.this.MODE_PRIVATE,null);
			//建立一个person表格
			base.execSQL("DROP TABLE IF EXISTS user");
			base.execSQL("CREATE TABLE user(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,age SMALLINT)");
			name="李华";
			age=30;
			//插入数据
			base.execSQL("INSERT INTO user VALUES (null,?,?)",new Object[]{name,age});
			name="张三";
		    age=33;
			//通过ContentValues插入数据
			ContentValues values=new ContentValues();
			values.put("name",name);
			values.put("age",age);
			base.insert("user",null,values);
			values=new ContentValues();
			values.put("age",35);
			//更新数据
			base.update("user",values,"name=?",new String[]{"张三"});
			//获取查询游标
			Cursor cursor=base.rawQuery("SELECT*FROM user WHERE age>=?",new String[]{"25"});
			//循环遍历数据库
			while(cursor.moveToNext())
			{
				int _id=cursor.getInt(cursor.getColumnIndex("_id"));
				String name=cursor.getString(cursor.getColumnIndex("name"));
				int age=cursor.getInt(cursor.getColumnIndex("age"));
				final String str=Integer.toString(_id)+""+name+""+Integer.toString(age);
				Handler handler=new Handler();
				//控制延时Toast
				handler.postDelayed(new Runnable()
				{
					@Override
					public void run()
					{
						Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
					}
				},1000);
			}
			//关闭游标
			cursor.close();
			//删除数据
			base.delete("user","age<?",new String[]{"35"});
			//关闭数据库
			base.close();
			
		}
}
