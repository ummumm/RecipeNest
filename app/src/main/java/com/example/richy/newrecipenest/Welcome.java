package com.example.richy.newrecipenest;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class Welcome extends Activity {

	//Intent i=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
	}

	public void login_sigin(View v)
	{
		switch(v.getId())
		{
			case R.id.log_in:
				Intent i=new Intent(Welcome.this,Login.class);
				startActivity(i);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
				break;
			case R.id.sign_in:
				Intent ii=new Intent(Welcome.this,Signin.class);
				startActivity(ii);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
				break;
		}
	}

}