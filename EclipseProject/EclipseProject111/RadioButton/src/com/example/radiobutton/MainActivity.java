package com.example.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private RadioButton female;
	private RadioButton male;
	private RadioGroup  group;
	private CheckBox run;
	private CheckBox play;
	private CheckBox read;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		next();
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(female.getId()==checkedId){
					Toast.makeText(MainActivity.this,"女",Toast.LENGTH_LONG).show();
				}else if(male.getId()==checkedId){
					Toast.makeText(MainActivity.this,"男",Toast.LENGTH_LONG).show();
				}
			}
		});
		run.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(MainActivity.this,"跑步",Toast.LENGTH_LONG).show();
			}

		});
	play.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(MainActivity.this,"动起来",Toast.LENGTH_LONG).show();
			}

		});
	read.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			Toast.makeText(MainActivity.this,"阅读",Toast.LENGTH_LONG).show();
		}

	});
		
	}
    

	
	private void next(){
		female=(RadioButton) findViewById(R.id.female);
		male=(RadioButton) findViewById(R.id.male);
		group=(RadioGroup) findViewById(R.id.group);
		run=(CheckBox) findViewById(R.id.run);
		play=(CheckBox) findViewById(R.id.play);
		read=(CheckBox) findViewById(R.id.read);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
