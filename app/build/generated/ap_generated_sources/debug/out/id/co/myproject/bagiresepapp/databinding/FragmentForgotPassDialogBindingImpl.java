package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentForgotPassDialogBindingImpl extends FragmentForgotPassDialogBinding implements id.co.myproject.bagiresepapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.etPasswordLayout, 3);
        sViewsWithIds.put(R.id.et_password, 4);
        sViewsWithIds.put(R.id.p_item_1_parent, 5);
        sViewsWithIds.put(R.id.cv_karakter, 6);
        sViewsWithIds.put(R.id.p_item_2_parent, 7);
        sViewsWithIds.put(R.id.cv_uppercase, 8);
        sViewsWithIds.put(R.id.p_item_3_parent, 9);
        sViewsWithIds.put(R.id.cv_angka, 10);
        sViewsWithIds.put(R.id.et_confirm_password, 11);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentForgotPassDialogBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentForgotPassDialogBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[10]
            , (androidx.cardview.widget.CardView) bindings[6]
            , (androidx.cardview.widget.CardView) bindings[8]
            , (android.widget.EditText) bindings[11]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.tvBatal.setTag(null);
        this.tvSelesai.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 1);
        mCallback2 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 2);
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
        if (BR.forgotDialog == variableId) {
            setForgotDialog((id.co.myproject.bagiresepapp.ui.login.IForgotPassDialog) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setForgotDialog(@Nullable id.co.myproject.bagiresepapp.ui.login.IForgotPassDialog ForgotDialog) {
        this.mForgotDialog = ForgotDialog;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.forgotDialog);
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
        id.co.myproject.bagiresepapp.ui.login.IForgotPassDialog forgotDialog = mForgotDialog;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.tvBatal.setOnClickListener(mCallback1);
            this.tvSelesai.setOnClickListener(mCallback2);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // forgotDialog != null
                boolean forgotDialogJavaLangObjectNull = false;
                // forgotDialog
                id.co.myproject.bagiresepapp.ui.login.IForgotPassDialog forgotDialog = mForgotDialog;



                forgotDialogJavaLangObjectNull = (forgotDialog) != (null);
                if (forgotDialogJavaLangObjectNull) {


                    forgotDialog.resetPassword();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // forgotDialog != null
                boolean forgotDialogJavaLangObjectNull = false;
                // forgotDialog
                id.co.myproject.bagiresepapp.ui.login.IForgotPassDialog forgotDialog = mForgotDialog;



                forgotDialogJavaLangObjectNull = (forgotDialog) != (null);
                if (forgotDialogJavaLangObjectNull) {


                    forgotDialog.resetPassword();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): forgotDialog
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}