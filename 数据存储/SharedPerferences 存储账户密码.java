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
public class MainActivity extends Activity
{
	    EditText edit1;
		EditText edit2;
		Button bt1;
		Button bt2;
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
              edit1=findViewById(R.id.et1);
			  edit2=findViewById(R.id.et2);
			  bt1=findViewById(R.id.bt1);
			  bt2=findViewById(R.id.bt2);
			  bt1.setOnClickListener(new View.OnClickListener()
			  {
				  @Override
				  public void onClick(View v)
				  {
					  String name=edit1.getText().toString();
					  String password=edit2.getText().toString();
					  SharedPreferences.Editor sp=getSharedPreferences
					  ("data",MODE_PRIVATE).edit();
					  sp.putString("User_name",name);
					  sp.putString("Password",password);
					  sp.apply();
					  Toast.makeText(MainActivity.this,"账户创建成功",Toast.LENGTH_SHORT).show();
				  }
			  });
			bt2.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
                     SharedPreferences sp2=getSharedPreferences("data",MODE_PRIVATE);
					 String name2=sp2.getString("User_name","");
					 String password2=sp2.getString("Password","");
					 if(!name2.equals("")&& !password2.equals(""))
					 {
				     edit1.setText(name2);
					 edit2.setText(password2);
					 Toast.makeText(MainActivity.this,"账户读取成功",Toast.LENGTH_SHORT).show();
					 }
					 else
					 {
						 Toast.makeText(MainActivity.this,"未创建账户",Toast.LENGTH_SHORT).show();
					 }
					}
				});
		}
}
