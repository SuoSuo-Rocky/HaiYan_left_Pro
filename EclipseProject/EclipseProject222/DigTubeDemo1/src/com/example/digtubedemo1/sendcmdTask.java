package com.example.digtubedemo1;

import java.io.InputStream;
import java.io.OutputStream;

import com.fro.util.FROIOControl;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class sendcmdTask extends AsyncTask<Void, Void, Void> {
	InputStream in = null;
	OutputStream out = null;
	private String cmd;
	private Context context;
	private byte[] data;
	private boolean state = false;

	public sendcmdTask(Context context, InputStream in, OutputStream out, String cmd) {
		this.in = in;
		this.out = out;
		this.cmd = cmd;
		this.context = context;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		if (state) {
			Toast.makeText(context, "操作成功", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, "操作失败", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		try {
			Log.i("shi","-----------------------------");
			StreamUtil.writeCommand(out, cmd);
			Log.i("shi","-----------------------------");
			Thread.sleep(200);
			data = StreamUtil.readData(in);
			Log.i("shi","-----------------------------");
			if (data == null && data.length < Constant.NODE_LEN)
				return null;
			Log.i("shi","-----------------------------");
			state = FROIOControl.isSuccess(Constant.NODE_LEN, Constant.NODE_NUM, data);
			Log.i("shi","-----------------------------");
			publishProgress();
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
