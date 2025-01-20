package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import java.util.ArrayList;
import android.view.*;
import android.graphics.drawable.Drawable;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.bt);
		final ImageView imageView=findViewById(R.id.iv1);
		button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.anim);
					Bitmap bitmap1=Bitmap.createBitmap(bitmap,50,50,300,300);
					imageView.setImageBitmap(bitmap1);
				}
			});
	}

}
	