package com.example.taskdemo1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class OtherActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
	}

	public void click(View view) {
		Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("sms://10086"));
		startActivity(intent);
		
		

	}

}
