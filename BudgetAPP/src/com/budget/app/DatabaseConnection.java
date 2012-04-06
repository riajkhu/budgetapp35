package com.budget.app;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Spinner;

public class DatabaseConnection {
	
	public String cat ="";
	public MySQLiteHelper dbHelper;
	public SQLiteDatabase db;
	// creating a array for saving the  columns
	//public String[] columns = {dbHelper.COLUMN_ID,dbHelper.COLUMN_DATE,dbHelper.COLUMN_EXPENSE,dbHelper.COLUMN_TYPE};
	//public String[] columns = {dbHelper.COLUMN_DATE,dbHelper.COLUMN_EXPENSE,dbHelper.COLUMN_TYPE};
	ContentValues cValues = new ContentValues();
	//constructor of DatabaseConnection contaning a dbHelper object 
	public DatabaseConnection(Context con){
		dbHelper = new MySQLiteHelper(con);
		
		
	}
	// opens a writable database 
	public DatabaseConnection open() throws SQLException{
		db = dbHelper.getWritableDatabase();
		return this;
		
	}
	//used for closing the database
	public void close(){
		dbHelper.close();
		
		
	}
	
	/*adds the data to the database
	 * uses the ContentValues class by creating the object cValues. cValues object is used for putting the values in different columns
	 * db object uses the insert method to insert the table and the values inside the table to the database
	 */
	public long addData(String date,String category,String expense){
		
		Log.i("inserting data",date);	
		cValues.put(dbHelper.COLUMN_DATE, date);
		cValues.put(dbHelper.COLUMN_TYPE, category);
		cValues.put(dbHelper.COLUMN_EXPENSE, expense);
		//cValues.put(dbHelper.COLUMN_ID, id);
		
		 return db.insert(dbHelper.TABLE_NAME, null, cValues);
	
		
	}
	
	
	/*used for retrieving the data  
	 * araayList is used to save data from the columns and the database to a list
	 * cursor is used to open and create a database and here is used to do the query 
	 * now cursor is on the first row
	 * a while loop is used to go until the last row
	 * inside the loop first data are added in the query through the cursor object using the getString() for saving the data to the respective column
	 * then typical add() of ArrayList is used to save the column info to the list
	 * after adding all the columns, the moveToNext() is used to point the cursor to the next row
	 * outside the loop close() is used to close the database
	 * returns the arrayList containing all the info of the database
	 */
	
	public String getData(){
		//ArrayList <String> budList = new ArrayList<String>();
		String[] columns = {dbHelper.COLUMN_DATE,dbHelper.COLUMN_EXPENSE,dbHelper.COLUMN_TYPE};
		Cursor cursor = db.query(dbHelper.TABLE_NAME, columns, null, null, null, null, null);
		
		String result ="";
		
		int dateRow = cursor.getColumnIndex(dbHelper.COLUMN_DATE);
		int expenseRow = cursor.getColumnIndex(dbHelper.COLUMN_EXPENSE);
		int typeRow = cursor.getColumnIndex(dbHelper.COLUMN_TYPE);
		
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
			
			result = result + cursor.getString(dateRow) +" "+ cursor.getString(expenseRow)+" "+ cursor.getString(typeRow) + "\n";
			
			
		}
		
		
		
		return result;
		
		/*cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			
			String strDate = cursor.getString(2);
		
			budList.add(strDate);
			String strCategory = cursor.getString(3);
			budList.add(strCategory);
			String strExpense = cursor.getString(4);
			budList.add(strExpense);
			cursor.moveToNext();
			
			
			
			
		}
		cursor.close();
		return  budList;
		
		*/
	}

}
