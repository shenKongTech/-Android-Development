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
public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        RelativeLayout layout=findViewById(R.id.fy);
		final MyView_A myView=new MyView_A(this);
		layout.addView(myView);
		Button button=findViewById(R.id.bt);
		//Alert:myview 占满全屏，按钮无法点击
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(MainActivity.this,"已刷新",Toast.LENGTH_SHORT).show();
				myView.clear();
			}
		});
	}

}
class MyView_A extends View
{
	private Paint upaint;
	private Canvas ucanvas;
	private Bitmap ubitmap;
	private Path upath;
	private int ux;
	private int uy;
	
	public MyView_A(Context context)
	{
		super(context);
		init();
	}
	public void init()
	{
		upaint=new Paint();
		upath=new Path();
		upaint.setColor(Color.BLACK);
		upaint.setAntiAlias(true);
		upaint.setDither(true);
		upaint.setStyle(Paint.Style.STROKE);
		upaint.setStrokeJoin(Paint.Join.ROUND);
		upaint.setStrokeCap(Paint.Cap.ROUND);
		upaint.setStrokeWidth(3);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width=getMeasuredWidth();
		int height=getMeasuredHeight();
		ubitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
		ucanvas=new Canvas(ubitmap);
	}
	@Override
	public void onDraw(Canvas canvas)
	{
		drawpath();
		canvas.drawBitmap(ubitmap,0,0,null);
	}
	public void drawpath()
	{
		ucanvas.drawPath(upath,upaint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int action=event.getAction();
		int x=(int)event.getX();
		int y=(int)event.getY();
		switch (action)
		{
			case MotionEvent.ACTION_DOWN:
			
				ux=x;
				uy=y;
				upath.moveTo(x,y);
				break;
			
			case MotionEvent.ACTION_UP:
			
				int diffiX=Math.abs(x-ux);
				int diffiY=Math.abs(y-uy);
				if (diffiX>2||diffiY>2)
				    upath.lineTo(x,y);
				ux=x;
				uy=y;
				break;
		}
			invalidate();
			return true;
	}
	public void clear()
	{
		if(ucanvas!=null)
		{
			upath.reset();
			ucanvas.drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR);
			invalidate();
		}
			
	}
	
	
	
}