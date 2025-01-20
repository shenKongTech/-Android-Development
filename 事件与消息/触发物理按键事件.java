public class MainActivity extends Activity
{   
    long exittime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
    }
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			if(System.currentTimeMillis()-exittime>2000)
			{
				exittime=System.currentTimeMillis();
				Toast.makeText(MainActivity.this,"再单击一次退出",Toast.LENGTH_SHORT).show();
			}
			else
			{
			    Toast.makeText(MainActivity.this,"退出失败",Toast.LENGTH_SHORT).show();
			}
		}
		return true;
	}
}
//Android 设备各个物理按键可触发的事件如下。
//KEYCODE_POWER：电源键，用于开机、关机或锁屏。
//KEYDODE_BACK：返回键，用于返回上一个界面。
//KEYCODEMENU：菜单键，用于显示菜单。
//KEYCODEHOME：Home 键，用于返回主界面。
//KEYCODESEARCH：查找键，用于启动搜索。
//KEYCODE_VOLUME_UP：音量键，用于提高音量。
//KEYCODE_VOLUME DOWN：音量键，用于减小音量。
//KEYCODE_DPAD CENTER：方向键。
//KEYCODE_DPAD_UP：方向键。
//KEYCODE DPAD DOWN：方向键。KEYCODE_DPAD_LEFT：方向键。KEYCODE DPAD RIGHT：方向键。
//在Android 处理物理按键的事件中，有以下几个回调方法。
//onKeyDownO：用户按下某个按键时触发该方法(前提是未释放)。
//onKeyUpO：用户释放某个按键时触发。
//onKeyLongPressO：用户长按某个按键时触发。