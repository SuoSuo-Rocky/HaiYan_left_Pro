package com.example.name33;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BluetoothLeAdapter extends BaseAdapter {
	 private Activity mcontext;
	 private List<BluetoothDevice> mDevice;
	 private LayoutInflater inflater;


	public BluetoothLeAdapter(Activity c) {
		super();
		mcontext=c;
		mDevice=new ArrayList<BluetoothDevice>();
		inflater=mcontext.getLayoutInflater();
	}
	
	public void addDevice(BluetoothDevice device) {
		if(!mDevice.contains(device)){
			mDevice.add(device);
		}
	}
	
	public BluetoothDevice getDevice(int position) {
		return mDevice.get(position);
	}

	@Override
	public int getCount() {
		return mDevice.size();
	}

	@Override
	public Object getItem(int position) {
		return mDevice.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		ViewHolder holder;
		if(view==null){
			view=inflater.inflate(R.layout.listdevice,null);
			holder=new ViewHolder();
			holder.deviceName=(TextView) view.findViewById(R.id.device_name);
			holder.deviceAddress=(TextView) view.findViewById(R.id.device_address);
			view.setTag(holder);
		}else{
			holder=(ViewHolder) view.getTag();
		}
		//对应的设备进行处理
		BluetoothDevice device=mDevice.get(position);
		final String  deviceName=device.getName();
		if(deviceName!=null&&deviceName.length()>0){
			holder.deviceName.setText(deviceName);
		}else{
			holder.deviceName.setText("未知设备");
		}
		holder.deviceAddress.setText(device.getAddress());
		
		return view;
		
	}
	
	final class ViewHolder{
		TextView deviceName;
		TextView deviceAddress;
	}

	public void clear() {
		mDevice.clear();
		
	}




}
