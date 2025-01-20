package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.Context;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner a=findViewById(R.id.s1);
		a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> adapterView,View view,int i,long l){
				String str=adapterView.getSelectedItem().toString();
				if(!str.equals("全部")){
					Toast.makeText(MainActivity.this,
					"你选择的电影类型是"+str+"，正在跳转中...",Toast.LENGTH_SHORT).show();
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?>   adaptview)
			{
				
			}
		});
	}
}