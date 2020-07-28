package id.co.myproject.bagiresepapp.ui.adapter;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.databinding.ItemLangkahInputBinding;
import id.co.myproject.bagiresepapp.databinding.LayoutBahanInputBinding;
import id.co.myproject.bagiresepapp.ui.AddResepActivity;
import id.co.myproject.bagiresepapp.ui.listener.LangkahListener;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.viewmodel.AddResepViewModel;

public class LangkahInputAdapter extends RecyclerView.Adapter<LangkahInputAdapter.ViewHolder> {
    Context context;
    List<LangkahEntity> langkahEntityList = new ArrayList<>();
    AddResepViewModel viewModel;
    LangkahListener langkahListener;
    CallbackInterfaceLangkah interfaceLangkah;
    LangkahGambarInputAdapter gambarInputAdapter;

    public interface CallbackInterfaceLangkah{
        void onHandleIntentLangkah(int idLangkah, int position, int type);
    }

    public LangkahInputAdapter(Context context, AddResepViewModel viewModel, LangkahListener langkahListener) {
        this.context = context;
        this.viewModel = viewModel;
        this.langkahListener = langkahListener;
        try{
           interfaceLangkah  = (CallbackInterfaceLangkah) context;
        }catch(ClassCastException ex){
            //.. should log the error or throw and exception
            Log.e("MyAdapter","Must implement the CallbackInterface in the Activity", ex);
        }
    }

    public void setLangkahEntityList(List<LangkahEntity> langkahEntityList){
        this.langkahEntityList.clear();
        this.langkahEntityList.addAll(langkahEntityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LangkahInputAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLangkahInputBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_langkah_input, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LangkahInputAdapter.ViewHolder holder, int position) {
        LangkahEntity langkahEntity = langkahEntityList.get(position);
        holder.langkahInputBinding.setLangkah(langkahEntity);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.langkahInputBinding.rvLangkahGambar.setLayoutManager(layoutManager);
        gambarInputAdapter = new LangkahGambarInputAdapter(context, viewModel);
        holder.langkahInputBinding.rvLangkahGambar.setAdapter(gambarInputAdapter);

        loadGambar(langkahEntity.getId(), position, false);

        holder.langkahInputBinding.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.getLangkahGambarMutable(langkahEntity.getId()).size() > 0){
                    viewModel.removeLangkahGambarByIdLangkah(langkahEntity.getId());
                }
                viewModel.removeLangkahById(langkahEntity.getId());
                removeLangkah(position);
                langkahListener.onLangkahListener(langkahEntity.getLangkah()+" Berhasil dihapus");
            }
        });

        holder.langkahInputBinding.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit Langkah");
                builder.setMessage("Edit langkah resep anda");
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutBahanInputBinding langkahViewBinding = DataBindingUtil.inflate(inflater, R.layout.layout_bahan_input, null, false);
                builder.setView(langkahViewBinding.getRoot());
                langkahViewBinding.etBahan.setHint("Masukkan langkah resep anda");
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        viewModel.updateLangkah(langkahEntity.getId(), langkahViewBinding.etBahan.getText().toString());
                        langkahListener.onLangkahListener("Berhasil di edit");
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

        holder.langkahInputBinding.ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interfaceLangkah != null) {
                    interfaceLangkah.onHandleIntentLangkah(langkahEntity.getId(), position, Utils.TYPE_INPUT_LANGKAH);
                }
            }
        });
    }

    private void removeLangkah(int position){
        notifyItemRemoved(position);
    }

    public void loadGambar(int idLangkah, int position, boolean inputImage) {
        gambarInputAdapter.setLangkahGambarEntityList(viewModel.getLangkahGambarMutable(idLangkah));
        if (inputImage) {
            notifyItemChanged(position);
        }
    }

    @Override
    public int getItemCount() {
        return langkahEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemLangkahInputBinding langkahInputBinding;
        public ViewHolder(@NonNull ItemLangkahInputBinding itemView) {
            super(itemView.getRoot());
            langkahInputBinding = itemView;
        }
    }
}
