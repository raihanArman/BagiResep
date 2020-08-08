package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemLangkahGambarInputBindingImpl extends ItemLangkahGambarInputBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cv_img, 2);
        sViewsWithIds.put(R.id.tv_hapus, 3);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemLangkahGambarInputBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemLangkahGambarInputBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.ivGambar.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
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
        if (BR.langkah == variableId) {
            setLangkah((id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLangkah(@Nullable id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity Langkah) {
        this.mLangkah = Langkah;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.langkah);
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
        id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity langkah = mLangkah;
        java.lang.String langkahGambar = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (langkah != null) {
                    // read langkah.gambar
                    langkahGambar = langkah.getGambar();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageBitmap(this.ivGambar, langkahGambar);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): langkah
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}