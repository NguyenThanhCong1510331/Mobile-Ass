package com.example.soundloneteamcomp.chitchat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class Sign_upActivity extends AppCompatActivity {
    private TextView textvSignIn;
    private Button btnSignUp;
    private EditText etUserName;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPassWord;
    private RadioButton rdMale;
    private RadioButton rdFemale;
    private RadioGroup rdgrSex;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etAddress;
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

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


        onDatePickerClicked();
        onRadioButtonClicked();
        onButtonSignInClicked();

    }
    public  void onDatePickerClicked(){
        mDisplayDate =findViewById(R.id.DatePicker_SignUp);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int date = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(Sign_upActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month,date);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = month + "/"+ day+"/"+year;
                mDisplayDate.setText(date);
            }
        };
    }

    public void onRadioButtonClicked(){
        rdgrSex = findViewById(R.id.radioGroupSex_SignUp);
        rdMale = findViewById(R.id.radioMale_SignUp);
        rdFemale = findViewById(R.id.radioFemale_SignUp);
        rdgrSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rdgrSex.getCheckedRadioButtonId()==  rdMale.getId()) {
                    rdFemale.setSelected(false);
                    rdMale.setSelected(true);
                }
                else{
                    rdMale.setSelected(false);
                    rdFemale.setSelected(true);
                }
            }
        });
    }
    public void onButtonSignInClicked(){
        btnSignUp = findViewById(R.id.button_SignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                etFirstName = findViewById(R.id.EditText_SignUpFirstName);
                final String firstname = etFirstName.getText().toString();

                etLastName = findViewById(R.id.EditText_SignUpLastName);
                final String lastname = etLastName.getText().toString();

                etUserName = findViewById(R.id.EditText_SignUpUserName);
                final String username = etUserName.getText().toString();

                etPassWord = findViewById(R.id.EditText_SignUpPassword);
                final String password = etPassWord.getText().toString();

                rdMale = findViewById(R.id.radioMale_SignUp);
                final Boolean isMale = rdMale.isChecked();

                etEmail = findViewById(R.id.EditText_SignUpEmail);
                final String email = etEmail.getText().toString();

                etPhone = findViewById(R.id.EditText_SignUpPhone);
                final String phone = etPhone.getText().toString();

                etAddress = findViewById(R.id.EditText_SignUpAddress);
                final String address = etAddress.getText().toString();

                User user = new User(username,firstname,lastname,isMale,email,phone,address,password);
                Database mydb = new Database();
                mydb.writeNewUser(user);

                Intent intent = new Intent(Sign_upActivity.this,Sign_in.class);
                startActivity(intent);
            }
        });
    }
}