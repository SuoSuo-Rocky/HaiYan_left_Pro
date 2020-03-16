package com.example.modledigtubdemo3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import android.os.AsyncTask;
import android.widget.TextView;

public class socketTask extends AsyncTask<Void,Socket,Void> {
	private TextView info_tv;
	
	
	public socketTask(TextView info_tv) {
		this.info_tv=info_tv;
	}
	
	@Override
	protected void onPreExecute() {
		info_tv.setText("��������......");
	}
	
	@Override
	protected Void doInBackground(Void... params) {
			final Socket socket = new Socket();
			final InetSocketAddress address = new InetSocketAddress(Constant.IP,Constant.port);
				try {
						socket.connect(address, 3000);
					} catch (IOException e) {
						e.printStackTrace();
					}
				publishProgress(socket);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			
	}
	
	
	@Override
	protected void onProgressUpdate(Socket... values) {
		if(values[0]!=null&&values[0].isConnected()){
			Constant.tubSocket=values[0];
			info_tv.setText("���ӳɹ�......");
		}else{
			info_tv.setText("����ʧ��.....");
		}
	}
	
	

}