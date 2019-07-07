package com.example.digtubedemo1;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private EditText ip_et;
	private EditText port_et;
	private ToggleButton button;
	private TextView info_tv;
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

	private String ip;
	private String port;
	private Context context;
	private sendcmdTask send;
	private ConnectTask connect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindveiw();
		initData();
		initEvent();
	}

	private void bindveiw() {
		ip_et = (EditText) findViewById(R.id.ip_et);
		port_et = (EditText) findViewById(R.id.port_et);
		button = (ToggleButton) findViewById(R.id.button);
		info_tv = (TextView) findViewById(R.id.info_tv);
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

	private void initData() {
		context = this;
		ip_et.setText(Constant.IP);
		port_et.setText(Constant.port + "");

	}

	private void initEvent() {
		// 开关按钮
		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					ip = ip_et.getText().toString().trim();
					port = port_et.getText().toString().trim();
					if (checkIpPort(ip, port)) {
						Constant.IP = ip_et.getText().toString().trim();
						Constant.port = Integer.parseInt(port_et.getText().toString().trim());
					} else {
						Toast.makeText(MainActivity.this, "IP 和 Port 输入错误 ！请重新输入：", Toast.LENGTH_SHORT).show();
						return;
					}

					// 开启任务
					connect = new ConnectTask(context, info_tv);
					connect.execute();
					Log.i("shi", "---------------connect.execute();--------------");
				} else {

				}
			}
		});

		// 11
		one.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.ONE_CMD);
					send.execute();
					Log.i("shi", "---------send.execute();------------");
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 22
		two.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.TWO_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 33
		three.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.THREE_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 44
		four.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.FOUR_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 55
		five.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.FIVE_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 66
		six.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.SIX_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 77
		seven.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.SEVEN_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 88
		eight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.EIGHT_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 99
		nine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.NINE_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 00
		zero.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.ZERO_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

		// .......
		point.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connect != null && connect.getSTATE()) {
					send = new sendcmdTask(context, connect.getInputStream(), connect.getOutputStream(),
							Constant.POINT_CMD);
					send.execute();
				} else {
					Toast.makeText(context, "请先进行连接在操作", Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

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

	@Override
	public void finish() {
		super.finish();
		try {
			// 取消任务
			if (connect != null && connect.getStatus() == AsyncTask.Status.RUNNING) {
				// 如果Task还在运行，则先取消它
				connect.cancel(true);
				connect.getSocket().close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
