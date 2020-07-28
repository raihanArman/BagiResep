package id.co.myproject.bagiresepapp.ui.listener;

import android.widget.ImageView;

import id.co.myproject.bagiresepapp.data.remote.model.Resep;

public interface ResepListener {
    void onResepClickListener(ImageView imageView, Resep resep);
}
