package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAddResepBindingImpl extends ActivityAddResepBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar_menu_add, 1);
        sViewsWithIds.put(R.id.iv_resep, 2);
        sViewsWithIds.put(R.id.layout_btn_add_image, 3);
        sViewsWithIds.put(R.id.tv_ganti_gambar, 4);
        sViewsWithIds.put(R.id.sp_kategori, 5);
        sViewsWithIds.put(R.id.et_resep, 6);
        sViewsWithIds.put(R.id.et_deskripsi, 7);
        sViewsWithIds.put(R.id.rv_bahan, 8);
        sViewsWithIds.put(R.id.lv_tambah_bahan, 9);
        sViewsWithIds.put(R.id.rv_langkah, 10);
        sViewsWithIds.put(R.id.lv_tambah_langkah, 11);
        sViewsWithIds.put(R.id.seekbar_waktu, 12);
        sViewsWithIds.put(R.id.textView10, 13);
        sViewsWithIds.put(R.id.tv_waktu, 14);
        sViewsWithIds.put(R.id.btn_publish, 15);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddResepBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityAddResepBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[15]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[6]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (com.jaygoo.widget.RangeSeekBar) bindings[12]
            , (android.widget.Spinner) bindings[5]
            , (android.widget.TextView) bindings[13]
            , (androidx.appcompat.widget.Toolbar) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[14]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}