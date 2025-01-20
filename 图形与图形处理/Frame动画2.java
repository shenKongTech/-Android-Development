package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import java.util.ArrayList;
import android.view.*;
import android.graphics.drawable.Drawable;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.*;
import android.graphics.drawable.AnimationDrawable;
public class MainActivity extends Activity
{


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ImageView imageView=findViewById(R.id.iv);
		Button button=findViewById(R.id.bt);
		Button button1=findViewById(R.id.bt1);
		imageView.setImageResource(R.drawable.donghua);
		final AnimationDrawable animation=(AnimationDrawable)imageView.getDrawable();
		button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					if(animation!=null)
					{
					animation.start();
					}
					else
					{
						Toast.makeText(MainActivity.this,"动画为空",Toast.LENGTH_SHORT).show();
					}
				}
			});
		button1.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					animation.stop();
				}
			});
	}

	}
	/***当命名空间schemas 写成schema 时，getDrawable 返回一个null，软件闪退
	<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"

    android:oneshot="false">
    <item android:drawable="@drawable/anim" android:duration="80"/>
    <item android:drawable="@drawable/anim2" android:duration="80"/>
    <item android:drawable="@drawable/anim3" android:duration="80"/>
</animation-list>**/
