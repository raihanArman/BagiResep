package id.co.myproject.bagiresepapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.databinding.ItemBahanInputBinding;
import id.co.myproject.bagiresepapp.databinding.LayoutBahanInputBinding;
import id.co.myproject.bagiresepapp.ui.AddResepActivity;
import id.co.myproject.bagiresepapp.ui.listener.BahanListener;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.viewmodel.AddResepViewModel;

public class BahanInputAdapter extends RecyclerView.Adapter<BahanInputAdapter.ViewHolder> {

    AddResepViewModel viewModel;
    BahanListener bahanListener;
    CallbackInterface callbackInterface;
    BahanGambarInputAdapter adapter;
    Context context;
    List<BahanEntity> bahanList = new ArrayList<>();

    public interface CallbackInterface{
        void onHandleIntent(int idBahan, int position, int type);
    }

    public BahanInputAdapter(Context context, AddResepViewModel viewModel, BahanListener bahanListener) {
        this.context = context;
        this.viewModel = viewModel;
        this.bahanListener = bahanListener;
        try{
            callbackInterface = (CallbackInterface) context;
        }catch(ClassCastException ex){
            //.. should log the error or throw and exception
            Log.e("MyAdapter","Must implement the CallbackInterface in the Activity", ex);
        }
    }

    public void setBahanList(List<BahanEntity> bahanList){
        this.bahanList.clear();
        this.bahanList.addAll(bahanList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BahanInputAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBahanInputBinding bahanInputBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bahan_input, parent, false);
        return new ViewHolder(bahanInputBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BahanInputAdapter.ViewHolder holder, int position) {
        BahanEntity bahanEntity = bahanList.get(position);
        holder.bahanInputBinding.setBahan(bahanEntity);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.bahanInputBinding.rvBahanGambar.setLayoutManager(layoutManager);
        adapter = new BahanGambarInputAdapter(context, viewModel);
        holder.bahanInputBinding.rvBahanGambar.setAdapter(adapter);

        loadGambar(bahanEntity.getId(), position, false);

        holder.bahanInputBinding.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.getBahanGambarMutable(bahanEntity.getId()).size() > 0){
                    viewModel.removeBahanGambarByIdBahan(bahanEntity.getId());
                }
                viewModel.removeBahan(bahanEntity.getId());
                removeBahan(position);
                bahanListener.onBahanListener(bahanEntity.getBahan()+" berhasil dihapus");
            }
        });

        holder.bahanInputBinding.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit Bahan");
                builder.setMessage("Edit bahan masakan anda");
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutBahanInputBinding bahanInputBinding = DataBindingUtil.inflate(inflater, R.layout.layout_bahan_input, null, false);
                bahanInputBinding.etBahan.setText(bahanEntity.getBahan());
                builder.setView(bahanInputBinding.getRoot());
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.updateBahan(bahanEntity.getId(), bahanInputBinding.etBahan.getText().toString());
                        bahanListener.onBahanListener("Berhasil diedit");
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        holder.bahanInputBinding.ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackInterface != null){
                    callbackInterface.onHandleIntent(bahanEntity.getId(), position, Utils.TYPE_INPUT_BAHAN);
                }
            }
        });

    }

    public void loadGambar(int idBahan, int position, boolean inputImage) {
        adapter.setBahanGambarEntityList(viewModel.getBahanGambarMutable(idBahan));
        if (inputImage) {
            notifyItemChanged(position);
        }
    }

    @Override
    public int getItemCount() {
        return bahanList.size();
    }

    private void removeBahan(int position){
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemBahanInputBinding bahanInputBinding;
        public ViewHolder(@NonNull ItemBahanInputBinding itemView) {
            super(itemView.getRoot());
            bahanInputBinding = itemView;
        }
    }
}
