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
				//当用户点击按钮时，我们创建一个 消息对象，并使用 Handler 发送该对象
				Message msg=handler.obtainMessage();
				msg.what=2;
				handler.sendMessage(msg);//将消息对象放入到消息队列当中去
				//1.Looper 将会从消息队列中把该消息取出
				//2.Looper 将会找到与该消息相对应的Handler 对象。
				//3.Looper 将会调用Handler 的 handlerMessage(Message msg)方法，用于处理消息对象。
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
