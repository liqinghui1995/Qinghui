package com.example.nutrition.user.vo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class NetHttpUtils {
	public static String HttpGet(String url)throws Exception{
		StringBuffer stringBuffer = new StringBuffer();
		HttpClient httpClient = new DefaultHttpClient();
		String result = null;
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGet);
		if(httpResponse.getStatusLine().getStatusCode()==200){
//			result = EntityUtils.toString(httpResponse.getEntity());
			InputStream input = httpResponse.getEntity().getContent();
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					input));
			String line = null;
			while ((line = buffer.readLine()) != null) {
				stringBuffer.append(line);
			}
			return stringBuffer.toString();
		}
		return result ;
	}
}
