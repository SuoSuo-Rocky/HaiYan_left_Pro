package com.example.connecttaskdemomodel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.fro.util.FROTemHum;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<Void, Void, Void> {
	private Context context;
	private TextView info_tv;
    private TextView tem_tv;
    private TextView hum_tv;
	
	private boolean state=false;
	
	private Socket sun2Socket;
	private byte[] date;
	private Float tem;
	private Float hum;
	
	
	public connectTask(Context context,TextView info_tv,TextView tem_tv,TextView hum_tv) {
		this.context=context;
		this.info_tv=info_tv;
		this.tem_tv=tem_tv;
		this.hum_tv=hum_tv;
	}
	
	
	@Override
	protected void onPreExecute() {
		info_tv.setText("正在连接 ......");
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		sun2Socket=getSocket(Constant.IP,Constant.port);
		if(sun2Socket!=null) {//当有多个Socket 时会管用
		while(state) {
			try {
				StreamUtil.writeCommand(sun2Socket.getOutputStream(),Constant.TEMHUM_CHK);
			    date=StreamUtil.readData(sun2Socket.getInputStream());
			    tem=FROTemHum.getTemData(Constant.TEMHUM_LEN,Constant.TEMHUM_NUM,date);
			    hum=FROTemHum.getHumData(Constant.TEMHUM_LEN,Constant.TEMHUM_NUM,date);
			    publishProgress();
			    Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
	tem_tv.setText(String.valueOf(tem));
		hum_tv.setText(String.valueOf(hum));
		
	}
	
	public Socket getSocket(String ip,int port) {
	           Socket	socket2=new Socket();
	InetSocketAddress	address2=new InetSocketAddress(ip,port);
		try {
			socket2.connect(address2,3000);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(!socket2.isConnected()) {
			info_tv.setText("连接失敗");
			return null;
		}else {
			info_tv.setText("连接成功");
			return socket2;     
		}
	}
	
	public void setState(boolean b) {
	state=b;
	}
	
	public boolean getState() {
		return state;
	}
	
	
	public  void closeSocket(){
		if(sun2Socket!=null) {
			try {
				sun2Socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
