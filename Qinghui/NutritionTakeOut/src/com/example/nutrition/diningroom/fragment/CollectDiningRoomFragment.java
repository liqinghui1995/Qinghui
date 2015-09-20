package com.example.nutrition.diningroom.fragment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.adapter.CollectDingRoomAdapter;
import com.example.nutrition.diningroom.adapter.DiningRoomAdapter;
import com.example.nutrition.diningroom.vo.AllDiningRoom;
import com.example.nutrition.utils.FastJsonUtil;
import com.google.gson.Gson;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class CollectDiningRoomFragment extends Fragment {
	private ListView listView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.collect_diningroom, null);
		listView=(ListView) view.findViewById(R.id.listView);
		Log.i("tag", view.toString());
		new Thread(){
			@Override
			public void run() {
				try {
					
					 HttpClient hClient = new DefaultHttpClient();
					 HttpGet hg = new HttpGet("http://cblue.tunnel.mobi/WebShop/dingroom");
					 HttpResponse hResponse = hClient.execute(hg);
					 if(hResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
						 HttpEntity he = hResponse.getEntity();
						 String str = EntityUtils.toString(he);
						 Message mes = myhandler.obtainMessage(1,str);
						 myhandler.sendMessage(mes);
					 }
				} catch (ClientProtocolException e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		return view;
	}
	
	Handler myhandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
				try {
					String json = (String) msg.obj;
					String	string4 = new String(json.getBytes("iso-8859-1"),"GBK");
					AllDiningRoom  all=	FastJsonUtil.json2Object(string4, AllDiningRoom.class);
//					CollectDingRoomAdapter  adapter = new DiningRoomAdapter(getActivity(), all.getResultlist());
					
					CollectDingRoomAdapter  adapter = new CollectDingRoomAdapter(getActivity(), all.getResultlist());
					listView.setAdapter(adapter);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	};

}
