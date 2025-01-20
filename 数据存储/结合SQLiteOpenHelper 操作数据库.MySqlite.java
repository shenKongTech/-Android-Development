package com.example.application;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;

public class MySqlite extends SQLiteOpenHelper
{
	Context mcontext;
    public MySqlite(Context context,String name,
	SQLiteDatabase.CursorFactory factory,int vision)
	{
		super(context,name,factory,vision);
		mcontext=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		Toast.makeText(mcontext,"你创建了一个数据库",Toast.LENGTH_SHORT).show();
		//创建数据库并创建一个叫user的表格
		String str="create table user(id int primary key,name varchar(200))";
		db.execSQL(str);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		Toast.makeText(mcontext,"数据库已更新",Toast.LENGTH_SHORT).show();
	}
}