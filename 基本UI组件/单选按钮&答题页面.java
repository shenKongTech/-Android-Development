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
		//创建一个 RadioGroup 单选按钮群对象，绑定 group
		final RadioGroup a=findViewById(R.id.group);
		//创建一个 Button 按钮对象，绑定 ok
		Button b=findViewById(R.id.ok);
		//设置点击事件监听器
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			//设置点击事件
			public void onClick(View v){
			//getChildCount()方法返回 a 对象的所有成员个数，即单选按钮群中的单选按钮个数
				for(int i=0;i<a.getChildCount();i++){
				//getChildAt(i)返回单选按钮群中的第 i 个单选按钮对象，使对象 c 利用 for 循环指向所有单选按钮
					RadioButton c=(RadioButton)a.getChildAt(i);
					//isChecked() 方法返回一个布尔值，用于判断单选按钮是否被选中
					if(c.isChecked()){
					//如果某个单选按钮是被选中状态，用 getText()方法获取按钮的文本，再用 equals()方法与传入 equals 的参数相匹配，返回一个布尔值，判断是否成功匹配
						if(c.getText().equals("疑是地上霜")){
						//如果被选中的单选按钮文本成功匹配，用 Toast 显示选择正确
							Toast.makeText(MainActivity.this,"选择正确",
							Toast.LENGTH_SHORT).show();
						}
						else{
						//如果被选中的单选按钮文本未能与指定字符串成功匹配
						//创建一个 AlertDialog.Builder 警示对话框建立者对象，传入当前活动得上下文作为初始化参数
							AlertDialog.Builder d=new AlertDialog.Builder(MainActivity.this);
							//设置警示框建立者对象的包含信息
							d.setMessage("回答错误");
							//设置警示框的确定按钮，注意第二参数为 null，然后显示出来
							d.setPositiveButton("确定",null).show();
							
						}
						//执行完退出循环
						break;
					}
				}
			}
		});
			
			
			
			
}}
