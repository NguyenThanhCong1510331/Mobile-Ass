package com.example.soundloneteamcomp.chitchat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messenger");

    public DatabaseReference getMyRef() {
        return myRef;
    }

    public void writeNewUser(User new_user){
        new_user.setUserId();
        myRef.child("users").child(new_user.getUserId()).setValue(new_user);
    }
}