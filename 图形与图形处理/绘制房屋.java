package com.example.application;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.view.MotionEvent;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.RectF;

public class MyView extends View
{
    public MyView(Context context)
	{
		super(context);
	}
	public void onDraw(Canvas canvas)
	{
		//绘制屋顶
		Paint paint=new Paint();
		paint.setAntiAlias(true);
		paint.setColor(0xffFF6666);
		canvas.drawRect(100,150,360,300,paint);
		//绘制屋檐
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(2);
		canvas.drawLine(230,50,50,185,paint);
		canvas.drawLine(230,50,410,185,paint);
		//绘制窗户
		paint.setColor(Color.WHITE);
		canvas.drawCircle(150,200,30,paint);
		canvas.drawCircle(310,200,30,paint);
		//绘制门
		RectF f=new RectF(210,230,255,310);
		canvas.drawRoundRect(f,10,10,paint);
		//绘制窗户格栅
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(2);
		canvas.drawLine(150,170,150,230,paint);
		canvas.drawLine(120,200,180,200,paint);
		canvas.drawLine(310,170,310,230,paint);
		canvas.drawLine(280,200,340,200,paint);
	}
}