package com.example.asynctaskdemo1;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class shiwei extends  AsyncTask<Integer ,Integer ,String> {

	TextView view;
	ProgressBar bar;
	
	public shiwei(TextView view,ProgressBar bar) {
		this.bar=bar;
		this.view=view;
	}
	@Override
	protected void onPreExecute() {
		view.setText("异步执行操作开始");
	}
	@Override
	protected String doInBackground(Integer... params) {
		Sleep sleep=new Sleep();
		int i=0;
		for( i=10;i<=100;i+=10){
			sleep.hi();
			publishProgress(i);
		}
		
		return i + params[0].intValue()+""; 
      		
	
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		//int i=values[0];
		bar.setProgress(values[0]);
		
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		view.setText("异步执行操作结束"+result);
	}


	
	
	
	



}
