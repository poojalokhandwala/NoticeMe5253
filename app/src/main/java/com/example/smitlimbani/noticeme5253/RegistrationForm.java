package com.example.smitlimbani.noticeme5253;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationForm extends AppCompatActivity {

    private EditText mFirstName;
    private EditText mLastName;
    private EditText mDOB;
    private EditText mContactNo;
    private RadioGroup mGenderGroup;
    private RadioButton mGenderBtn;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();
    private FirebaseUser currentUser;
//    private EditText mEmailId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        mFirstName = (EditText) findViewById(R.id.firstName);
        mLastName = (EditText) findViewById(R.id.lastName);
        mDOB = (EditText) findViewById(R.id.DOB);
        mContactNo = (EditText) findViewById(R.id.contactNo);
//        mEmailId = (EditText) findViewById(R.id.emailId);
        mGenderGroup = (RadioGroup) findViewById(R.id.genderGroup);

    }

    protected void submitUserDetails(View view) {

        UserDetails userDetails= new UserDetails();
        userDetails.setDisplayName(mFirstName.getText().toString()+" "+mLastName.getText().toString());
        userDetails.setDob(mDOB.getText().toString());
        userDetails.setContactNo(mContactNo.getText().toString());
//        userDetails.setEmailId(mEmailId.getText().toString());
        int genderId = mGenderGroup.getCheckedRadioButtonId();
        mGenderBtn = (RadioButton) findViewById(genderId);
        userDetails.setGender(mGenderBtn.getText().toString());

        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        userDetails.setEmailId(currentUser.getEmail().toString());

        userDetails.setOrg_id("");
        userDetails.setUser_type("");

        mDatabaseReference.child("user_details").child(currentUser.getUid().toString()).setValue(userDetails);

        startActivity(new Intent(RegistrationForm.this, MainActivity.class));
    }
}
