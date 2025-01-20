package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import java.util.List;
import java.util.ArrayList;
import android.view.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import com.example.application.TestActivity;





public class MainActivity extends Activity
{   
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton btn=findViewById(R.id.btn1);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent =new Intent(MainActivity.this,TestActivity.class);
				startActivity(intent);
			}
		});
		
	}
}

