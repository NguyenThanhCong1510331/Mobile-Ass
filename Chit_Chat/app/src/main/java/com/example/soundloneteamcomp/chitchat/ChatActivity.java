package com.example.soundloneteamcomp.chitchat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView list_message;
    private final List<Messages> messageList = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private Message_Adapter messageAdapter;
    private EditText editText;
    private Dialog myDialog;
    private Button btnSetApp;
    private Button btnDate, btnTime;
    private TextView txtDate, txtTime;
    private EditText txtName;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextView txt_name, txt_date, txt_time;
    private String name, date, time;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        messageAdapter = new Message_Adapter(messageList);

        list_message = (RecyclerView) findViewById(R.id.recyler_list_message);

        linearLayoutManager = new LinearLayoutManager(this);

        list_message.setHasFixedSize(true);

        list_message.setLayoutManager(linearLayoutManager);

        list_message.setAdapter(messageAdapter);

        editText = (EditText) findViewById(R.id.edtxt_Chat);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER && !editText.getText().toString().equals("")) {
                    fetchMessage();
                    editText.setText("");
                    list_message.smoothScrollToPosition(messageAdapter.getItemCount() - 1);
                    return true;
                }
                return false;
            }
        });

        btnSetApp = (Button) findViewById(R.id.btn_set_appointment);
        btnSetApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup();
            }
        });

        goBack = (Button) findViewById(R.id.button_BackChat);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });

    }

    private void fetchMessage() {
        Messages messages = new Messages(editText.getText().toString());
        messageList.add(messages);
        messageAdapter.notifyDataSetChanged();
    }

    private void showPopup() {
        Button btnCancel;
        Button btnConfirm;

        myDialog = new Dialog(ChatActivity.this);
        myDialog.setContentView(R.layout.activity_set_appointment);

        btnCancel = (Button) myDialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        btnDate = (Button) myDialog.findViewById(R.id.btn_date);
        txtDate = (TextView) myDialog.findViewById(R.id.txt_date);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ChatActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        date = dayOfMonth + "-" + (month + 1) + "-" + year;
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnTime = (Button) myDialog.findViewById(R.id.btn_time);
        txtTime = (TextView) myDialog.findViewById(R.id.txt_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(ChatActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        txtTime.setText(hourOfDay + ":" + minute);
                        time = hourOfDay + ":" + minute;
                    }
                }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        txtName = (EditText) myDialog.findViewById(R.id.name_of_appointment);

        btnConfirm = (Button) myDialog.findViewById(R.id.btn_confirm);
        txt_name = (TextView) findViewById(R.id.appoint_name);
        txt_date = (TextView) findViewById(R.id.appoint_date);
        txt_time = (TextView) findViewById(R.id.appoint_time);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                if (!name.equals("")) txt_name.setText(name);
                txt_date.setText(date);
                txt_time.setText(time);
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
