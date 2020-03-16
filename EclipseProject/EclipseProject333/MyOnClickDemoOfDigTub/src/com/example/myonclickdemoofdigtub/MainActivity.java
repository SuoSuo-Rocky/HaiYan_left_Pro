package com.example.myonclickdemoofdigtub;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private ToggleButton connect_tb;
	private TextView info_tv;
	// private Button one;
	// private Button two;
	// private Button three;
	// private Button four;
	// private Button five;
	// private Button six;
	// private Button seven;
	// private Button eight;
	// private Button nine;
	// private Button zero;
	// private Button point;

	private EditText ip_et;
	private EditText port_et;

	private Context context;
	private connectTask connect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bindView();
		initDate();
		initEvent();

	}

	private void initEvent() {
		connect_tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					String ip = ip_et.getText().toString().trim();
					String port = port_et.getText().toString().trim();
					if (checkIpPort(ip, port)) {
						Constant.IP = ip;
						Constant.port = Integer.parseInt(port);
					} else {
						info_tv.setText("ip��port ���벻��ȷ������������.....");
						return;
					}
					Constant.tubeSocket = getSocket(Constant.IP, Constant.port);
					if (Constant.tubeSocket != null) {
						info_tv.setText("���ӳɹ�.....");
					}
				} else {
					closeall();
				}

			}
		});

	}

	private void initDate() {
		ip_et.setText(Constant.IP);
		port_et.setText(Constant.port + "");
		info_tv.setText("��������.......");
		context = this;
	}

	public void shiwei(View v) {
		switch (v.getId()) {
		case R.id.one:
			send(Constant.ONE_CMD);
			// Toast.makeText(context,"11111111",Toast.LENGTH_SHORT).show();
			break;
		case R.id.two:
			send(Constant.TWO_CMD);
			// Toast.makeText(context,"22222222",Toast.LENGTH_SHORT).show();
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
		case R.id.nine:
			send(Constant.NINE_CMD);
			break;
		case R.id.zero:
			send(Constant.ZERO_CMD);
			break;
		case R.id.point:
			send(Constant.POINT_CMD);
			// Toast.makeText(context,". . . . . ",Toast.LENGTH_SHORT).show();
			break;
		case R.id.eight:
			send(Constant.EIGHT_CMD);
			break;
		default:
			break;
		}
	}

	public void send(String cmd) {
		connect = new connectTask(context, info_tv);
		connect.execute(cmd);
	}

	public Socket getSocket(String ip, int port) {
		final Socket socket = new Socket();
		final InetSocketAddress address = new InetSocketAddress(ip, port);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					socket.connect(address, 3000);
					info_tv.setText("���ѽ��");
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}
		}).start(); 
		
		
		if (socket.isConnected()) {
			return socket;
		} else {
			info_tv.setText("����ʧ��.......");
			return null;
		}
	}

	public void closeall() {
		if (Constant.tubeSocket != null) {
			try {
				Constant.tubeSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (connect != null && connect.getStatus() == AsyncTask.Status.RUNNING) {
			connect.cancel(true);
		}

	}

	private void bindView() {
		connect_tb = (ToggleButton) findViewById(R.id.connect_tb);
		info_tv = (TextView) findViewById(R.id.info_tv);
		// one=(Button) findViewById(R.id.one);
		// two=(Button) findViewById(R.id.two);
		// three=(Button) findViewById(R.id.three);
		// four=(Button) findViewById(R.id.four);
		// five=(Button) findViewById(R.id.five);
		// six=(Button) findViewById(R.id.six);
		// seven=(Button) findViewById(R.id.seven);
		// eight=(Button) findViewById(R.id.eight);
		// nine=(Button) findViewById(R.id.nine);
		// zero=(Button) findViewById(R.id.zero);
		// point=(Button) findViewById(R.id.point);

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