package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.databinding.ItemBahanGambarInputBinding;
import id.co.myproject.bagiresepapp.viewmodel.AddResepViewModel;

public class BahanGambarInputAdapter extends RecyclerView.Adapter<BahanGambarInputAdapter.ViewHolder> {
    List<BahanGambarEntity> bahanGambarEntityList = new ArrayList<>();
    Context context;
    AddResepViewModel viewModel;

    public BahanGambarInputAdapter(Context context, AddResepViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    public void setBahanGambarEntityList(List<BahanGambarEntity> bahanGambarEntityList){
        this.bahanGambarEntityList.clear();
        this.bahanGambarEntityList.addAll(bahanGambarEntityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BahanGambarInputAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBahanGambarInputBinding  binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bahan_gambar_input, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BahanGambarInputAdapter.ViewHolder holder, int position) {
        BahanGambarEntity bahanGambarEntity = bahanGambarEntityList.get(position);
        holder.binding.setBahan(bahanGambarEntity);
        holder.binding.tvHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.removeBahanGambarById(bahanGambarEntity.getId());
                Toast.makeText(context, "Berhasil hapus gambar", Toast.LENGTH_SHORT).show();
                removeList(position);
            }
        });
    }

    private void removeList(int position){
        bahanGambarEntityList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return bahanGambarEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemBahanGambarInputBinding binding;
        public ViewHolder(@NonNull ItemBahanGambarInputBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
