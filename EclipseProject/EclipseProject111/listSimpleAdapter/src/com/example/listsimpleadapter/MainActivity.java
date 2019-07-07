package com.example.listsimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	/*
	 * ��ʾSimpleAdapter ��ʹ��
	 */
	private ListView lv;
	private List<Map<String,Object>> list;
	private int[] images={R.drawable.imag01,R.drawable.imag02,R.drawable.imag03,
			R.drawable.imag04,R.drawable.imag05,
			R.drawable.imag06,R.drawable.imag07,R.drawable.imag08,R.drawable.imag09};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.lv);
		//1.׼������Դ
		list=new ArrayList<Map<String,Object>>();
		for(int i=0;i<9;i++){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("img",images[i]);
			map.put("text","item"+i);
			list.add(map);
		}
		//2.�����ݼ��ص������� ��
		/*
		 * context:�����Ķ���
		 * data:��ʾ���ص�������������Դ����
		 * resource:��ʾadapter�ؼ���ÿ�����Դid
		 * from:��ʾ����Դ Map ��kep �����飬��ʾָ���� ��ֵ
		 * to:��ʾ��Ҫչʾ��Ӧ���ݵÿؼ� id
		 *    ͨ�� from ��to �Ķ�Ӧ����from ��key����Ӧ������ָ����ֵ��ʾ��to ָ����Դ id �Ŀؼ���
		 */
		SimpleAdapter  adapter=new SimpleAdapter(MainActivity.this,list,
				R.layout.listitem,new String[]{"img","text"},new int[]{R.id.iv,R.id.tv});
		//3.���������е�����չʾ���ؼ���
		lv.setAdapter(adapter);
		
	}

	

}
