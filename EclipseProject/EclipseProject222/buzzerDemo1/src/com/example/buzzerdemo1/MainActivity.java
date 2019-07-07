package com.example.buzzerdemo1;
						
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Context;
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
	
	private EditText ip_et;
	private EditText port_et;
	private ToggleButton button;
	private TextView info_ev;
	
	private Button music;
	private Button red;
	private Button green;
	private Button blue;
	private Button closeall;
	
	private Context context;
	private String ip;
	private String port;
	
	private connectTask connect;
	private sendcmdTask send;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	   bindview();
	   initData();
	   initEvent();
	   
	}
	private void bindview() {
		ip_et=(EditText) findViewById(R.id.ip_et);
		port_et=(EditText) findViewById(R.id.port_et);
		button=(ToggleButton) findViewById(R.id.button);
		info_ev=(TextView) findViewById(R.id.info_tv);
		music=(Button) findViewById(R.id.music);
		red=(Button) findViewById(R.id.red);
		green=(Button) findViewById(R.id.green);
		blue=(Button) findViewById(R.id.blue);
		closeall=(Button) findViewById(R.id.close);
		
	}
	
	
	private void initData() {
		ip_et.setText(Constant.IP);
		port_et.setText(Constant.port+"");
		context=this;
		info_ev.setText("��������");
		
	}
	private void initEvent() {
		//����
	button.setOnCheckedChangeListener(new  OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked) {
					ip=ip_et.getText().toString().trim();
					port=port_et.getText().toString().trim();
					if(checkIpPort(ip, port)) {
						Constant.IP=ip;
						Constant.port=Integer.parseInt(port);
						//��������
						connect=new connectTask(context,info_ev);
						connect.execute();
					}
				}
			}
		});
		//����
	music.setOnClickListener(new  OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(connect!=null&&connect.getSTATE()) {
			send=new sendcmdTask(connect.getInputStream(),connect.getOutputStream(), context,Constant.BUZZER_CMD);
			send.execute();
			
		}else {
			info_ev.setText("�������ӣ��ڽ�������������");
		}
		}
	});
	
	//���
red.setOnClickListener(new  OnClickListener() {
	
	@Override
	public void onClick(View v) {
		if(connect!=null&&connect.getSTATE()) {
		send=new sendcmdTask(connect.getInputStream(),connect.getOutputStream(), context,Constant.RED_CMD);
		send.execute();
		
	}else {
		info_ev.setText("�������ӣ��ڽ�������������");
	}
	}
});

//�̵�
green.setOnClickListener(new  OnClickListener() {

@Override
public void onClick(View v) {
	if(connect!=null&&connect.getSTATE()) {
	send=new sendcmdTask(connect.getInputStream(),connect.getOutputStream(), context,Constant.GREEN_CMD);
	send.execute();
	
}else {
	info_ev.setText("�������ӣ��ڽ�������������");
}
}
});

//����
blue.setOnClickListener(new  OnClickListener() {

@Override
public void onClick(View v) {
	if(connect!=null&&connect.getSTATE()) {
	send=new sendcmdTask(connect.getInputStream(),connect.getOutputStream(), context,Constant.BLUE_CMD);
	send.execute();
	
}else {
	info_ev.setText("�������ӣ��ڽ�������������");
}
}
});

//ȫ��
closeall.setOnClickListener(new  OnClickListener() {

@Override
public void onClick(View v) {
if(connect!=null&&connect.getSTATE()) {
	send=new sendcmdTask(connect.getInputStream(),connect.getOutputStream(), context,Constant.CLOSEALL_CMD);
	send.execute();
	
}else {
	info_ev.setText("�������ӣ��ڽ�������������");
}
}
});
		
	}

	
	
	private boolean checkIpPort(String IP,String port){
		boolean isIpAddress= false;
		boolean isPort = false;
		
		if(IP==null || IP.length() < 7 || IP.length() > 15 || "".equals(IP) 
				|| port==null || port.length() < 4 || port.length() > 5)
	      {
	        return false;
	      }
	       //�ж�IP��ʽ�ͷ�Χ
	      String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
	      
	      Pattern pat = Pattern.compile(rexp);  
	      
	      Matcher mat = pat.matcher(IP);  
	      
	      isIpAddress = mat.find();
	      
	      //�ж϶˿�
	      int portInt=Integer.parseInt(port);
	      if(portInt>1024 && portInt<65536){
	    	  isPort=true;
	      }

		return (isIpAddress&&isPort);
	}

}
