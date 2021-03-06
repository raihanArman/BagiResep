// Generated by data binding compiler. Do not edit!
package id.co.myproject.bagiresepapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLangkahInputBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivCamera;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final RecyclerView rvLangkahGambar;

  @NonNull
  public final TextView tvNasioa;

  @Bindable
  protected LangkahEntity mLangkah;

  protected ItemLangkahInputBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivCamera, ImageView ivDelete, ImageView ivEdit, RecyclerView rvLangkahGambar,
      TextView tvNasioa) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivCamera = ivCamera;
    this.ivDelete = ivDelete;
    this.ivEdit = ivEdit;
    this.rvLangkahGambar = rvLangkahGambar;
    this.tvNasioa = tvNasioa;
  }

  public abstract void setLangkah(@Nullable LangkahEntity langkah);

  @Nullable
  public LangkahEntity getLangkah() {
    return mLangkah;
  }

  @NonNull
  public static ItemLangkahInputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_langkah_input, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLangkahInputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLangkahInputBinding>inflateInternal(inflater, R.layout.item_langkah_input, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLangkahInputBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_langkah_input, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLangkahInputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLangkahInputBinding>inflateInternal(inflater, R.layout.item_langkah_input, null, false, component);
  }

  public static ItemLangkahInputBinding bind(@NonNull View view) {
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
  public static ItemLangkahInputBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLangkahInputBinding)bind(component, view, R.layout.item_langkah_input);
  }
}
