package com.example.seventhreads;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class search extends alls{
	 TableLayout table_layout;
	 EditText seracher;
	 Button addmem_btn;
	 String shouldnotbeoverrided = "<style> table { width:100%; } th{ color: white; background-color: black; } th, td { padding: 5px; text-align: left; } </style> <table border=\"1\"><tr> <th>ID</th> <th>Product Name</th> <th>Manufacturer</th><th>Total</th><th>View</th></tr>";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		
		  seracher = (EditText) findViewById(R.id.fistname_et_id);
		  addmem_btn = (Button) findViewById(R.id.addmem_btn_id);
		  WebView webViews = (WebView) findViewById(R.id.webView1);
		  
		  webViews.getSettings().setLoadWithOverviewMode(true);
		  webViews.getSettings().setUseWideViewPort(true);
		  
		  webViews.loadData(shouldnotbeoverrided,"text/html", "UTF-8");
		  addmem_btn.setOnClickListener(this);
		  
		  webViews.setWebViewClient(new WebViewClient(){
			  public boolean shouldOverrideUrlLoading(WebView view, String url) {
				  seracher.setText(url);
				  startintent();
				  return true;
			    }
		  });
		
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		blc data = new blc (this);
		
		
		WebView webViews = (WebView) findViewById(R.id.webView1);
		
		webViews.loadData(shouldnotbeoverrided+data.invoiceshower(seracher.getText().toString())+"</table>","text/html", "UTF-8");
		
	}
	
	public void startintent() {
		try {
			Intent i = new Intent(this, showinvoice.class);
			  i.putExtra("new_variable_name",seracher.getText().toString());
			  startActivity(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, e.toString(), 1000).show();
		}
	}
	

}
