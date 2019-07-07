package com.example.listdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	 private ListView listview;
	 String[] str={"上海","北京","广州"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview=(ListView) findViewById(R.id.listView1);
		 listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String s=str[arg2];
				Log.v("shiwei","---------------->" +s);
			}
			 
		});
		 
		
	 ArrayAdapter<String> adapter=new ArrayAdapter<String>
	 (this,R.layout.demo2, R.id.textView1,str);
	 listview.setAdapter(adapter);
		
	}


}
