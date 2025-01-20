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
public class MainActivity extends Activity implements View.OnClickListener
{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv =findViewById(R.id.tv);
		Button bt1=findViewById(R.id.bt1);
		Button bt2=findViewById(R.id.bt2);
		Button bt3=findViewById(R.id.bt3);
		Button bt4=findViewById(R.id.bt4);
		Button bt5=findViewById(R.id.bt5);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
			case R.id.bt1:
			{
				ObjectAnimator ani=ObjectAnimator.ofFloat(tv,"alpha",1f,0f,1f);
				ani.setDuration(5000);
				ani.start();
				break;
			}
			case R.id.bt2:
			{
				ObjectAnimator ani=ObjectAnimator.ofFloat(tv,"scaleY",1f,3f,1f);
				ani.setDuration(5000);
				ani.start();
				break;
			}
			case R.id.bt3:
			{
				float nx=tv.getTranslationX();
				ObjectAnimator ani=ObjectAnimator.ofFloat(tv,"translationX",nx,-500f,nx);
				ani.setDuration(5000);
				ani.start();
				break;
			}
			case R.id.bt4:
			{
				ObjectAnimator ani=ObjectAnimator.ofFloat(tv,"rotation",0f,360f);
				ani.setDuration(5000);
				ani.start();
				break;
			}
			case R.id.bt5:
			{
				ObjectAnimator alpha=ObjectAnimator.ofFloat(tv,"alpha",1f,0f,1f);
				ObjectAnimator translation=ObjectAnimator.ofFloat(tv,"translationX",-500f,0f);
				ObjectAnimator rotation=ObjectAnimator.ofFloat(tv,"rotation",0f,360f);
				AnimatorSet aniset=new AnimatorSet();
				aniset.play(rotation).with(alpha).after(translation);
				aniset.setDuration(5000);
				aniset.start();
				break;
			}
			
		}
	} 
}
	