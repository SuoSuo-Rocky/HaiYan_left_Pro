package com.example.myonclickdemoofdigtub;

import java.io.IOException;

import com.fro.util.FROIOControl;
import com.fro.util.StreamUtil;

import android.R.bool;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<String , Void,Void> {
	private Context context;
	private TextView info_tv;
	
	private byte[] date;
	private boolean state;
    	
	public connectTask(Context context,TextView info_tv) {
		this.context=context;
		this.info_tv=info_tv;
	}
	
	@Override
	protected void onPreExecute() {
		info_tv.setText("��������......");
	}
	
	@Override
	protected Void doInBackground(String... params) {
		try {
			StreamUtil.writeCommand(Constant.tubeSocket.getOutputStream(),params[0]);
			date=StreamUtil.readData(Constant.tubeSocket.getInputStream());
			state=FROIOControl.isSuccess(Constant.NODE_LEN,Constant.NODE_NUM,date);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		publishProgress();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		if(state) {
			info_tv.setText("OK!");
		}else {
			info_tv.setText("Failure!");
		}
	}
	

}
