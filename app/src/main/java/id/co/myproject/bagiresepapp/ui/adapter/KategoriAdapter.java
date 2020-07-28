package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.ItemKategoriBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Kategori;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

    Context context;
    List<Kategori> kategoriList = new ArrayList<>();

    public KategoriAdapter(Context context) {
        this.context = context;
    }

    public void setKategoriList(List<Kategori> kategoriList) {
        this.kategoriList.clear();
        this.kategoriList.addAll(kategoriList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KategoriAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemKategoriBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_kategori, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriAdapter.ViewHolder holder, int position) {
        Kategori kategori = kategoriList.get(position);
        holder.binding.setKategori(kategori);
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemKategoriBinding binding;
        public ViewHolder(@NonNull ItemKategoriBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
