package com.example.buzzerdemo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<Void,Void,Void> {
	private Context context;
	private TextView view;
	
	private Socket socket;
	private InetSocketAddress address;
	private InputStream in;
	private OutputStream out;
	
	private  boolean STATE=false;
	
	
	public connectTask(Context context,TextView view) {
		this.context=context;
		this.view=view;
		
	}
	
	@Override
	protected void onPreExecute() {
	   view.setText("��������");
	}
	@Override
	protected Void doInBackground(Void... params) {
		try {
			socket=new Socket();
			address=new InetSocketAddress(Constant.IP,Constant.port);
			socket.connect(address,3000);
			if(socket.isConnected()) {
				setSTATE(true);
				in=socket.getInputStream();
				out=socket.getOutputStream();
		    }else {
		    	setSTATE(false);
		    	view.setText("IP �� Port ����������������룺");
		    	return null;
		    }
				
				
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
		if(STATE) {
			view.setText("���ӳɹ�");
		}else {
			view.setText("����ʧ�ܣ�");
		}
		
	}
	
	public void setSTATE(boolean sTATE) {
		STATE = sTATE;
	}
	
	public boolean getSTATE(){
		return STATE;
	}
	
	public InputStream getInputStream() {
		return in;
	}
	public OutputStream getOutputStream() {
		return out;
	}
	
	public Socket getSocket() {
		return socket;
	}

}
