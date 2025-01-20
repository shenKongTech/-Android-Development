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






public class MainActivity extends Activity
{   
//声明MyAdapter类 的对象 mAdapter、泛型 List 字符串列表的对象 mdata，RecycleView 控件对象 mRecycler
	private MyAdapter mAdapter;
	private List<String> mdata;
	private  RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//创建一个 ArrayList 类型的数列，用来存字符串，ArrayList 是 List 接口的常用实现类
		mdata=new ArrayList<String>();
		//用 for 循环为字符串列表填充数据
		for(int i=0;i<=30;i++)
		{
			mdata.add("物品"+i);
		}
		//绑定 RecyclerView
	    mRecycler =findViewById(R.id.RecyclerV);
	    //用 setLayoutManager() 为 mRecycler 设置一个布局管理器，让其能够显示布局
		mRecycler.setLayoutManager(new 
		LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
		//将 mAdapter 在当前活动实例化，将字符串列表数据传入 mAdapter
		mAdapter =new MyAdapter(this,mdata);
		//设置 mRecycler 的适配器mAdapter，适配器的作用是为组件传递数据(在此处将传递打包好的装有数据的组件、一个xml 文件转换成的视图，和数据项个数)
		mRecycler.setAdapter(mAdapter);
	}
}
//声明一个 Myholder 类继承 RecyclerView 的 ViewHolder 视图包装，主要功能是包装 RecyclerView 中每个子项的视图
class Myholder extends RecyclerView.ViewHolder
{
//声明一个 TextView 对象，用来显示列表项的文本数据
	TextView tv;
	//
	public Myholder(View itemView)
	{  
	//继承父类的构造方法，对传入视图进行初始化
		super(itemView);
		//查找传入视图中的 TextView，ID 为 tv 的，并使对象 tv 指向它，以便后续快速访问
		tv=itemView.findViewById(R.id.tv);
	}
}
//创建一个 MyAdapter 类继承 RecycleView 的内部接口类 Adapter<Myholder>，设计适配器
 class MyAdapter extends RecyclerView.Adapter<Myholder>
{
//声明上下文对象、数据源列表对象、布局填充器对象
	private Context mContext;
	private List<String> mdata;
	private LayoutInflater inflater;
	
	//该构造方法用于接收传入的上下文和数据，并实例化一个布局填充器，用于转换 xml 文件为视图
	public MyAdapter(Context context,List<String> mdata)
	{
		this.mdata=mdata;
		this.mContext=context;
		//LayoutInflater.from()方法是 LayoutInflater 的实例化方法
		this.inflater=LayoutInflater.from(context);
	}
	//它的作用是创建并返回一个新的 ViewHolder 对象，打包 item.xml 转换成的视图
	@Override
	public Myholder onCreateViewHolder(ViewGroup parent,int viewType)
	{
	//用 inflate()方法将 item.xml 文件转换成 view，并将视图附加到父视图中，false 参数为不立即添加，让 RecyclerView 自动处理
		View view=inflater.inflate(R.layout.item,parent,false);
		//将视图传入一个视图打包类对象
		Myholder holder=new Myholder(view);
		//返回视图打包类对象
		return holder;
	}
	//打包好组件和布局后，打包数据
	//该方法用于将数据绑定在视图中，position 参数为数据在数据集中的索引
	@Override
	public void onBindViewHolder(Myholder holder,int position)
	{
	//为 holder 的视图 tv 设置文本，get(position)方法读出 mdata 的所有数据项
		holder.tv.setText(mdata.get(position));
	}
	
	//该方法用于返回数据集数据项个数，告诉 Recycler 的适配器一共有多少项需要显示，以使 RecyclerView 根据这个值分配视图
	@Override
	public int getItemCount()
	{
		return mdata.size();
	}
}

