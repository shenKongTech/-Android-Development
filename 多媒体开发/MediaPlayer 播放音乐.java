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
		final  MediaPlayer media=MediaPlayer.create(this,R.raw.love_ergency);
		bt1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				media.start();
			}
		});
		bt2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 media.pause();
				}
			});
		bt3.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 media.stop();
				}
			});
		
	}

	
	
}
	