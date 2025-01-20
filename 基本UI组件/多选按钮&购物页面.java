package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//创建四个 CheckBox 可选框对象，分别绑定 b1,b2,b3,b4
		final CheckBox a=findViewById(R.id.b1);
		final CheckBox b=findViewById(R.id.b2);
		final CheckBox c=findViewById(R.id.b3);
		final CheckBox d=findViewById(R.id.b4);
		final CheckBox e=findViewById(R.id.b5);
		//创建 Button 按钮对象
		Button   f=findViewById(R.id.ok);
		//设置点击事件监听器
		f.setOnClickListener(new View.OnClickListener(){
			@Override
			//设置点击事件
			public void onClick(View v){
			//创建一个字符串变量 str 存放字符串
				String str="购物车：";
				//如果任意一个多选框被选中，则获取多选框的文本字符串，并存入字符串变量
				if(a.isChecked()){
					str+=a.getText().toString()+" ";
				}
				if(b.isChecked()){
					str+=b.getText().toString()+" ";
				}
				if(c.isChecked()){
					str+=c.getText().toString()+" ";
				}
				if(d.isChecked()){
					str+=d.getText().toString()+" ";
				}
				if(e.isChecked()){
					str+=e.getText().toString()+" ";
				}
				//创建警示对话框对象，显示字符串变量存储的字符串
				AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
				builder.setMessage(str);
				builder.setPositiveButton("确定",null).show();
				
			}
			
			
		});
			
}}
