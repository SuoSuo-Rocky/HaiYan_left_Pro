package com.example.modeldemo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.fro.util.FROSun;
import com.fro.util.StreamUtil;

import android.R.bool;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<Void, Void, Void> {
	
	private Context context;
    private TextView info_tv;
    private TextView sun_tv;
    
    private boolean state;
    
    private Socket sunSocket;
    private byte[] date; 
    private Float float1;
    public connectTask(Context context,TextView info_tv,TextView sun_tv) {
	this.context=context;	
	this.info_tv=info_tv;
	this.sun_tv=sun_tv;
	}

    
    



	@Override
	protected void onPreExecute() {
		info_tv.setText("正在连接......");
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		sunSocket=getSocket(Constant.IP,Constant.port);
		if(sunSocket!=null){
			try {
				while (state) {
					StreamUtil.writeCommand(sunSocket.getOutputStream(),Constant.SUN_CHK);
					date=StreamUtil.readData(sunSocket.getInputStream());
					float1=FROSun.getData(Constant.SUN_LEN,Constant.SUN_NUM,date);
					publishProgress();
					Thread.sleep(200);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
       sun_tv.setText(String.valueOf(float1));		
	}
	
	public Socket getSocket(String ip,int port){
		Socket socket=new Socket();
		InetSocketAddress address=new InetSocketAddress(ip,port);
		try {
			socket.connect(address,3000);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(socket.isConnected()){
			return socket;
		}else{
			info_tv.setText("连接失败");
			setState(false);
			return null;
		}
		
	}
		
	public boolean isState() {
		return state;
	}



	public void setState(boolean state) {
		this.state = state;
	}

	
public void	closeSocket(){
	
	if(sunSocket!=null){
		try {
			sunSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
	
	
	
	

}
