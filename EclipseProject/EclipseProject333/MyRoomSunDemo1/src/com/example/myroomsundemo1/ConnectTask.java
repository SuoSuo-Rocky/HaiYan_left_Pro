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
		info_tv.setText("��������......");
	}

	@Override
	protected Void doInBackground(Void... params) {
		Log.i("shi","doInBackground:Thread:"+Thread.currentThread().getName() );
		try {
			sunSocket = getSocket("����", Const.SUN_IP, Const.SUN_PORT);
			Thread.sleep(200);
			if (sunSocket != null) {
				bar.setProgress(25);
			}
			tubeSocket = getSocket("�����", Const.TUBE_IP, Const.TUBE_PORT);
			Thread.sleep(200);
			if (tubeSocket != null) {
				bar.setProgress(50);
			}
			buzzerSocket = getSocket("������", Const.BUZZER_IP, Const.BUZZER_PORT);
			Thread.sleep(200);
			if (buzzerSocket != null) {
				bar.setProgress(75);
			}
			curtainSocket = getSocket("�ҵĴ���", Const.CURTAIN_IP, Const.CURTAIN_PORT);
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
					// ��ѯ����ֵ
					StreamUtil.writeCommand(sunSocket.getOutputStream(), Const.SUN_CHK);
					Thread.sleep(Const.time / 2);
					date = StreamUtil.readData(sunSocket.getInputStream());
					float1 = FROSun.getData(Const.SUN_LEN, Const.SUN_NUM, date);
					if (float1 != null) {
						Const.sun = (int) (float) float1;
					}
					// �������ʾ
					Const.TUBE_CMD = FRODigTube.intToCmdString(Const.sun);
					StreamUtil.writeCommand(tubeSocket.getOutputStream(), Const.TUBE_CMD);
					Thread.sleep(Const.time / 2);
					// �ж�
					if (Const.sun > Const.maxLim && Const.linkage) {
						// ������
						if (!Const.isBuzzerOn) {
							StreamUtil.writeCommand(buzzerSocket.getOutputStream(), Const.BUZZER_ON);
							Thread.sleep(1000);
							StreamUtil.writeCommand(buzzerSocket.getOutputStream(), Const.BUZZER_OFF);
							Thread.sleep(200);
						}
						// ����
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
				info_tv.setText("����ʧ�ܣ����� IP �� Port ......");
			}
		}

		// ���ڶ��ε����ťʱ����رշ�����
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

		if (!mSocket.isConnected()) {// Socket�����Ƿ��������ӳɹ���
			info_tv.setText("�豸��" + name + ",����ʧ��");
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
