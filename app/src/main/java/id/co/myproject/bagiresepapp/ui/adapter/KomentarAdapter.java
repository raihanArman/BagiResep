package id.co.myproject.bagiresepapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.ItemKomentarBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.util.TimeStampFormatter;
import id.co.myproject.bagiresepapp.viewmodel.DetailResepViewModel;

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.ViewHolder> {
    List<Komentar> komentarList = new ArrayList<>();
    Context context;
    TimeStampFormatter timeStampFormatter;
    DetailResepViewModel viewModel;

    public KomentarAdapter(Context context, TimeStampFormatter timeStampFormatter, DetailResepViewModel viewModel) {
        this.context = context;
        this.timeStampFormatter = timeStampFormatter;
        this.viewModel = viewModel;
    }

    public void setKomentarList(List<Komentar> komentarList){
        if (komentarList.size() > 0){
            this.komentarList.clear();
        }
        this.komentarList.addAll(komentarList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KomentarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemKomentarBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_komentar, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KomentarAdapter.ViewHolder holder, int position) {
        Komentar komentar = komentarList.get(position);
        holder.binding.setKomentar(komentar);
        holder.binding.setTimeStampFormat(timeStampFormatter);

        viewModel.getUserKomentarMutable(komentar.getIdUser())
                .observe((FragmentActivity)context, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse userResponse) {
                        if (userResponse.getValue() == 1){
                            holder.binding.setUser(userResponse.getUser());
                        }
                    }
                });

    }

    @Override
    public int getItemCount() {
        return komentarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemKomentarBinding binding;
        public ViewHolder(@NonNull ItemKomentarBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
