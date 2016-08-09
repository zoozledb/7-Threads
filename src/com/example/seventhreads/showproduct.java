package com.example.seventhreads;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class showproduct extends Activity implements OnClickListener , OnItemClickListener, OnItemSelectedListener{
	 
	private Button button1;
	private Button button2;
	private Button button3;
	private TextView textView1;
	private TextView textView6;
	private AutoCompleteTextView editText1;
	private EditText editText3;
	private EditText editText2;
	private EditText editText4;
	private Button button4;
	private ArrayAdapter<String> adapter;
	blc ss = new blc(this);
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showproduct);
		
				button1 = (Button)findViewById( R.id.button1 );
				button2 = (Button)findViewById( R.id.button2 );
				button3 = (Button)findViewById( R.id.button3 );


				textView1 = (TextView)findViewById( R.id.textView1 );
				textView6 = (TextView)findViewById( R.id.textView6 );
				
				editText1 = (AutoCompleteTextView)findViewById( R.id.editText1 );

				editText3 = (EditText)findViewById( R.id.editText3 );

				editText2 = (EditText)findViewById( R.id.editText2 );

				editText4 = (EditText)findViewById( R.id.editText4 );
				button4 = (Button)findViewById( R.id.button4 );

				button1.setOnClickListener( this );
				button2.setOnClickListener( this );
				button3.setOnClickListener( this );
				button4.setOnClickListener( this );

				adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ss.getAllSpinnerContent());
		        
				editText1.setThreshold(1);
		        
		        //Set adapter to AutoCompleteTextView
				editText1.setAdapter(adapter);
				editText1.setOnItemSelectedListener(this);
				editText1.setOnItemClickListener(this);
				
				editText1.setTextColor(Color.RED);
				
				Bundle extras = getIntent().getExtras();
				if (extras != null) {
				 String value = extras.getString("new_variable_name");
				 textView6.setText(value);
				editText1.setText(ss.productshowerforid(value)[1]);
				editText2.setText(ss.productshowerforid(value)[3]);
				editText3.setText(ss.productshowerforid(value)[2]);
				editText4.setText(ss.productshowerforid(value)[4]);
				
	}
	
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if ( v == button1 ) {
			// Handle clicks for button1
			System.exit(0);
			
		} else if ( v == button2 ) {
			// Handle clicks for button2 Delete
			
			new AlertDialog.Builder(this)
		    .setTitle("Delete Product")
		    .setMessage("Are you sure you want to delete this Product?")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        	String sqldelete="DELETE FROM products WHERE ID =" +textView6.getText().toString();
					try {
						ss.executesql(sqldelete);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		     })
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		     .show();
			
		} else if ( v == button3 ) {
			// Handle clicks for button3 Foward
			
			try {
				Intent i = new Intent(this, showproduct.class);
				  i.putExtra("new_variable_name",""+(Integer.parseInt(textView6.getText().toString())+1));
				  startActivity(i);
				  System.exit(0);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(this, "Error !!"+e.toString(), Toast.LENGTH_LONG).show();
			}
			
		} else if ( v == button4 ) {
			// Handle clicks for button4
			
			new AlertDialog.Builder(this)
		    .setTitle("Update Product")
		    .setMessage("Are you sure you want to Update this Product?")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        	String sqlupdate="UPDATE products SET productname = '"+editText1.getText()+"', manu = '"+editText2.getText()+"' , price = '"+editText3.getText()+"', des = '"+editText4.getText()+"' WHERE ID ="+textView6.getText().toString();
					try {
						ss.executesql(sqlupdate);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		     })
		    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_alert)
		     .show();
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
