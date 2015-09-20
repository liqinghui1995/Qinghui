package com.example.nutrition.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.vo.Gifts;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class GiftsAdapter extends BaseAdapter {
	private Context mContext;
	private List<Gifts> list;
	private int userid;
	private int usercoin;
	
	public GiftsAdapter(Context mContext, List<Gifts> list,int userid,int usercoin) {
		super();
		this.mContext = mContext;
		this.list = list;
		this.userid = userid;
		this.usercoin = usercoin;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		viewHolder vh = null;
		if(convertView==null){
			vh = new viewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.set_giftcenter_item, null);
			vh.img = (ImageView) convertView.findViewById(R.id.set_giftcenter_item_img);
			vh.btn = (Button) convertView.findViewById(R.id.set_giftcenter_item_btn);
			vh.title = (TextView) convertView.findViewById(R.id.set_giftcenter_item_title);
			vh.price = (TextView) convertView.findViewById(R.id.set_giftcenter_item_price);
			convertView.setTag(vh);
		}else{
			vh = (viewHolder) convertView.getTag();
		}
		final Gifts g = list.get(position);
		vh.title.setText(g.getName());
		vh.price.setText(g.getPrice()+"ÐÇë´±Ò");
		BitmapUtils bu = new BitmapUtils(mContext);
		bu.display(vh.img, "http://cblue.tunnel.mobi/WebShop/"+g.getImgurl());
		vh.btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(userid==0){
					Toast.makeText(mContext, "ÇëÏÈµÇÂ½", 1).show();
				}else{
					int coin = position*1000+1000;
					if(usercoin<coin){
						Toast.makeText(mContext, "ÐÇë´±Ò²»×ã", 1).show();
					}else{
						RequestParams params = new RequestParams();
						params.addBodyParameter("userid", userid+"");
						params.addBodyParameter("giftid", g.getId()+"");
						String url = "http://cblue.tunnel.mobi/WebShop/usersservlet?method=convert";
						HttpUtils hu = new HttpUtils();
						hu.send(HttpMethod.POST, url, params, new RequestCallBack<String>() {
							@Override
							public void onFailure(HttpException arg0, String arg1) {
								// TODO Auto-generated method stub
							}
							@Override
							public void onSuccess(ResponseInfo<String> arg0) {
								// TODO Auto-generated method stub
							}
						});
					}
				}
			}
		});
		return convertView;
	}
	
	class viewHolder{
		ImageView img;
		Button btn;
		TextView title,price;
	}
}
