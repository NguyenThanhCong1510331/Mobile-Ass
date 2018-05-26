package com.example.asus.ex3.Activity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.ex3.Database.OfflineDatabaseHelper;
import com.example.asus.ex3.Models.JobInfo;
import com.example.asus.ex3.R;
import com.example.asus.ex3.Util.UlTagHandler;
import com.example.asus.ex3.Util.UtilityJob;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JobDetailActivity extends AppCompatActivity {

    @BindView(R.id.liked) Button liked;
    @BindView(R.id.jobTitle) TextView jobTitle;
    @BindView(R.id.companyName) TextView company;
    @BindView(R.id.jobType) TextView jobType;
    @BindView(R.id.location) TextView location;
    @BindView(R.id.jobCreated) TextView jobCreated;
    @BindView(R.id.jobDescription) TextView jobDescription;
    @BindView(R.id.backBtn) ImageView backBtn;
    String howToApply;
    OfflineDatabaseHelper db;
    JobInfo jobInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        ButterKnife.bind(this);
        //Declare Database
        db=new OfflineDatabaseHelper(JobDetailActivity.this);
        //Get JobInfo
        jobInfo= UtilityJob.getInstance().getJobInfo();
        checkAlreadyLiked();
        initUI();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.checkExist(jobInfo.getJobId())){
                    db.deleteJob(jobInfo.getJobId());
                    liked.setText("Save");
                }
                else {
                    db.insertJob(jobInfo);
                    liked.setText("Move");
                }
            }
        });
    }

    private void checkAlreadyLiked(){
        if(db.checkExist(jobInfo.getJobId())){
            liked.setText("Move");
        }
        else{
            liked.setText("Save");
        }
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY,null, new UlTagHandler());
        } else {
            return Html.fromHtml(html,null,new UlTagHandler());
        }
    }
    private void initUI(){
        jobTitle.setText(jobInfo.getJobTitle());
        company.setText(jobInfo.getCompany());
        jobType.setText(jobInfo.getType());
        location.setText(jobInfo.getLocation());
        jobCreated.setText(jobInfo.getJobCreatedAt());
        jobDescription.setText(fromHtml(jobInfo.getDescription()));
        jobDescription.setMovementMethod(LinkMovementMethod.getInstance());
        howToApply =jobInfo.getHowToApply();
    }



}
