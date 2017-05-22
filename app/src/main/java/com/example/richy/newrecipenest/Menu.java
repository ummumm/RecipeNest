package com.example.richy.newrecipenest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Richy on 5/22/2017.
 */

public class Menu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void action(View v)
    {
        switch(v.getId())
        {
            case R.id.btnList:
                Intent i=new Intent(Menu.this,FoodList.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.btnAddRecipe:
                Intent ii=new Intent(Menu.this,MainActivity.class);
                startActivity(ii);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);;
                break;
        }
    }


}
