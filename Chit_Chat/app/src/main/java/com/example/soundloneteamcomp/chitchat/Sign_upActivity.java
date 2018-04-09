package com.example.soundloneteamcomp.chitchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sign_upActivity extends AppCompatActivity {
    private TextView textvSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textvSignIn = findViewById(R.id.TextView_SignIn);
        textvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_upActivity.this,Sign_in.class);
                startActivity(intent);
            }
        });
    }

}