package com.example.myroomsundemo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.fro.util.FRODigTube;
import com.fro.util.FROSun;
import com.fro.util.StreamUtil;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ConnectTask extends AsyncTask<Void, Void, Void> {
	private Context context;
	private TextView info_tv;
	private ProgressBar bar;
	private TextView sun_tv;

	private boolean state;
	private boolean tubeState;

	byte[] date;
	Float float1;

	private Socket sunSocket;
	private Socket tubeSocket;
	private Socket buzzerSocket;
	private Socket curtainSocket;

	public ConnectTask(Context context, TextView sun, TextView info_tv, ProgressBar bar) {
		this.context = context;
		this.info_tv = info_tv;
		this.sun_tv = sun;
		this.bar = bar;

	}

	@Override
	protected void onPreExecute() {
		info_tv.setText("请点击连接......");
	}

	@Override
	protected Void doInBackground(Void... params) {
		Log.i("shi","doInBackground:Thread:"+Thread.currentThread().getName() );
		try {
			sunSocket = getSocket("光照", Const.SUN_IP, Const.SUN_PORT);
			Thread.sleep(200);
			if (sunSocket != null) {
				bar.setProgress(25);
			}
			tubeSocket = getSocket("数码管", Const.TUBE_IP, Const.TUBE_PORT);
			Thread.sleep(200);
			if (tubeSocket != null) {
				bar.setProgress(50);
			}
			buzzerSocket = getSocket("蜂鸣器", Const.BUZZER_IP, Const.BUZZER_PORT);
			Thread.sleep(200);
			if (buzzerSocket != null) {
				bar.setProgress(75);
			}
			curtainSocket = getSocket("我的窗帘", Const.CURTAIN_IP, Const.CURTAIN_PORT);
			Thread.sleep(200);
			if (curtainSocket != null) {
				bar.setProgress(100);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (state) {
			if (sunSocket != null && tubeSocket != null && buzzerSocket != null && curtainSocket != null) {
				try {
					// 查询光照值
					StreamUtil.writeCommand(sunSocket.getOutputStream(), Const.SUN_CHK);
					Thread.sleep(Const.time / 2);
					date = StreamUtil.readData(sunSocket.getInputStream());
					float1 = FROSun.getData(Const.SUN_LEN, Const.SUN_NUM, date);
					if (float1 != null) {
						Const.sun = (int) (float) float1;
					}
					// 数码管显示
					Const.TUBE_CMD = FRODigTube.intToCmdString(Const.sun);
					StreamUtil.writeCommand(tubeSocket.getOutputStream(), Const.TUBE_CMD);
					Thread.sleep(Const.time / 2);
					// 判断
					if (Const.sun > Const.maxLim && Const.linkage) {
						// 蜂鸣器
						if (!Const.isBuzzerOn) {
							StreamUtil.writeCommand(buzzerSocket.getOutputStream(), Const.BUZZER_ON);
							Thread.sleep(1000);
							StreamUtil.writeCommand(buzzerSocket.getOutputStream(), Const.BUZZER_OFF);
							Thread.sleep(200);
						}
						// 窗帘
						if (!Const.isCurtainOn) {
							StreamUtil.writeCommand(curtainSocket.getOutputStream(), Const.CURTAIN_ON);
							Thread.sleep(200);
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				publishProgress();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				info_tv.setText("连接失败，请检查 IP 和 Port ......");
			}
		}

		// 当第二次点击按钮时，则关闭蜂鸣器
		try {
			if (buzzerSocket != null) {
				Const.isBuzzerOn = false;
				Const.isCurtainOn = false;
				StreamUtil.writeCommand(buzzerSocket.getOutputStream(), Const.BUZZER_OFF);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeSocket();
		}

		return null;
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		Log.i("shi","onProgressUpdate:Thread:"+Thread.currentThread().getName() );
		sun_tv.setText(String.valueOf(Const.sun));
	}

	public Socket getSocket(String name, String ip, int port) {
		Log.i("shi","getSocket:Thread:"+Thread.currentThread().getName() );
		Log.i("shi",name+"Thread:"+Thread.currentThread().getName() );
		Socket mSocket = new Socket();
		InetSocketAddress address = new InetSocketAddress(ip, port);
		try {
			mSocket.connect(address, 3000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!mSocket.isConnected()) {// Socket对象是否曾经连接成功过
			info_tv.setText("设备：" + name + ",连接失败");
			return null;
		} else {
			
			return mSocket;
		}
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean getState() {
		return state;
	}

	public void closeSocket() {
		Log.i("shi","closeSocket:Thread:"+Thread.currentThread().getName() );
		try {
			if (sunSocket != null) {
				sunSocket.close();
			}
			if (tubeSocket != null) {
				tubeSocket.close();
			}
			if (buzzerSocket != null) {
				buzzerSocket.close();
			}
			if (curtainSocket != null) {
				curtainSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
