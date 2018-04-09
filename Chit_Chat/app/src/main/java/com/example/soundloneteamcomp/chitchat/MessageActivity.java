package com.example.soundloneteamcomp.chitchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MessageActivity extends AppCompatActivity {
    private ImageView btnCallActivityProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btnCallActivityProfile = findViewById(R.id.avatar);
        btnCallActivityProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}