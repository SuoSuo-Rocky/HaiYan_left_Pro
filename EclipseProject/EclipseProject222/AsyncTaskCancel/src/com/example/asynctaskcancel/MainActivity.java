package com.example.asynctaskcancel;

import com.example.asyncTaskalone.MyAsyncTaskDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView view2;
	private String imagePath="http://02imgmini.eastday.com/mobile/20180929/20180929142716_a04be411d2e896d047e0dde52452340b_1.jpeg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view2=(ImageView) findViewById(R. id.view);
	}
	public  void click(View view) {
		new MyAsyncTaskDemo(MainActivity.this, view2).execute(imagePath);

	}


}
