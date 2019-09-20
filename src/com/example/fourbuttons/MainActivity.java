package com.example.fourbuttons;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
Button jbtnnum1,jbtnnum2,jbtnadd,jbtnreset;
int n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtnnum1=(Button)findViewById(R.id.btnnum1);
        jbtnnum2=(Button)findViewById(R.id.btnnum2);
        jbtnadd=(Button)findViewById(R.id.btnadd);
        jbtnreset=(Button)findViewById(R.id.btnreset);
        
        jbtnnum1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try
				{
			Intent i=new Intent(getApplicationContext(),MyNumber.class);
			i.putExtra("hint","n1");
			startActivityForResult(i,1);
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "Something Went Wrong in Fetching Number 1 Data"+e.toString(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
        
        jbtnnum2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try
				{
				Intent i=new Intent(getApplicationContext(),MyNumber.class);
				i.putExtra("hint","n2");
				startActivityForResult(i,1);
				}
				catch(Exception e)
				{
					Toast.makeText(getApplicationContext(), "Something Went Wrong in Fetching Number 2 Data"+e.toString(), Toast.LENGTH_LONG).show();
				}
				
			}
		});
        
        
        
        jbtnadd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				boolean flag=false;
				flag=getData();
				if(flag)
				{
					int n3=n1+n2;
					jbtnadd.setText(String.valueOf(n3));
				}
				
				
			}
		});
        
        jbtnreset.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				jbtnnum1.setText("Number 1");
				jbtnnum2.setText("Number 2");
				jbtnadd.setText("Add");
				jbtnreset.setText("Reset");
				
			}
		});
    }
	protected boolean getData() {
		boolean flag = false;
        flag = getFirst();
        if(flag)
            flag = getSecond();
        return flag;
	}
	private boolean getSecond() {
		boolean flag = false;
        try
        {
             n2 =Integer.parseInt(jbtnnum2.getText().toString());
            if(n2> 0)
            	
                flag = true;
           
            else
                Toast.makeText(MainActivity.this,"Enter Number 2",Toast.LENGTH_SHORT).show();
                
        }
        catch (Exception e) {
               Toast.makeText(MainActivity.this, "Only numbers allowed.Enter Number again!", Toast.LENGTH_SHORT).show();
        }
    return flag;
	
	}
	private boolean getFirst() {
		boolean flag = false;
        try
        {
             n1 =Integer.parseInt(jbtnnum1.getText().toString());
            if(n1> 0)
            	
                flag = true;
           
            else
                Toast.makeText(MainActivity.this,"Enter Number 1",Toast.LENGTH_SHORT).show();
                
        }
        catch (Exception e) {
               Toast.makeText(MainActivity.this, "Only numbers allowed.Enter Number again!", Toast.LENGTH_SHORT).show();
        }
    return flag;
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bundle b=data.getExtras();
		if(b.containsKey("n1"))
		{
		jbtnnum1.setText(String.valueOf(b.getInt("n1")));
		jbtnnum1.setTextColor(Color.RED);
		}
		else
		{
		jbtnnum2.setText(String.valueOf(b.getInt("n2")));
		jbtnnum2.setTextColor(Color.RED);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}


    
}
