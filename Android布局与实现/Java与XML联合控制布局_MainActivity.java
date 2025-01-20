package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置显示的内容视图，搜索布局文件 avtivity_main
		setContentView(R.layout.activity_main);
		//创建一个 EditText 对象，绑定对象 edit，使 e 指向 edit 在 xml 中设置的布局属性
        final EditText e= findViewById(R.id.edit);
        //创建一个 Button 对象，绑定对象 btn
		Button btn1=findViewById(R.id.btn);
		//设置点击事件监听器
		btn1.setOnClickListener(new View.OnClickListener(){
		@Override
		//设置点击事件
		public void onClick(View v){
		//声明一个字符串str，指向编辑文本对象 e 通过 getText().toString()方法中返回的文本字符串
			String str=e.getText().toString();
			//用 Toast 的 makeText()和 show()方法显示 str 和其他字符串
			Toast.makeText(MainActivity.this,"你输入了："
			+str,Toast.LENGTH_SHORT).show();
			
		  }
		});
        
    }
    
}