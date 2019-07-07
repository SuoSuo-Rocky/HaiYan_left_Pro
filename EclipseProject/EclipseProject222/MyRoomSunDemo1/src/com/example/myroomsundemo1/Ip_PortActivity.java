package com.example.myroomsundemo1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class Ip_PortActivity extends Activity {
	
	private EditText sunIp_et;
	private EditText sunPort_et;
	private EditText tubeIp_et;
	private EditText tubePort_et;
	private EditText buzzerIp_et;
	private EditText buzzerPort_et;
	private EditText curtainIp_et;
	private EditText curtainPort_et;
	
	private Button overbutton;
	
	private Context ip_portContext;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ip_port);
		bindview();
		initData();
		initEvent();
	}




	private void bindview() {
		sunIp_et = (EditText) findViewById(R.id.sunIp_et);
		sunPort_et = (EditText) findViewById(R.id.sunPort_et);
		tubeIp_et = (EditText) findViewById(R.id.tubeIp_et);
		tubePort_et = (EditText) findViewById(R.id.tubePort_et);
		buzzerIp_et = (EditText) findViewById(R.id.buzzerIp_et);
		buzzerPort_et = (EditText) findViewById(R.id.buzzerPort_et);
		curtainIp_et = (EditText) findViewById(R.id.curtainIp_et);
		curtainPort_et = (EditText) findViewById(R.id.curtainPort_et);
		overbutton=(Button) findViewById(R.id.overbutton);
		
	}
	

	private void initData() {
		ip_portContext=this;
		sunIp_et.setText(Const.SUN_IP);
		sunPort_et.setText(String.valueOf(Const.SUN_PORT));
		tubeIp_et.setText(Const.TUBE_IP);
		tubePort_et.setText(String.valueOf(Const.TUBE_PORT));
		buzzerIp_et.setText(Const.BUZZER_IP);
		buzzerPort_et.setText(String.valueOf(Const.BUZZER_PORT));
		curtainIp_et.setText(Const.CURTAIN_IP);
		curtainPort_et.setText(String.valueOf(Const.CURTAIN_PORT));
		
	}


	private void initEvent() {
		
		overbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// 获取IP和端口
				String SUN_IP = sunIp_et.getText().toString().trim();
				String SUN_PORT = sunPort_et.getText().toString().trim();
				String TUBE_IP = tubeIp_et.getText().toString().trim();
				String TUBE_PORT = tubePort_et.getText().toString().trim();
				String BUZZER_IP = buzzerIp_et.getText().toString().trim();
				String BUZZER_PORT = buzzerPort_et.getText().toString().trim();
				String CURTAIN_IP = curtainIp_et.getText().toString().trim();
				String CURTAIN_PORT = curtainPort_et.getText().toString().trim();
				if (checkIpPort(SUN_IP, SUN_PORT) && checkIpPort(TUBE_IP, TUBE_PORT)
						&& checkIpPort(BUZZER_IP, BUZZER_PORT) && checkIpPort(CURTAIN_IP, CURTAIN_PORT)) {
					Const.SUN_IP = SUN_IP;
					Const.SUN_PORT = Integer.parseInt(SUN_PORT);
					Const.TUBE_IP = TUBE_IP;
					Const.TUBE_PORT = Integer.parseInt(TUBE_PORT);
					Const.BUZZER_IP = BUZZER_IP;
					Const.BUZZER_PORT = Integer.parseInt(BUZZER_PORT);
					Const.CURTAIN_IP = CURTAIN_IP;
					Const.CURTAIN_PORT = Integer.parseInt(CURTAIN_PORT);
					Intent intent=new Intent();//跳转页面的next One,但要注意在配置文件中还有活哦！
					//intent.setAction("successed");//不能设置两个 Action
					intent.setClass(Ip_PortActivity.this,MainActivity.class);////跳转页面的next Two
					startActivity(intent);
				} else {
					Toast.makeText(ip_portContext, "配置信息不正确,请重输！", Toast.LENGTH_SHORT).show();
					overbutton.setText("配置信息不正确,请重输！");
					return;
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
				|| port.length() > 5 || "".equals(port)) {
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
