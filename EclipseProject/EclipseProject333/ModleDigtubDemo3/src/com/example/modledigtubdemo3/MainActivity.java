package com.example.modledigtubdemo3;

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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private TextView sun_tv;
	private TextView info_tv;
	private EditText ip_et;
	private EditText port_et;
	private ToggleButton connect_tb;

	private Button one;
	private Button two;
	private Button three;
	private Button four;
	private Button five;
	private Button six;
	private Button seven;
	private Button eight;
	private Button nine;
	private Button zero;
	private Button point;

	private Context context;
	private connectTask connect;
	private socketTask socket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindView();
		initData();
		initEvent();
	}

	private void initData() {
		info_tv.setText("请点击连接......");
		context = this;
		ip_et.setText(Constant.IP);
		port_et.setText(String.valueOf(Constant.port));
	}

	private void bindView() {
		ip_et = (EditText) findViewById(R.id.ip_et);
		port_et = (EditText) findViewById(R.id.port_et);
		sun_tv = (TextView) findViewById(R.id.sun_tv);
		info_tv = (TextView) findViewById(R.id.info_tv);
		connect_tb = (ToggleButton) findViewById(R.id.connect_tb);
		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);
		point = (Button) findViewById(R.id.point);

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
					}
					socket=new socketTask(info_tv);
					socket.execute();
					//Constant.tubSocket = getSocket(Constant.IP, Constant.port);
				} else {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (Constant.tubSocket != null) {
						try {
							Constant.tubSocket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					info_tv.setText("请点击连接.......");
				}
			}
		});

		one.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.ONE_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		two.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.TWO_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		three.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.THREE_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		four.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.FOUR_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		five.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.FIVE_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		six.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.SIX_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		seven.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.SEVEN_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		eight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.EIGHT_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		nine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.NINE_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		zero.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.ZERO_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

		point.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.tubSocket != null) {
					connect = new connectTask(context, info_tv);
					connect.execute(Constant.POINT_CMD);
				} else {
					info_tv.setText("请先进行连接，再操作......");
				}
			}
		});

	}

	

	/**
	 * IP地址可用端口号验证，可用端口号（1024-65536）
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
		// 判断IP格式和范围
		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

		Pattern pat = Pattern.compile(rexp);

		Matcher mat = pat.matcher(IP);

		isIpAddress = mat.find();

		// 判断端口
		int portInt = Integer.parseInt(port);
		if (portInt > 1024 && portInt < 65536) {
			isPort = true;
		}

		return (isIpAddress && isPort);
	}

}
