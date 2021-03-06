// Generated by data binding compiler. Do not edit!
package id.co.myproject.bagiresepapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemResepHomeBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivResep;

  @NonNull
  public final LinearLayout lvComment;

  @Bindable
  protected Resep mResep;

  protected ItemResepHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivResep, LinearLayout lvComment) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivResep = ivResep;
    this.lvComment = lvComment;
  }

  public abstract void setResep(@Nullable Resep resep);

  @Nullable
  public Resep getResep() {
    return mResep;
  }

  @NonNull
  public static ItemResepHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_resep_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemResepHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemResepHomeBinding>inflateInternal(inflater, R.layout.item_resep_home, root, attachToRoot, component);
  }

  @NonNull
  public static ItemResepHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_resep_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemResepHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemResepHomeBinding>inflateInternal(inflater, R.layout.item_resep_home, null, false, component);
  }

  public static ItemResepHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemResepHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemResepHomeBinding)bind(component, view, R.layout.item_resep_home);
  }
}
