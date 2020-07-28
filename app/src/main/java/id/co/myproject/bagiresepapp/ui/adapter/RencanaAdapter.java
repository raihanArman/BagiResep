package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.databinding.DialogPeringatanBinding;
import id.co.myproject.bagiresepapp.databinding.ItemRencanaBinding;
import id.co.myproject.bagiresepapp.ui.listener.ResepListener;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.viewmodel.MyResepViewModel;

public class RencanaAdapter extends RecyclerView.Adapter<RencanaAdapter.ViewHolder> {

    List<RencanaEntity> resepList = new ArrayList<>();
    Context context;
    ResepListener resepListener;
    MyResepViewModel viewModel;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public RencanaAdapter(Context context, ResepListener resepListener, MyResepViewModel viewModel){
        this.context = context;
        this.resepListener = resepListener;
        this.viewModel = viewModel;
        preferences = context.getSharedPreferences(Utils.LOGIN_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setResepList(List<RencanaEntity> resepList){
        this.resepList.clear();
        this.resepList.addAll(resepList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RencanaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRencanaBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_rencana, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RencanaAdapter.ViewHolder holder, int position) {
        RencanaEntity entity = resepList.get(position);
        holder.binding.setEntity(entity);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resep resep = new Resep(entity.getIdResep(), entity.getIdUser());
                resepListener.onResepClickListener(holder.binding.ivResep, resep);
            }
        });
        holder.binding.lvHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                DialogPeringatanBinding peringatanBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_peringatan, null, false);
                peringatanBinding.setResep(entity);
                builder.setView(peringatanBinding.getRoot());
                AlertDialog alertDialog = builder.create();
                peringatanBinding.btnHapus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewModel.removeRencana(entity.getId());
                        if (preferences.getString(Utils.MASAK_KEY, "").equals(entity.getIdResep())){
                            editor.putString(Utils.MASAK_KEY, "");
                            editor.commit();
                        }
                        removeList(position);
                        alertDialog.dismiss();
                    }
                });
                peringatanBinding.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return resepList.size();
    }

    private void removeList(int position){
        resepList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRencanaBinding binding;
        public ViewHolder(@NonNull ItemRencanaBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
