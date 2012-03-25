package com.budget.app;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
public class ProgressBarActivity extends Activity {
	ProgressBar foodBar;
	 private static final int PROGRESS = 0x1;

     private ProgressBar mProgress;
     private int mProgressStatus = 0;
     private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar);
		
		foodBar=(ProgressBar) findViewById(R.id.foodBar);
		 new Thread(new Runnable() {
             public void run() {
                 while (mProgressStatus < 100) {
                     mProgressStatus = doWork();

                     // Update the progress bar
                     mHandler.post(new Runnable() {
                         public void run() {
                             mProgress.setProgress(mProgressStatus);
                         }
                     });
                 }
             }

			private int doWork() {
				// TODO Auto-generated method stub
				return 100;
			}
         }).start();

		
	}
		}
	
	
	
	



                 
			 
		
	
		