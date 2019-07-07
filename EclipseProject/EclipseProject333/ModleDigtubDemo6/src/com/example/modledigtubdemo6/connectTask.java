package com.example.modledigtubdemo6;

import java.io.IOException;

import com.fro.util.FROIOControl;
import com.fro.util.StreamUtil;

import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<String, Void, Void> {
	private TextView info_tv;
	private byte[] date;
	private boolean state;
	
	
	public connectTask(TextView info_tv) {
		this.info_tv=info_tv;
	}
	
	@Override
	protected void onPreExecute() {
		info_tv.setText("正在连接......");
	}
	
	@Override
	protected Void doInBackground(String... params) {
		try {
			StreamUtil.writeCommand(Constant.tubSocket.getOutputStream(),params[0]);
			date=StreamUtil.readData(Constant.tubSocket.getInputStream());
			state=FROIOControl.isSuccess(Constant.NODE_LEN,Constant.NODE_NUM,date);
			publishProgress();
			Thread.sleep(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		if(state){
			info_tv.setText("操作成功....");
		}else{
			info_tv.setText("操作失敗......");
		}
	}
	
	
	
	

}
