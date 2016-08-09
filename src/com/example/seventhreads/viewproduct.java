package com.example.seventhreads;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class viewproduct extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.viewproduct);
	
	TextView data = (TextView) findViewById(R.id.textView1);
	
	blc sss= new blc(this);
	String text = sss.shower().toString();
	
	try {
		data.setText("Your Data : "+text);	
	} catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}

}

}
