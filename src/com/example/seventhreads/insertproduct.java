package com.example.seventhreads;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class insertproduct extends alls implements OnItemClickListener, OnItemSelectedListener {
	private ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insertproduct);
	
		Button b1 =(Button)findViewById(R.id.button1);
		
		b1.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		blc bb = new blc(this);
		AutoCompleteTextView productname = (AutoCompleteTextView) findViewById(R.id.editText1);
		EditText manufature = (EditText) findViewById(R.id.editText3);
		EditText price = (EditText) findViewById(R.id.editText2);
		EditText desc = (EditText) findViewById(R.id.editText4);
		
		blc ss = new blc(this);
		
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ss.getAllSpinnerContent());
        
		productname.setThreshold(0);
        
        //Set adapter to AutoCompleteTextView
		productname.setAdapter(adapter);
		productname.setOnItemSelectedListener(this);
		productname.setOnItemClickListener(this);
		
		productname.setTextColor(Color.RED);
         

try {
	int s = Integer.parseInt(price.getText().toString());
	bb.inserter(productname.getText().toString(), manufature.getText().toString(), s, desc.getText().toString());
	Toast.makeText(this, "Product Name : "+productname.getText().toString()+"\n Manufacturer : "+manufature.getText().toString()+"\n Price : "+price.getText().toString()+"\n Discription : "+desc.getText().toString()+"\n Inserted Successfully !", Toast.LENGTH_LONG).show();
	productname.setText("");
	
} catch (Exception e) {
	// TODO: handle exception
	Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	
}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		 InputMethodManager imm = (InputMethodManager) getSystemService(
	                INPUT_METHOD_SERVICE);
	            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 1);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
