package com.example.application;
import android.app.Fragment;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import java.io.IOException;
import android.widget.Toast;
import android.app.FragmentManager;
import android.text.Layout;
import android.os.Handler;
import android.os.Message;
import android.os.Looper;
import org.jsoup.nodes.Element;
import android.util.Log;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import android.content.Intent;
import android.view.View.OnClickListener;

public class Fragment1 extends Fragment implements View.OnClickListener
{
    String data,s;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    
    
    //新闻跳转
    @Override
    public void onClick(View v) 
    {
        Intent intent=new Intent(getActivity(),News.class);
        Bundle bundle=new Bundle();
        switch(v.getId())
        {
            case R.id.tv1:
                bundle.putInt("id",1);break;
            case R.id.tv2:
                bundle.putInt("id",2);break;
            case R.id.tv3:
                bundle.putInt("id",3);break;
            case R.id.tv4:
                bundle.putInt("id",4);break;
            case R.id.tv5:
                bundle.putInt("id",5);break;
            case R.id.tv6:
                bundle.putInt("id",6);break;
            case R.id.tv7:
                bundle.putInt("id",7);break;
            case R.id.tv8:
                bundle.putInt("id",8);break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }


    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
    {

        View view=inflater.inflate(R.layout.jump1,container,false);
        
        
        //初始化
        final TextView tv1=view.findViewById(R.id.tv1);
        final TextView tv2=view.findViewById(R.id.tv2);
        final TextView tv3=view.findViewById(R.id.tv3);
        final TextView tv4=view.findViewById(R.id.tv4);
        final TextView tv5=view.findViewById(R.id.tv5);
        final TextView tv6=view.findViewById(R.id.tv6);
        final TextView tv7=view.findViewById(R.id.tv7);
        final TextView tv8=view.findViewById(R.id.tv8);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        tv7.setOnClickListener(this);
        tv8.setOnClickListener(this);
        //数据返回与显示
        final Handler handler=new Handler(Looper.getMainLooper())
        {
            @Override
            public void handleMessage(Message msg)
            {
                if(msg.what==0)
                {
                    tv1.setText(s);
                }
                else if(msg.what==1)
                {
                    tv2.setText(s);
                }
                else if(msg.what==2)
                {
                    tv3.setText(s);
                }
                else if(msg.what==3)
                {
                    tv4.setText(s);
                }
                else if(msg.what==4)
                {
                    tv5.setText(s);
                }
                else if(msg.what==5)
                {
                    tv6.setText(s);
                }
                else if(msg.what==6)
                {
                    tv7.setText(s);
                }
                else if(msg.what==7)
                {
                    tv8.setText(s);
                }

            }
        };
        
        
        //抓取目标库
        final String web[]=new String[]
        {
            "https://wallstreetcn.com/articles/3736759",
            "https://wallstreetcn.com/articles/3736846",
            "https://wallstreetcn.com/articles/3736839",
            "https://wallstreetcn.com/articles/3736845",
            "https://wallstreetcn.com/articles/3736844",
            "https://wallstreetcn.com/articles/3736843",
            "https://wallstreetcn.com/articles/3736748",
            "https://wallstreetcn.com/livenews/2833394"
        };
        final int id[]=new int[]
        {
            R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
            R.id.tv6, R.id.tv7, R.id.tv8,
        };
        
        
        //新建线程，完成数据抓取操作
        new Thread()
        {
            public void run()
            {
                for(int i=0;i<id.length;i++)
                {
                    try{
                        HttpsURLConnection connection=null;
                        URL url=new URL(web[i]);
                        connection=(HttpsURLConnection)url.openConnection();
                        connection.setRequestMethod("GET");
                        InputStream is=connection.getInputStream();
                        BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                        data="";
                        String line;
                        while((line=reader.readLine())!=null)
                        {
                            data+=line;
                        }
                        is.close();
                        reader.close();
                        Document doc=Jsoup.parse(data);
                        Element title=doc.select("meta[property=og:title]").first();
                        String title1="";
                        if(title!=null)
                        {
                            title1=title.attr("content");
                        }
                        s=title1;
                        handler.sendEmptyMessage(i);
                    }
                    catch(MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return view;
    }
}