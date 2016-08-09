package com.example.seventhreads;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class sync extends alls{
	private EditText editText1;
	private EditText foldername;
	private Button button1;
	Spinner filetype;
	Spinner  tablename;
	blc ss = new blc(this);
	
	public void datasaver(String a , String filename , String Filetype ,String foldername) {
	    // write on SD card file data in the text box
	    try {
	        File newFolder = new File(Environment.getExternalStorageDirectory(), foldername);
	        if (!newFolder.exists()) {
	            newFolder.mkdir();
	        }
	        try {
	            File file = new File(newFolder, filename +"."+ Filetype);
	            file.createNewFile();
	            FileOutputStream fos;
	            fos = new FileOutputStream(file);
	            byte[] data = a.getBytes();
	            fos.write(data);
	            fos.flush();
	            fos.close();
	        } catch (Exception ex) {
	            System.out.println("ex: " + ex);
	            Toast.makeText(this, "ex: " + ex, Toast.LENGTH_LONG).show();
	        }
	    } catch (Exception e) {
	        System.out.println("e: " + e);
	        Toast.makeText(this, "e: " + e, Toast.LENGTH_LONG).show();
	    }
	   
	}
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.sync);

	filetype  = (Spinner) findViewById(R.id.spinner1);
	tablename = (Spinner) findViewById(R.id.tablename);
	button1 = (Button)findViewById( R.id.button1 );
	foldername = (EditText)findViewById(R.id.foldername);
	button1.setOnClickListener( this );
	
	 List<String> list = new ArrayList<String>();
     list.add("txt");
     list.add("csv");
     list.add("sql");
     
     List<String> tablelist = new ArrayList<String>();
     tablelist.add("invoice");
     tablelist.add("products");
     
     ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
     (this, android.R.layout.simple_spinner_item,list);
      
     dataAdapter.setDropDownViewResource
     (android.R.layout.simple_spinner_dropdown_item);
      
	filetype.setAdapter(dataAdapter);
	
	
	ArrayAdapter<String> dataAdapters = new ArrayAdapter<String>
    (this, android.R.layout.simple_spinner_item,tablelist);
     
	dataAdapters.setDropDownViewResource
    (android.R.layout.simple_spinner_dropdown_item);
     
	tablename.setAdapter(dataAdapters);
	
}



public void onClick(View v) {
	if ( v == button1 ) {
		// Handle clicks for button1
		
		editText1 = (EditText)findViewById( R.id.editText1 );
		
		if (String.valueOf(tablename.getSelectedItem()).equals("invoice")) {
			try {
				datasaver(ss.syncinvoice(String.valueOf(tablename.getSelectedItem())) ,  editText1.getText().toString() , String.valueOf(filetype.getSelectedItem()) , foldername.getText().toString());
				Toast.makeText(this,  "Saved DATA Of "+String.valueOf(tablename.getSelectedItem())+" In "+foldername.getText().toString()+" Folder >> "+editText1.getText().toString()+"."+String.valueOf(filetype.getSelectedItem()), Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(this, "Error ! \n"+e.toString(), Toast.LENGTH_LONG).show();
				
			}
		} else {
			try {
				datasaver(ss.shower().toString() ,  editText1.getText().toString() , String.valueOf(filetype.getSelectedItem()) , foldername.getText().toString());
				Toast.makeText(this,  "Saved DATA Of "+String.valueOf(tablename.getSelectedItem())+" In "+foldername.getText().toString()+" Folder >> "+editText1.getText().toString()+"."+String.valueOf(filetype.getSelectedItem()), Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(this, "Error ! \n"+e.toString(), Toast.LENGTH_LONG).show();
				
			}
		}
	}
	
}



}
