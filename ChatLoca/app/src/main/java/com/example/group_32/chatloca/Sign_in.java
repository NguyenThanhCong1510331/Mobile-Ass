package com.example.group_32.chatloca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_in extends AppCompatActivity {
    private Button btnCallActivityMessage;
    private TextView textvSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnCallActivityMessage = findViewById(R.id.button_SignIn);
        btnCallActivityMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        textvSignUp = findViewById(R.id.TextView_SignUp);
        textvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this,Sign_upActivity.class);
                startActivity(intent);
            }
        });
    }
}
