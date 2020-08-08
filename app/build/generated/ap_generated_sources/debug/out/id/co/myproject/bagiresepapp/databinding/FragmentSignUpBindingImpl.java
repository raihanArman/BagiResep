package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignUpBindingImpl extends FragmentSignUpBinding implements id.co.myproject.bagiresepapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.et_email, 3);
        sViewsWithIds.put(R.id.et_nama, 4);
        sViewsWithIds.put(R.id.etPasswordLayout, 5);
        sViewsWithIds.put(R.id.et_password, 6);
        sViewsWithIds.put(R.id.p_item_1_parent, 7);
        sViewsWithIds.put(R.id.cv_karakter, 8);
        sViewsWithIds.put(R.id.p_item_2_parent, 9);
        sViewsWithIds.put(R.id.cv_uppercase, 10);
        sViewsWithIds.put(R.id.p_item_3_parent, 11);
        sViewsWithIds.put(R.id.cv_angka, 12);
        sViewsWithIds.put(R.id.et_confirm_password, 13);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentSignUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (androidx.cardview.widget.CardView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[8]
            , (androidx.cardview.widget.CardView) bindings[10]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[9]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.widget.ScrollView) bindings[0]
            , (android.widget.TextView) bindings[2]
            );
        this.btnSignUp.setTag(null);
        this.svSignIn.setTag(null);
        this.tvLogin.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 1);
        mCallback4 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 2);
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
        if (BR.signUp == variableId) {
            setSignUp((id.co.myproject.bagiresepapp.ui.login.ISignUpFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSignUp(@Nullable id.co.myproject.bagiresepapp.ui.login.ISignUpFragment SignUp) {
        this.mSignUp = SignUp;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.signUp);
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
        id.co.myproject.bagiresepapp.ui.login.ISignUpFragment signUp = mSignUp;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnSignUp.setOnClickListener(mCallback3);
            this.tvLogin.setOnClickListener(mCallback4);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // signUp != null
                boolean signUpJavaLangObjectNull = false;
                // signUp
                id.co.myproject.bagiresepapp.ui.login.ISignUpFragment signUp = mSignUp;



                signUpJavaLangObjectNull = (signUp) != (null);
                if (signUpJavaLangObjectNull) {


                    signUp.registerProses();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // signUp != null
                boolean signUpJavaLangObjectNull = false;
                // signUp
                id.co.myproject.bagiresepapp.ui.login.ISignUpFragment signUp = mSignUp;



                signUpJavaLangObjectNull = (signUp) != (null);
                if (signUpJavaLangObjectNull) {


                    signUp.goSignIn();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): signUp
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}