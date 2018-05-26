// Generated code from Butter Knife. Do not modify!
package com.example.asus.ex3.Activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.asus.ex3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class JobDetailActivity_ViewBinding implements Unbinder {
  private JobDetailActivity target;

  @UiThread
  public JobDetailActivity_ViewBinding(JobDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public JobDetailActivity_ViewBinding(JobDetailActivity target, View source) {
    this.target = target;

    target.liked = Utils.findRequiredViewAsType(source, R.id.liked, "field 'liked'", Button.class);
    target.jobTitle = Utils.findRequiredViewAsType(source, R.id.jobTitle, "field 'jobTitle'", TextView.class);
    target.company = Utils.findRequiredViewAsType(source, R.id.companyName, "field 'company'", TextView.class);
    target.jobType = Utils.findRequiredViewAsType(source, R.id.jobType, "field 'jobType'", TextView.class);
    target.location = Utils.findRequiredViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.jobCreated = Utils.findRequiredViewAsType(source, R.id.jobCreated, "field 'jobCreated'", TextView.class);
    target.jobDescription = Utils.findRequiredViewAsType(source, R.id.jobDescription, "field 'jobDescription'", TextView.class);
    target.backBtn = Utils.findRequiredViewAsType(source, R.id.backBtn, "field 'backBtn'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    JobDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.liked = null;
    target.jobTitle = null;
    target.company = null;
    target.jobType = null;
    target.location = null;
    target.jobCreated = null;
    target.jobDescription = null;
    target.backBtn = null;
  }
}
