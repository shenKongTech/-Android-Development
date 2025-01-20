//MainActivity.java
package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.GridView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用初始化方法创建一个相对布局
	    RelativeLayout layout= new RelativeLayout(this);
	    /**LayoutParams 是 RelativiLayout的一个内部类，里面存储着控制相对布局的属性
		 *用初始化方法初始化 params 对象，使其作为存储子视图在相对布局中的相对位置，       
		 *MATCH_PARENT 是 ViewGroup.LayoutParams 的常量属性，规定视图宽高与父视图相匹配**/
		RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.MATCH_PARENT,
			RelativeLayout.LayoutParams.MATCH_PARENT);
		//创建一个 Button 对象，将当前 Activity(上下文)作为参数传入，使其能够访问当前活动环境、资源和服务
		Button btn1=new Button(this);
		//调用 setText 方法为按钮设置显示文本
		btn1.setText("按钮1");
		//
		RelativeLayout.LayoutParams params1=new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.MATCH_PARENT,
			RelativeLayout.LayoutParams.WRAP_CONTENT);
		//用 setId 方法为按钮设置 id
		btn1.setId(1001);
		//用 setLayoutParams 方法设置按钮的布局属性
		btn1.setLayoutParams(params1);
		/**用 setOnClickListener 方法设置按钮点击事件监听器，
		 * 用初始化方法创建一个 View.OnClickListener 接口的一个匿名实现对象，作为 btn1 的监听器。
		 *{}中重写 onClick()方法，用来设置按钮 btn1 点击后的事件，View v 参数代指 btn1。
		 *用 Toast 类的 makeText 方法设置显示的文本信息和相关属性，MainActivity.this 作为上下文，表示显示位置是在 MainActivity 活动，然后设置显示的文本内容，Toast 类的常量 LENGTH_SHORT 表示短暂显示，最后用 show()方法显示*/
		btn1.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					Toast.makeText(MainActivity.this,"单击了按钮1",
								   Toast.LENGTH_SHORT).show();
				}
			});
		//用 addView 方法在布局中加入并显示按钮 btn1
	    layout.addView(btn1);
	    //新建一个按钮 btn2
		Button btn2=new Button(this);
		//用 setText 方法 设置 btn2 的显示文本
		btn2.setText("第二个按钮");
		//创建布局属性对象，存入子视图在相对布局中的宽高属性
		RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.MATCH_PARENT,
			RelativeLayout.LayoutParams.WRAP_CONTENT);
		//用 setLayoutParams 方法设置 btn2 的布局属性
		btn2.setLayoutParams(params2);
		//在布局属性对象中加入属性，相对布局在 按钮 btn1 的下方
		params2.addRule(RelativeLayout.BELOW,1001);
		//在布局中加入并显示按钮 btn2
		layout.addView(btn2);
		//设置活动的内容视图是 layout 对象
		setContentView(layout);

    }

}