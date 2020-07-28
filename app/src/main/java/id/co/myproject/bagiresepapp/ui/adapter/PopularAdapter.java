package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.ItemResepPopularBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.ui.DetailResepActivity;
import id.co.myproject.bagiresepapp.util.Utils;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    Context context;
    List<Resep> resepList = new ArrayList<>();

    public PopularAdapter(Context context) {
        this.context = context;
    }

    public void setResepList(List<Resep> resepList) {
        this.resepList.clear();
        this.resepList.addAll(resepList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemResepPopularBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_resep_popular, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        Resep resep = resepList.get(position);
        holder.binding.setResep(resep);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailResepActivity.class);
                intent.putExtra("id_resep", resep.getId());
                intent.putExtra("resep", resep);
                intent.putExtra(Utils.INTENT_DETAIL_KEY, Utils.TYPE_INTENT_RESEP);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemResepPopularBinding binding;
        public ViewHolder(@NonNull ItemResepPopularBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
