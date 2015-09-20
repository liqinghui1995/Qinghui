package com.example.nutrition.fragment;

import java.util.ArrayList;

import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.pano.platform.http.v;
import com.example.nutrition.R;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBHelper;
import com.example.nutrition.dinnerinfo.cart.helper.CarDBUtils;
import com.example.nutrition.dinnerinfo.vo.Shop;
import com.example.nutrition.order.activity.OrderActivity;
import com.example.nutrition.order.adapter.OrderAdpter;
import com.example.nutrition.order.vo.Order;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 订单
 * @author Administrator
 *
 */
public class OrderFragment extends Fragment{

	private ListView orderlistview;
	private ImageView BtnTop;// 返回顶部的按钮
	private boolean scrollFlag = false;// 标记是否滑动
	private int lastVisibleItemPosition = 0;// 标记上次滑动位置
	private ArrayList<Shop> list = new ArrayList<Shop>();
	private TextView diningroom , money , mun;
	private SQLiteDatabase db;
	private CarDBUtils carDbUtils;
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container,Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.order_fragment, null);
		orderlistview = (ListView) view.findViewById(R.id.orderlistview);
		BtnTop = (ImageView) view.findViewById(R.id.BtnTop);
		diningroom = (TextView) view.findViewById(R.id.diningroom);
		money = (TextView) view.findViewById(R.id.money);
		mun = (TextView) view.findViewById(R.id.mun);
		BtnTop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "点击额TOP", 1).show();
				orderlistview.setSelection(0);
			}
		});

		orderlistview.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				switch (scrollState) {
				case OnScrollListener.SCROLL_STATE_IDLE:

					scrollFlag = false;
					// 判断滚动到底部
					if (orderlistview.getLastVisiblePosition() == (orderlistview
							.getCount() - 1)) {
						BtnTop.setVisibility(View.VISIBLE);
					}
					// 判断滚动到顶部
					if (orderlistview.getFirstVisiblePosition() == 0) {
						BtnTop.setVisibility(View.GONE);
					}
					break;
				case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// 滚动时
					scrollFlag = true;
					break;
					// 是当用户由于之前划动屏幕并抬起手指，屏幕产生惯性滑动时
				case OnScrollListener.SCROLL_STATE_FLING:
					scrollFlag = false;
					break;
				default:
					break;
				}
			}
			/**
			 * firstVisibleItem：当前能看见的第一个列表项ID（从0开始）
			 * visibleItemCount：当前能看见的列表项个数（小半个也算） totalItemCount：列表项共数
			 */
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// 当开始滑动且ListView底部的Y轴点超出屏幕最大范围时，显示或隐藏顶部按钮

				if (firstVisibleItem > lastVisibleItemPosition) {// 上滑
					BtnTop.setVisibility(View.VISIBLE);
				} else if (firstVisibleItem < lastVisibleItemPosition) {// 下滑
					BtnTop.setVisibility(View.GONE);
				} else {
					return;
				}
				lastVisibleItemPosition = firstVisibleItem;

			}
		});
		
		CarDBHelper helper = new CarDBHelper(getActivity());
		db = helper.getWritableDatabase();
		carDbUtils = new CarDBUtils(db);
		list =  (ArrayList<Shop>) carDbUtils.query();
		
		OrderAdpter orderAdpter = new OrderAdpter(list, getActivity());
		orderlistview.setAdapter(orderAdpter);
	
		return view;
	}
	
	
}
