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
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.databinding.ItemLangkahGambarInputBinding;
import id.co.myproject.bagiresepapp.viewmodel.AddResepViewModel;

public class LangkahGambarInputAdapter extends RecyclerView.Adapter<LangkahGambarInputAdapter.ViewHolder> {
    Context context;
    List<LangkahGambarEntity> langkahGambarEntityList = new ArrayList<>();
    AddResepViewModel viewModel;

    public LangkahGambarInputAdapter(Context context, AddResepViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
    }

    public void setLangkahGambarEntityList(List<LangkahGambarEntity> langkahGambarEntityList){
        this.langkahGambarEntityList.clear();
        this.langkahGambarEntityList.addAll(langkahGambarEntityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LangkahGambarInputAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLangkahGambarInputBinding langkahGambarInputBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_langkah_gambar_input, parent, false);
        return new ViewHolder(langkahGambarInputBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LangkahGambarInputAdapter.ViewHolder holder, int position) {
        LangkahGambarEntity entity = langkahGambarEntityList.get(position);
        holder.binding.setLangkah(entity);

        holder.binding.tvHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.removeLangkahGambarById(entity.getIdLangkah());
                Toast.makeText(context, "Berhasil hapus gambar", Toast.LENGTH_SHORT).show();
                removeList(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return langkahGambarEntityList.size();
    }

    private void removeList(int position){
        langkahGambarEntityList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemLangkahGambarInputBinding binding;
        public ViewHolder(@NonNull ItemLangkahGambarInputBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
