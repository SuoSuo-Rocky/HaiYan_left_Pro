package com.example.myrfiddemo_twodemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fro.util.CRCValidate;
import com.fro.util.HexStrConvertUtil;

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
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private ToggleButton button;
	private TextView info_tv;

	private Button findCardBtn;
	private TextView findCardTv;

	private Button readCardBtn;
	private TextView readCardTv;

	private Button chooseCardBtn;
	private TextView chooseCardTv;

	private Button chooseAreaBtn;
	private TextView chooseAreaTv;

	private Button readAreaBtn;
	private TextView readAreaTv;

	private Context context;
	private connectTask connectTask;
	private secondTask send;

	private EditText ip_et;
	private EditText port_et;

	private String ip;
	private String port;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindView();
		initData();
		initEvent();

	}

	private void bindView() {
		button = (ToggleButton) findViewById(R.id.button);
		info_tv = (TextView) findViewById(R.id.info_tv);

		findCardBtn = (Button) findViewById(R.id.findCarBtn);
		findCardTv = (TextView) findViewById(R.id.findCartv);

		readCardBtn = (Button) findViewById(R.id.readCarBtn);
		readCardTv = (TextView) findViewById(R.id.readCartv);

		chooseCardBtn = (Button) findViewById(R.id.chooseCarBtn);
		chooseCardTv = (TextView) findViewById(R.id.chooseCartv);

		chooseAreaBtn = (Button) findViewById(R.id.chooseAreaBtn);
		chooseAreaTv = (TextView) findViewById(R.id.chooseAreatv);

		readAreaBtn = (Button) findViewById(R.id.readAreaBtn);
		readAreaTv = (TextView) findViewById(R.id.readAreatv);

		ip_et = (EditText) findViewById(R.id.ip_et);
		port_et = (EditText) findViewById(R.id.port_et);

	}

	private void initData() {
		context = this;
		info_tv.setText("请点击连接...");
		ip_et.setText(Constant.IP);
		new String();
		port_et.setText(String.valueOf(Constant.port));

	}

	private void initEvent() {
		// 连接
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
						Toast.makeText(context, "IP 和 Port 输入不正确！\n 请重新输入......", Toast.LENGTH_SHORT).show();
						return;
					}

					connectTask = new connectTask(context, info_tv);
					connectTask.execute();

				} else {
					if (connectTask != null && connectTask.getStatus() == AsyncTask.Status.RUNNING) {
						connectTask.setState(false);
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						connectTask.cancel(true);
						connectTask.closeSocket();
					}
					info_tv.setText("请点击连接......");
				}
			}
		});

		// 寻卡
		findCardBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connectTask != null && connectTask.getState()) {
					send = new secondTask(context, findCardTv, connectTask.getInputStream(),
							connectTask.getOnputStream(), Constant.FIND_CARD_CMD, Constant.FIND_CARD_ERROR);
					send.execute();
				} else {
					Toast.makeText(context, "请点击连接，在进行操作！", Toast.LENGTH_SHORT).show();
				}

			}
		});

		// 读卡
		readCardBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connectTask != null && connectTask.getState()) {
					send = new secondTask(context, readCardTv, connectTask.getInputStream(),
							connectTask.getOnputStream(), Constant.READ_CARD_CMD, Constant.READ_CARD_ERROR);
					send.execute();

				} else {
					Toast.makeText(context, "请点击连接，在进行操作！", Toast.LENGTH_SHORT).show();
				}

			}
		});

		// 选卡
		chooseCardBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connectTask != null && connectTask.getState()) {
					
					Constant.CARD_ID=HexStrConvertUtil.transSpace(Constant.CARD_ID).trim();
					//"5A EF C6 04"->"00 00 03 02 5A EF C6 04"
					String addnewCardId="00 00 03 02 "+Constant.CARD_ID;
					//crc={0,0x76}
					byte[] crc={0,(byte) CRCValidate.calculateSingleCRC(HexStrConvertUtil.hexStringToByte(addnewCardId),0,addnewCardId.length())};
					//{0,0x76}->"00 76"
					String newcrc=""+HexStrConvertUtil.bytesToHexString(crc).substring(2);

					//CHOOSE_CARD_CMD="AA BB 09 00 "+"00 00 03 02 5A EF C6 04"+" 76"
					Constant.CHOOSE_CARD_CMD="AA BB 09 00 "+addnewCardId+newcrc;

					send = new secondTask(context, chooseCardTv, connectTask.getInputStream(),
							connectTask.getOnputStream(), Constant.CHOOSE_CARD_CMD, Constant.CHOOSE_CARD_ERROR);
					send.execute();

				} else {
					Toast.makeText(context, "请点击连接，在进行操作！", Toast.LENGTH_SHORT).show();
				}

			}
		});

		// 选块
		chooseAreaBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connectTask != null && connectTask.getState()) {
					send = new secondTask(context, chooseAreaTv, connectTask.getInputStream(),
							connectTask.getOnputStream(), Constant.CHOOSE_AREA_CMD, Constant.CHOOSE_AREA_ERROR);
					send.execute();

				} else {
					Toast.makeText(context, "请点击连接，在进行操作！", Toast.LENGTH_SHORT).show();
				}

			}
		});

		// 读块
		readAreaBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (connectTask != null && connectTask.getState()) {
					send = new secondTask(context, readAreaTv, connectTask.getInputStream(),
							connectTask.getOnputStream(), Constant.READ_AREA_CMD, Constant.READ_AREA_ERROR);
					send.execute();

				} else {
					Toast.makeText(context, "请点击连接，在进行操作！", Toast.LENGTH_SHORT).show();
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

}
