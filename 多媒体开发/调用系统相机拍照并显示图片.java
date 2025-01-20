//注：显示原图功能异常。由于 Uri.fromFile(new File(filePath)) 使用了外部存储路径，可能会导致闪退，尤其是在 Android 7.0 及更高版本中，因为从 Android 7.0 开始，直接访问外部存储上的文件需要特殊权限或者通过 FileProvider 进行共享。从 Android 7.0 开始，直接使用 Uri.fromFile() 会受到限制，必须通过 FileProvider 获取可共享的 Uri。FileProvider 通过 URI 权限来确保访问文件的安全性。
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
import android.content.Intent;
import android.provider.MediaStore;
import java.io.File;
import android.graphics.Bitmap;
import java.io.FileInputStream;
import android.graphics.BitmapFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.Manifest;
import androidx.core.app.ActivityCompat;
import android.util.Log;
public class MainActivity extends Activity {

		private ImageView iv;
		private String filePath;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			// 初始化ImageView和filePath
			iv = findViewById(R.id.iv);
			filePath = Environment.getExternalStorageDirectory().getPath();
			filePath += "/image.png";

			// 设置按钮的点击事件
			Button bt1 = findViewById(R.id.bt1);
			bt1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						onCamera();  // 点击bt1时调用onCamera()方法，显示缩略图
					}
				});
           //安卓7以上，功能异常
			Button bt2 = findViewById(R.id.bt2);
			bt2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						CameraImage();  // 点击bt2时调用CameraImage()方法，显示原图
					}
				});
		}

		public void onCamera() {
			// 启动相机并显示缩略图
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, 0x1);
		}

		public void CameraImage() {
			// 启动相机并保存图片，安卓7以上功能异常
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			Uri picUri = Uri.fromFile(new File(filePath));
			intent.putExtra(MediaStore.EXTRA_OUTPUT, picUri);
			startActivityForResult(intent, 0x2);
		}

		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);
			if (resultCode == RESULT_OK) {
				if (requestCode == 0x1) {
					// 缩略图
					Bundle bundle = data.getExtras();
					Bitmap bit = (Bitmap) bundle.get("data");
					iv.setImageBitmap(bit);
				} else if (requestCode == 0x2) {
					// 保存图片并显示原图，安卓7以上功能异常
					File file = new File(filePath);
					if (file.exists()) {
						FileInputStream fis = null;
						try {
							fis = new FileInputStream(filePath);
							Bitmap bitmap = BitmapFactory.decodeStream(fis);
							iv.setImageBitmap(bitmap);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} finally {
							try {
								if (fis != null) {
									fis.close();
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} 
					}
				}
			}
		
	
	
	
	
}
