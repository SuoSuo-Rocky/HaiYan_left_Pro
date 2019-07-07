package com.example.modledigtubdemo6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private ToggleButton button;
	private TextView info_tv;
	private EditText ip_et;
	private EditText port_et;

	private connectTask connect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindView();
		initView();

		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					String ip = ip_et.getText().toString().trim();
					String port = port_et.getText().toString().trim();
					if (checkIpPort(ip, port)) {
						Constant.IP = ip;
						Constant.port = Integer.parseInt(port);
					} else {
						info_tv.setText("ip �� Port ���벻��ȷ�� ����������......");
						return;
					}
					getSocket(Constant.IP, Constant.port);
					if (Constant.tubSocket != null) {
						info_tv.setText("���ӳɹ�.....");
					}
				}else{
					closeAll();
				}
			}
		});
	}

	public void shiwei(View v) {
		switch (v.getId()) {
		case R.id.one:
			send(Constant.ONE_CMD);
			break;
		case R.id.two:
			send(Constant.TWO_CMD);
			break;
		case R.id.three:
			send(Constant.THREE_CMD);
			break;
		case R.id.four:
			send(Constant.FOUR_CMD);
			break;
		case R.id.five:
			send(Constant.FIVE_CMD);
			break;
		case R.id.six:
			send(Constant.SIX_CMD);
			break;
		case R.id.seven:
			send(Constant.SEVEN_CMD);
			break;
		case R.id.eight:
			send(Constant.EIGHT_CMD);
			break;
		case R.id.nine:
			send(Constant.NINE_CMD);
			break;
		case R.id.zero:
			send(Constant.ZERO_CMD);
			break;
		case R.id.point:
			send(Constant.POINT_CMD);
			break;
		default:
			break;
		}
	}

	private void send(String cmd) {
		if (Constant.tubSocket == null) {
			info_tv.setText("���Ƚ������ӣ��ٽ�����������.......");
			return;
		}
		connect = new connectTask(info_tv);
		connect.execute(cmd);
	}

	private void initView() {
		info_tv.setText("��������......");
		ip_et.setText(Constant.IP);
		port_et.setText(String.valueOf(Constant.port));
	}

	public void closeAll() {
		if (connect != null && connect.getStatus() == AsyncTask.Status.RUNNING) {
			connect.cancel(true);
		}
		if (Constant.tubSocket != null) {
			try {
				Constant.tubSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void getSocket(String ip, int port) {
		final Socket socket = new Socket();
		final InetSocketAddress address = new InetSocketAddress(ip, port);
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					socket.connect(address, 3000);
					if (!socket.isConnected()) {
						info_tv.setText("����ʧ��...");
					} else {
						Constant.tubSocket=socket;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}).start();

	
	}

	private void bindView() {
		button = (ToggleButton) findViewById(R.id.connect_tb);
		info_tv = (TextView) findViewById(R.id.info_tv);
		ip_et = (EditText) findViewById(R.id.ip_et);
		port_et = (EditText) findViewById(R.id.port_et);

	}

	/**
	 * IP��ַ���ö˿ں���֤�����ö˿ںţ�1024-65536��
	 * 
	 * @param IP
	 * @param port
	 * @return
	 */
	private boolean checkIpPort(String IP, String port) {
		boolean isIpAddress = false;
		boolean isPort = false;

		if (IP == null || IP.length() < 7 || IP.length() > 15 || "".equals(IP) || port == null || port.length() < 4
				|| port.length() > 5) {
			return false;
		}
		// �ж�IP��ʽ�ͷ�Χ
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

		Pattern pat = Pattern.compile(rexp);

		Matcher mat = pat.matcher(IP);

		isIpAddress = mat.find();

		// �ж϶˿�
		int portInt = Integer.parseInt(port);
		if (portInt > 1024 && portInt < 65536) {
			isPort = true;
		}

		return (isIpAddress && isPort);
	}

}
