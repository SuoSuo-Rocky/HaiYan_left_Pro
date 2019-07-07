package com.example.myrfiddemo_twodemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class connectTask extends AsyncTask<Void, Void, Void> {
	private TextView info_tv;
	boolean state;

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private InetSocketAddress address;

	public connectTask(Context context, TextView l) {
		this.info_tv = l;
	}

	@Override
	protected void onPreExecute() {
		info_tv.setText("正在连接......");
	}

	@Override
	protected Void doInBackground(Void... params) {
		socket = new Socket();
		address = new InetSocketAddress(Constant.IP, Constant.port);
		try {
			socket.connect(address, 3000);
			if (socket.isConnected()) {
				setState(true);
				in = socket.getInputStream();
				out = socket.getOutputStream();
				

			} else {
				setState(false);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		publishProgress();
	    try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		if (state) {
			info_tv.setText("连接成功");
		} else {
			info_tv.setText("连接失败");
		}
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean getState() {
		return state;
	}

	public void closeSocket() {
		try {
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InputStream getInputStream() {
		return in;
	}

	public OutputStream getOnputStream() {
		return out;
	}

}
