package com.example.seventhreads;


import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class blc extends  SQLiteOpenHelper {
	 // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "HATDB";
 
    public blc(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE products ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
                "productname VARCHAR(255), "+
                "manu VARCHAR(100), "+
                "price int, "+
                "des VARCHAR(255) )";
 
        // create books table
        
        String CREATE_Invoice = "CREATE TABLE invoice ( " +
                "Invoice_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
                "customername VARCHAR(255), "+
                "datf VARCHAR(100), "+
                "item1_name VARCHAR(255), "+
                "item1_price int, "+
                "item1_quan int, "+
                "item2_name VARCHAR(255), "+
                "item2_price int, "+
                "item2_quan int, "+
                "item3_name VARCHAR(255), "+
                "item3_price int, "+
                "item3_quan int, "+
                "due_price int ) ";
 
        // create books table
        db.execSQL(CREATE_Invoice);
        
        
    	db.execSQL(CREATE_BOOK_TABLE);
        
    	 String login = "CREATE TABLE login ( " +
                 "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
         		+"username VARCHAR(255), "+
                 "password VARCHAR(255) )";
         
         db.execSQL(login);
         
         String defaultlogin="Insert into login (username , password) Values ('admin', 'admin1234') ";
         
         db.execSQL(defaultlogin);
        
        
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older  table if existed
        db.execSQL("DROP TABLE IF EXISTS products");
        db.execSQL("DROP TABLE IF EXISTS invoice");
        db.execSQL("DROP TABLE IF EXISTS login");
        // create fresh books table
        this.onCreate(db);
    }
    
    public void inserter(String productname , String manu  ,int  price , String des) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	db.execSQL("INSERT INTO products VALUES(NULL,'"+productname+"','"+manu+"','"+price+"','"+des+"');");
}
    
    
    public void inserterininvoice(String customername , String date, String item1_name  ,int  item1_price , int item1_quan ,String item2_name  ,int  item2_price , int item2_quan , String item3_name  ,int  item3_price , int item3_quan , int due_price) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.execSQL("INSERT INTO invoice VALUES(NULL,'"+customername+"','"+date+"','"+item1_name+"','"+item1_price+"','"+item1_quan+"','"+item2_name+"','"+item2_price+"','"+item2_quan+"','"+item3_name+"','"+item3_price+"','"+item3_quan+"','"+due_price+"');");
}
    
    public String shower() {
    	String alldata="";
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM products";
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	 if(c.moveToFirst()){
    		 
             do{
            	
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                String column4 = c.getString(3);
                String column5 = c.getString(4);
                
                alldata = alldata +"\n ID : "+ column1 +"\n Product Name : "+ column2 +"\n Manufacturer : "+column3+"\n PRICE : "+column4+"\n DESCRIPTION : "+column5+"\n";
             }
             while(c.moveToNext());
         }
    	 
    	 return alldata;
    	
}

    
    public String[] invoiceshowerforid (String id) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM invoice Where Invoice_ID = "+id;
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	String[] s = new String[13];
    	 if(c.moveToFirst()){
    		 
             do{
            	
                for (int i = 0; i < s.length; i++) {
					s[i] = c.getString(i);
				}
             }
             while(c.moveToNext());
         }
    	 
    	 return s;
    	
}

    
    public String[] productshowerforid (String id) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM products Where ID = "+id;
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	String[] s = new String[5];
    	 if(c.moveToFirst()){
    		 
             do{
            	
                for (int i = 0; i < s.length; i++) {
					s[i] = c.getString(i);
				}
             }
             while(c.moveToNext());
         }
    	 
    	 return s;
    	
}

    
    
    public void tblmaker() {
    	SQLiteDatabase db = this.getWritableDatabase();
    	String CREATE_Invoice = "CREATE TABLE invoice ( " +
                "Invoice_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
                "customername VARCHAR(255), "+
                "datf VARCHAR(100), "+
                "item1_name VARCHAR(255), "+
                "item1_price int, "+
                "item1_quan int, "+
                "item2_name VARCHAR(255), "+
                "item2_price int, "+
                "item2_quan int, "+
                "item3_name VARCHAR(255), "+
                "item3_price int, "+
                "item3_quan int, "+
                "due_price int ) ";
 
        // create books table
        db.execSQL(CREATE_Invoice);
        String CREATE_BOOK_TABLE = "CREATE TABLE products ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + 
                "productname VARCHAR(255), "+
                "manu VARCHAR(100), "+
                "price int, "+
                "des VARCHAR(255) )";
        
        db.execSQL(CREATE_BOOK_TABLE);
        String login = "CREATE TABLE login ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
        		+"username VARCHAR(255), "+
                "password VARCHAR(255) )";
        
        db.execSQL(login);
        
        String defaultlogin="Insert into login (username , password) Values ('admin', 'admin1234') ";
        
        db.execSQL(defaultlogin);
	}
    
    
    public String[] getAllSpinnerContent(){
    	String[] allSpinner;
        String query = "Select * from products";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> spinnerContent = new ArrayList<String>();
        spinnerContent.add("N/A");
        if(cursor.moveToFirst()){
            do{
                String word = cursor.getString(cursor.getColumnIndexOrThrow("productname"));
                spinnerContent.add(word);
            }while(cursor.moveToNext());
        }
        cursor.close();

        allSpinner = new String[spinnerContent.size()];
        allSpinner = spinnerContent.toArray(allSpinner);

        return allSpinner;
    }
    
    
    public String invoiceshower( String customername ) {
    	String alldata="<tr>";
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM invoice WHERE customername LIKE '%"+customername+"%' OR item1_name LIKE '%"+customername+"%' OR item2_name LIKE '%"+customername+"%' OR item3_name LIKE '%"+customername+"%' OR datf LIKE '%"+customername+"%'";
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	 if(c.moveToFirst()){
    		 
             do{
            	
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
               
                int price = Integer.parseInt(c.getString(4))*Integer.parseInt(c.getString(5))+Integer.parseInt(c.getString(7))*Integer.parseInt(c.getString(8))+Integer.parseInt(c.getString(10))*Integer.parseInt(c.getString(11))+Integer.parseInt(c.getString(12));
                
                alldata = alldata +"<td>"+ column1 +"</td><td>"+ column2 +"</td><td>"+column3+"</td><td>"+price+"<td><a href='"+ column1 +"'> View INVOICE # "+ column1 +"</a></td></tr>";

             }
             while(c.moveToNext());
         }
    	 
    	 return alldata;
    	
}
    
    public void executesql(String a) {
    	SQLiteDatabase db = this.getWritableDatabase();
    	db.execSQL(a);
	}
    
    public String[] profitcalculate(String sql) {
		
    	// convert into array for list view in profit 
    	SQLiteDatabase db = this.getWritableDatabase();
    	 String[] allSpinner;
         Cursor cursor = db.rawQuery(sql, null);
         ArrayList<String> spinnerContent = new ArrayList<String>();
         if(cursor.moveToFirst()){
             do{
                 String Invoice_ID = cursor.getString(cursor.getColumnIndexOrThrow("Invoice_ID"));
                 String customername = cursor.getString(cursor.getColumnIndexOrThrow("customername"));
                 String due_price = cursor.getString(cursor.getColumnIndexOrThrow("due_price"));
                 String datf = cursor.getString(cursor.getColumnIndexOrThrow("datf"));
                 spinnerContent.add(Invoice_ID+"\n\n\n"+customername+"\n\n\n"+datf+"\n"+due_price+"\n\n\n");
                 
             }while(cursor.moveToNext());
         }
         cursor.close();

         allSpinner = new String[spinnerContent.size()];
         allSpinner = spinnerContent.toArray(allSpinner);

         return allSpinner;
	}
    
    
    public String productshower( String customername ) {
    	String alldata="<tr>";
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM products WHERE productname LIKE '%"+customername+"%' OR manu LIKE '%"+customername+"%' OR price LIKE '%"+customername+"%' OR des LIKE '%"+customername+"%'";
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	 if(c.moveToFirst()){
    		 
             do{
            	
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                String column4 = c.getString(3);
               
                alldata = alldata +"<td>"+ column1 +"</td><td>"+ column2 +"</td><td>"+column3+"</td><td>"+column4+"</td><td><a href='"+ column1 +"'>Update</a></td></tr>";

             }
             while(c.moveToNext());
         }
    	 
    	 return alldata;
    	
}
    public String dueaount(String sql) {
    	
    	String alldata="";
    	int saver=0;
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	Cursor c = db.rawQuery(sql, null);
    	
    	 if(c.moveToFirst()){
    		 
             do{
            	
                String column1 = c.getString(0);
                saver  = saver+Integer.parseInt(column1);
             }
             while(c.moveToNext());
         }
    	 
    	 return saver+alldata;
    	 
	}
    
    public String syncinvoice(String table) {
    	
    	String alldata=null;
    	SQLiteDatabase db = this.getWritableDatabase();
    	String selectQuery="SELECT * FROM "+table;
    	
    	Cursor c = db.rawQuery(selectQuery, null);
    	
    	 if(c.moveToFirst()){
    		 
             do{
            	
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                String column4 = c.getString(3);
                String column5 = c.getString(4);
                String column6 = c.getString(5);
                String column7 = c.getString(6);
                String column8 = c.getString(7);
                String column9 = c.getString(8);
                String column10 = c.getString(9);
                String column11 = c.getString(10);
                String column12 = c.getString(11);
                String column13 = c.getString(12);
                
                alldata = alldata +"\n"+ column1 +"\n"+ column2 +"\n"+column3+"\n"+column4+"\n"+ column5 +"\n"+ column6 +"\n"+ column7 +"\n"+ column8 +"\n"+ column9 +"\n"+ column10 +"\n"+ column11 +"\n"+ column12 +"\n"+ column12 +"\n"+column13+"\n";

             }
             while(c.moveToNext());
         }
    	 
    	 return alldata;
		
	}
    
    
    public boolean checkusername(String username , String pass) {
		SQLiteDatabase db = getWritableDatabase();
		
		String sql = "Select username,password from login where username = '"+username+"' And password = '"+pass+"' AND ID = 1";
    	try {
			db.execSQL(sql);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
    
    
}
