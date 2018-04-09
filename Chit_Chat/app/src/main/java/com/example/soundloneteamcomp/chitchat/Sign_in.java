package com.example.soundloneteamcomp.chitchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        /*Example about get and set value data*/
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//        myRef.setValue("Hello, World!");
//
//        DatabaseReference getvalue = database.getReference("abccc").child("user");
//        getvalue.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.e("Error",dataSnapshot.getValue(String.class));
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.w("Error", "Failed to read value.", databaseError.toException());
//            }
//        });


    }
}
