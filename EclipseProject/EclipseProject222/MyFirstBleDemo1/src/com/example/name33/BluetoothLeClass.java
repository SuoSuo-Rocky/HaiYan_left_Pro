package com.example.name33;



import java.util.UUID;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public class BluetoothLeClass {
//	public interface OnConnectListener {
//		public void onConnect(BluetoothGatt gatt);
//	}
//
//	public interface OnDisconnectListener {
//		public void onDisconnect(BluetoothGatt gatt);
//	}
//
//
//	private OnConnectListener mOnConnectListener; 
//	private OnDisconnectListener mOnDisconnectListener;
//
//	public void setOnConnectListener(OnConnectListener l) {
//		mOnConnectListener = l;
//	}
//
//	public void setOnDisconnectListener(OnDisconnectListener l) {
//		mOnDisconnectListener = l;
//	}

	public interface onServerDiscoveredListener {
		public void onServerDisvered(BluetoothGatt gatt);
	}

	public interface onDataAvaliableListener {
		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status);

		public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic);
	}

	private onServerDiscoveredListener mServerListener;
	private onDataAvaliableListener mDataListener;

	public void setmServerListener(onServerDiscoveredListener mServerListener22) {
		mServerListener = mServerListener22;
	}

	public void setmDataListener(onDataAvaliableListener mDataListener22) {
		mDataListener = mDataListener22;
	}

	private Context context;
	public BluetoothGatt mgatt;
	
	public BluetoothAdapter adapter;
	private  BluetoothManager manager;
	
	private String mBluetoothDeviceAddress;

	public static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = UUID
			.fromString("00002902-0000-1000-8000-00805f9b34fb");

	public BluetoothLeClass(Context c) {
		context = c;
	}
	
	public boolean initialize() {
		// Use this check to determine whether BLE is supported on the device.
				// Then you can
				// selectively disable BLE-related features.
				if (!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
					Log.i("shi", "Unable to initialize Bluetooth,do not has BLE system");
					return false;
				} else {
					Log.i("shi", "initialize Bluetooth, has BLE system");
				}
				// For API level 18 and above, get a reference to BluetoothAdapter
				// through
				// BluetoothManager.
				if (manager == null) {
					manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
					if (manager == null) {
						Log.i("shi", "Unable to initialize BluetoothManager.");
						return false;
					}
				}

				adapter = manager.getAdapter();
				if (adapter == null) {
					Log.i("shi", "Unable to obtain a BluetoothAdapter.");
					return false;
				}

				// Ö±½ÓÆô¶¯À¶ÑÀ
				boolean isEnableBTA = adapter.enable();
				if (isEnableBTA) {
					Log.i("shi", "mBluetoothAdapter.enable");
				} else {
					Log.i("shi", "mBluetoothAdapter.disable");
				}

				return isEnableBTA;
	}
	
	

	public boolean connect(String address) {
//		if (adapter == null || address == null) {
//			Log.i("shi", "BluetoothAdapter not initialized or unspecified address.");
//			return false;
//		}
//
//		// Previously connected device. Try to reconnect.
//		if (mBluetoothDeviceAddress != null && address.equals(mBluetoothDeviceAddress) && mgatt != null) {
//			Log.i("shi", "Trying to use an existing mBluetoothGatt for connection.");
//			if (mgatt.connect()) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//
//		final BluetoothDevice device =adapter.getRemoteDevice(address);
//		if (device == null) {
//			Log.i("shi", "Device not found.  Unable to connect.");
//			return false;
//		}
//		// We want to directly connect to the device, so we are setting the
//		// autoConnect
//		// parameter to false.
//		mgatt = device.connectGatt(context, false, mcallback);
//		Log.i("shi", "Trying to create a new connection.");
//		mBluetoothDeviceAddress = address;
//		return true;
//		

		Log.i("shi22", "activity.getBluetoothAdapter()=" + adapter);
		Log.i("shi22", "address=" + address);
		if (adapter== null || address == null) {
			return false;
		}
		Log.i("shi", "----------------3------------------");
		if (mgatt != null) {
			if (mgatt.connect()) {
				return true;
			} else {
				return false;
			}
		}
		final BluetoothDevice device = adapter.getRemoteDevice(address);
		mgatt = device.connectGatt(context, false, mcallback);
		return true;
	}

//	public void disconnect() {
//		if (adapter == null || mgatt == null) {
//			return;
//		}
//		mgatt.disconnect();
//
//	}

	private final BluetoothGattCallback mcallback = new BluetoothGattCallback() {
		public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
			if (newState == BluetoothProfile.STATE_CONNECTED) {
				mgatt.discoverServices();
//				if (mOnConnectListener != null)
//					mOnConnectListener.onConnect(gatt);
//				Log.i("shi", "Connected to GATT server.");
//				// Attempts to discover services after successful connection.
//				Log.i("shi", "Attempting to start service discovery:" + );
//
//			} else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
//				if (mOnDisconnectListener != null)
//					mOnDisconnectListener.onDisconnect(gatt);
//				Log.i("shi", "Disconnected from GATT server.");
			}
		};

		public void onServicesDiscovered(BluetoothGatt gatt, int status) {
			Log.i("shi", "-----------------6-----------------");
			if (status == BluetoothGatt.GATT_SUCCESS && mServerListener != null) {
				Log.i("shi", "---------------7-------------------");
				mServerListener.onServerDisvered(gatt);
			}

		};

		public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
			if (mDataListener != null) {
				mDataListener.onCharacteristicRead(gatt, characteristic, status);
			}
		};

		public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
			if (mDataListener != null) {
				mDataListener.onCharacteristicWrite(gatt, characteristic);
			}

		};
	};

//	public void close() {
//		if (mgatt == null) {
//			return;
//		}
//		mgatt.close();
//		mgatt = null;
//	}

	public void setCharacteristicNotification(BluetoothGattCharacteristic mChar6, boolean b) {
		Log.i("shi", "----------setCharacteristicNotification-----------");
		if (mgatt == null || adapter == null) {
			return;
		}
		if (b == true) {
			Log.i("shi", "--------setCharacteristicNotification------------");
			mgatt.setCharacteristicNotification(mChar6, true);
			BluetoothGattDescriptor descriptor = mChar6.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
			descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
			mgatt.writeDescriptor(descriptor);
		} else {
			mgatt.setCharacteristicNotification(mChar6, false);
			BluetoothGattDescriptor descriptor = mChar6.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID);
			descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
			mgatt.writeDescriptor(descriptor);

		}

	}


}
