package com.example.seventhreads;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class showinvoice extends alls{
	private TableRow tableRow3;
	private Button button1;
	private Button button2;
	private TableRow tableRow1;
	private TextView textView1;
	private TableRow TableRow06;
	private TextView TextView11;
	private TextView TextView12;
	private TableRow TableRow05;
	private TextView TextView10;
	private TextView TextView09;
	private TableRow TableRow04;
	private TextView TextView08;
	private TextView TextView07;
	private TableRow TableRow01;
	private TextView TextView02;
	private TextView TextView01;
	private TableRow TableRow07;
	private TextView TextView13;
	private TextView TextView14;
	private TableRow TableRow08;
	private TextView TextView15;
	private TextView TextView16;
	private TableRow TableRow02;
	private TextView TextView04;
	private TextView TextView03;
	private TableRow TableRow12;
	private TextView TextView23;
	private TextView TextView22;
	private TableRow TableRow11;
	private TextView TextView21;
	private TextView TextView24;
	private TableRow TableRow03;
	private TextView TextView06;
	private TextView TextView05;
	private TableRow TableRow10;
	private TextView TextView19;
	private TextView TextView18;
	private TableRow TableRow09;
	private TextView TextView17;
	private TextView TextView20;
	private TableRow tableRow4;
	private TextView textView3;
	private TextView textView4;

 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.showinvoice);
	
		tableRow3 = (TableRow)findViewById( R.id.tableRow3 );
		button1 = (Button)findViewById( R.id.button1 );
		button2 = (Button)findViewById( R.id.button2 );
		tableRow1 = (TableRow)findViewById( R.id.tableRow1 );
		textView1 = (TextView)findViewById( R.id.textView1 );
		TableRow06 = (TableRow)findViewById( R.id.TableRow06 );
		TextView11 = (TextView)findViewById( R.id.TextView11 );
		TextView12 = (TextView)findViewById( R.id.TextView12 );
		TableRow05 = (TableRow)findViewById( R.id.TableRow05 );
		TextView10 = (TextView)findViewById( R.id.TextView10 );
		TextView09 = (TextView)findViewById( R.id.TextView09 );
		TableRow04 = (TableRow)findViewById( R.id.TableRow04 );
		TextView08 = (TextView)findViewById( R.id.TextView08 );
		TextView07 = (TextView)findViewById( R.id.TextView07 );
		TableRow01 = (TableRow)findViewById( R.id.TableRow01 );
		TextView02 = (TextView)findViewById( R.id.TextView02 );
		TextView01 = (TextView)findViewById( R.id.TextView01 );
		TableRow07 = (TableRow)findViewById( R.id.TableRow07 );
		TextView13 = (TextView)findViewById( R.id.TextView13 );
		TextView14 = (TextView)findViewById( R.id.TextView14 );
		TableRow08 = (TableRow)findViewById( R.id.TableRow08 );
		TextView15 = (TextView)findViewById( R.id.TextView15 );
		TextView16 = (TextView)findViewById( R.id.TextView16 );
		TableRow02 = (TableRow)findViewById( R.id.TableRow02 );
		TextView04 = (TextView)findViewById( R.id.TextView04 );
		TextView03 = (TextView)findViewById( R.id.TextView03 );
		TableRow12 = (TableRow)findViewById( R.id.TableRow12 );
		TextView23 = (TextView)findViewById( R.id.TextView23 );
		TextView22 = (TextView)findViewById( R.id.TextView22 );
		TableRow11 = (TableRow)findViewById( R.id.TableRow11 );
		TextView21 = (TextView)findViewById( R.id.TextView21 );
		TextView24 = (TextView)findViewById( R.id.TextView24 );
		TableRow03 = (TableRow)findViewById( R.id.TableRow03 );
		TextView06 = (TextView)findViewById( R.id.TextView06 );
		TextView05 = (TextView)findViewById( R.id.TextView05 );
		TableRow10 = (TableRow)findViewById( R.id.TableRow10 );
		TextView19 = (TextView)findViewById( R.id.TextView19 );
		TextView18 = (TextView)findViewById( R.id.TextView18 );
		TableRow09 = (TableRow)findViewById( R.id.TableRow09 );
		TextView17 = (TextView)findViewById( R.id.TextView17 );
		TextView20 = (TextView)findViewById( R.id.TextView20 );
		tableRow4 = (TableRow)findViewById( R.id.tableRow4 );
		textView3 = (TextView)findViewById( R.id.textView3 );
		textView4 = (TextView)findViewById( R.id.textView4 );

		button1.setOnClickListener( this );
		button2.setOnClickListener( this );
		
		blc ss = new blc(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			 String value = extras.getString("new_variable_name");
		    textView1.setText(value);
		    TextView12.setText(ss.invoiceshowerforid(value)[1]);
			TextView09.setText(ss.invoiceshowerforid(value)[2]);
			TextView01.setText(ss.invoiceshowerforid(value)[3]);
			TextView14.setText(ss.invoiceshowerforid(value)[5]);
			TextView16.setText(ss.invoiceshowerforid(value)[4]);
			TextView03.setText(ss.invoiceshowerforid(value)[6]);
			TextView22.setText(ss.invoiceshowerforid(value)[7]);
			TextView24.setText(ss.invoiceshowerforid(value)[8]);
			TextView05.setText(ss.invoiceshowerforid(value)[9]);
			TextView18.setText(ss.invoiceshowerforid(value)[11]);
			TextView20.setText(ss.invoiceshowerforid(value)[10]);
			TextView07.setText(ss.invoiceshowerforid(value)[12]);
			textView4.setText(""+((Integer.parseInt(ss.invoiceshowerforid(value)[4])*Integer.parseInt(ss.invoiceshowerforid(value)[5])+Integer.parseInt(ss.invoiceshowerforid(value)[7])*Integer.parseInt(ss.invoiceshowerforid(value)[8])+Integer.parseInt(ss.invoiceshowerforid(value)[10])*Integer.parseInt(ss.invoiceshowerforid(value)[11]))+Integer.parseInt(ss.invoiceshowerforid(value)[12])));

			
		}


}
 
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.button1:
			System.exit(0);
			break;
	case R.id.button2:
			try {
				blc obj = new blc(this);
				obj.executesql("DELETE FROM invoice WHERE Invoice_ID = "+textView1.getText().toString());
				System.exit(0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Toast.makeText(this, "Error !!"+e1.toString(), Toast.LENGTH_LONG).show();
			}
			break;
		
		}
		
	}

}
