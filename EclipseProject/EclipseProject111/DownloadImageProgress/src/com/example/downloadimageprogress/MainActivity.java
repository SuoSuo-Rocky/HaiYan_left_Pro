package com.example.downloadimageprogress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ImageView view;
	private String imagePath="";
	
	/*
	 * ��ʾ���ؽ���
	 * 
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		view=(ImageView) findViewById(R.id.view);
	}
	//�������ͼƬ������ʾ
public  void click(View view) {
	new MyAsyncTask().execute(imagePath);

}

class MyAsyncTask  extends AsyncTask<String ,Integer,byte[]>{
	private ProgressDialog pd;
	
	
	@Override
	protected void onPreExecute() {
		pd=new ProgressDialog(MainActivity.this);// ����Dialog
		pd.setTitle("������ʾ");//���ñ���
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//������ʽ
		pd.show();
	}
	
@Override
protected byte[] doInBackground(String... params) {
	ByteArrayOutputStream outputStream=new ByteArrayOutputStream();//��׼����һ���ֽ����������
	try {
		URL url=new URL(params[0]);//��·�����ݹ���
		HttpURLConnection conn=(HttpURLConnection) url.openConnection();//�����������
		conn.setDoInput(true);//�����Ӵ������϶�ȡ
		conn.setRequestMethod("GET");  //��������ʱΪ get
		conn.connect();//���ô�����
		
		int responseCode=conn.getResponseCode();//�����Ӧ��
		if(responseCode==200){//�����Ӧ��Ϊ200����˵��������Ӧ�ɹ���
			InputStream in=conn.getInputStream();//�ɹ�֮����ʼ�����������
			//��ȡ�ļ�������ͼƬ���ܳ���
			long totallLength=conn.getContentLength();//ר�ŵķ�����ȡ����
			int currentLength=0;//��ʾ��ǰ���ص�ͼƬ���ļ�����
		
			byte [] date=new byte[1024];//����һ���ֽ����飬���ڽ������ݡ�
			int temp=0;
			while ((temp=in.read(date))!=-1) {//һ�� While ѭ����ʼ��Ӧ�Ķ�ȡ����
				currentLength+=temp;//��ÿ��ѭ����ȡ�����ݵĳ������ӵ����ȳ��ȱ����У����ڱ�ʾ����
				//��ʼ���㣬��ý��ȣ������ļ��ĳ��ȣ������ؽ���
				int progress=(int)((currentLength/(float)totallLength)*100);
				
				publishProgress(progress);//�����ȷ��������߳���
				
				outputStream.write(date, 0,temp);//���ֽ������������д���ֽ�����
				outputStream.flush();//��ջ�����
			}
			
		}
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return outputStream.toByteArray();
	
	
}
/*
 * ��ʾ������ס�߳��У��������н��ȵĻص�������
 */

@Override
protected void onProgressUpdate(Integer... values) {
	Log.v("shiwei",Thread.currentThread().getName()+"---------onProgressUpdate------->");
	pd.setProgress(values[0]);//���ø��½���
	
	
}


@Override
protected void onPostExecute(byte[] result) {
	if(result!=null&&result.length!=0){//�Խ�������жϣ�
		//���ֽ���������ת��Ϊ   Bitmap  ���� 
		Bitmap bm=BitmapFactory.decodeByteArray(result, 0, result.length);
		view.setImageBitmap(bm);
		
	}else{
		Toast.makeText(MainActivity.this,"ͼƬ����ʧ�ܣ�",Toast.LENGTH_SHORT).show();
	}
	
	pd.dismiss();//ͼƬ������֮��Ҫ�� Dialog �رգ� ��Ȼ��һֱ���֡�
}



}
}





