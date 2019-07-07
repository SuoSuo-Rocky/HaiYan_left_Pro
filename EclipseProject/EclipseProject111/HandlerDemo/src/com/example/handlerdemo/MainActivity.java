package com.example.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button=(Button) findViewById(R.id.button);
		handler=new FirstHandler();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//���û������ťʱ�����Ǵ���һ�� ��Ϣ���󣬲�ʹ�� Handler ���͸ö���
				Message msg=handler.obtainMessage();
				msg.what=2;
				handler.sendMessage(msg);//����Ϣ������뵽��Ϣ���е���ȥ
				//1.Looper �������Ϣ�����аѸ���Ϣȡ��
				//2.Looper �����ҵ������Ϣ���Ӧ��Handler ����
				//3.Looper �������Handler �� handlerMessage(Message msg)���������ڴ�����Ϣ����
			}
		});
		
	}
	
	
	class FirstHandler extends Handler{
		
		@Override
		public void handleMessage(Message msg) {
			int What=msg.what;
			System.out.println("What="+What);
			
		}
	}


}
