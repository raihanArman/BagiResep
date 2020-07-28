package id.co.myproject.bagiresepapp.ui.home;

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
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.databinding.FragmentHomeBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.ui.DetailResepActivity;
import id.co.myproject.bagiresepapp.ui.adapter.KategoriAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.PopularAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.ResepAdapter;
import id.co.myproject.bagiresepapp.ui.listener.ResepListener;
import id.co.myproject.bagiresepapp.viewmodel.KategoriViewModel;
import id.co.myproject.bagiresepapp.viewmodel.ResepViewModel;
import id.co.myproject.bagiresepapp.viewmodel.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ResepListener {

    private FragmentHomeBinding binding;
    KategoriAdapter kategoriAdapter;
    PopularAdapter popularAdapter;
    ResepAdapter resepAdapter;

    ResepViewModel resepViewModel;
    UserViewModel userViewModel;
    KategoriViewModel kategoriViewModel;
    ViewModelProvider.Factory factory;

    SharedPreferences sharedPreferences;
    String idUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        sharedPreferences = getActivity().getSharedPreferences(Utils.LOGIN_KEY, Context.MODE_PRIVATE);
        binding.setImageBgHome(R.drawable.bg_home);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        factory = new ViewModelProvider.NewInstanceFactory();
        kategoriViewModel = ViewModelProviders.of(this, factory).get(KategoriViewModel.class);
        resepViewModel = ViewModelProviders.of(this, factory).get(ResepViewModel.class);
        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);

        idUser = sharedPreferences.getString(Utils.ID_USER_KEY, "");

        kategoriAdapter = new KategoriAdapter(getActivity());
        resepAdapter = new ResepAdapter(getActivity(), this);
        popularAdapter = new PopularAdapter(getActivity());

        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(getActivity());
        layoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvKategori.setLayoutManager(layoutManagerHorizontal);
        LinearLayoutManager layoutManagerHorizontal1 = new LinearLayoutManager(getActivity());
        layoutManagerHorizontal1.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvPopular.setLayoutManager(layoutManagerHorizontal1);
        binding.rvResep.setLayoutManager(new LinearLayoutManager(getActivity()));

        binding.rvKategori.setAdapter(kategoriAdapter);
        binding.rvPopular.setAdapter(popularAdapter);
        binding.rvResep.setAdapter(resepAdapter);

        kategoriViewModel.getKategoriMutable().observe(this, new Observer<KategoriResponse>() {
            @Override
            public void onChanged(KategoriResponse kategoriResponse) {
                kategoriAdapter.setKategoriList(kategoriResponse.getKategoriList());
                Toast.makeText(getActivity(), "Size kategori : "+kategoriResponse.getKategoriList().size(), Toast.LENGTH_SHORT).show();
            }
        });

        resepViewModel.getResepMutable().observe(this, new Observer<ResepResponse>() {
            @Override
            public void onChanged(ResepResponse resepResponse) {
                resepAdapter.setResepList(resepResponse.getResepList());
            }
        });

        resepViewModel.getPopularMutable().observe(this, new Observer<ResepResponse>() {
            @Override
            public void onChanged(ResepResponse resepResponse) {
                popularAdapter.setResepList(resepResponse.getResepList());
            }
        });

        userViewModel.getUserMutable(idUser)
                .observe(this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse userResponse) {
                        binding.setUser(userResponse.getUser());
                    }
                });

    }

    @Override
    public void onResepClickListener(ImageView imageView, Resep resep) {
        Intent intent = new Intent(getActivity(), DetailResepActivity.class);
        intent.putExtra("id_resep", resep.getId());
        intent.putExtra("resep", resep);
        intent.putExtra(Utils.INTENT_DETAIL_KEY, Utils.TYPE_INTENT_RESEP);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                imageView, "image_resep");
        startActivity(intent, options.toBundle());

    }
}
