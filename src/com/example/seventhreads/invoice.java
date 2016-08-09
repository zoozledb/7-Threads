package com.example.seventhreads;

import java.util.Date;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class invoice extends alls  implements OnItemSelectedListener{

	blc  db = new blc(this);
	private EditText customername;
	private EditText dueamount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invoice);
		EditText date  =(EditText)findViewById(R.id.editText2);
		customername =(EditText)findViewById(R.id.editText1);
		Date d = new Date();
		CharSequence s  = DateFormat.format("d-MMMM-yyyy ", d.getTime());
		date.setText(s.toString());
		Spinner item1name = (Spinner)findViewById(R.id.spinner1);
		Spinner item2name = (Spinner)findViewById(R.id.spinner2);
		Spinner item3name = (Spinner)findViewById(R.id.spinner3);
		//item1name.setOnItemSelectedListener(this);
		try {
			String[] spinnerLists =db.getAllSpinnerContent();
			 ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerLists);
			  
			    spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			    item1name.setAdapter(spinnerAdapter);
			    item2name.setAdapter(spinnerAdapter);
			    item3name.setAdapter(spinnerAdapter);
			    item1name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			        @Override
			        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			      
			        	return;
			        }
			        @Override
			        public void onNothingSelected(AdapterView<?> parent) {
 
			        }
			    });
			  
			    item2name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			        @Override
			        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			            return;
			        }
			        @Override
			        public void onNothingSelected(AdapterView<?> parent) {
 
			        }
			    });
			    
			    
			    
			    item3name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			        @Override
			        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			            return;
			        }
			        @Override
			        public void onNothingSelected(AdapterView<?> parent) {
 
			        }
			    });
			    
			    
			    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
	    
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		ImageView emails = (ImageView) findViewById(R.id.imageView1);
		ImageView message = (ImageView) findViewById(R.id.imageView2);
		
		
		ImageView refersh  = (ImageView) findViewById(R.id.imageView3);
		ImageView foward  = (ImageView) findViewById(R.id.imageView5);
		ImageView back  = (ImageView) findViewById(R.id.imageView4);
		
		Button check = (Button)findViewById(R.id.button3);
		
		refersh.setOnClickListener(this);
		foward.setOnClickListener(this);
		back.setOnClickListener(this);
		
		emails.setOnClickListener(this);
		message.setOnClickListener(this);
		check.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		customername = (EditText)findViewById(R.id.editText1);
		dueamount  =   (EditText)findViewById(R.id.editText3);
		EditText date  =(EditText)findViewById(R.id.editText2);
		EditText item1price  =(EditText)findViewById(R.id.editText5);
		EditText item1quan  =(EditText)findViewById(R.id.editText4);
		EditText item2price  =(EditText)findViewById(R.id.EditText02);
		EditText item2quan  =(EditText)findViewById(R.id.EditText03);
		EditText item3price  =(EditText)findViewById(R.id.EditText04);
		EditText item3quan  =(EditText)findViewById(R.id.EditText01);
		EditText totals  =(EditText)findViewById(R.id.editText6);
		EditText dicount  =(EditText)findViewById(R.id.editText7);
		
		
		switch (arg0.getId()) {
		case R.id.button1:
			blc kinsertere = new blc(this);
			String item1s = ((Spinner)findViewById(R.id.spinner1)).getSelectedItem().toString();
			String item2s = ((Spinner)findViewById(R.id.spinner2)).getSelectedItem().toString();
			String item3s = ((Spinner)findViewById(R.id.spinner3)).getSelectedItem().toString();
			 
			try {
			kinsertere.inserterininvoice(customername.getText().toString(), date.getText().toString(), item1s, Integer.parseInt(item1price.getText().toString()), Integer.parseInt(item1quan.getText().toString()), item2s , Integer.parseInt(item2price.getText().toString()), Integer.parseInt(item2quan.getText().toString()),  item3s , Integer.parseInt(item3price.getText().toString()), Integer.parseInt(item3quan.getText().toString()),Integer.parseInt(dueamount.getText().toString()));
			Toast.makeText(this, "INVOICE Generated Successfully !", Toast.LENGTH_LONG).show();
			
			} catch (Exception e) {
				// TODO: handle exception
				Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
				
			}
			break;

		case R.id.button2:
			try {
				int total = Integer.parseInt(dueamount.getText().toString())+Integer.parseInt(item1price.getText().toString())*Integer.parseInt(item1quan.getText().toString())+Integer.parseInt(item2price.getText().toString())*Integer.parseInt(item2quan.getText().toString())+Integer.parseInt(item3price.getText().toString())*Integer.parseInt(item3quan.getText().toString());
				int totalser = total-Integer.parseInt(dicount.getText().toString());
				totals.setText("Rs "+totalser);
				
			} catch (Exception e) {
				Toast.makeText(this, e.toString(), 1000).show();
			}
			
			break;
			
		case R.id.imageView2:
			try {
				Intent sendIntent = new Intent(Intent.ACTION_VIEW);
				sendIntent.putExtra("sms_body", "7Threads Invoice \nCustomer Name : "+customername.getText().toString()+"\nDate : "+date.getText().toString()+"\n Due : "+dueamount.getText().toString()+"\nTotal : "+totals.getText().toString()+"\nDeveloped By DDevelopers (HAT Inc)");
				sendIntent.setType("vnd.android-dir/mms-sms");
				startActivity(sendIntent);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(),
						e.toString(),
						Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
			break;
			
		case R.id.imageView1:
			try {
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_SUBJECT, "7Threads Invoice");
				i.putExtra(Intent.EXTRA_TEXT   , "7Threads \nCustomer Name : "+customername.getText().toString()+"\nDate : "+date.getText().toString()+"\n Due : "+dueamount.getText().toString()+"\nTotal : "+totals.getText().toString()+"\nDeveloped By DDevelopers (HAT Inc)");
				try {
				    startActivity(Intent.createChooser(i, "Send mail..."));
				} catch (android.content.ActivityNotFoundException ex) {
				    Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(),
						"SMS faild, please try again later!",
						Toast.LENGTH_LONG).show();
				e.printStackTrace();
			}
			break;
			
			
		case R.id.imageView3:
			customername.setText("");
			dueamount.setText("0");
			item1price.setText("0");
			item1quan.setText("0");
			item2price.setText("0");
			item2quan.setText("0");
			item3price.setText("0");
			item3quan.setText("0");
			dicount.setText("0");
			totals.setText("0");
			
			
			break;
			
		case R.id.imageView5:
			break;
			
		case R.id.imageView4:
			System.exit(0);
			break;
			
			
		case R.id.button3:
			
			if (!(customername.getText().equals(""))) {
    			try {
					String sql = "Select due_price from invoice Where customername = '"+customername.getText()+"'";
					dueamount.setText(db.dueaount(sql));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(invoice.this, "Error ! \n"+e.toString(), 1000).show();
				}
			}
    		else {
    			Toast.makeText(invoice.this, "Enter Customer Name To Find His Previous Dues \n", 1000).show();
			}
    	break;
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
		
	}

}
