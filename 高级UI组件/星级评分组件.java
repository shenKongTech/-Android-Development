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
		RatingBar a=findViewById(R.id.r1);
		a.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
			@Override
			public void onRatingChanged(RatingBar ratingbar,float i,boolean b){
				Toast.makeText(MainActivity.this,"您打的评分是："+i+"分！",
				Toast.LENGTH_SHORT).show();
			}
		});
		
		
		}
}