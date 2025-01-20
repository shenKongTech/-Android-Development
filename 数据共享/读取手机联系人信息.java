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
import android.widget.Button;
import androidx.core.app.ActivityCompat;
import java.security.acl.Permission;
import android.content.pm.PackageManager;
import android.Manifest;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;
import androidx.core.content.ContextCompat;
import android.database.Cursor;
import android.provider.ContactsContract;

public class MainActivity extends Activity
{
	    ArrayAdapter<String> adapter;
		List<String> list=new ArrayList<>();
		ListView lv;
		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
		    lv=findViewById(R.id.lv1);
			adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
			lv.setAdapter(adapter);
			if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)!=PackageManager.PERMISSION_GRANTED)
				{
					ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
				}
			else
			{
				readData();
			}
         }
	private void readData()
	{
		Cursor cursor=null;
		try
		{
			cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
			if(cursor!=null)
			{
				while(cursor.moveToNext())
				{
					String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
					String tel=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					list.add("name"+name+"-"+"tel"+tel);
				}
				adapter.notifyDataSetChanged();
			}
			else
			{
				Toast.makeText(MainActivity.this,"您的联系人列表为空",Toast.LENGTH_SHORT).show();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(cursor!=null)
			{
				cursor.close();
			}
		}

	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
	{
		switch(requestCode)
		{
		     case 1:
			 {
				 if(grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED)
				 {
					 readData();
				 }
				 else
				 {
					 Toast.makeText(MainActivity.this,"您未授予权限",Toast.LENGTH_SHORT).show();
				 }
			 }
			 default:
		}
	}
}
