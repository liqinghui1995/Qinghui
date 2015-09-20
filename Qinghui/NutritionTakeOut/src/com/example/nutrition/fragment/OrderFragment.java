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
 * ����
 * @author Administrator
 *
 */
public class OrderFragment extends Fragment{

	private ListView orderlistview;
	private ImageView BtnTop;// ���ض����İ�ť
	private boolean scrollFlag = false;// ����Ƿ񻬶�
	private int lastVisibleItemPosition = 0;// ����ϴλ���λ��
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
				Toast.makeText(getActivity(), "�����TOP", 1).show();
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
					// �жϹ������ײ�
					if (orderlistview.getLastVisiblePosition() == (orderlistview
							.getCount() - 1)) {
						BtnTop.setVisibility(View.VISIBLE);
					}
					// �жϹ���������
					if (orderlistview.getFirstVisiblePosition() == 0) {
						BtnTop.setVisibility(View.GONE);
					}
					break;
				case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:// ����ʱ
					scrollFlag = true;
					break;
					// �ǵ��û�����֮ǰ������Ļ��̧����ָ����Ļ�������Ի���ʱ
				case OnScrollListener.SCROLL_STATE_FLING:
					scrollFlag = false;
					break;
				default:
					break;
				}
			}
			/**
			 * firstVisibleItem����ǰ�ܿ����ĵ�һ���б���ID����0��ʼ��
			 * visibleItemCount����ǰ�ܿ������б��������С���Ҳ�㣩 totalItemCount���б����
			 */
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// ����ʼ������ListView�ײ���Y��㳬����Ļ���Χʱ����ʾ�����ض�����ť

				if (firstVisibleItem > lastVisibleItemPosition) {// �ϻ�
					BtnTop.setVisibility(View.VISIBLE);
				} else if (firstVisibleItem < lastVisibleItemPosition) {// �»�
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