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
		pd.setTitle("显示进度！");
		pd.setMessage("Lod......");
		pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		//点击进度条对话框中的按钮取消 AsyncTask 
		pd.setButton(ProgressDialog.BUTTON_NEGATIVE,"Cancal",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				cancel(true);//如果设置为 真， 则表示取消异步任务。
				
			}
		});
		pd.show();
		
		
	}
	/*
	 * 表示 UI 线程中调用 cancel() 方法 取消异步任务 成功时回调的方法
	 * 注意： 如果 onCanceled() 被回调，这时将不再执行 onPostExecute()方法。
	 */
	@Override
	protected void onCancelled() {
		pd.dismiss();
		Log.v("shiwei","异步任务停止了-----------onCancelled-----------");
		
		
		
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
				 *  isCanceled() 表示 AsyncTask 是否被取消，当文件 没有读取完毕并且
				 *  AsyncTask 没有 停止的情况下继续读取，及时停止。
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
			Toast.makeText(context, "图片下载失败！",Toast.LENGTH_SHORT).show();
		}
		
		pd.dismiss();
		
	}


	

}
