package com.example.hp.codeoverflow2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.api.model.StringList;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class signup_activity extends AppCompatActivity {
    Button b1;
    private EditText eid, password, confpassword, name;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        eid = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        confpassword = (EditText)findViewById(R.id.editText3);
        name = (EditText)findViewById(R.id.editText4);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    insertData();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    public void insertData(){
        try{
            if(!password.getText().toString().equals(confpassword.getText().toString())){
                Toast.makeText(getApplicationContext(), "Enter same password in confirm password", Toast.LENGTH_LONG).show();
                return;
            }

            mDatabase.child("users").child(name.getText().toString()).child("eid").setValue(eid.getText().toString());
            mDatabase.child("users").child(name.getText().toString()).child("passw").setValue(password.getText().toString());
            Toast.makeText(getApplicationContext(), "Account created Successfully !", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
