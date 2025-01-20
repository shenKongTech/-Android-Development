//以上代码演示了如何使用一个日历视图组件。在布局管理器中布局了一个日历视图，在主活动中创建并绑定，设置监听事件发生改变做出的提示，根据实际需要在监听事件中设置相应的逻辑。
package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import java.util.Calendar;
import android.annotation.NonNull;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CalendarView a=findViewById(R.id.c1);
		a.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
			@Override
			public void onSelectedDayChange(CalendarView 
			calendarView,int year,int month,int day_OfMonth){
				String str="你选择的日期是："+year+"年"+
				month+"月"+day_OfMonth+"日";
				AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
				builder.setMessage(str);
				builder.setPositiveButton("确定",null).show();
			}
		});
		}
}