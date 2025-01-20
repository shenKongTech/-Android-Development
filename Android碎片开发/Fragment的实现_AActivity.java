package com.example.application;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast;
import android.graphics.Color;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import java.util.List;

public class AActivity extends Activity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    boolean state=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aactivity);
        init();
        //初始化显示页面
        Fragment1 fragement1=new Fragment1();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction trans=manager.beginTransaction();
        trans.replace(R.id.ff,fragement1);
        trans.commit();
   //切换Fragment页面
        t1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                flush();
                t1.setTextColor(Color.RED);
                Fragment1 fragement1=new Fragment1();
                FragmentManager manager=getFragmentManager();
                FragmentTransaction trans=manager.beginTransaction();
                trans.replace(R.id.ff,fragement1);
                trans.commit();
                
            }
        });
        t2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t2.setTextColor(Color.RED);
                    Fragment2 fragement2=new Fragment2();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement2);
                    trans.commit();
                }
            });
        t3.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t3.setTextColor(Color.RED);
                    Fragment3 fragement3=new Fragment3();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement3);
                    trans.commit();
                }
            });
        t4.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t4.setTextColor(Color.RED);
                    Fragment4 fragement4=new Fragment4();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement4);
                    trans.commit();
                }
            });
        t5.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t5.setTextColor(Color.RED);
                    Fragment5 fragement5=new Fragment5();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement5);
                    trans.commit();
                }
            });
        t6.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t6.setTextColor(Color.RED);
                    Fragment6 fragement6=new Fragment6();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement6);
                    trans.commit();
                }
            });
        t7.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t7.setTextColor(Color.RED);
                    Fragment7 fragement7=new Fragment7();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement7);
                    trans.commit();
                }
            });
        t8.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t8.setTextColor(Color.RED);
                    Fragment8 fragement8=new Fragment8();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement8);
                    trans.commit();
                }
            });
        t9.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {Toast.makeText(AActivity.this,"测试正常",Toast.LENGTH_SHORT).show();
                    flush();
                    t9.setTextColor(Color.RED);
                    Fragment9 fragement9=new Fragment9();
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction trans=manager.beginTransaction();
                    trans.replace(R.id.ff,fragement9);
                    trans.commit();
                }
            });
    }
    //初始化方法
    public void init()
    {
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);        
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
    }
    //刷新字体颜色
    public void flush()
    {
        t1.setTextColor(Color.BLACK);
        t2.setTextColor(Color.BLACK);
        t3.setTextColor(Color.BLACK);
        t4.setTextColor(Color.BLACK);
        t5.setTextColor(Color.BLACK);
        t6.setTextColor(Color.BLACK);
        t7.setTextColor(Color.BLACK);
        t8.setTextColor(Color.BLACK);
        t9.setTextColor(Color.BLACK);
    }
}