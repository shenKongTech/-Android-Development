package com.example.application;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 获取 VideoView 并设置视频 URI
        VideoView videoView = findViewById(R.id.vv);

        // 使用正确的资源 URI
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_dessky);

        videoView.setVideoURI(uri);

        // 设置 MediaController
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        // 请求焦点并开始播放
        videoView.requestFocus();
        videoView.start();
    }
}
