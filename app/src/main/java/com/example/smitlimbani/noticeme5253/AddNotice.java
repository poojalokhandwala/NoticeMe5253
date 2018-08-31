package com.example.smitlimbani.noticeme5253;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AddNotice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);


    }

    public void captureImage(View view)
    {
        startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
    }
}
