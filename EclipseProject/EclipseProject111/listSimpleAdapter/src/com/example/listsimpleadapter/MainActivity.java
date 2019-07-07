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
	 * 演示SimpleAdapter 的使用
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
		//1.准备数据源
		list=new ArrayList<Map<String,Object>>();
		for(int i=0;i<9;i++){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("img",images[i]);
			map.put("text","item"+i);
			list.add(map);
		}
		//2.将数据加载到适配器 中
		/*
		 * context:上下文对象
		 * data:表示加载到适配器的数据源对象
		 * resource:表示adapter控件中每项布局资源id
		 * from:表示数据源 Map 中kep 的数组，表示指定的 数值
		 * to:表示需要展示对应数据得控件 id
		 *    通过 from 和to 的对应，将from 中key所对应的数据指定的值显示到to 指定资源 id 的控件中
		 */
		SimpleAdapter  adapter=new SimpleAdapter(MainActivity.this,list,
				R.layout.listitem,new String[]{"img","text"},new int[]{R.id.iv,R.id.tv});
		//3.将适配器中的数据展示到控件中
		lv.setAdapter(adapter);
		
	}

	

}
