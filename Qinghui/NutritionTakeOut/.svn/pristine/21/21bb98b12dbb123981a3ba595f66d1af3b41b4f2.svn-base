package com.example.nutrition.dinnerinfo.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdpter extends FragmentPagerAdapter{
	private List<Fragment> mList;

	public FragmentAdpter(FragmentManager fm,List<Fragment> list) {
		super(fm);
		this.mList=list;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return mList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

}
