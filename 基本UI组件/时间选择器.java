//这段代码创建了一个时间选择器和一个按钮，在主活动中创建了两个变量用于存放小时与分钟，先获取当前的时间，在时间选择器的事件监听中修改选择后的小时、分钟,通过单击按钮事件输出修改后的小时、分钟。
package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import java.util.Calendar;

public class MainActivity extends Activity {
	public int hour;
	public int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button a=findViewById(R.id.b1);
		TimePicker b=findViewById(R.id.t1);
		Calendar calendar=Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR);
		minute=calendar.get(Calendar.MINUTE);
		b.setOnTimeChangedListener((new TimePicker.OnTimeChangedListener(){
			@Override
			public void onTimeChanged(TimePicker timepicker,int j,int k){
				MainActivity.this.hour=j;
				MainActivity.this.minute=k;
			}
		}));
		a.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				String str="你选择的时间是："+MainActivity.this.hour+"时"+
				MainActivity.this.minute+"分";
				AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
				builder.setMessage(str);
				builder.setPositiveButton("确定",null).show();
			}
		});
		}
}