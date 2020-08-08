package id.co.myproject.bagiresepapp.databinding;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemKomentarBindingImpl extends ItemKomentarBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.view, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemKomentarBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ItemKomentarBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[2]
            , (android.view.View) bindings[5]
            );
        this.ivUser.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvContent.setTag(null);
        this.tvDate.setTag(null);
        this.tvUsername.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.user == variableId) {
            setUser((id.co.myproject.bagiresepapp.data.remote.model.User) variable);
        }
        else if (BR.timeStampFormat == variableId) {
            setTimeStampFormat((id.co.myproject.bagiresepapp.util.TimeStampFormatter) variable);
        }
        else if (BR.komentar == variableId) {
            setKomentar((id.co.myproject.bagiresepapp.data.remote.model.Komentar) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable id.co.myproject.bagiresepapp.data.remote.model.User User) {
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    public void setTimeStampFormat(@Nullable id.co.myproject.bagiresepapp.util.TimeStampFormatter TimeStampFormat) {
        this.mTimeStampFormat = TimeStampFormat;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.timeStampFormat);
        super.requestRebind();
    }
    public void setKomentar(@Nullable id.co.myproject.bagiresepapp.data.remote.model.Komentar Komentar) {
        this.mKomentar = Komentar;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.komentar);
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
        id.co.myproject.bagiresepapp.data.remote.model.User user = mUser;
        java.lang.String komentarIsiKomentar = null;
        java.util.Date komentarTimestamp = null;
        id.co.myproject.bagiresepapp.util.TimeStampFormatter timeStampFormat = mTimeStampFormat;
        java.lang.String userNama = null;
        id.co.myproject.bagiresepapp.data.remote.model.Komentar komentar = mKomentar;
        java.lang.String timeStampFormatFormatKomentarTimestamp = null;
        java.lang.String userGambar = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (user != null) {
                    // read user.nama
                    userNama = user.getNama();
                    // read user.gambar
                    userGambar = user.getGambar();
                }
        }
        if ((dirtyFlags & 0xeL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (komentar != null) {
                        // read komentar.isiKomentar
                        komentarIsiKomentar = komentar.getIsiKomentar();
                    }
            }

                if (komentar != null) {
                    // read komentar.timestamp
                    komentarTimestamp = komentar.getTimestamp();
                }


                if (timeStampFormat != null) {
                    // read timeStampFormat.format(komentar.timestamp)
                    timeStampFormatFormatKomentarTimestamp = timeStampFormat.format(komentarTimestamp);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            id.co.myproject.bagiresepapp.util.GlideBindingAdapters.setImageUrl(this.ivUser, userGambar);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUsername, userNama);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvContent, komentarIsiKomentar);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvDate, timeStampFormatFormatKomentarTimestamp);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): timeStampFormat
        flag 2 (0x3L): komentar
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}