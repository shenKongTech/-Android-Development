package com.example.application;
import android.widget.Button;
import android.util.AttributeSet;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.KeyEvent;

public class MyButton extends Button
{
	private Context cont;
    public MyButton(Context context,AttributeSet attr)
	{
		super(context,attr);
		cont=context;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		
		Toast.makeText(cont,"你触碰了自定义按钮", Toast.LENGTH_SHORT).show();
		return true;
	}
    @Override
	public boolean onKeyUp(int keyCode,KeyEvent event)
	{
		Toast.makeText(cont,"你释放下了键盘", Toast.LENGTH_SHORT).show();
		return true;
	}
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		Toast.makeText(cont,"你按下了键盘", Toast.LENGTH_SHORT).show();
		return true;
	}
    
}