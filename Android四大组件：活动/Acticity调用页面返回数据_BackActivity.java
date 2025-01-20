package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.content.Intent;
import android.widget.*;
import android.view.View;
import android.view.ViewGroup;

public class BackActivity extends Activity {
    int picture[]=new int[]
	{
		R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar3,
		R.drawable.avatar4,R.drawable.avatar5
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.back);
		GridView gridview=findViewById(R.id.gv1);
		gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adpterview,View v,int i,long l)
			{
				Intent intent=getIntent();
				Bundle bundle =new Bundle();
				bundle.putInt("Id",picture[i]);
				intent.putExtras(bundle);
			    setResult(333,intent);
				finish();
			};
		});
        BaseAdapter adapter=new BaseAdapter()
		{


			@Override
			public int getCount()
			{
				return picture.length;
			}
			@Override
			public Object getItem(int i)
			{
				return i;
			}
			@Override
			public long getItemId(int i)
			{
				return i;
			}
			@Override
			public View getView(int i,View view,ViewGroup viewgroup)
			{
				ImageView imageView = null;
				if(view==null)
				{
					imageView=new ImageView(BackActivity.this);
					imageView.setAdjustViewBounds(true);
					imageView.setMaxHeight(140);
					imageView.setMaxWidth(140);
					imageView.setPadding(5,5,5,5);
				}
				else
				{
					imageView=(ImageView) view;
				}
				imageView.setImageResource(picture[i]);
				return imageView;
			}
		};
		gridview.setAdapter(adapter);
    }
    
}