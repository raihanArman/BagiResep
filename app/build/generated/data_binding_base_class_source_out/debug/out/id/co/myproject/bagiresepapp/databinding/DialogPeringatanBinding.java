// Generated by data binding compiler. Do not edit!
package id.co.myproject.bagiresepapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogPeringatanBinding extends ViewDataBinding {
  @NonNull
  public final TextView btnCancel;

  @NonNull
  public final TextView btnHapus;

  @Bindable
  protected RencanaEntity mResep;

  protected DialogPeringatanBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView btnCancel, TextView btnHapus) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnHapus = btnHapus;
  }

  public abstract void setResep(@Nullable RencanaEntity resep);

  @Nullable
  public RencanaEntity getResep() {
    return mResep;
  }

  @NonNull
  public static DialogPeringatanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_peringatan, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogPeringatanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogPeringatanBinding>inflateInternal(inflater, R.layout.dialog_peringatan, root, attachToRoot, component);
  }

  @NonNull
  public static DialogPeringatanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_peringatan, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogPeringatanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogPeringatanBinding>inflateInternal(inflater, R.layout.dialog_peringatan, null, false, component);
  }

  public static DialogPeringatanBinding bind(@NonNull View view) {
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
  public static DialogPeringatanBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogPeringatanBinding)bind(component, view, R.layout.dialog_peringatan);
  }
}