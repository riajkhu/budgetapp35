package com.budget.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
TextView dateText;
TextView expenseText;
Spinner categorySpinner;
private DatabaseConnection datasource;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		datasource = new DatabaseConnection(this);
		datasource.open();
		
		saveButton =(Button) findViewById(R.id.saveButton);
		saveButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dateText =(TextView) findViewById(R.id.dateField);
				String date = dateText.getText().toString();
				expenseText = (TextView) findViewById(R.id.expenseField);
				String expense = expenseText.getText().toString();
				categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
				

				// TODO Auto-generated method stub
				
			}
		});
		//clearButton =(Button) findViewById(R.id.clearButton);
		
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.option,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(adapter);

		// listener if you need one
		categorySpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
		
		
		
	}
	public class MyOnItemSelectedListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {

			Toast.makeText(
					parent.getContext(),
					"You have selected  "
							+ parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_LONG).show();
	
		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
		}
	}
	
	
	
	
	
	
	

}
