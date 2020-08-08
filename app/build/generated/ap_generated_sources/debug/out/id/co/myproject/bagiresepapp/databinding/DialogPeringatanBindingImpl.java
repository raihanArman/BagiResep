package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogPeringatanBindingImpl extends DialogPeringatanBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btn_cancel, 2);
        sViewsWithIds.put(R.id.btn_hapus, 3);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogPeringatanBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private DialogPeringatanBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
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
        if (BR.resep == variableId) {
            setResep((id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResep(@Nullable id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity Resep) {
        this.mResep = Resep;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.resep);
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
        java.lang.String stringFormatMboundView1AndroidStringGeneratePeringatanRencanaResepTitleResep = null;
        id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity resep = mResep;
        java.lang.String resepTitleResep = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (resep != null) {
                    // read resep.titleResep
                    resepTitleResep = resep.getTitleResep();
                }


                // read String.format(@android:string/generate_peringatan_rencana, resep.titleResep)
                stringFormatMboundView1AndroidStringGeneratePeringatanRencanaResepTitleResep = java.lang.String.format(mboundView1.getResources().getString(R.string.generate_peringatan_rencana), resepTitleResep);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, stringFormatMboundView1AndroidStringGeneratePeringatanRencanaResepTitleResep);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): resep
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}