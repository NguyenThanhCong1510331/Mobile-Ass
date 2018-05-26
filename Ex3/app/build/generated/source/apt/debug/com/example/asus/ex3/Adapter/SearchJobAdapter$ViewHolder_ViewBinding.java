// Generated code from Butter Knife. Do not modify!
package com.example.asus.ex3.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.asus.ex3.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchJobAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SearchJobAdapter.ViewHolder target;

  @UiThread
  public SearchJobAdapter$ViewHolder_ViewBinding(SearchJobAdapter.ViewHolder target, View source) {
    this.target = target;

    target.companyLogo = Utils.findRequiredViewAsType(source, R.id.companyLogo, "field 'companyLogo'", ImageView.class);
    target.titleJob = Utils.findRequiredViewAsType(source, R.id.titleJob, "field 'titleJob'", TextView.class);
    target.companyName = Utils.findRequiredViewAsType(source, R.id.companyName, "field 'companyName'", TextView.class);
    target.typeJob = Utils.findRequiredViewAsType(source, R.id.typeJob, "field 'typeJob'", TextView.class);
    target.location = Utils.findRequiredViewAsType(source, R.id.location, "field 'location'", TextView.class);
    target.createdAt = Utils.findRequiredViewAsType(source, R.id.createdAt, "field 'createdAt'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchJobAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.companyLogo = null;
    target.titleJob = null;
    target.companyName = null;
    target.typeJob = null;
    target.location = null;
    target.createdAt = null;
  }
}
