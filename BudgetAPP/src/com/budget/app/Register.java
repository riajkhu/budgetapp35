package com.budget.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Register extends Activity {
Button saveButton;
Button clearButton;
Button showDataButton;
TextView dateText;
TextView expenseText;
Spinner categorySpinner;
private DatabaseConnection dataSource = new DatabaseConnection(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		
		dateText =(TextView) findViewById(R.id.dateField);
		expenseText = (TextView) findViewById(R.id.expenseField);
		categorySpinner  = (Spinner) findViewById(R.id.categorySpinner);
		
		//code for clearButton;
		clearButton =(Button) findViewById(R.id.clearButton);
		clearButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				dateText.setText("");
				expenseText.setText("");
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//code for showDataButton.
		showDataButton = (Button) findViewById(R.id.getButton);
		showDataButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				setContentView(R.layout.budget);
				TextView budgetView = (TextView) findViewById(R.id.budgetView);
				//dataSource.open();
				//String data = dataSource.getData();
				
				//dataSource.close();
				//budgetView.setText(data);
				// TODO Auto-generated method stub
				
			}
		});
		
		//code for the save button
		saveButton =(Button) findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String date = dateText.getText().toString();
				Log.i("This is date", date);
				String expense = expenseText.getText().toString();
				Log.i("The expense is", expense);
				String category = categorySpinner.getSelectedItem().toString();
				Log.i("This is category", category);
				dataSource.open();
			    
				dataSource.addData(date, category, expense);
			    
			    dataSource.close();
			
				
				
			    
			    
			   
				//categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
				//String spinner = categorySpinner.getAdapter().toString();
				

				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		  
		
		 
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
					this, R.array.option, android.R.layout.simple_spinner_item);
			
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			categorySpinner.setAdapter(adapter);

			// listener if you need one
			categorySpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
			
		
		
	}
	public class MyOnItemSelectedListener implements OnItemSelectedListener {
/*
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			Toast.makeText(
					parent.getContext(),
					"You have selected  "
							+ parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_LONG).show();
	
		}
*/
		public void DisplayNotice(String notice) 
	    { 
	        Toast.makeText(Register.this, 
	                notice, 
	                Toast.LENGTH_LONG).show(); 
	    } 
	    public void onItemSelected(AdapterView parent, View v, int 
	position, long id) { 
	        switch (position) { 
	        case 0: 
	                DisplayNotice(parent.getSelectedItem().toString()); 
	            break; 
	        case 1: 
	                DisplayNotice(parent.getSelectedItem().toString()); 
	            break; 
	        case 2: 
	                DisplayNotice(parent.getSelectedItem().toString()); 
	            break; 
	        default: 
	                DisplayNotice(parent.getSelectedItem().toString()); 
	            break; 
	        } 
	    } 
		
		
		public void onNothingSelected(AdapterView parent) {
			
			
			// Do nothing.
		}
	}
	
	
	
	
	
	
	

}
