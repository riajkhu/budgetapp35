package com.budget.app;

import android.app.Activity;
import android.os.Bundle;

public class Budget extends Activity {
	private DatabaseConnection dataSource = new DatabaseConnection(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.budget);
		
		dataSource.getData();
	}
	
	

}
