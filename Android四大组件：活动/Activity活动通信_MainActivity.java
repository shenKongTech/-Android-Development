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
import android.app.AlertDialog;





public class MainActivity extends Activity
{   
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Intent intent=new Intent(MainActivity.this,TestActivity.class);
		final Bundle bundle=new Bundle();
		Button botton=findViewById(R.id.bt1);
		 
		
	    botton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				
					EditText e1=findViewById(R.id.et1);
					EditText e2=findViewById(R.id.et2);
					EditText e3=findViewById(R.id.et3);
					EditText e4=findViewById(R.id.et4);
					EditText e5=findViewById(R.id.et5);
					String str1= e1.getText().toString();
					String str2= e2.getText().toString();
					String str3= e3.getText().toString();
					String str4= e4.getText().toString();
					String str5= e5.getText().toString();
				if(!str1.equals("")&&!str2.equals("")&&
				   !str3.equals("")&&!str4.equals("")&&!str5.equals(""))
				{
					bundle.putCharSequence("Name",str1);
					bundle.putCharSequence("Sex",str2);
					bundle.putCharSequence("Born",str3);
					bundle.putCharSequence("Location",str4);
					bundle.putCharSequence("Write",str5);
					intent.putExtras(bundle);
					startActivity(intent);
				}
				else
				{
					AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
					builder.setMessage("请完善好个人资料");
					builder.setPositiveButton("好的",null).show();
					return;
				}
				
			}
		});
		
	}
}

