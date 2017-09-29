package com.example.hp.codeoverflow2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login_activity extends AppCompatActivity {
      Button b1;
    private EditText eid, password;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eid = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        mDatabase = FirebaseDatabase.getInstance().getReference();
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
        try{
            // For testing purpose !
//            DatabaseReference dref = mDatabase.child("emailId");
//            dref.setValue(eid.getText().toString());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
