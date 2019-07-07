package com.example.asynctaskdemofile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements Button.OnClickListener {

    TextView textView = null;
    Button btnDownload = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        btnDownload = (Button)findViewById(R.id.btnDownload);
        Log.i("iSpring", "MainActivity -> onCreate, Thread name: " + Thread.currentThread().getName());
    }

    @Override
    public void onClick(View v) {
        //Ҫ���ص��ļ���ַ
        String[] urls = {
                "http://blog.csdn.net/iispring/article/details/47115879",
                "http://blog.csdn.net/iispring/article/details/47180325",
                "http://blog.csdn.net/iispring/article/details/47300819",
                "http://blog.csdn.net/iispring/article/details/47320407",
                "http://blog.csdn.net/iispring/article/details/47622705"
        };

        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(urls);
    }

    //public abstract class AsyncTask<Params, Progress, Result>
    //�ڴ����У�Params������String���ͣ�Progress������Object���ͣ�Result������Long����
    private class DownloadTask extends AsyncTask<String, Object, Long> {
    	
        @Override
        protected void onPreExecute() {  //��һ���ᱻ����
            Log.i("iSpring", "DownloadTask -> onPreExecute, Thread name: " + Thread.currentThread().getName());
            super.onPreExecute();
            btnDownload.setEnabled(false);
            textView.setText("��ʼ����...");
        }

        @Override
        protected Long doInBackground(String... params) {
            Log.i("iSpring", "DownloadTask -> doInBackground, Thread name: " + Thread.currentThread().getName());
            //totalByte��ʾ�������ص��ļ������ֽ���
            long totalByte = 0;
            //params��һ��String����
            for(String url: params){
                //����Url���飬�������ض�Ӧ���ļ�
            	System.out.println(url);
                Object[] result = downloadSingleFile(url);
                System.out.println("shiwei");
                int byteCount = (Integer)result[0];
                totalByte += byteCount;
                //��������һ���ļ�֮�����ǾͰѽ׶��ԵĴ�����������ȥ
                publishProgress(result);
                //���AsyncTask��������cancel()��������ô����ȡ��������forѭ��
                if(isCancelled()){
                    break;
                }
            }
            //���ܹ����ص��ֽ�����Ϊ�������
            return totalByte;
        }
        
        
        

        //�����ļ��󷵻�һ��Object���飺�����ļ����ֽ����Լ����صĲ��͵�����
        private Object[] downloadSingleFile(String str){
        	Object[] result = new Object[2];
            int byteCount = 0;
            String blogName = "";
            HttpURLConnection conn = null;
            try{
                URL url = new URL(str);
                conn = (HttpURLConnection) url.openConnection();
                System.out.println("22");
                InputStream is = conn.getInputStream();//////������
                System.out.println("33");
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int length = 0;
                while ((length = is.read(buf)) != -1) {
                	System.out.println("44");
                    baos.write(buf, 0, length);
                    byteCount += length;
                }
                String respone = new String(baos.toByteArray(), "utf-8");
                int startIndex = respone.indexOf("<title>");
                if(startIndex > 0){
                    startIndex += 7;
                    int endIndex = respone.indexOf("</title>");
                    if(endIndex > startIndex){
                        //�����������еı���
                        blogName = respone.substring(startIndex, endIndex);
                    }
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if(conn != null){
                    conn.disconnect();
                }
            }
            result[0] = byteCount;
            result[1] = blogName;
            return result;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            Log.i("iSpring", "DownloadTask -> onProgressUpdate, Thread name: " + Thread.currentThread().getName());
            super.onProgressUpdate(values);
            int byteCount = (Integer)values[0];
            String blogName = (String)values[1];
            String text = textView.getText().toString();
            text += "\n���͡�" + blogName + "��������ɣ���" + byteCount + "�ֽ�";
            textView.setText(text);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            Log.i("iSpring", "DownloadTask -> onPostExecute, Thread name: " + Thread.currentThread().getName());
            super.onPostExecute(aLong);
            String text = textView.getText().toString();
            text += "\nȫ��������ɣ��ܹ�������" + aLong + "���ֽ�";
            textView.setText(text);
            btnDownload.setEnabled(true);
        }

        @Override
        protected void onCancelled() {
            Log.i("iSpring", "DownloadTask -> onCancelled, Thread name: " + Thread.currentThread().getName());
            super.onCancelled();
            textView.setText("ȡ������");
            btnDownload.setEnabled(true);
        }
    }
}