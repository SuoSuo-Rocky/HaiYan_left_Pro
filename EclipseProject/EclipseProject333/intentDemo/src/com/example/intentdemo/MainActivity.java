package com.example.intentdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class MainActivity extends Activity {
	/*
	 * ��ʾ intent ��ʹ��
	 */
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void click(View view) {
		switch (view.getId()) {
		case R.id.self://����Activity,һ��Ϊ����������ʽ
			Intent intent=new Intent();
			ComponentName componentName=new ComponentName(MainActivity.this,OtherActivity.class);
			intent.setComponent(componentName);
			startActivity(intent);
//			Intent intent=new Intent();
//			intent.setClass(MainActivity.this,OtherActivity.class);
//			startActivity(intent);
			
//			Intent intent=new Intent();
//			intent.setClassName(MainActivity.this,OtherActivity.class.getName() );
//			startActivity(intent);
			break;
		case R.id.shi://��绰
			//Uri.parse(Stirng s); uri�ǳ����࣬ ���þ�̬�� parse  ������ ָ��actionҪ����������
			Intent intent2=new Intent(Intent.ACTION_CALL,Uri.parse("tel://10086"));
			startActivity(intent2);
			break;
		case R.id.send://������
			Intent intent3=new Intent(Intent.ACTION_SENDTO,Uri.parse("sms://10086"));
			startActivity(intent3);
			break;
		case R.id.web://����ҳ
			Intent intent4=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
			startActivity(intent4);
			break;
		case R.id.music://��������
			Intent intent5=new Intent(Intent.ACTION_VIEW);
			//�ụ�����
//			intent5.setData(Uri.parse("file:///"+Environment.getExternalStorageDirectory().getAbsolutePath()+"Far.mp3"));
//			intent5.setType("audio/*");
			intent5.setDataAndType(Uri.parse("file:///"+Environment.getExternalStorageDirectory().getAbsolutePath()+"Far.mp3"),"audio/*");
			
			startActivity(intent5);
			break;
			

		}

	}


}