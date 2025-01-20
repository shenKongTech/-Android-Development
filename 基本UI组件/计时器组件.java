package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import java.util.Calendar;
import android.annotation.NonNull;
import android.os.SystemClock;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button a=findViewById(R.id.b1);
		Button b=findViewById(R.id.b2);
		Button c=findViewById(R.id.b3);
		final Chronometer d=findViewById(R.id.c1);
		d.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
			@Override
			public void onChronometerTick(Chronometer chronometer){
				String str=chronometer.getText().toString();
				if(str.equals("00:10")){
					chronometer.stop();
					AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
					builder.setMessage("时间到！");
					builder.setPositiveButton("确定",null).show();
				}
			}
		});
		a.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				d.start();
			}
		});
		b.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					d.stop();
				}
			});
		c.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					d.setBase(SystemClock.elapsedRealtime());
				}
			});
		
		
		}
}