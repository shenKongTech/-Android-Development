package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.MotionEvent;

public class MainActivity extends Activity {
    private int arr[]=new int[]
	{R.drawable.account,R.drawable.android,
		R.drawable.click,R.drawable.electri,
		R.drawable.homee,R.drawable.pen,
		R.drawable.phone,R.drawable.plane};
    private int index;
	private int downx;
	private int upx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ImageSwitcher a=findViewById(R.id.s1);
		ImageView b=new ImageView(MainActivity.this);
		//设置进入和退出动画
		a.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));
		a.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));
		//设置Factory，在其中用ViewSwitcher.ViewFactory实现类，重写makeView方法，在Factory中显示图片
		a.setFactory(new ViewSwitcher.ViewFactory(){
			@Override
			public View makeView(){
				ImageView picture=new ImageView(MainActivity.this);
				picture.setImageResource(arr[index]);
				return picture;
			};
		});
       a.setOnTouchListener(new View.OnTouchListener(){
		   @Override
		   public boolean onTouch(View view,MotionEvent motionevent){
			   if(motionevent.getAction()==MotionEvent.ACTION_DOWN)
				{
				   downx=(int) motionevent.getX();
				   return true;
			       }
			   else if(motionevent.getAction()==MotionEvent.ACTION_UP)
				   {
				   upx=(int)motionevent.getX();
				   if(upx-downx>10)
					   {
					   index=index==0?arr.length-1:index-1;
					   a.setImageResource(arr[index]);
				       }
				   else if(downx-upx>10)
					   {
					   index=index==arr.length-1?0:index+1;
					   a.setImageResource(arr[index]);
				       }
				   return true;
			       }
				 return false;
		        }
	   });



	}
	
}