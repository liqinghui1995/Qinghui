package com.example.nutrition.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtil {
	/**
	 * �ж���������״̬
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context mContext) {
		ConnectivityManager connMgr = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = connMgr.getActiveNetworkInfo();
		if (netInfo == null || !netInfo.isAvailable()) {
			return false;
		}
		return true;
	}
	/**
	 * post���󷵻�json
	 * ����list����
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url,List <NameValuePair> params)  
    {  
        String result = "";  
        HttpPost httpRequst = new HttpPost(url);//����HttpPost����  
        try {  
            httpRequst.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));  
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);  
            if(httpResponse.getStatusLine().getStatusCode() == 200)  
            {  
                HttpEntity httpEntity = httpResponse.getEntity();  
                result = EntityUtils.toString(httpEntity,"GBK");//ȡ��Ӧ���ַ���  
            }  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            result = e.getMessage().toString();  
        }  
        catch (ClientProtocolException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            result = e.getMessage().toString();  
        }  
        catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            result = e.getMessage().toString();  
        }  
        return result;  
    }  
	/**
	 * get�������
	 * @param urlStr
	 * @return
	 */
	public static String getStringFromUrl(String urlStr){
		String result = "";
		HttpGet req = new HttpGet(urlStr);
		HttpParams connParam = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(connParam, 5 * 1000);
		HttpConnectionParams.setSoTimeout(connParam, 5 * 1000);
		HttpClient client = new DefaultHttpClient(connParam);
		try{
			HttpResponse resp = client.execute(req);
			if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity respEntity = resp.getEntity();
				result = EntityUtils.toString(respEntity, "GBK");
			}else{
				Log.e("TAG", "��Ӧʧ�ܣ�");
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		}
		
		return result;
	}

	/**
	 * ���󷵻�inputStream
	 * @param urlStr
	 * @return
	 */
	public static InputStream getInputStreamFromUrl(String urlStr) {
		InputStream is = null;
		HttpGet req = new HttpGet(urlStr);
		HttpParams connParam = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(connParam, 5 * 1000);
		HttpConnectionParams.setSoTimeout(connParam, 5 * 1000);
		HttpClient client = new DefaultHttpClient(connParam);
		try {
			HttpResponse resp = client.execute(req);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = resp.getEntity();
				is = entity.getContent();
			} else {
				Log.e("TAG", "��Ӧʧ�ܣ�");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		}
		return is;
	}
	/**
	 * ͼƬ���󷵻�bitmap
	 * @param imageUrl
	 * @return
	 */
	public static Bitmap loadImageFromUrl(String imageUrl){
		Bitmap result = null;
		HttpGet rep = new HttpGet(imageUrl);
		HttpParams connParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(connParams, 5 * 1000);
		HttpConnectionParams.setSoTimeout(connParams, 5 * 1000);
		HttpClient client = new DefaultHttpClient(connParams);
		try{
			HttpResponse resp = client.execute(rep);
			if(resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity entity = resp.getEntity();
				result = BitmapFactory.decodeStream(entity.getContent());
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		}catch(IOException e){
			e.printStackTrace();
			Log.e("TAG", "" + e.getMessage());
		}
		return result;
	}
}
