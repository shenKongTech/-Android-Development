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
		Drawable frame1=getResources().getDrawable(R.drawable.anim);
		Drawable frame2=getResources().getDrawable(R.drawable.anim2);
		AnimationDrawable anim=new AnimationDrawable();
		anim.addFrame(frame1,80);
		anim.addFrame(frame2,80);
		imageView.setBackgroundDrawable(anim);
		anim.start();
	}

}
