package com.example.seventhreads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class admin extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);
		
		Button insertproduct = (Button) findViewById(R.id.button1);
		Button viewproduct = (Button) findViewById(R.id.button2);
		Button profit = (Button) findViewById(R.id.button3);
		Button search = (Button) findViewById(R.id.button4);
		Button invoice = (Button) findViewById(R.id.button7);
		Button logit = (Button) findViewById(R.id.button5);
		Button exit = (Button) findViewById(R.id.button6);
		Button sync = (Button) findViewById(R.id.Button01);
		Button seacherproducts = (Button)findViewById(R.id.searchproducts);
		Button settings = (Button)findViewById(R.id.settings);
		
		insertproduct.setOnClickListener(this);
		viewproduct.setOnClickListener(this);
		profit.setOnClickListener(this);
		search.setOnClickListener(this);
		invoice.setOnClickListener(this);
		logit.setOnClickListener(this);
		exit.setOnClickListener(this);
		seacherproducts.setOnClickListener(this);
		sync.setOnClickListener(this);
		settings.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch (arg0.getId()) {
		case R.id.button1:
			Intent pro = new Intent(this , insertproduct.class);
			startActivity(pro);
			break;
			

		case R.id.button7:
			try {
				Intent invoice = new Intent(this , invoice.class);
				startActivity(invoice);
				
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(this,e.toString(), 50).show();
			}
			
			break;
			
		case R.id.button6:
			android.os.Process.killProcess(android.os.Process.myPid());
	        break;

			
		case R.id.button2:
			Intent viewproducts = new Intent(this , viewproduct.class);
			startActivity(viewproducts);
			break;

		case R.id.button5:
			Intent mains = new Intent(this , MainActivity.class);
			startActivity(mains);
			break;
			
		case R.id.button4:
			Intent seracher = new Intent(this , search.class);
			startActivity(seracher);
			break;
			
		case R.id.searchproducts:
			try {
				Intent searchproducts = new Intent(this , searchproducts.class);
				startActivity(searchproducts);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Toast.makeText(this, e1.toString(), 100).show();
			}
			break;
			
			
		case R.id.button3:
			try {
				Intent profits = new Intent(this , profit.class);
				startActivity(profits);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
			}
			break;
			
		case R.id.Button01:
			Intent sync = new Intent(this , sync.class);
			startActivity(sync);
			break;
			
		case R.id.settings:
			Intent settings = new Intent(this , settings.class);
			startActivity(settings);
			break;

			
		}
		
	}

}
