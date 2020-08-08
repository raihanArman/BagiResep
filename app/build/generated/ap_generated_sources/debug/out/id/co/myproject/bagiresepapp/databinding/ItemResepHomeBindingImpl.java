package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemResepHomeBindingImpl extends ItemResepHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lv_comment, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemResepHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemResepHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[5]
            );
        this.ivResep.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
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
        java.lang.String resepJumKomentar = null;
        java.lang.String stringFormatMboundView4AndroidStringGenerateJumlahKomentarResepJumKomentar = null;
        java.lang.String stringFormatMboundView3AndroidStringGenerateJumlahLikeResepJumLike = null;
        java.lang.String resepJumLike = null;
        java.lang.String resepGambar = null;
        java.lang.String resepResep = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (resep != null) {
                    // read resep.jumKomentar
                    resepJumKomentar = resep.getJumKomentar();
                    // read resep.jumLike
                    resepJumLike = resep.getJumLike();
                    // read resep.gambar
                    resepGambar = resep.getGambar();
                    // read resep.resep
                    resepResep = resep.getResep();
                }


                // read String.format(@android:string/generate_jumlah_komentar, resep.jumKomentar)
                stringFormatMboundView4AndroidStringGenerateJumlahKomentarResepJumKomentar = java.lang.String.format(mboundView4.getResources().getString(R.string.generate_jumlah_komentar), resepJumKomentar);
                // read String.format(@android:string/generate_jumlah_like, resep.jumLike)
                stringFormatMboundView3AndroidStringGenerateJumlahLikeResepJumLike = java.lang.String.format(mboundView3.getResources().getString(R.string.generate_jumlah_like), resepJumLike);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.ivResep, resepGambar);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, resepResep);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringFormatMboundView3AndroidStringGenerateJumlahLikeResepJumLike);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, stringFormatMboundView4AndroidStringGenerateJumlahKomentarResepJumKomentar);
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