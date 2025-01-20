//在build.grade 中配置 implementation 'org.jsoup:jsoup:1.15.4'  
//代码中引用了Jsoup 外连包的功能

package com.example.application;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.WindowManager;
import android.widget.ImageView;
import android.os.Environment;
import android.view.View;
import android.content.Intent;import android.util.Log;
import android.widget.Button;
import androidx.core.app.ActivityCompat;
import java.security.acl.Permission;
import android.content.pm.PackageManager;
import android.Manifest;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;
import androidx.core.content.ContextCompat;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.os.Handler;
import android.os.Message;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import org.json.JSONObject;
import org.json.JSONException;
import android.widget.TextView;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;

public class MainActivity extends Activity
{

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web=findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        WebSettings settings=web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        web.setWebViewClient(new WebViewClient()
            {
                @Override
                public boolean shouldOverrideUrlLoading(WebView webView,String url)
                {
                    return false;
                }
            });
        web.loadUrl("https://chat18.aichatos.xyz/#/chat/1734009373969");
        web.getSettings().setUserAgentString("Dalvik/2.1.0 (Linux; U; Android 13; 22122RK93C Build/TP1A.220624.014)");
        

    }
    @Override
    public void onBackPressed()
    {
        if(web.canGoBack())
        {
            web.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }




}
