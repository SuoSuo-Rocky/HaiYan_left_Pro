package com.example.modeldemo1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private TextView info_tv;
	private EditText ip_et;
	private EditText port_et;
	private ToggleButton connect_tb;
	private TextView sun_tv;
	
	private Context context; 
	private connectTask connect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindView();
		initData();
		initEvent();
		
	}


	private void initData() {
		ip_et.setText(Constant.IP);
		port_et.setText(String.valueOf(Constant.port));
		info_tv.setText("请点击连接......");
        context=this;		
	}


	private void bindView() {
		ip_et=(EditText) findViewById(R.id.ip_et);
		port_et=(EditText) findViewById(R.id.port_et);
		sun_tv=(TextView) findViewById(R.id.sun_tv);
		info_tv=(TextView) findViewById(R.id.info_tv);
		connect_tb=(ToggleButton) findViewById(R.id.connect_tb);
	}
	

	private void initEvent() {
		connect_tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					String ip=ip_et.getText().toString().trim();
					String port=port_et.getText().toString().trim();
					if(checkIpPort(ip, port)){
						Constant.IP=ip;
						Constant.port=Integer.parseInt(port);
					}
					//开启任务
					connect=new connectTask(context,info_tv,sun_tv);
					connect.setState(true);
					connect.execute();
				}else{
					
					connect.setState(false);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					connect.cancel(true);
					connect.closeSocket();
					info_tv.setText("请点击连接......");
					
				}
				
			}
		});
		
		
		
		
		
		
	}

	/**
	 * IP地址可用端口号验证，可用端口号（1024-65536）
	 * @param IP
	 * @param port
	 * @return
	 */
	private boolean checkIpPort(String IP,String port){
		boolean isIpAddress= false;
		boolean isPort = false;
		
		if(IP==null || IP.length() < 7 || IP.length() > 15 || "".equals(IP) 
				|| port==null || port.length() < 4 || port.length() > 5)
	      {
	        return false;
	      }
	       //判断IP格式和范围
	      String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
	      
	      Pattern pat = Pattern.compile(rexp);  
	      
	      Matcher mat = pat.matcher(IP);  
	      
	      isIpAddress = mat.find();
	      
	      //判断端口
	      int portInt=Integer.parseInt(port);
	      if(portInt>1024 && portInt<65536){
	    	  isPort=true;
	      }

		return (isIpAddress&&isPort);
	}

}





















