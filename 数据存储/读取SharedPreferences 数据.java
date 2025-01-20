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
public class MainActivity extends Activity {

		String data;
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
            final EditText edit=findViewById(R.id.et);
			SharedPreferences sp=getSharedPreferences("test",MODE_PRIVATE);
			String name=sp.getString("name","chen");
			boolean sex=sp.getBoolean("boy",true);
			int age=sp.getInt("age",18);
			String str="姓名："+name+"\n"+"性别:男"+Boolean.toString(sex)+"\n"+"年龄"+Integer.toString(age);
			Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
	}
}
