package com.example.seventhreads;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class settings extends alls{
	private Button button1;
	private EditText editText1;
	private EditText editText2;
	private EditText editText4;
	private EditText editText3;
	private Button button3;
	private Button button2;
	blc ss = new blc(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminsettings);
		
		button1 = (Button)findViewById( R.id.button1 );
		button3 = (Button)findViewById( R.id.button3 );
		button2 = (Button)findViewById( R.id.button2 );
		
		button1.setOnClickListener( this );
		button3.setOnClickListener( this );
		button2.setOnClickListener( this );
		
	}
	
	public void onClick(View v) {
		
		editText1 = (EditText)findViewById( R.id.editText1 );
		editText2 = (EditText)findViewById( R.id.editText2 );
		editText4 = (EditText)findViewById( R.id.editText4 );
		editText3 = (EditText)findViewById( R.id.editText3 );
		
		
		if ( v == button1 ) {
			// Handle clicks for button1
			
			
			new AlertDialog.Builder(this)
		    .setTitle("Delete All")
		    .setMessage("Are you sure you want to delete All Data?")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete
		        	try {
						ss.executesql("DROP TABLE IF EXISTS products");
						ss.executesql("DROP TABLE IF EXISTS invoice");
						ss.executesql("DROP TABLE IF EXISTS login");
						ss.tblmaker();
						Toast.makeText(getApplicationContext(), "Default Username is admin and pass is admin123", Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Toast.makeText(getApplicationContext(), "Error !\n"+e.toString(), Toast.LENGTH_LONG).show();
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
			
			
		}  else if ( v == button3 ) {
			// Handle clicks for button3
			try {
				ss.executesql(editText1.getText().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(this, "Error !\n"+e.toString(), Toast.LENGTH_LONG).show();
			}

		}
			else if ( v == button2 ) {
				if(editText2.getText().toString().equals(editText3.getText().toString())){
				ss.executesql("UPDATE login SET username = '"+editText2.getText().toString()+"' , password = '"+editText4.getText().toString()+"' WHERE ID = 1");
				}
				else {
					Toast.makeText(this, "Password Does Not Match !", Toast.LENGTH_LONG).show();
				}
			}
			
			}
	}
	
