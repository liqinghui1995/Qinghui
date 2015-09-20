package com.example.nutrition.diningroom.activity;

import com.example.nutrition.R;
import com.example.nutrition.diningroom.vo.DiningRoom;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DiningRoomDetail extends Activity{
	private TextView textView;
	int id;  

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.fragment_dinner_menu);
			textView = (TextView)findViewById(R.id.diningname);
			DiningRoom  p=(DiningRoom) getIntent().getSerializableExtra("diningroom");
			textView.setText(p.getDiningRoomName());
			id = p.getId();
		}
}
