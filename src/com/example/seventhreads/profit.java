package com.example.seventhreads;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class profit extends alls implements OnItemClickListener {
	private ArrayAdapter<String> adapter;
	blc ss = new blc(this);
@Override
protected void onCreate(Bundle savedInstanceState){
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.profit);

	blc ss = new blc(this);
	
	//String sql ="SELECT distinct invoice.Invoice_ID , invoice.datf , invoice.item1_price-products.price FROM products INNER JOIN invoice ON products.productname = invoice.item1_name";
	String sql ="SELECT Invoice_ID , customername ,due_price , datf From invoice Where due_price > 0 Order by datf;";
//	t1.setText(ss.profitcalculate(sql).toString());
	
	
	adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ss.profitcalculate(sql));
   
    ListView listView = (ListView) findViewById(R.id.mobile_list);
    try {
		listView.setAdapter(adapter);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
	}
    
    listView.setOnItemClickListener(this);    

}
@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	
	   ListView listView = (ListView) findViewById(R.id.mobile_list);
	final String a = ((TextView)arg1).getText().toString();
	final String splitter[] = a.split("\\n+");
	TextView t1 = (TextView) findViewById(R.id.textView1);
	
	for (int i = 0; i < arg0.getCount(); i++) {
		if(arg2==i){

			
			new AlertDialog.Builder(this)
		    .setTitle("Clear "+splitter[1]+" Dues Of "+splitter[2])
		    .setMessage("Are you sure "+splitter[1]+" Have Cleared His Dues ?")
		    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // continue with delete

		        	String sql="UPDATE invoice SET due_price = 0 Where Invoice_ID ="+splitter[0];
		        	ss.executesql(sql);
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
	
}


}
