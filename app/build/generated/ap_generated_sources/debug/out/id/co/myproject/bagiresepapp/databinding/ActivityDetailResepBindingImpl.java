package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityDetailResepBindingImpl extends ActivityDetailResepBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(29);
        sIncludes.setIncludes(9, 
            new String[] {"layout_akun_user", "layout_comment"},
            new int[] {12, 13},
            new int[] {id.co.myproject.bagiresepapp.R.layout.layout_akun_user,
                id.co.myproject.bagiresepapp.R.layout.layout_comment});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 14);
        sViewsWithIds.put(R.id.col, 15);
        sViewsWithIds.put(R.id.cv_detail, 16);
        sViewsWithIds.put(R.id.iv_back, 17);
        sViewsWithIds.put(R.id.nested_scroll_view, 18);
        sViewsWithIds.put(R.id.iv_like, 19);
        sViewsWithIds.put(R.id.iv_bookmark, 20);
        sViewsWithIds.put(R.id.iv_share, 21);
        sViewsWithIds.put(R.id.rv_bahan, 22);
        sViewsWithIds.put(R.id.rv_steps, 23);
        sViewsWithIds.put(R.id.lv_bottom, 24);
        sViewsWithIds.put(R.id.lv_mulai_masak, 25);
        sViewsWithIds.put(R.id.lv_rencana, 26);
        sViewsWithIds.put(R.id.iv_rencana, 27);
        sViewsWithIds.put(R.id.tv_rencana, 28);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView10;
    @NonNull
    private final android.widget.TextView mboundView11;
    @NonNull
    private final de.hdodenhof.circleimageview.CircleImageView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.LinearLayout mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityDetailResepBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private ActivityDetailResepBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.material.appbar.AppBarLayout) bindings[14]
            , (com.google.android.material.appbar.CollapsingToolbarLayout) bindings[15]
            , (androidx.cardview.widget.CardView) bindings[16]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[21]
            , (id.co.myproject.bagiresepapp.databinding.LayoutCommentBinding) bindings[13]
            , (id.co.myproject.bagiresepapp.databinding.LayoutAkunUserBinding) bindings[12]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[26]
            , (androidx.core.widget.NestedScrollView) bindings[18]
            , (androidx.recyclerview.widget.RecyclerView) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[23]
            , (android.widget.TextView) bindings[28]
            );
        this.imageView3.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView10 = (android.widget.TextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView11 = (android.widget.TextView) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView2 = (de.hdodenhof.circleimageview.CircleImageView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView9 = (android.widget.LinearLayout) bindings[9];
        this.mboundView9.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        layoutProfil.invalidateAll();
        layoutKomentar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (layoutProfil.hasPendingBindings()) {
            return true;
        }
        if (layoutKomentar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.resep == variableId) {
            setResep((id.co.myproject.bagiresepapp.data.remote.model.Resep) variable);
        }
        else if (BR.user == variableId) {
            setUser((id.co.myproject.bagiresepapp.data.remote.model.User) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setResep(@Nullable id.co.myproject.bagiresepapp.data.remote.model.Resep Resep) {
        this.mResep = Resep;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.resep);
        super.requestRebind();
    }
    public void setUser(@Nullable id.co.myproject.bagiresepapp.data.remote.model.User User) {
        this.mUser = User;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        layoutProfil.setLifecycleOwner(lifecycleOwner);
        layoutKomentar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLayoutProfil((id.co.myproject.bagiresepapp.databinding.LayoutAkunUserBinding) object, fieldId);
            case 1 :
                return onChangeLayoutKomentar((id.co.myproject.bagiresepapp.databinding.LayoutCommentBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLayoutProfil(id.co.myproject.bagiresepapp.databinding.LayoutAkunUserBinding LayoutProfil, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutKomentar(id.co.myproject.bagiresepapp.databinding.LayoutCommentBinding LayoutKomentar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
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
        java.lang.String stringFormatMboundView10AndroidStringGenerateKategoriResepNamaKategori = null;
        java.lang.String resepWaktuMasak = null;
        java.lang.String resepNamaUser = null;
        id.co.myproject.bagiresepapp.data.remote.model.Resep resep = mResep;
        java.lang.String resepTotalRating = null;
        java.lang.String stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps = null;
        java.lang.String resepTotalSteps = null;
        java.lang.String resepGambarUser = null;
        java.lang.String resepTotalUserRating = null;
        java.lang.String stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak = null;
        java.lang.String stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating = null;
        java.lang.String resepNamaKategori = null;
        java.lang.String resepDeksripsi = null;
        java.lang.String resepResep = null;
        java.lang.String resepGambar = null;

        if ((dirtyFlags & 0x14L) != 0) {



                if (resep != null) {
                    // read resep.waktuMasak
                    resepWaktuMasak = resep.getWaktuMasak();
                    // read resep.nama_user
                    resepNamaUser = resep.getNama_user();
                    // read resep.totalRating
                    resepTotalRating = resep.getTotalRating();
                    // read resep.totalSteps
                    resepTotalSteps = resep.getTotalSteps();
                    // read resep.gambar_user
                    resepGambarUser = resep.getGambar_user();
                    // read resep.totalUserRating
                    resepTotalUserRating = resep.getTotalUserRating();
                    // read resep.nama_kategori
                    resepNamaKategori = resep.getNama_kategori();
                    // read resep.deksripsi
                    resepDeksripsi = resep.getDeksripsi();
                    // read resep.resep
                    resepResep = resep.getResep();
                    // read resep.gambar
                    resepGambar = resep.getGambar();
                }


                // read String.format(@android:string/generate_waktu_masak, resep.waktuMasak)
                stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak = java.lang.String.format(mboundView6.getResources().getString(R.string.generate_waktu_masak), resepWaktuMasak);
                // read String.format(@android:string/generate_langkah, resep.totalSteps)
                stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps = java.lang.String.format(mboundView7.getResources().getString(R.string.generate_langkah), resepTotalSteps);
                // read String.format(@android:string/generate_total_user_rating, resep.totalUserRating)
                stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating = java.lang.String.format(mboundView5.getResources().getString(R.string.generate_total_user_rating), resepTotalUserRating);
                // read String.format(@android:string/generate_kategori, resep.nama_kategori)
                stringFormatMboundView10AndroidStringGenerateKategoriResepNamaKategori = java.lang.String.format(mboundView10.getResources().getString(R.string.generate_kategori), resepNamaKategori);
        }
        // batch finished
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.imageView3, resepGambar);
            this.layoutProfil.setProfil(resep);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, resepResep);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, stringFormatMboundView10AndroidStringGenerateKategoriResepNamaKategori);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, resepDeksripsi);
            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.mboundView2, resepGambarUser);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, resepNamaUser);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, resepTotalRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps);
        }
        executeBindingsOn(layoutProfil);
        executeBindingsOn(layoutKomentar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): layoutProfil
        flag 1 (0x2L): layoutKomentar
        flag 2 (0x3L): resep
        flag 3 (0x4L): user
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}