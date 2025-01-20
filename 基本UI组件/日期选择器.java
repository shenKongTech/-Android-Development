//这个例子创建了一个日期选择器、一个“确定”按钮，在主活动onCreate 方法中获取当前年月日，并设置日期选择监听将改变后的年月日进行替换，最后通过按钮单击事件打印输出选择后的年月日。
package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import java.util.Calendar;

public class MainActivity extends Activity {

	public int year;

	public int month;

	public int day;

	
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DatePicker a=findViewById(R.id.date);
		Calendar calendar=Calendar.getInstance();
		Button b=findViewById(R.id.b1);
	    int year,month,day;
		year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
		day=calendar.get(Calendar.DAY_OF_MONTH);
		a.init(year,month,day,new DatePicker.OnDateChangedListener(){
			@Override
			public void onDateChanged(DatePicker datepicker,int j,int k,int l){
				MainActivity.this.year=j;
				MainActivity.this.month=k;
				MainActivity.this.day=l;
				
			}
		});
        b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				String str=MainActivity.this.year+"年"+(MainActivity.this.month)+"月"+
				(MainActivity.this.day)+"日";
				AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
				builder.setMessage(str);
				builder.setPositiveButton("确定",null).show();
				
			}
		});
		}
}