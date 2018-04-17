package com.example.soundloneteamcomp.chitchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Sign_in extends AppCompatActivity{
    private Button btnCallActivityMessage;
    private TextView textvSignUp;

    private EditText userName ;
    private EditText passWord;

    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser!=null){
                    Intent intent = new Intent(Sign_in.this,MessageActivity.class);
                    startActivity(intent);
                    toastMessage("Successfully signed in with "+ firebaseUser.getEmail());
                }
            }
        };

        userName = findViewById(R.id.editText_SignInUsername);
        passWord = findViewById(R.id.editText_SignInPassword);
        textvSignUp = findViewById(R.id.TextView_SignUp);


        btnCallActivityMessage = findViewById(R.id.button_SignIn);
        btnCallActivityMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();
                if(!user.equals("")&&!pass.equals("")){
                    firebaseAuth.signInWithEmailAndPassword(user,pass);
                }
                else {
                    toastMessage("You didn't fill in all the fields.");
                }

            }
        });

        textvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this,Sign_upActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
