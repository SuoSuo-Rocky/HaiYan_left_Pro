package com.example.myrfiddemo_twodemo;

import java.io.InputStream;
import java.io.OutputStream;

import com.fro.util.HexStrConvertUtil;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class secondTask extends AsyncTask<Void, Void, Void> {

	private InputStream in;
	private OutputStream out;
	private TextView info_tv;
	private String cmd;
	private String error;
	byte[] date;
	String readStr;
	private boolean state = false;

	public secondTask(Context context, TextView info, InputStream in, OutputStream out, String cmd, String error) {
		
		this.info_tv = info;
		this.in = in;
		this.out = out;
		this.cmd = cmd;
		this.error = error;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		switch (cmd) {
		// 读卡
		case Constant.READ_CARD_CMD:
			if (state) {
				Constant.CARD_ID = readStr.substring(readStr.length() - 10, readStr.length() - 2);
				info_tv.setText("正常，卡号为" + Constant.CARD_ID);
				state = false;
			} else {
				info_tv.setText("异常");
			}
			break;

		// 读块
		case Constant.READ_AREA_CMD:
			if (state) {
				Constant.AREA_DATA = readStr.substring(readStr.length() - 36, readStr.length() - 2);
				info_tv.setText("正常，数据为" + Constant.AREA_DATA);
				state = false;
			} else {
				info_tv.setText("异常");
			}
			break;

		default:
			if (state) {
				info_tv.setText("正常");
				state = false;
			} else {
				info_tv.setText("异常");
			}
			break;
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		StreamUtil.writeCommand(out, cmd);
		try {
			Thread.sleep(200);
			date = StreamUtil.readData(in);
			if (date == null && date.length < 10) 
				return null;
				readStr = HexStrConvertUtil.bytesToHexString(date);
				state = !(readStr.equals(error.replace(" ", "").toLowerCase()));
			    publishProgress();
				Thread.sleep(200);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
