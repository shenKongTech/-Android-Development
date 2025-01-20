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
import android.view.ViewGroup;
import android.content.Context;

public class MainActivity extends Activity {
    //声明一个数组资源
    private int arr[]=new int[]
	{R.drawable.account,R.drawable.android,
		R.drawable.click,R.drawable.electri,
		R.drawable.homee,R.drawable.pen,
		R.drawable.phone,R.drawable.plane};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//绑定网格视图
		GridView a=findViewById(R.id.g1);
		//设置适配器（图片适配器）
		a.setAdapter(new ImageAdapter(this));
	}
	//创建图片适配器类，继承 BaseAdapter 类
	public class ImageAdapter extends BaseAdapter{
	    //声明上下文
		private Context m_cont;
		//调用初始化方法初始化上下文
		public ImageAdapter(Context c)
		{
			m_cont=c;
		}
		@Override
		//获取图片资源个数
		public int getCount()
		{
			return arr.length;
		}
		//获取资源
		public Object getItem(int i)
		{
			return 0;
		}
		//获取资源 ID
		public long getItemId(int i)
		{
			return 0;
		}
		@Override
		//调用获取图像方法，传入图像数组下标，图像，图像群
		public View getView(int i,View view,ViewGroup viewgroup){
		//初始化图像视图
			ImageView imageV = null;
			if(imageV==null)
			{    
			    //调用初始化方法，传入适配器的上下文作为参数
				 imageV=new ImageView(m_cont);
				 //初始化图片视图布局属性
				imageV.setLayoutParams(new GridView.LayoutParams(150, 230));
				//初始化图片视图缩放方式
				imageV.setScaleType(ImageView.ScaleType.CENTER_CROP);
			}
			//可优化段
			else
			{
				imageV=(ImageView) view;
			}
			//利用图像视图设置图像资源，遍历图像资源数组
			imageV.setImageResource(arr[i]);
			//返回全部图片资源给网格视图组件
			return imageV;
			
		}
	}
}