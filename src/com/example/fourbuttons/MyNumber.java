package com.example.fourbuttons;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyNumber extends Activity{
	EditText jetnumber;
	Button jbtnok;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mynumber);
		
		jetnumber=(EditText)findViewById(R.id.etnumber);
		jbtnok=(Button)findViewById(R.id.btnnumber);
		jbtnok.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			int data=Integer.parseInt(jetnumber.getText().toString());
			Intent i=getIntent();
			Bundle b=i.getExtras();
			String h=b.getString("hint");
			i.putExtra(h,data);
			setResult(1,i);
			finish();
				
			}
		});
	}
	

}
