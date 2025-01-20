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
import com.example.application.BackActivity;
import android.app.AlertDialog;



public class MainActivity extends Activity
{   
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Intent intent =new Intent(MainActivity.this,MainService.class);
		Button button1=findViewById(R.id.btn1);
		Button button2=findViewById(R.id.btn2);
		button1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				startService(intent);
			}
		});
		button2.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					stopService(intent);
				}
			});
    }
     
}

