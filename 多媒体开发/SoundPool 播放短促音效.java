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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.animation.ValueAnimator;
import android.animation.ObjectAnimator;
import android.view.animation.AnimationSet;
import android.animation.AnimatorSet;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.AudioManager;
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
		final SoundPool pool=new SoundPool(3,AudioManager.STREAM_SYSTEM,5);
		final int s1,s2,s3;
		s1=pool.load(this,R.raw.alert,1);
		s2=pool.load(this,R.raw.click,1);
		s3=pool.load(this,R.raw.press,1);
		bt1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				pool.play(s1,1,1,0,1,1);
			}
		});
		bt2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 pool.play(s2,1,1,0,1,1);
				}
			});
		bt3.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 pool.play(s3,1,1,0,1,1);
				}
			});
		
	}

	
	
}
	