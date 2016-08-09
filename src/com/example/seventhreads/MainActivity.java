package com.example.seventhreads;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        Button login = (Button) findViewById(R.id.button1);
        
        login.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		 
        EditText pass = (EditText) findViewById(R.id.TextView01);
        EditText usernames = (EditText) findViewById(R.id.username);
		blc ss = new blc(this);
	
			if(usernames.getText().toString().equals("admin") && pass.getText().toString().equals("admin123")){
				//if(ss.checkusername(usernames.getText().toString(), pass.getText().toString())){
				Toast.makeText(this, "Welcome Admin !", Toast.LENGTH_LONG).show();
				try {
					Intent i = new Intent(this , admin.class);
					startActivity(i);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
				}
				
				}
			
			else if (usernames.getText().toString().equals("customer") && pass.getText().toString().equals("123")) {
				
				Toast.makeText(this, "Welcome Customer !", Toast.LENGTH_LONG).show();
			}
			else{
			//	Intent i = new Intent(this , admin.class);
			//	startActivity(i);
				Toast.makeText(this, "Incorrect User Name Or Password", Toast.LENGTH_SHORT).show();
			}
		}
		
	
	}