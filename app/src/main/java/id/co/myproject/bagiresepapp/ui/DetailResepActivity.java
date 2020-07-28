package id.co.myproject.bagiresepapp.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Feedback;
import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.databinding.ActivityDetailResepBinding;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.BahanResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.KomentarResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.StepsResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import id.co.myproject.bagiresepapp.databinding.DialogFeedbackBinding;
import id.co.myproject.bagiresepapp.util.TimeStampFormatter;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.ui.adapter.BahanAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.KomentarAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.ResepAkunAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.StepAdapter;
import id.co.myproject.bagiresepapp.ui.listener.ResepListener;
import id.co.myproject.bagiresepapp.viewmodel.DetailResepViewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.UUID;

public class DetailResepActivity extends AppCompatActivity implements ResepListener {

    private ActivityDetailResepBinding binding;
    DetailResepViewModel resepViewModel;
    ViewModelProvider.Factory factory;

    StepAdapter stepAdapter;
    BahanAdapter bahanAdapter;
    KomentarAdapter komentarAdapter;
    ResepAkunAdapter resepAkunAdapter;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String idUser;
    String idResep;
    Resep resep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);

        idResep = getIntent().getStringExtra("id_resep");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_resep);
        sharedPreferences = getSharedPreferences(Utils.LOGIN_KEY, Context.MODE_PRIVATE);
        idUser = sharedPreferences.getString(Utils.ID_USER_KEY, "");
        editor = sharedPreferences.edit();

        resepViewModel = ViewModelProviders.of(this, factory).get(DetailResepViewModel.class);
        resep = getIntent().getParcelableExtra("resep");

        binding.col.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        binding.col.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);

        bahanAdapter = new BahanAdapter(this);
        stepAdapter = new StepAdapter(this);
        resepAkunAdapter = new ResepAkunAdapter(this, this);
        komentarAdapter = new KomentarAdapter(this, new TimeStampFormatter(), resepViewModel);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvBahan.setLayoutManager(new LinearLayoutManager(this));
        binding.rvSteps.setLayoutManager(new LinearLayoutManager(this));
        binding.layoutProfil.rvResepLainnya.setLayoutManager(layoutManager);
        binding.layoutKomentar.rvComment.setLayoutManager(new LinearLayoutManager(this));

        binding.rvBahan.setAdapter(bahanAdapter);
        binding.rvSteps.setAdapter(stepAdapter);
        binding.layoutKomentar.rvComment.setAdapter(komentarAdapter);

        loadDataResep();
        loadDataBahan();
        loadDataSteps();
        loadDataUser();
        loadKomentar();
        checkFollowers(resep);
        checkLike(resep);
        checkBookmark(idResep);
        checkRencana(idResep);


        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.ivLike.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(DetailResepActivity.this, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    addLike(resep);
                    return super.onDoubleTap(e);
                }
            });
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });



        binding.layoutKomentar.ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isiKomentar = binding.layoutKomentar.etKomentar.getText().toString();
                Komentar komentar = new Komentar();
                komentar.setIdResep(resep.getId());
                komentar.setIdUser(idUser);
                komentar.setIsiKomentar(isiKomentar);
                resepViewModel.getInputKomentarMutable(komentar)
                        .observe(DetailResepActivity.this, new Observer<Value>() {
                            @Override
                            public void onChanged(Value value) {
                                if (value.getValue() == 1){
                                    loadKomentar();
                                    binding.layoutKomentar.etKomentar.setText("");
                                }
                                Toast.makeText(DetailResepActivity.this, "Pesan : "+value.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    private void loadDataResep() {
        resepViewModel.getByIdMutable(idResep)
                .observe(this, new Observer<ResepResponse>() {
                    @Override
                    public void onChanged(ResepResponse resepResponse) {
                        if (resepResponse.getValue() == 1){
                            Resep resepData = resepResponse.getResepList().get(0);
                            binding.setResep(resepData);
                            resepAkunAdapter.setResepList(resepResponse.getResepList());
                            if (resepData.getId_user().equals(idUser)){
                                binding.layoutProfil.lvProfil.setVisibility(View.GONE);
                                binding.lvBottom.setVisibility(View.GONE);
                            }else {
                            }
                        }
                    }
                });
    }

    private void checkRencana(String idResep) {
        if (resepViewModel.getCheckRencana(idResep, idUser)){
            binding.lvRencana.setVisibility(View.GONE);
            String cekMasak = sharedPreferences.getString(Utils.MASAK_KEY, "");
            if (cekMasak.equals(idResep)){
                binding.lvMulaiMasak.setVisibility(View.GONE);
                binding.lvBottom.setVisibility(View.VISIBLE);
                binding.lvRencana.setVisibility(View.VISIBLE);
                binding.tvRencana.setText("SUDAH MASAK");
                binding.lvRencana.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
                binding.ivRencana.setImageDrawable(getDrawable(R.drawable.finish));
                binding.lvRencana.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(DetailResepActivity.this);
                        LayoutInflater inflater = getLayoutInflater();
                        DialogFeedbackBinding feedbackBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_feedback, null, false);
                        builder.setView(feedbackBinding.getRoot());
                        AlertDialog alertDialog = builder.create();
                        feedbackBinding.btnGive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final float rate = feedbackBinding.ratingBar.getRating();
                                Feedback feedback = new Feedback();
                                feedback.setIdResep(idResep);
                                feedback.setIdUser(idUser);
                                feedback.setRating(String.valueOf(rate));
                                if (TextUtils.isEmpty(feedbackBinding.etMasukan.getText().toString())){
                                    feedback.setMasukan("");
                                }else {
                                    feedback.setMasukan(feedbackBinding.etMasukan.getText().toString());
                                }
                                resepViewModel.getInputFeedbackMutable(feedback)
                                        .observe(DetailResepActivity.this, new Observer<Value>() {
                                            @Override
                                            public void onChanged(Value value) {
                                                Toast.makeText(DetailResepActivity.this, ""+value.getMessage(), Toast.LENGTH_SHORT).show();
                                                if (value.getValue() == 1){
                                                    resepViewModel.updateStatusRencana(Utils.STATUS_SUDAH_MASAK, idResep);
                                                    editor.putString(Utils.MASAK_KEY, "");
                                                    editor.commit();
                                                    alertDialog.dismiss();
                                                    binding.lvRencana.setVisibility(View.GONE);
                                                    binding.lvMulaiMasak.setVisibility(View.GONE);
                                                    binding.lvBottom.setVisibility(View.GONE);
                                                }
                                            }
                                        });
                            }
                        });
                        feedbackBinding.ivClose.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                resepViewModel.updateStatusRencana(Utils.STATUS_SUDAH_MASAK, idResep);
                                editor.putString(Utils.MASAK_KEY, "");
                                editor.commit();
                                alertDialog.dismiss();
                                binding.lvRencana.setVisibility(View.GONE);
                                binding.lvMulaiMasak.setVisibility(View.GONE);
                                binding.lvBottom.setVisibility(View.GONE);
                            }
                        });
                        alertDialog.show();
                    }
                });
            }else {
                binding.lvMulaiMasak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.putString(Utils.MASAK_KEY, idResep);
                        editor.commit();
                        binding.lvMulaiMasak.setVisibility(View.GONE);
                        binding.lvBottom.setVisibility(View.VISIBLE);
                        binding.lvRencana.setVisibility(View.VISIBLE);
                        binding.tvRencana.setText("SUDAH MASAK");
                        binding.lvRencana.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#4CAF50")));
                        binding.ivRencana.setImageDrawable(getDrawable(R.drawable.finish));
                    }
                });
            }
        }else {
            binding.lvRencana.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RencanaEntity bookmarkEntity = new RencanaEntity();
                    bookmarkEntity.setIdResep(resep.getId());
                    bookmarkEntity.setIdUser(idUser);
                    bookmarkEntity.setTitleResep(resep.getResep());
                    bookmarkEntity.setPosterResep(resep.getGambar());
                    bookmarkEntity.setStatus(Utils.STATUS_BELUM_MASAK);
                    resepViewModel.insertRencana(bookmarkEntity);
                    Toast.makeText(DetailResepActivity.this, "Berhasil menambah di rencana", Toast.LENGTH_SHORT).show();
                    binding.lvRencana.setVisibility(View.GONE);
                }
            });
        }
    }

    private void checkBookmark(String idResep){
        if (resepViewModel.getCheckBookmark(idResep, idUser)){
            binding.ivBookmark.setImageDrawable(this.getDrawable(R.drawable.ic_bookmark_black_24dp));
            binding.ivBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BookmarkEntity bookmarkEntity = resepViewModel.getItemBookmark(idResep, idUser);
                    resepViewModel.removeBookmark(bookmarkEntity.getId());
                    Toast.makeText(DetailResepActivity.this, "Berhasil menghapus", Toast.LENGTH_SHORT).show();
                    binding.ivBookmark.setImageDrawable(DetailResepActivity.this.getDrawable(R.drawable.ic_bookmark_border_black_24dp));
                }
            });
        }else {
            binding.ivBookmark.setImageDrawable(this.getDrawable(R.drawable.ic_bookmark_border_black_24dp));
            binding.ivBookmark.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BookmarkEntity bookmarkEntity = new BookmarkEntity();
                    bookmarkEntity.setIdResep(resep.getId());
                    bookmarkEntity.setIdUser(idUser);
                    bookmarkEntity.setTitleResep(resep.getResep());
                    bookmarkEntity.setPosterResep(resep.getGambar());
                    resepViewModel.insertBookmark(bookmarkEntity);
                    Toast.makeText(DetailResepActivity.this, "Berhasil menambah di bookmark", Toast.LENGTH_SHORT).show();
                    binding.ivBookmark.setImageDrawable(DetailResepActivity.this.getDrawable(R.drawable.ic_bookmark_black_24dp));
                }
            });
        }
    }

    private void checkLike(Resep resep) {
        resepViewModel.getCheckLikeMutable(resep.getId(), idUser)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        if (value.getValue() == 1){
                            binding.ivLike.setImageDrawable(getDrawable(R.drawable.ic_favorite_black_24dp));
                        }else {
                            binding.ivLike.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_black_24dp));
                        }
                    }
                });
    }

    private void checkFollowers(Resep resep) {
        resepViewModel.getCheckFollowMutable(resep.getId_user(), idUser)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        if (value.getValue() == 1){
                            binding.layoutProfil.tvIkutiUser.setVisibility(View.GONE);
                        }else {
                            binding.layoutProfil.tvIkutiUser.setVisibility(View.VISIBLE);
                            binding.layoutProfil.tvIkutiUser.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    addFollowers(resep);
                                }
                            });
                        }
                    }
                });
    }

    private void addFollowers(Resep resep) {
        String idFollowers = UUID.randomUUID().toString();
        resepViewModel.getAddFollowMutable(idFollowers, resep.getId_user(), idUser)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        if (value.getValue() == 1){
                            binding.layoutProfil.tvIkutiUser.setVisibility(View.INVISIBLE);
                        }
                        Toast.makeText(DetailResepActivity.this, ""+value.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void addLike(Resep resep) {
        resepViewModel.getAddLikeMutable(resep.getId(), idUser)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        if (value.getValue() == 1){
                            binding.ivLike.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_black_24dp));
                        }else if(value.getValue() == 2){
                            binding.ivLike.setImageDrawable(getDrawable(R.drawable.ic_favorite_black_24dp));
                        }
//                        Toast.makeText(DetailResepActivity.this, "Pesan : "+value.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadKomentar() {
        resepViewModel.getKomentarMutable(idResep)
                .observe(this, new Observer<KomentarResponse>() {
                    @Override
                    public void onChanged(KomentarResponse komentarResponse) {
                        if (komentarResponse.getValue() == 1){
                            komentarAdapter.setKomentarList(komentarResponse.getKomentarList());
                        }
                    }
                });
    }

    private void loadDataUser() {
        resepViewModel.getUserMutable(idUser)
                .observe(this, new Observer<UserResponse>() {
                    @Override
                    public void onChanged(UserResponse userResponse) {
                        Toast.makeText(DetailResepActivity.this, "Nama : "+userResponse.getUser().getNama(), Toast.LENGTH_SHORT).show();
                        binding.layoutKomentar.setProfilImage(userResponse.getUser().getGambar());
                    }
                });
    }

    private void loadDataBahan() {
        resepViewModel.getBahanResepMutable(idResep)
                .observe(this, new Observer<BahanResponse>() {
                    @Override
                    public void onChanged(BahanResponse bahanResponse) {
                        if (bahanResponse.getValue() == 1){
                            bahanAdapter.setBahanList(bahanResponse.getBahanList());
                        }
                    }
                });
    }

    private void loadDataSteps(){
        resepViewModel.getStepResepMutable(idResep)
                .observe(this, new Observer<StepsResponse>() {
                    @Override
                    public void onChanged(StepsResponse stepsResponse) {
                        if (stepsResponse.getValue() == 1){
                            stepAdapter.setStepsList(stepsResponse.getStepsList());
                        }
                    }
                });
    }

    @Override
    public void onResepClickListener(ImageView imageView, Resep resep) {

    }
}
