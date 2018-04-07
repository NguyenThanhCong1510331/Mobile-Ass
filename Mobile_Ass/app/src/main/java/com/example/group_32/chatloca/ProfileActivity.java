package com.example.group_32.chatloca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity  extends AppCompatActivity {
    private Button btnCallActivityBack;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnCallActivityBack = findViewById(R.id.button_BackProfile);
        btnCallActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        btnLogout = findViewById(R.id.button_Logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,Sign_in.class);
                startActivity(intent);
            }
        });

    }
}

