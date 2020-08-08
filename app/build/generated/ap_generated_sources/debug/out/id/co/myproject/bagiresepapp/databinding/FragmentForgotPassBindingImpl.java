package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentForgotPassBindingImpl extends FragmentForgotPassBinding implements id.co.myproject.bagiresepapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView2, 3);
        sViewsWithIds.put(R.id.textView, 4);
        sViewsWithIds.put(R.id.textView3, 5);
        sViewsWithIds.put(R.id.et_forgot_password_email, 6);
        sViewsWithIds.put(R.id.textView4, 7);
        sViewsWithIds.put(R.id.forgot_password_email_container, 8);
        sViewsWithIds.put(R.id.forgot_password_email_icon, 9);
        sViewsWithIds.put(R.id.forgot_password_email_text, 10);
        sViewsWithIds.put(R.id.forgot_password_progress, 11);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentForgotPassBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentForgotPassBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.EditText) bindings[6]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ProgressBar) bindings[11]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[2]
            );
        this.btnResetPassword.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvResetPasswordGoBack.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 1);
        mCallback6 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.forgotPass == variableId) {
            setForgotPass((id.co.myproject.bagiresepapp.ui.login.IForgotPass) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setForgotPass(@Nullable id.co.myproject.bagiresepapp.ui.login.IForgotPass ForgotPass) {
        this.mForgotPass = ForgotPass;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.forgotPass);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        id.co.myproject.bagiresepapp.ui.login.IForgotPass forgotPass = mForgotPass;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnResetPassword.setOnClickListener(mCallback5);
            this.tvResetPasswordGoBack.setOnClickListener(mCallback6);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // forgotPass
                id.co.myproject.bagiresepapp.ui.login.IForgotPass forgotPass = mForgotPass;
                // forgotPass != null
                boolean forgotPassJavaLangObjectNull = false;



                forgotPassJavaLangObjectNull = (forgotPass) != (null);
                if (forgotPassJavaLangObjectNull) {


                    forgotPass.checkEmail();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // forgotPass
                id.co.myproject.bagiresepapp.ui.login.IForgotPass forgotPass = mForgotPass;
                // forgotPass != null
                boolean forgotPassJavaLangObjectNull = false;



                forgotPassJavaLangObjectNull = (forgotPass) != (null);
                if (forgotPassJavaLangObjectNull) {


                    forgotPass.goBack();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): forgotPass
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}