package com.example.asyncTaskalone;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MyAsyncTaskDemo extends AsyncTask<String ,Integer,byte[]> {
	ByteArrayOutputStream out=new ByteArrayOutputStream();
	private  ProgressDialog pd;
	private Context context;
	
	private ImageView view;
	
	
  public MyAsyncTaskDemo(Context context,ImageView view) {
	  this.context=context;
	  this.view=view;
	  

}
	@Override
	protected void onPreExecute() {
		pd=new ProgressDialog(context);
		pd.setTitle("��ʾ���ȣ�");
		pd.setMessage("Lod......");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		//����������Ի����еİ�ťȡ�� AsyncTask 
		pd.setButton(ProgressDialog.BUTTON_NEGATIVE,"Cancal",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				cancel(true);//�������Ϊ �棬 ���ʾȡ���첽����
				
			}
		});
		pd.show();
		
		
	}
	/*
	 * ��ʾ UI �߳��е��� cancel() ���� ȡ���첽���� �ɹ�ʱ�ص��ķ���
	 * ע�⣺ ��� onCanceled() ���ص�����ʱ������ִ�� onPostExecute()������
	 */
	@Override
	protected void onCancelled() {
		pd.dismiss();
		Log.v("shiwei","�첽����ֹͣ��-----------onCancelled-----------");
		
		
		
	}
	
	@Override
	protected byte[] doInBackground(String... params) {
		try {
			URL url=new URL(params[0]);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode=conn.getResponseCode();
			if(responseCode==200){
				InputStream in=conn.getInputStream();
				long totalLlength=conn.getContentLength();
				int currentLength=0;
				 byte[] buffer=new byte[1024];
				int temp=0;
				/*
				 *  isCanceled() ��ʾ AsyncTask �Ƿ�ȡ�������ļ� û�ж�ȡ��ϲ���
				 *  AsyncTask û�� ֹͣ������¼�����ȡ����ʱֹͣ��
				 */
				
				while((temp=in.read(buffer))!=-1&&!isCancelled()){
					currentLength+=temp;
					int progress=(int) ((currentLength/(float)totalLlength)*100);
					publishProgress(progress);
					out.write(buffer,0,temp);
					out.flush();
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
		
		return out.toByteArray();
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		pd.setProgress(values[0]);
		
		
		
	}

	
	
	@Override
	protected void onPostExecute(byte[] result) {
		if(result!=null&&result.length!=0){
			Bitmap  bm=BitmapFactory.decodeByteArray(result, 0, result.length);
			view.setImageBitmap(bm);
			
		}else{
			Toast.makeText(context, "ͼƬ����ʧ�ܣ�",Toast.LENGTH_SHORT).show();
		}
		
		pd.dismiss();
		
	}


	

}
