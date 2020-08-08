package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemResepPopularBindingImpl extends ItemResepPopularBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.lv_comment, 10);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    @NonNull
    private final android.widget.TextView mboundView6;
    @NonNull
    private final android.widget.TextView mboundView7;
    @NonNull
    private final android.widget.TextView mboundView8;
    @NonNull
    private final android.widget.TextView mboundView9;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemResepPopularBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ItemResepPopularBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.LinearLayout) bindings[10]
            , (androidx.appcompat.widget.AppCompatRatingBar) bindings[3]
            );
        this.ivResep.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (android.widget.TextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (android.widget.TextView) bindings[9];
        this.mboundView9.setTag(null);
        this.ratingBar.setTag(null);
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
        java.lang.String resepWaktuMasak = null;
        java.lang.String resepJumKomentar = null;
        float floatParseFloatResepTotalRating = 0f;
        java.lang.String resepJumLike = null;
        java.lang.String stringFormatMboundView9AndroidStringGenerateJumlahKomentarResepJumKomentar = null;
        id.co.myproject.bagiresepapp.data.remote.model.Resep resep = mResep;
        java.lang.String resepTotalRating = null;
        java.lang.String stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps = null;
        java.lang.String resepTotalSteps = null;
        java.lang.String resepTotalUserRating = null;
        java.lang.String stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak = null;
        java.lang.String stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating = null;
        java.lang.String stringFormatMboundView8AndroidStringGenerateJumlahLikeResepJumLike = null;
        java.lang.String resepGambar = null;
        java.lang.String resepResep = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (resep != null) {
                    // read resep.waktuMasak
                    resepWaktuMasak = resep.getWaktuMasak();
                    // read resep.jumKomentar
                    resepJumKomentar = resep.getJumKomentar();
                    // read resep.jumLike
                    resepJumLike = resep.getJumLike();
                    // read resep.totalRating
                    resepTotalRating = resep.getTotalRating();
                    // read resep.totalSteps
                    resepTotalSteps = resep.getTotalSteps();
                    // read resep.totalUserRating
                    resepTotalUserRating = resep.getTotalUserRating();
                    // read resep.gambar
                    resepGambar = resep.getGambar();
                    // read resep.resep
                    resepResep = resep.getResep();
                }


                // read String.format(@android:string/generate_waktu_masak, resep.waktuMasak)
                stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak = java.lang.String.format(mboundView6.getResources().getString(R.string.generate_waktu_masak), resepWaktuMasak);
                // read String.format(@android:string/generate_jumlah_komentar, resep.jumKomentar)
                stringFormatMboundView9AndroidStringGenerateJumlahKomentarResepJumKomentar = java.lang.String.format(mboundView9.getResources().getString(R.string.generate_jumlah_komentar), resepJumKomentar);
                // read String.format(@android:string/generate_jumlah_like, resep.jumLike)
                stringFormatMboundView8AndroidStringGenerateJumlahLikeResepJumLike = java.lang.String.format(mboundView8.getResources().getString(R.string.generate_jumlah_like), resepJumLike);
                // read Float.parseFloat(resep.totalRating)
                floatParseFloatResepTotalRating = java.lang.Float.parseFloat(resepTotalRating);
                // read String.format(@android:string/generate_langkah, resep.totalSteps)
                stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps = java.lang.String.format(mboundView7.getResources().getString(R.string.generate_langkah), resepTotalSteps);
                // read String.format(@android:string/generate_total_user_rating, resep.totalUserRating)
                stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating = java.lang.String.format(mboundView5.getResources().getString(R.string.generate_total_user_rating), resepTotalUserRating);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.ivResep, resepGambar);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, resepResep);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, resepTotalRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringFormatMboundView5AndroidStringGenerateTotalUserRatingResepTotalUserRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, stringFormatMboundView6AndroidStringGenerateWaktuMasakResepWaktuMasak);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, stringFormatMboundView7AndroidStringGenerateLangkahResepTotalSteps);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, stringFormatMboundView8AndroidStringGenerateJumlahLikeResepJumLike);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, stringFormatMboundView9AndroidStringGenerateJumlahKomentarResepJumKomentar);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.ratingBar, floatParseFloatResepTotalRating);
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