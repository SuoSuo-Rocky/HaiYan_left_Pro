package com.example.taskdemo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
	}


  public void click(View view) {
	startActivity(new Intent(MainActivity.this,OtherActivity.class));
	

}
	
}
