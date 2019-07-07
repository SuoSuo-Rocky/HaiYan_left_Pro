package com.example.baseadapterdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView list;
	List<String > datasourse=new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list=(ListView) findViewById(R.id.listView1);
		 
		String[] array=getResources().getStringArray(R.array.test);
		for (int i = 0; i < array.length; i++) {
			datasourse.add(array[i]);
			
		}
		list.setAdapter(new Myadapter());
		
		
	}
	
	class  Myadapter  extends  BaseAdapter{
		
		
		/*
		 * ��ĸ���(non-Javadoc)
		 * @see android.widget.Adapter#getCount()
		 */
		@Override
		public int getCount() {
			return datasourse.size();
		}
		
		/*
		 * ������
		 */
		@Override
		public Object getItem(int position) {
			return position;
 		}
		/*
		 * ������ ID (non-Javadoc)
		 * @see android.widget.Adapter#getItemId(int)
		 */
		@Override
		public long getItemId(int position) {
			return position;
			
			
			
		}
		/*
		 * �������  View(non-Javadoc)
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			//�����ļ� ������ View
			LayoutInflater infalter=getLayoutInflater();
			//LayoutInflater.from(MainActivity.this);
			View row=infalter.inflate(R.layout.view,parent,false);
			//
			//���ҵ���Ӧ�����
			TextView tv=(TextView) row.findViewById(R.id.textView1);
			//����Ҫ��ʾ������
			tv.setText(datasourse.get(position));
			return row;
			
		}
		
		
		
	}
	


}
