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
		SeekBar a=findViewById(R.id.s1);
		final TextView b=findViewById(R.id.t1);
		a.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekbar,int i,boolean p){
				b.setText("当前进度条进度为："+i+"/100");
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar){
				Toast.makeText(MainActivity.this,"你触碰了进度条",
				Toast.LENGTH_SHORT).show();
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekbar){
				Toast.makeText(MainActivity.this,"你停止触碰进度条",
							   Toast.LENGTH_SHORT).show();
			}
		});
		
		
		}
}