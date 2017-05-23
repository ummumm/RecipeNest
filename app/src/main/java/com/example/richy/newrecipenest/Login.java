package com.example.richy.newrecipenest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends Activity {
	Intent i=null;
	ImageView im=null;
	EditText tv1,tv4;
	boolean flag=false;
	SQLiteDatabase db=null;
	String moblie_no;
	User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		im=(ImageView)findViewById(R.id.show_hide2);
		tv1=(EditText)findViewById(R.id.phone2);
		tv4=(EditText)findViewById(R.id.password2);
		db=openOrCreateDatabase("mydb", MODE_PRIVATE, null);
	//	db.execSQL("create table if not exists login(name varchar,mobile_no varchar,email_id varchar,password varchar,flag varchar)");

		im.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
			
				if(flag==false)
				{
					im.setImageResource(R.drawable.hide);
					tv4.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
					flag=true;
				}
				else
				{
					im.setImageResource(R.drawable.show);
					tv4.setInputType(129);
					flag=false;
					
				}
			}
		});
	}
	
	public void action(View v)
	{
	switch(v.getId())
	{
	case R.id.signin2: 
		i=new Intent(this,Signin.class);
		startActivityForResult(i, 500);
		overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom); 
		finish();
		break;
	 case R.id.start:
		String email=tv1.getText().toString();
		String password=tv4.getText().toString();
		if(email==null||email==""||email.length()<10)
		{
			show("Please Enter Correct email.");
		}
		else if(password==null||password==""||password.length()<6)
		{
			show("Please Enter Correct Password.");
		}
		else
		{		
			Cursor c=db.rawQuery("select * from login where email_id='"+email+"' and password='"+password+"'",null);
			user = new User(email, password);
			c.moveToFirst();
			if(c.getCount()>0)
			{
			i=new Intent(this,AllFootList.class);
			startActivityForResult(i,500);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); 
			db.close();
			finish();
			}
			else
				show("Wrong Password or Email.");
			
		}
		break;
	}
  }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
	} 
	
	public void show(String str)
	{
	Toast.makeText(this, str, Toast.LENGTH_LONG).show();
	}

}
