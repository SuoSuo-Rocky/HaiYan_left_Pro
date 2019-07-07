package com.example.selfmysundemo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;


import com.fro.util.FROSun;
import com.fro.util.HexStrConvertUtil;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MainActivity extends Activity {
	
	public interface OnServiceDiscoverListener {
		public void onServiceDiscover(BluetoothGatt gatt);
	}
	
	public interface OnDataAvailableListener {
		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

		public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);
	}
	
	private OnServiceDiscoverListener  mOnServiceDiscoverListener;
	private OnDataAvailableListener mOnDataAvailableListener;
	
	public void setmOnServiceDiscoverListener(OnServiceDiscoverListener mOnServiceDiscoverListener) {
		this.mOnServiceDiscoverListener = mOnServiceDiscoverListener;
	}
	
	public void setmOnDataAvailableListener(OnDataAvailableListener mOnDataAvailableListener) {
		this.mOnDataAvailableListener = mOnDataAvailableListener;
	}
	public static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = UUID
			.fromString("00002902-0000-1000-8000-00805f9b34fb");
	
	public static final int NODE_NUM=1;
	
	public static final String SUN_CMD="01 03 00 2A 00 01 a5 c2";
	public static final int SUN_LEN=7;
	

	private static final String UUID_SERVICE = "0000fff0-0000-1000-8000-00805f9b34fb";
	private static final String UUID_CHAR6 = "0000fff6-0000-1000-8000-00805f9b34fb";
	private static final String UUID_DESC = "00002902-0000-1000-8000-00805f9b34fb";
	
	// ���յ��ֶ�
	private StringBuilder recv_sb;
	// �Ƿ�����д����
		private boolean isReadTaskRun;
	
	private final Timer timer = new Timer();
	private TimerTask task;
	private Handler handler;
	
	
	private ToggleButton button;
	private TextView info_tv;
	private TextView sun_tv;
	String RemoteDriveName="FR_2CE7_G";
	List<BluetoothDevice> list;
	
	private Context context;
	private BluetoothAdapter adapter;
	private BluetoothManager manager;
	private BluetoothGatt mgatt;
	private BluetoothGattService mService;
	private BluetoothGattCharacteristic gattCharacteristic_char6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("shi","Hello");
		bindView();
		initData();
		initEvent();
		setmOnServiceDiscoverListener(discoverService);
		setmOnDataAvailableListener(dataAvaliable);
	}



	private void bindView() {
		Log.i("shi","Hello2");
		button=(ToggleButton) findViewById(R.id.button);
		info_tv=(TextView) findViewById(R.id.info_tv);
		sun_tv=(TextView) findViewById(R.id.sun_tv);
	}

	private void initData() {
		Log.i("shi","Hello3");
		context=MainActivity.this;
		list=new ArrayList<BluetoothDevice>();
	}
	
	
	private void initEvent() {
		

		// ������Ϣ
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				// ���1��,�յ�msg���ȡһ������
				if (msg.what == 1) {
					if (isReadTaskRun) {
						ReadBle();
					}
				}
			}
		};

		// ��ʱ����
		task = new TimerTask() {
			@Override
			public void run() {
				Message message = new Message();
				message.what = 1;
				handler.sendMessage(message);
			}
		};
		
		// ������ȡ�����߳�
		timer.schedule(task, 100, 1000);
		
		
		
		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					manager=(BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
					
					if(manager!=null){
					adapter=manager.getAdapter();
					Log.i("shi","�ҵ������豸������Ϊ��"+adapter.getName()+"----------1---------------");					
					if(adapter.isEnabled()==false){
						Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
						startActivity(intent);
					}
					
					if(adapter!=null){
						adapter.startLeScan(callback);
						Log.i("shi","---------------2-----");
						info_tv.setText("����ɨ���豸");
					}else{
						Toast.makeText(MainActivity.this,"�Բ�������豸��֧����������",Toast.LENGTH_SHORT).show();
					}
					
//					//��ȡ�Ѿ���������豸��Ϣ
//					Set<BluetoothDevice> devices = adapter.getBondedDevices();
//					if (devices.size()>0) {  
//					    for(Iterator<BluetoothDevice> iterator=devices.iterator();iterator.hasNext();){  
//					          BluetoothDevice bluetoothDevice=(BluetoothDevice)iterator.next();  
//					          System.out.println("�豸��"+bluetoothDevice.getName() + " " + bluetoothDevice.getAddress());
//					    }  
//					}  
					}
				}
			}
		});
	
	}
	
	
	/**
	 * ��ȡBLE����
	 */
	private void ReadBle() {
		Log.i("shi","---------------��ʼ���� ��������ķ���-----");
		// TODO Auto-generated method stub
		if (mgatt != null && gattCharacteristic_char6 != null) {
			Log.i("shi","---------------15-----");
			// ��ȡ��������
			String writeStr =SUN_CMD;
			// ������������
			gattCharacteristic_char6.setValue(HexStrConvertUtil.hexStringToByte(writeStr));
			Log.i("shi","---------------16-----");
			// ������ģ��д������
			mgatt.writeCharacteristic(gattCharacteristic_char6);
			Log.i("shi","---------------17-----");
			Log.i("shi", "��ȡ����...");
			info_tv.setText("���ڶ�ȡ����");
		} else {
			Log.i("shi", "mBLE.getmBluetoothGatt()=null or gattCharacteristic_char6=null");
		}
	}
	
	//ɨ���豸�ص�
	private BluetoothAdapter.LeScanCallback  callback=new BluetoothAdapter.LeScanCallback(){
		
		@Override
		public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
			list.add(device);
			Log.i("shi","�ҵ���Ϊ��"+device.getName()+"���豸");
			Log.i("shi","---------------3-----");
			//if(device.getName().trim()==RemoteDriveName.trim()){
				isReadTaskRun=!isReadTaskRun;
			Toast.makeText(MainActivity.this, "��Ϊ��FR_2CE7_G���ҵ�", Toast.LENGTH_SHORT).show();
			
			connect(device.getAddress());
			//}
		}

	};
	
	
	private void connect(String address) {
		Log.i("shi","---------------4-----");
		final BluetoothDevice device=adapter.getRemoteDevice(address);
		Log.i("shi","---------------5-----");
		mgatt=device.connectGatt(context, false,gattCallback);
		Log.i("shi","---------------6-----");
		
		
		
		
	}
	
	//��ȡ Gatt ����Ļص�����
	private final  BluetoothGattCallback gattCallback=new BluetoothGattCallback() {
		//����״̬�ص�
		@Override
		public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
			Log.i("shi","---------------7-----");
			if (newState == BluetoothProfile.STATE_CONNECTED) {
				adapter.stopLeScan(callback);
				Log.i("shi","---------------8-----");
			mgatt.discoverServices();
			Log.i("shi","---------------8%%9---mgatt="+mgatt.toString());
			}
		}
		
		public void onServicesDiscovered(BluetoothGatt gatt, int status) {
			Log.i("shi","---------------9-----");
			if (status == BluetoothGatt.GATT_SUCCESS && mOnServiceDiscoverListener != null) {
				mOnServiceDiscoverListener.onServiceDiscover(gatt);
				Log.i("shi","---------------10-----");
			}
		};
		
		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
			if(mOnDataAvailableListener!=null){
				mOnDataAvailableListener.onCharacteristicRead(gatt, characteristic, status);
				
			}
			
		};
		
		public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
			 if(mOnDataAvailableListener!=null){
				 mOnDataAvailableListener.onCharacteristicWrite(gatt, characteristic);
			 }
			
			
		};
		
	};


	private OnServiceDiscoverListener   discoverService=new OnServiceDiscoverListener(){

		@Override
		public void onServiceDiscover(BluetoothGatt gatt) {
			Log.i("shi","---------------11-----");
			mService=gatt.getService(UUID.fromString(UUID_SERVICE));
			if(mService!=null){
				Log.i("shi","---------------12-----");
				gattCharacteristic_char6=mService.getCharacteristic(UUID.fromString(UUID_CHAR6));
				Log.i("shi","---------------12%%13-----gattCharacteristic_char6"+gattCharacteristic_char6.toString());
				if(gattCharacteristic_char6!=null){
					Log.i("shi","---------------13-----");
					setCharacteristicNotification(gattCharacteristic_char6, true);
					Log.i("shi","---------------14-----");
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							info_tv.setText("���ӳɹ���");
						}
					});
				}
			}else{
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						info_tv.setText("����ʧ�ܣ�");
					}
				});
			}
			
			
			
		}
		
	};
	
	
	private OnDataAvailableListener  dataAvaliable=new OnDataAvailableListener() {
		
		@Override
		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
			Log.i("shi","---------------18-----");
			Log.i("shi", "onCharRead " + gatt.getDevice().getName() + " read " + characteristic.getUuid().toString()
					+ " -> " + HexStrConvertUtil.bytesToHexString(characteristic.getValue()));
			Log.i("shi","---------------19-----");
			
		}
		
		@Override
		public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
			Log.i("shi","---------------20-----");
			Log.i("shi", "characteristic.getUuid().toString()=" + characteristic.getUuid().toString());
			if(characteristic.getUuid().toString().equals(UUID_CHAR6)){
				Log.i("shi","---------------21-----");
				// ��������
				Float fData = FROSun.getData(SUN_LEN,NODE_NUM, characteristic.getValue());
				String value = String.valueOf((int) (float) fData + "Lux");
				Log.i("shi","---------------22-----");
				Log.i("shi", "onCharWrite=" + gatt.getDevice().getName() + "   value=" + value);
				// ׷�ӵ������ֶ�
				recv_sb.replace(0, recv_sb.length(), value);
				// ���½�����������ʾ
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						Log.i("shi","---------------23-----");
						updateDisplaySendInfo();
						
					}

				});
			}
			
		}
		
	};
	

	private void updateDisplaySendInfo() {
		Log.i("shi","---------------24-----");
		sun_tv.setText(recv_sb.toString());
	}
	
	
	public void setCharacteristicNotification(BluetoothGattCharacteristic characteristic, boolean enabled) {
		Log.i("shi","---------------֪ͨ�豸1-----");
		if(enabled==true){
			mgatt.setCharacteristicNotification(characteristic, true);
			Log.i("shi","-----------֪ͨ�豸2---------");
			BluetoothGattDescriptor descriptor = characteristic
					.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
			descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
			mgatt.writeDescriptor(descriptor);
			Log.i("shi","---------------֪ͨ�豸3-----");
			
		}else {
			Log.i("shi","---------------֪ͨ�豸4-----");
			Log.i("shi", "Disable Notification");
			mgatt.setCharacteristicNotification(characteristic, false);
			BluetoothGattDescriptor descriptor = characteristic
					.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
			descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
			mgatt.writeDescriptor(descriptor);
			Log.i("shi","---------------֪ͨ�豸5-----");
		}
	}

	


}


















