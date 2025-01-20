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
		Button button=findViewById(R.id.btn1);
		button.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					Intent intent =new Intent(MainActivity.this,BackActivity.class);
					startActivityForResult(intent,333);
				}
			});
	}
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==333&&data!=null)
		{
			Bundle bundle=data.getExtras();
			int id=bundle.getInt("Id");
			ImageView imageView=findViewById(R.id.iv1);
			imageView.setImageResource(id);
		}
	}

}

