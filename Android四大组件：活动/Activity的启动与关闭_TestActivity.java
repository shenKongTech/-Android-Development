package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;

public class TestActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
		Button botton2=findViewById(R.id.btn2);
		botton2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				finish();
			}
		});
        
    }
    
}