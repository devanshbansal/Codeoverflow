package com.example.hp.codeoverflow2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
      Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
     b1= (Button) findViewById(R.id.button);
     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(validate_login())
             {
                 Intent i=new Intent(getApplicationContext(),home_activity.class);
                 startActivity(i);
             }
             else
                 Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
         }
     });

    }

    boolean validate_login()
    {
        return true;
    }
}
