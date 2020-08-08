package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentMyResepBindingImpl extends FragmentMyResepBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView5, 3);
        sViewsWithIds.put(R.id.linearLayout, 4);
        sViewsWithIds.put(R.id.tv_daftar_rencana, 5);
        sViewsWithIds.put(R.id.rv_rencana, 6);
        sViewsWithIds.put(R.id.tv_koleksi, 7);
        sViewsWithIds.put(R.id.tv_ket, 8);
        sViewsWithIds.put(R.id.btn_tambah_resep, 9);
        sViewsWithIds.put(R.id.iv_lainnya, 10);
        sViewsWithIds.put(R.id.rv_resep_saya, 11);
        sViewsWithIds.put(R.id.lv_sudah_buat, 12);
        sViewsWithIds.put(R.id.rv_sudah_buat, 13);
        sViewsWithIds.put(R.id.rl_sedang_buat, 14);
        sViewsWithIds.put(R.id.cv_resep, 15);
        sViewsWithIds.put(R.id.textView8, 16);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentMyResepBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentMyResepBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageView) bindings[10]
            , (android.widget.RelativeLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[14]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
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
            setResep((id.co.myproject.bagiresepapp.data.remote.model.Resep) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResep(@Nullable id.co.myproject.bagiresepapp.data.remote.model.Resep Resep) {
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
        id.co.myproject.bagiresepapp.data.remote.model.Resep resep = mResep;
        java.lang.String resepGambar = null;
        java.lang.String resepResep = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (resep != null) {
                    // read resep.gambar
                    resepGambar = resep.getGambar();
                    // read resep.resep
                    resepResep = resep.getResep();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.mboundView1, resepGambar);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, resepResep);
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