package com.example.name33;
                                //������
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import com.example.name33.BluetoothLeClass.onDataAvaliableListener;
import com.example.name33.BluetoothLeClass.onServerDiscoveredListener;
import com.fro.util.FROSun;
import com.fro.util.HexStrConvertUtil;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	
	private ListView listview;
	private ToggleButton button;
	private TextView info_tv;
	private TextView sun_tv;
	
	private StringBuilder result;
	private Handler mhandler;
	private Timer  mtimer;
	private TimerTask mtimertask;
	
	private BluetoothLeClass mBle;
	private  BluetoothLeAdapter mAdapter;
	private Context mContext;
	

	
	private BluetoothGattService mServer;
	private BluetoothGattCharacteristic mChar6;
	
	private static final String UUID_SERVICE = "0000fff0-0000-1000-8000-00805f9b34fb";
	private static final String UUID_CHAR6 = "0000fff6-0000-1000-8000-00805f9b34fb";
	private static final String UUID_DESC = "00002902-0000-1000-8000-00805f9b34fb";
	
	public static final int NODE_NUM=1;
	public static final String SUN_CMD="01 03 00 2A 00 01 a5 c2";
	public static final int SUN_LEN=7;
	
	private boolean isRead=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//����ͼ
		 bindview();
		 //��ʼ������
		 initData();
		 //��ʼ���¼�
		 initEvent();
			mBle=new BluetoothLeClass(this);
			// ��ʼ��BLE
			if (mBle.initialize()) {
				info_tv.setText("��ʼ��BLE�ɹ�!");
				// Log.i(TAG, "��ʼ��BLE�ɹ�");
			} else {
				info_tv.setText("��ʼ��BLEʧ��!");
				// Log.i(TAG, "��ʼ��BLEʧ��");
			}
		 mBle.setmServerListener(mServerListener);
		 mBle.setmDataListener(mDataListener);
	}




	




	private void bindview() {
		listview=(ListView) findViewById(R.id.listview);
		button=(ToggleButton) findViewById(R.id.button);
		info_tv=(TextView) findViewById(R.id.info_tv);
		sun_tv=(TextView) findViewById(R.id.sun_tv);
		
	}
	
	
	private void initData() {
		mtimer=new Timer();
		result=new StringBuilder("");
		mContext=MainActivity.this;
		mAdapter=new BluetoothLeAdapter(this);
		listview.setAdapter(mAdapter);
		
		
	}
	
	private void initEvent() {
		
		
		mhandler=new Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what==1){
					if(isRead){
						sendCommand();
					}
				}
				
			}
		};
	
		//��ʱ��
		mtimertask=new TimerTask() {
			
			@Override
			public void run() {
				Message message=new Message();
				message.what=1;
				mhandler.sendMessage(message);
				
			}
		};
		
		mtimer.schedule(mtimertask,100,1000);
		
		
		//������ť
		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
//					manager=(BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
//					adapter=manager.getAdapter();
//					Log.i("shi22","MyAdapter="+adapter);
//					
//					if(!adapter.enable()||adapter==null){
//						Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//					    startActivity(intent);
//					}
					if(mBle.adapter.isEnabled()){
						//����б�
						mAdapter.clear();
						mBle.adapter.startLeScan(mcallback);
						Log.i("shi","---------------1-------------------");
						info_tv.setText("��ʼɨ�� BLE �նˡ���������");
					}
				}else{
					mBle.adapter.stopLeScan(mcallback);
					info_tv.setText("��ֹͣɨ�� BLE �ն�");
				}
			}
		});
		
		
		//Item ���
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//ֹͣɨ��
				boolean shi;
//				button.setChecked(false);
//				mBle.adapter.stopLeScan(mcallback);
//				final BluetoothDevice device=mAdapter.getDevice(position);
//				if(device==null){
//					return;
//				}
//				isRead=!isRead;
//				if (isRead) {
//					// ����GATT����
//					info_tv.setText("��������BLE�ն�...");
//					if (!mBle.connect(device.getAddress())) {
//						info_tv.setText("����ʧ�ܣ�");
//					}
//				}
				final BluetoothDevice device=mAdapter.getDevice(position);
				isRead=!isRead;
				if(isRead){
					Log.i("shi","--------------2--------------------");
					//����GATT����
					info_tv.setText("�������� BLE �ն�");
					shi=mBle.connect(device.getAddress());
					shi=!shi;
					if(shi){
						info_tv.setText("����ʧ��");
					}
				}
//				else{
//					mBle.disconnect();
//				}
			}
		
		});
	}
	
	
	

	private BluetoothAdapter.LeScanCallback mcallback=new BluetoothAdapter.LeScanCallback() {
		
		@Override
		public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					mAdapter.addDevice(device);
					mAdapter.notifyDataSetChanged();
					
				}
			});
			
		}
	};
	
//	private BluetoothAdapter.LeScanCallback mcallback=new LeScanCallback() {
//		
//		@Override
//		public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
//			runOnUiThread(new Runnable() {
//				
//				@Override
//				public void run() {
//					mAdapter.addDevice(device);
//					mAdapter.notifyDataSetChanged();
//					
//				}
//			});
//			
//			
//			
//		}
//	};
//	
	
	
	private BluetoothLeClass.onServerDiscoveredListener mServerListener=new  onServerDiscoveredListener() {
		
		@Override
		public void onServerDisvered(BluetoothGatt gatt) {
			Log.i("shi","-----------------8-----------------");
			mServer=gatt.getService(UUID.fromString(UUID_SERVICE));
			if(mServer!=null){
				Log.i("shi","-----------------9-----------------");
				mChar6=mServer.getCharacteristic(UUID.fromString(UUID_CHAR6));
				if(mChar6!=null){
					Log.i("shi","-----------------10-----------------");
					mBle.setCharacteristicNotification(mChar6,true);
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							info_tv.setText("���ӳɹ�");
							
						}
					});
				}
			}else{
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						info_tv.setText("��ȡ����ʧ�ܣ�");
						
					}
				});
			}
			
		}
	};
	
	
	private BluetoothLeClass.onDataAvaliableListener mDataListener=new onDataAvaliableListener() {
		
		@Override
		public void onCharacteristicRead(BluetoothGatt gatt,BluetoothGattCharacteristic characteristic,int status) {
			Log.i("shi","onCharRead="+gatt.getDevice().getName()+"\t read="+characteristic.getUuid().toString()
					+"---->"+HexStrConvertUtil.bytesToHexString(characteristic.getValue()));
		}
		
		@Override
		public void onCharacteristicWrite(BluetoothGatt gatt,BluetoothGattCharacteristic characteristic) {
			Log.i("shi","---------------13-------------------");
			Log.i("shi","characteristic.getUuid().toString()="+characteristic.getUuid().toString());
			if(characteristic.getUuid().toString().equals(UUID_CHAR6)){
				Log.i("shi","------------------14----------------");
				Log.i("shi","�յ�BLE�ն�д�����ݻص�");
				Float fData=FROSun.getData(SUN_LEN, NODE_NUM, characteristic.getValue());
				String value=String.valueOf((int) (float)fData+"Lux");
				result.replace(0,result.length(),value);
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						sun_tv.setText(result);
						
					}
				});
			}
			
			
			
		}
	};

	@Override
	protected void onPause() {
		super.onPause();
	}
	
	
	protected void onDestroy() {
		super.onDestroy();
		mtimer.cancel();
		mBle.adapter.stopLeScan(mcallback);
//		mBle.disconnect();
//		mBle.close();
	}

	
	
		
	private void sendCommand() {
		Log.i("shi","-----------------11-----------------");
		if(mBle.mgatt!=null&&mChar6!=null){
			Log.i("shi","-----------------12-----------------");
			//��������
			String str=SUN_CMD;
			mChar6.setValue(HexStrConvertUtil.hexStringToByte(str));
			//������ģ��д������
			mBle.mgatt.writeCharacteristic(mChar6);
		}
	}




	

}