package com.example.buzzerdemo1;

import java.io.InputStream;
import java.io.OutputStream;

import com.fro.util.FROIOControl;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class sendcmdTask extends AsyncTask<Void,Void,Void> {
	
	private InputStream in;
	private OutputStream out;
	private Context context;
	
	private  String cmd;
	private boolean STATE=false;
	private byte[] date;
	
	
	public sendcmdTask(InputStream in,OutputStream out,Context context,String cmd ) {
		this.in=in;
		this.out=out;
		this.cmd=cmd;
		this.context=context;
		
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		if(STATE) {
			Toast.makeText(context, "操作成功",Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(context, "操作失败!",Toast.LENGTH_SHORT).show();
		}
		
	}
	 
	 
	 @Override
	protected Void doInBackground(Void... params) {
		 try {
			StreamUtil.writeCommand(out, cmd);
			 Thread.sleep(200);
			 date=StreamUtil.readData(in);
			 if(date==null||date.length<Constant.NODE_LEN) {
				 return null;
			 }
			 STATE=FROIOControl.isSuccess(Constant.NODE_LEN,Constant.NODE_NUM,
					 date);
			 publishProgress();
			 Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		return null;
	}


}
