```java
public class MainActivity extends Activity { 
    // 定义 UI 组件
    Button Search; // 搜索按钮
    EditText Content; // 输入框，用户输入搜索内容
    TextView SC_M, SC_In, SC_Im, SC_U; // 用于显示搜索结果的 TextView
    ImageView picture; // 显示图片的 ImageView
    LinearLayout Get_tips, Get_results; // 用于显示提示信息和搜索结果的布局
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 设置界面布局为 activity_main.xml
        
        // 初始化 UI 组件，绑定 XML 中的控件
        Get_tips = findViewById(R.id.Get_tips); // 提示框布局
        Get_results = findViewById(R.id.Get_results); // 搜索结果布局
        
        // 初始化显示结果的 TextView
        SC_M = findViewById(R.id.SC_M); 
        SC_In = findViewById(R.id.SC_In);
        SC_Im = findViewById(R.id.SC_Im);
        SC_U = findViewById(R.id.SC_U);
        
        // 设置点击事件，点击 SC_U (URL 链接)，打开百度百科的网页
        SC_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("百度百科结果", MODE_PRIVATE);
                String Url = sharedPreferences.getString("地址", ""); // 获取保存的 URL
                Uri uri = Uri.parse(Url); // 将 URL 字符串转化为 Uri
                Intent intent = new Intent(Intent.ACTION_VIEW, uri); // 创建一个跳转网页的 Intent
                startActivity(intent); // 启动浏览器打开链接
            }
        });
        
        // 初始化输入框和搜索按钮
        Content = findViewById(R.id.Content);
        Search = findViewById(R.id.Search);
        
        // 设置搜索按钮的点击事件
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Get_tips.setVisibility(View.VISIBLE); // 显示加载提示
                
                // 获取用户输入的搜索内容
                String Search_Content = Content.getText().toString();
                
                // 将搜索内容存储到 SharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences("百度百科内容", MODE_PRIVATE).edit();
                editor.clear(); // 清除之前的内容
                editor.putString("内容", Search_Content) // 存储新的内容
                    .apply();
                
                // 清空之前的搜索结果
                SharedPreferences sharedPreferences = getSharedPreferences("百度百科结果", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                
                // 延迟执行 Article_acquisition 方法，模拟加载过程
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Article_acquisition(); // 获取文章内容
                    }
                }, 2000); // 延迟 2 秒调用，模拟等待加载
                
                // 延迟执行，更新界面显示搜索结果
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Get_tips.setVisibility(View.GONE); // 隐藏加载提示
                        // 如果加载提示已经隐藏，则显示搜索结果
                        if (Get_tips.getVisibility() == View.GONE) {
                            Get_results.setVisibility(View.VISIBLE); // 显示搜索结果布局
                            
                            // 从 SharedPreferences 获取百度百科搜索结果
                            SharedPreferences sharedPreferences = getSharedPreferences("百度百科结果", MODE_PRIVATE);
                            String Msg = sharedPreferences.getString("内容", "");
                            String info = sharedPreferences.getString("信息", "");
                            String image = sharedPreferences.getString("图片", "");
                            String Url = sharedPreferences.getString("地址", "");
                            
                            // 设置 TextView 的内容显示搜索结果
                            SC_M.setText(Msg);
                            SC_In.setText(info);
                            SC_Im.setText(image);
                            SC_U.setText(Url);
                            
                            // 设置图片加载
                            picture = findViewById(R.id.ImageView);
                            Glide.with(MainActivity.this)
                                .load(image) // 使用 Glide 加载图片
                                .into(picture); // 将图片显示在 ImageView 中
                        }
                    }
                }, 4000); // 延迟 4 秒执行，显示搜索结果
            }
        });
    }
}
```
