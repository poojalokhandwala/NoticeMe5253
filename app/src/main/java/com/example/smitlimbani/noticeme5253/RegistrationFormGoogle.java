package com.example.smitlimbani.noticeme5253;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegistrationFormGoogle extends AppCompatActivity{


    private EditText mDOB;
    private RadioGroup mGenderGroup;
    private RadioButton mGenderBtn;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form_google);

        mDOB = (EditText) findViewById(R.id.DOBGoogle);

        mGenderGroup = (RadioGroup) findViewById(R.id.genderGroupGoogle);



    }
    protected void submitUserDetails(View view) {

        Log.e("ye to mil raha hai", FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
//        UserDetails userDetails= new UserDetails();
//        userDetails.setDisplayName(mAuth.getCurrentUser().getDisplayName().toString());
//        userDetails.setDob(mDOB.getText().toString());
//        userDetails.setContactNo(mAuth.getCurrentUser().getPhoneNumber().toString());
//        int genderId = mGenderGroup.getCheckedRadioButtonId();
//        mGenderBtn = (RadioButton) findViewById(genderId);
//        userDetails.setGender(mGenderBtn.getText().toString());
//
//        mDatabaseReference.child("user_details").child(mAuth.getCurrentUser().getUid().toString()).setValue(userDetails);

        startActivity(new Intent(RegistrationFormGoogle.this, MainActivity.class));
    }
}
