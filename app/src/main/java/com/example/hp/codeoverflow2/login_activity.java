package com.example.hp.codeoverflow2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login_activity extends AppCompatActivity {
    Button b1;
    private EditText phone, password;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             validate_login();
             Toast.makeText(login_activity.this, "Me " + password.getText().toString(), Toast.LENGTH_SHORT).show();
             boolean ok = false;
             if(password.getText().toString().equals("1")){
                 password.setText("1234567891011212123445");
                 ok = true;
             }

             if(ok)
             {
                 Intent i=new Intent(getApplicationContext(),home_activity.class);
                 startActivity(i);
             }
             else
                 Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
         }
        });

    }


    public static class getdata{
        public String eid = "", passw = "";
        public getdata(){
            //just for reference
        }
        getdata(String eid, String passw){
            this.eid = eid;
            this.passw = passw;
        }
    }

    void validate_login()
    {
        try{
            mDatabase.child("users").child(phone.getText().toString()).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                    getdata gd = dataSnapshot.child("users").getValue(new getdata(eid.getText().toString(), password.getText().toString()));
//                    Toast.makeText(login_activity.this, gd.eid + " " + gd.passw, Toast.LENGTH_SHORT).show();
//                    System.out.println(gd.eid + " " + gd.passw);
                    if(dataSnapshot.getKey().equals("passw")){
                        int res = (dataSnapshot.getValue().toString().compareTo(password.getText().toString()));
                        if(res == 0){
                            password.setText("1");
                        }
                    }
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
