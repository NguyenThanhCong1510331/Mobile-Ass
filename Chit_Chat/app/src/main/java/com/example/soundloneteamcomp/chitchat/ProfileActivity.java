package com.example.soundloneteamcomp.chitchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ProfileActivity  extends AppCompatActivity {
    private Button btnCallActivityBack;
    private Button btnEdit;
    private Button btnLogOut;
    private TextView txtName;
    private TextView txtGender;
    private TextView txtBirthday;
    private TextView txtEmail;
    private TextView txtPhone;
    private TextView txtAddress;
    private ImageView imgAvatar;
    private ViewSwitcher swtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnCallActivityBack = (Button)findViewById(R.id.button_BackProfile);
        btnLogOut = findViewById(R.id.button_Logout);
        btnEdit = (Button) findViewById(R.id.button_Edit);
        txtName = (TextView)findViewById(R.id.TextView_NameProfile);
        txtGender = (TextView)findViewById(R.id.TextView_GenderProfile);
        txtBirthday = (TextView)findViewById(R.id.TextView_BirthdayProfile);
        txtEmail = (TextView)findViewById(R.id.TextView_EmailProfile);
        txtPhone = (TextView)findViewById(R.id.TextView_PhoneProfile);
        txtAddress = (TextView)findViewById(R.id.TextView_AddressProfile);
        imgAvatar = (ImageView)findViewById(R.id.image_avatar);
        swtName = (ViewSwitcher)findViewById(R.id.ViewSwitcher_NameProfile);

        setData();

        btnCallActivityBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swtName.showNext();

            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setData(){
        txtName.setText("Tín Nguyễn");
        txtEmail.setText("tjinlag@gmail.com");
        txtAddress.setText("Thu Duc District HCMC");
        txtBirthday.setText("31/12/1997");
        txtGender.setText("Male");
        txtPhone.setText("0965075940");
    }
}

