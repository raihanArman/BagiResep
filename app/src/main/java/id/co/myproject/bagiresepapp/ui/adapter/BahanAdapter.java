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
import id.co.myproject.bagiresepapp.databinding.ItemBahanBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;

public class BahanAdapter extends RecyclerView.Adapter<BahanAdapter.ViewHolder> {

    Context context;
    List<Bahan> bahanList = new ArrayList<>();

    public BahanAdapter(Context context) {
        this.context = context;
    }

    public void setBahanList(List<Bahan> bahanList) {
        this.bahanList.clear();
        this.bahanList.addAll(bahanList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BahanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBahanBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bahan, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BahanAdapter.ViewHolder holder, int position) {
        Bahan bahan = bahanList.get(position);
        holder.bahanBinding.setBahan(bahan);
    }

    @Override
    public int getItemCount() {
        return bahanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemBahanBinding bahanBinding;
        public ViewHolder(@NonNull ItemBahanBinding itemView) {
            super(itemView.getRoot());
            bahanBinding = itemView;
        }
    }
}
