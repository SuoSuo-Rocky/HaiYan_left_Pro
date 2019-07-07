package com.example.nextblecomeon;

import java.io.IOException;

import com.fro.util.FROSun;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<	Void,Void,Void> {
	private TextView sun_tv;
	private Context context;
	
	private connectTask connect;
	private byte[] float1;
	private Float date;
	
	public connectTask(Context con,TextView view) {
		this.context=con;
		this.sun_tv=view;
	}

 
 
 @Override
	protected Void doInBackground(Void... params) {
	  try {
		StreamUtil.writeCommand(Constant.sunsocket.getOutputStream(),Constant.SUN_CHK);
	    float1=StreamUtil.readData(Constant.sunsocket.getInputStream());
	    date=FROSun.getData(Constant.SUN_LEN,Constant.SUN_NUM,float1);
	    publishProgress();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
 
 @Override
	protected void onProgressUpdate(Void... values) {
	 sun_tv.setText(date+"Lux");
	}
 
 
}
