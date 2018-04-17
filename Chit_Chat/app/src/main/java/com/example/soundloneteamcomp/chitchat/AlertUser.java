package com.example.soundloneteamcomp.chitchat;

import android.app.Activity;
import android.widget.Toast;

public class AlertUser {

    public void toastMessage(String message, Activity activity){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
    }
}
