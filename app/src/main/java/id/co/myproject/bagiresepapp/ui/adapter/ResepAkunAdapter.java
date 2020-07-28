package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.ItemResep2Binding;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.ui.listener.ResepListener;

public class ResepAkunAdapter extends RecyclerView.Adapter<ResepAkunAdapter.ViewHolder> {

    Context context;
    List<Resep> resepList = new ArrayList<>();
    ResepListener listener;

    public ResepAkunAdapter(Context context, ResepListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setResepList(List<Resep> resepList) {
        this.resepList.clear();
        this.resepList.addAll(resepList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResepAkunAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResep2Binding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_resep_2, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResepAkunAdapter.ViewHolder holder, int position) {
        Resep resep = resepList.get(position);
        holder.binding.setResep(resep);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onResepClickListener(holder.binding.ivResep, resep);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemResep2Binding binding;
        public ViewHolder(@NonNull ItemResep2Binding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
