package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//创建一个 RadioGroup 单选按钮群对象并绑定 grouo
	    RadioGroup a=findViewById(R.id.group);
	    //设置 RadioView 对象的选中改变事件监听器
		a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
				@Override
				//设置选中改变事件
				public void onCheckedChanged(RadioGroup radiogroup,int i){
				//创建一个单选按钮对象，并绑定 id
					RadioButton a1=findViewById(R.id.b1);
					//用 getText()方法获取按钮文本，并用 Toast.makeText().show()方法显示
					Toast.makeText(MainActivity.this,a1.getText(),Toast.LENGTH_SHORT).show();
				}
			});

      }
}
