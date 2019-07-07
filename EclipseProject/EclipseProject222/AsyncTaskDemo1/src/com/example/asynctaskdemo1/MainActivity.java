package com.example.asynctaskdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ProgressBar bar;
	private TextView view;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bar=(ProgressBar) findViewById(R.id.bar);
		view=(TextView) findViewById(R.id.textview);
		bar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				shiwei  hu=new shiwei(view,bar);
					hu.execute(1000);
					
			}
		});
		
	}
}
