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
	private MediaPlayer player=null;
	private SurfaceView surface;
	private SurfaceHolder holder;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1=findViewById(R.id.bt1);
		bt2=findViewById(R.id.bt2);
		bt3=findViewById(R.id.bt3);
		surface=findViewById(R.id.sf);
		holder=surface.getHolder();
		holder.setFixedSize(320,200);
		player=MediaPlayer.create(this,R.raw.video_dessky);
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
		{
			@Override
			public void onCompletion(MediaPlayer play)
			{
				Toast.makeText(MainActivity.this,"视频播放完毕",Toast.LENGTH_SHORT).show();
			}
		});
		bt1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				player.setDisplay(holder);
	            player.start();
			}
		});
		bt2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 player.pause();
				}
			});
		bt3.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
                 player.stop();
				}
			});
		
	}

	
	
}
	