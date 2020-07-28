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
import id.co.myproject.bagiresepapp.databinding.ItemStepsBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {

    Context context;
    List<Steps> stepsList = new ArrayList<>();

    public StepAdapter(Context context) {
        this.context = context;
    }

    public void setStepsList(List<Steps> stepsList) {
        this.stepsList.clear();
        this.stepsList.addAll(stepsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StepAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStepsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_steps, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdapter.ViewHolder holder, int position) {
        Steps steps = stepsList.get(position);
        holder.binding.setSteps(steps);
    }

    @Override
    public int getItemCount() {
        return stepsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemStepsBinding binding;
        public ViewHolder(ItemStepsBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
