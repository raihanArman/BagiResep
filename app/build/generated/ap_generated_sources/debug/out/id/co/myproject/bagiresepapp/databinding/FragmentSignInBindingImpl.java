package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignInBindingImpl extends FragmentSignInBinding implements id.co.myproject.bagiresepapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.fm, 4);
        sViewsWithIds.put(R.id.tv_email, 5);
        sViewsWithIds.put(R.id.et_email, 6);
        sViewsWithIds.put(R.id.et_pass_layout, 7);
        sViewsWithIds.put(R.id.et_password, 8);
    }
    // views
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSignInBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentSignInBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[2]
            , (android.widget.EditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (android.widget.FrameLayout) bindings[4]
            , (android.widget.ScrollView) bindings[0]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.btnSignIn.setTag(null);
        this.svSignIn.setTag(null);
        this.tvLupaPassword.setTag(null);
        this.tvSignUp.setTag(null);
        setRootTag(root);
        // listeners
        mCallback9 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 3);
        mCallback7 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 1);
        mCallback8 = new id.co.myproject.bagiresepapp.generated.callback.OnClickListener(this, 2);
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
        if (BR.signIn == variableId) {
            setSignIn((id.co.myproject.bagiresepapp.ui.login.ISignInFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSignIn(@Nullable id.co.myproject.bagiresepapp.ui.login.ISignInFragment SignIn) {
        this.mSignIn = SignIn;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.signIn);
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
        id.co.myproject.bagiresepapp.ui.login.ISignInFragment signIn = mSignIn;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnSignIn.setOnClickListener(mCallback8);
            this.tvLupaPassword.setOnClickListener(mCallback7);
            this.tvSignUp.setOnClickListener(mCallback9);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // signIn != null
                boolean signInJavaLangObjectNull = false;
                // signIn
                id.co.myproject.bagiresepapp.ui.login.ISignInFragment signIn = mSignIn;



                signInJavaLangObjectNull = (signIn) != (null);
                if (signInJavaLangObjectNull) {


                    signIn.goSignUp();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // signIn != null
                boolean signInJavaLangObjectNull = false;
                // signIn
                id.co.myproject.bagiresepapp.ui.login.ISignInFragment signIn = mSignIn;



                signInJavaLangObjectNull = (signIn) != (null);
                if (signInJavaLangObjectNull) {


                    signIn.goForgotPass();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // signIn != null
                boolean signInJavaLangObjectNull = false;
                // signIn
                id.co.myproject.bagiresepapp.ui.login.ISignInFragment signIn = mSignIn;



                signInJavaLangObjectNull = (signIn) != (null);
                if (signInJavaLangObjectNull) {


                    signIn.loginProses();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): signIn
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}