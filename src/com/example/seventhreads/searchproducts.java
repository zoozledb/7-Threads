package com.example.seventhreads;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class searchproducts extends Activity implements OnClickListener{
  	private TextView textView1;
  	private Button button1;
  	private WebView webView1;
  	String shouldnotbeoverrided = "<style> table { width:100%; } th{ color: white; background-color: black; } th, td { padding: 5px; text-align: left; } </style> <table border=\"1\"><tr> <th>ID</th> <th>Item Name</th><th>Manufacture</th><th>Price</th><th>Update</th></tr>";

  @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.searchproducts);
      
  		textView1 = (EditText)findViewById( R.id.textView1 );
  		button1 = (Button)findViewById( R.id.button1 );
  		webView1 = (WebView)findViewById( R.id.webView1 );
  		button1.setOnClickListener( this );
  		webView1.setWebViewClient(new WebViewClient(){
			  public boolean shouldOverrideUrlLoading(WebView view, String url) {
				  textView1.setText(url);
				  startintent();
				  return true;
			    }
		  });
   }

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
	//String sql ="Select invoice.datf , products.manu , count(invoice.item1_name) , count(invoice.item2_name) , count(invoice.item3_name) from invoice INNER JOIN products ON products.productname = invoice.item1_name OR invoice.item2_name OR invoice.item3_name order by datf";
	
	blc ss = new blc(this);
	WebView webViewss = (WebView) findViewById(R.id.webView1);
	
	webViewss.loadData(shouldnotbeoverrided+ss.productshower(textView1.getText().toString())+"</table>", "text/html", "UTF-8");
	
}


public void startintent() {
	try {
		Intent i = new Intent(this, showproduct.class);
		  i.putExtra("new_variable_name",textView1.getText().toString());
		  startActivity(i);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
}

}