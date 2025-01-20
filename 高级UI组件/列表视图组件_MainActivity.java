package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int pic[]=new int[]
		{
			R.drawable.cloud,R.drawable.hot,R.drawable.rain,
			R.drawable.rainelec,R.drawable.snow,R.drawable.sunmy,
			R.drawable.wind
		};
		String str[]=new String[]
		{
			"多云","高温","雨天","雷雨","雪天","晴天","台风"
		};
		List<Map<String,Object>> listItem=new ArrayList<Map<String,Object>>();
		for(int i=0;i<pic.length;i++)
		{
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image",pic[i]);
			map.put("name",str[i]);
			listItem.add(map);
		}
		SimpleAdapter adapter=new SimpleAdapter(this,listItem,R.layout.list_main,
		new String[]{"image","name"},new int[]{R.id.i1,R.id.t1});
		ListView c=findViewById(R.id.l1);
		c.setAdapter(adapter);
	    c.setOnItemClickListener(new 
		AdapterView.OnItemClickListener()
			{
			@Override
			public void onItemClick(AdapterView<?> adapterView,
			View view,int i,long l)
			{
				Map<String,Object> map =(Map<String,Object>) adapterView.getItemAtPosition(i);
				Toast.makeText(MainActivity.this,"你选择了："+map.get("name").toString()+
				"天气",Toast.LENGTH_SHORT).show();
			}
		});
	}
}