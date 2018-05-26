// Generated code from Butter Knife. Do not modify!
package com.example.asus.ex3.Fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.asus.ex3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileFragment_ViewBinding implements Unbinder {
  private ProfileFragment target;

  private View view2131296296;

  private View view2131296433;

  @UiThread
  public ProfileFragment_ViewBinding(final ProfileFragment target, View source) {
    this.target = target;

    View view;
    target.edtPosition = Utils.findRequiredViewAsType(source, R.id.edtPosition, "field 'edtPosition'", EditText.class);
    target.edtLocation = Utils.findRequiredViewAsType(source, R.id.edtLocation, "field 'edtLocation'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSave, "field 'btnSave' and method 'btnSaveClick'");
    target.btnSave = Utils.castView(view, R.id.btnSave, "field 'btnSave'", Button.class);
    view2131296296 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnSaveClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.spinnerSchedule, "field 'spinner' and method 'spinnerItemSelected'");
    target.spinner = Utils.castView(view, R.id.spinnerSchedule, "field 'spinner'", Spinner.class);
    view2131296433 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.spinnerItemSelected(Utils.castParam(p0, "onItemSelected", 0, "spinnerItemSelected", 0, Spinner.class));
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtPosition = null;
    target.edtLocation = null;
    target.btnSave = null;
    target.spinner = null;

    view2131296296.setOnClickListener(null);
    view2131296296 = null;
    ((AdapterView<?>) view2131296433).setOnItemSelectedListener(null);
    view2131296433 = null;
  }
}
