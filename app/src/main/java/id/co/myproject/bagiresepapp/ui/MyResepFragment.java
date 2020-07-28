package id.co.myproject.bagiresepapp.ui;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.databinding.FragmentMyResepBinding;
import id.co.myproject.bagiresepapp.ui.adapter.RencanaAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.ResepAkunAdapter;
import id.co.myproject.bagiresepapp.ui.listener.ResepListener;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.viewmodel.MyResepViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyResepFragment extends Fragment implements ResepListener {

    private MyResepViewModel myResepViewModel;
    ViewModelProvider.Factory factory;
    private FragmentMyResepBinding binding;
    SharedPreferences sharedPreferences;
    String idUser;

    private RencanaAdapter rencanaAdapter;
    private RencanaAdapter sudahBuatAdapter;
    private ResepAkunAdapter resepAkunAdapter;

    public MyResepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_resep, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences(Utils.LOGIN_KEY, Context.MODE_PRIVATE);
        idUser = sharedPreferences.getString(Utils.ID_USER_KEY, "");
        myResepViewModel = ViewModelProviders.of(this, factory).get(MyResepViewModel.class);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);

        binding.rvRencana.setLayoutManager(layoutManager);
        binding.rvResepSaya.setLayoutManager(layoutManager2);
        binding.rvSudahBuat.setLayoutManager(layoutManager3);

        rencanaAdapter = new RencanaAdapter(getActivity(), this, myResepViewModel);
        resepAkunAdapter = new ResepAkunAdapter(getActivity(), this);
        sudahBuatAdapter = new RencanaAdapter(getActivity(), this, myResepViewModel);

        binding.rvResepSaya.setAdapter(resepAkunAdapter);
        binding.rvRencana.setAdapter(rencanaAdapter);
        binding.rvSudahBuat.setAdapter(sudahBuatAdapter);

        loadRencana();
        loadMyResep();
        loadSudahBuat();
        loadSedangBuat();

        binding.btnTambahResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddResepActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loadSedangBuat() {
        String resepSedangBuat = sharedPreferences.getString(Utils.MASAK_KEY, "");
        if (!resepSedangBuat.equals("")){
            binding.rlSedangBuat.setVisibility(View.VISIBLE);
            myResepViewModel.getResepByIdMutable(resepSedangBuat)
                    .observe(getActivity(), new Observer<ResepResponse>() {
                        @Override
                        public void onChanged(ResepResponse resepResponse) {
                            binding.setResep(resepResponse.getResepList().get(0));
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            params.setMargins(0, 0, 0, 140);
                            binding.lvSudahBuat.setLayoutParams(params);
                        }
                    });
        }else {
            binding.rlSedangBuat.setVisibility(View.GONE);
        }
    }

    private void loadSudahBuat() {
        myResepViewModel.getSudahMasakMutable(idUser)
                .observe(this, new Observer<List<RencanaEntity>>() {
                    @Override
                    public void onChanged(List<RencanaEntity> rencanaEntities) {
                        sudahBuatAdapter.setResepList(rencanaEntities);
                    }
                });
    }

    private void loadMyResep() {
        myResepViewModel.getMyResepMutableLiveData(idUser)
                .observe(this, new Observer<ResepResponse>() {
                    @Override
                    public void onChanged(ResepResponse resepResponse) {
                        resepAkunAdapter.setResepList(resepResponse.getResepList());
                    }
                });
    }

    private void loadRencana() {
        myResepViewModel.getRencanaMutable(idUser)
                .observe(this, new Observer<List<RencanaEntity>>() {
                    @Override
                    public void onChanged(List<RencanaEntity> rencanaEntities) {
                        rencanaAdapter.setResepList(rencanaEntities);
                    }
                });
    }

    @Override
    public void onResepClickListener(ImageView imageView, Resep resep) {
        Intent intent = new Intent(getActivity(), DetailResepActivity.class);
        intent.putExtra("id_resep", resep.getId());
        intent.putExtra("resep", resep);
        intent.putExtra(Utils.INTENT_DETAIL_KEY, Utils.TYPE_INTENT_RENCANA);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                imageView, "image_resep");
        startActivity(intent, options.toBundle());
    }
}
