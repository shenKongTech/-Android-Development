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
public class MainActivity extends Activity {

		String data;
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
            final EditText edit=findViewById(R.id.et);
			Button bt1=findViewById(R.id.bt1);
			Button bt2=findViewById(R.id.bt2);
			File file=new File(getExternalFilesDir(null),"test1.txt");
			try
			{
				file.createNewFile();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		    bt1.setOnClickListener(new View.OnClickListener()
			{
			
				@Override
				public void onClick(View v)
				{
					FileOutputStream stream=null;
					data=edit.getText().toString();
					try
					{
						//以写的方式打开文件
						stream=openFileOutput("test1",MODE_APPEND);
						stream.write(data.getBytes());
						stream.flush();
						stream.close();
					}
					catch(FileNotFoundException e)
					{
						e.printStackTrace();
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					
				}
			});
			bt2.setOnClickListener(new View.OnClickListener()
				{
					  byte buffer[];
					@Override
					public void onClick(View v)
					{
                      FileInputStream stream=null;
					  try
					  {
						  stream=openFileInput("test1");
						  int length=stream.available();
						  buffer=new byte[length];
						  stream.read(buffer);
						  buffer.toString();
					  }
					  catch(FileNotFoundException e)
					  {
						  e.printStackTrace();
					  }
					  catch(IOException e)
					  {
						  e.printStackTrace();
					  }
					  finally
					  {
						  if(stream!=null)
						  {
							  try
							  {
								  stream.close();
								  String str=new String(buffer);
								  edit.setText(str);
							  }
							  catch(IOException e)
							  {
								  e.printStackTrace();
							  }
							  
						  }
					  }
					}
				});
	}
}
