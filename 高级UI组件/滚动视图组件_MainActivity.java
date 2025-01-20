package com.example.application;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout a=findViewById(R.id.l1);
	    ScrollView b= new ScrollView(MainActivity.this);
		TextView c=new TextView(MainActivity.this);
		c.setText(R.string.text_pome);
		b.addView(c);
		a.addView(b);
	}
}
