package com.example.asus.ex3.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.ex3.GetRelatedJobs;
import com.example.asus.ex3.Models.JobInfo;
import com.example.asus.ex3.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    public static final String TAG = "PROFILE_FRAGMENT";
    ArrayList<JobInfo> jobsList = new ArrayList<>();
    @BindView(R.id.edtPosition)
    EditText edtPosition;
    @BindView(R.id.edtLocation)
    EditText edtLocation;
    @BindView(R.id.btnSave)
    Button btnSave;
    @BindView(R.id.spinnerSchedule)
    Spinner spinner;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = (TextView) spinner.getChildAt(0);
        if (text != null) {
            text.setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    @OnItemSelected(R.id.spinnerSchedule)
    public void spinnerItemSelected(Spinner spinner) {
        try {
            ((TextView) spinner.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorWhite));
        } catch (Exception e) {
            // DO NOTHING
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("PROFILE", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String position = sharedPreferences.getString("position", "");
        String location = sharedPreferences.getString("location", "");
        int schedule = sharedPreferences.getInt("schedule", 0);

        edtPosition.setText(position);
        edtLocation.setText(location);
        spinner.setSelection(schedule);

    }

    @OnClick(R.id.btnSave)
    public void btnSaveClick(View v) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("PROFILE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("position", edtPosition.getText().toString());
        editor.putString("location", edtLocation.getText().toString());
        editor.putInt("schedule", spinner.getSelectedItemPosition());
        editor.apply();

        Toast.makeText(getContext(), "Profile saved!", Toast.LENGTH_LONG).show();

        String schedule = (spinner.getSelectedItemPosition() == 0) ? "fulltime" : "parttime";
        String url = "https://jobs.search.gov/jobs/search.json?query="
                + schedule + "+" + edtPosition.getText().toString() + "+jobs+at+" + edtLocation.getText().toString();
        GetRelatedJobs getRelatedJobs = new GetRelatedJobs(getActivity());
        getRelatedJobs.execute(url);
    }

}
