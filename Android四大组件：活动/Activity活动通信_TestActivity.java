package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.location.Location;

public class TestActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
		Intent intent= getIntent();
		Bundle bundle= intent.getExtras();
		TextView textview=findViewById(R.id.tv);
		Button botton2=findViewById(R.id.btn2);
		String str="个人资料"+"\n"+"姓名："+bundle.getString("Name")+"\n"+
		"性别："+bundle.getString("Sex")+"\n"+"生日："+bundle.getString("Born")
		+"\n"+"所在地:"+bundle.getString("Location")+"\n"+"个性签名："
		+bundle.getString("Write")+"\n";
		textview.setText(str);
		botton2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				finish();
			}
		});
        
    }
    
}