package com.example.myroomsundemo1;

import com.fro.room_sunalarmcase.view.PushSlideSwitchView;
import com.fro.room_sunalarmcase.view.PushSlideSwitchView.OnSwitchChangedListener;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private EditText cycle;
	private TextView sun_tv;
	private EditText maxLim;
	private PushSlideSwitchView switchview;
	private ToggleButton button;
	private TextView info_tv;
	private ProgressBar bar;

	private ConnectTask connect;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindview();
		initData();
		initEvent();
	}

	private void bindview() {
		cycle = (EditText) findViewById(R.id.cycle);
		sun_tv = (TextView) findViewById(R.id.sun_tv);
		maxLim = (EditText) findViewById(R.id.maxLim);
		switchview = (PushSlideSwitchView) findViewById(R.id.linkage_sw);
		button = (ToggleButton) findViewById(R.id.button);
		info_tv = (TextView) findViewById(R.id.info_tv);
		bar = (ProgressBar) findViewById(R.id.bar);

	}

	private void initData() {
		context = this;
		switchview.setChecked(true);
		cycle.setText(new String().valueOf(Const.time));
		maxLim.setText(new String().valueOf(Const.maxLim));
		info_tv.setText("请点击连接....");

	}

	private void initEvent() {
		// 联动
		switchview.setOnChangeListener(new OnSwitchChangedListener() {

			@Override
			public void onSwitchChange(PushSlideSwitchView switchView, boolean isChecked) {
				if (isChecked) {
                   Const.linkage=true;
				}else{
					Const.linkage=false;
				}

			}
		});

		// 连接
		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					Const.maxLim = Integer.parseInt(maxLim.getText().toString().trim());
					Const.time = Integer.parseInt(cycle.getText().toString().trim());
					// 进度条显示
					bar.setVisibility(View.VISIBLE);
					// 开启任务
					connect = new ConnectTask(context, sun_tv, info_tv, bar);
					connect.setState(true);
					connect.execute();
				} else {
					if (connect != null && connect.getStatus() == AsyncTask.Status.RUNNING) {
						connect.setState(false);
						try {
							Thread.sleep(3500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						connect.cancel(true);
						connect.closeSocket();

					}
					bar.setVisibility(View.GONE);
					info_tv.setText("请点击连接......");
				}

			}
		});

	}

}
