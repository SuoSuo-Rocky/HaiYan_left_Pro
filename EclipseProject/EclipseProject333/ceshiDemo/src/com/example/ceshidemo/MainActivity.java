package com.example.ceshidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void together(View  view){
		switch (view.getId()) {
		case R.id.num1:
			Toast  toast=new Toast(this);
			toast.setDuration(Toast.LENGTH_SHORT);
			toast.setGravity( Gravity.CENTER,0,0);
			LinearLayout layout=new LinearLayout(this);
			ImageView view2=new ImageView(this);
			view2.setImageResource(R.drawable.one);
			view2.setPadding(0, 5, 0, 0);
			layout.addView(view2);
			TextView view3=new TextView(this);
			view3.setText("Shi Wei Good Morning!");
			layout.addView(view3);
			toast.setView(layout);
			toast.show();
			break;
			
		default:
			break;
		}
	}

	
	

}
