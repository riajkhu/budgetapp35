package com.budget.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	//decleared the table name,column names,database name and database version
	public static final String TABLE_NAME ="bud_app";
	public static final String COLUMN_ID ="id";
	public static final String COLUMN_DATE="date";
	public static final String COLUMN_TYPE ="category";
	public static final String COLUMN_EXPENSE ="expense"; 
	public static final String DATABASE_NAME ="budget.db";
	public static final int DATABASE_VERSION =1;
	
	//created a database with the table contents
	public static final String DATABASE_CREATE = "create table"+ TABLE_NAME+"("+ COLUMN_ID+
			"an incremented integer"+COLUMN_DATE+" date"+COLUMN_TYPE+"category of expense" + COLUMN_EXPENSE+"expense);";
//used constructor with context to create the database
	//context is used for creating or opening database
	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
  //creating the database
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		// TODO Auto-generated method stub
		
	}
	//used for database versioning and changin the database to a new database

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),"upgrading from the old version " +oldVersion+"to the new version"+newVersion );
		db.execSQL("DROP the table " + TABLE_NAME);
		onCreate(db);
		
		
		// TODO Auto-generated method stub
		
	}

}
