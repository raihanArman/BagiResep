package id.co.myproject.bagiresepapp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import id.co.myproject.bagiresepapp.R;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Kategori;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.databinding.ActivityAddResepBinding;
import id.co.myproject.bagiresepapp.databinding.LayoutBahanInputBinding;
import id.co.myproject.bagiresepapp.ui.adapter.BahanInputAdapter;
import id.co.myproject.bagiresepapp.ui.adapter.LangkahInputAdapter;
import id.co.myproject.bagiresepapp.ui.listener.BahanListener;
import id.co.myproject.bagiresepapp.ui.listener.ConvertBitmap;
import id.co.myproject.bagiresepapp.ui.listener.LangkahListener;
import id.co.myproject.bagiresepapp.util.Utils;
import id.co.myproject.bagiresepapp.viewmodel.AddResepViewModel;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Toast;

import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddResepActivity extends AppCompatActivity implements BahanListener, BahanInputAdapter.CallbackInterface, ConvertBitmap, LangkahListener, LangkahInputAdapter.CallbackInterfaceLangkah {

    private static final String TAG = "AddResepActivity";

    public static final int ADD_IMAGE = 79;
    public static final int ADD_IMAGE_BAHAN = 74;

    ProgressDialog progressDialog;
    private ActivityAddResepBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String idUser, imageThumbs;
    int spinnerPosition, idBahan, positionImage, idLangkah, typeInput;
    Bitmap bitmap;
    AddResepViewModel viewModel;
    ViewModelProvider.Factory factory;

    List<String> listIdKategori = new ArrayList<>();
    BahanInputAdapter bahanInputAdapter;
    LangkahInputAdapter langkahInputAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resep);
        progressDialog = new ProgressDialog(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_resep);
        sharedPreferences = getSharedPreferences(Utils.LOGIN_KEY, Context.MODE_PRIVATE);
        idUser = sharedPreferences.getString(Utils.ID_USER_KEY, "");
        editor = sharedPreferences.edit();

        viewModel = ViewModelProviders.of(this, factory).get(AddResepViewModel.class);

        binding.rvBahan.setLayoutManager(new LinearLayoutManager(this));
        bahanInputAdapter = new BahanInputAdapter(this, viewModel, this);
        binding.rvBahan.setAdapter(bahanInputAdapter);

        binding.rvLangkah.setLayoutManager(new LinearLayoutManager(this));
        langkahInputAdapter = new LangkahInputAdapter(this, viewModel, this);
        binding.rvLangkah.setAdapter(langkahInputAdapter);

        binding.tvWaktu.setText("15");
        binding.seekbarWaktu.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {
                binding.tvWaktu.setText(String.valueOf((int) leftValue));
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });

        binding.spKategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerPosition = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.layoutBtnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImage();
            }
        });

        binding.tvGantiGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImage();
            }
        });

        binding.lvTambahLangkah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddResepActivity.this);
                builder.setTitle("Input Langkah");
                builder.setMessage("Masukkan langkah resep anda");
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutBahanInputBinding langkahViewBinding = DataBindingUtil.inflate(inflater, R.layout.layout_bahan_input, null, false);
                builder.setView(langkahViewBinding.getRoot());
                langkahViewBinding.etBahan.setHint("Masukkan langkah resep anda");
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LangkahEntity langkahEntity = new LangkahEntity();
                        langkahEntity.setLangkah(langkahViewBinding.etBahan.getText().toString());
                        viewModel.insertLangkah(langkahEntity);
                        Toast.makeText(AddResepActivity.this, "Berhasil Input langkah", Toast.LENGTH_SHORT).show();
                        loadLangkah();
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

        binding.lvTambahBahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AddResepActivity.this);
                builder.setTitle("Input Bahan");
                builder.setMessage("Masukkan bahan resep anda");
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LayoutBahanInputBinding bahanInputBinding = DataBindingUtil.inflate(inflater, R.layout.layout_bahan_input, null, false);
                builder.setView(bahanInputBinding.getRoot());
                builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BahanEntity bahanEntity = new BahanEntity();
                        bahanEntity.setBahan(bahanInputBinding.etBahan.getText().toString());
                        viewModel.insertBahan(bahanEntity);
                        dialog.dismiss();
                        Toast.makeText(AddResepActivity.this, "Berhasil Input bahan", Toast.LENGTH_SHORT).show();
                        loadBahan();
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

        binding.btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputResep();
            }
        });

        loadKategori();



    }

    private void inputResep() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Prosess ...");
        progressDialog.show();
        String idResep = UUID.randomUUID().toString();
        Resep resep = new Resep();
        resep.setId(idResep);
        resep.setId_kategori(listIdKategori.get(spinnerPosition));
        resep.setId_user(idUser);
        resep.setResep(binding.etResep.getText().toString());
        resep.setGambar(imageThumbs);
        resep.setDeksripsi(binding.etDeskripsi.getText().toString());
        resep.setWaktuMasak(String.valueOf((int)binding.seekbarWaktu.getLeftSeekBar().getProgress()));
        viewModel.getInputResepMutable(resep)
                .observe(this, new Observer<Value>() {
                    @Override
                    public void onChanged(Value value) {
                        viewModel.getInputResepMutable(resep).removeObserver(this);
                        if (value.getValue() == 1){
                            viewModel.getBahanMutable()
                                    .observe(AddResepActivity.this, new Observer<List<BahanEntity>>() {
                                        @Override
                                        public void onChanged(List<BahanEntity> bahanEntities) {
                                            if (bahanEntities.size() > 0){
                                                int ket = 1;
                                                for (int i=0; i<bahanEntities.size(); i++){
                                                    Bahan bahan = new Bahan();
                                                    bahan.setIdResep(idResep);
                                                    bahan.setBahan(bahanEntities.get(i).getBahan());
                                                    bahan.setKet(String.valueOf(ket));
                                                    ket++;
                                                    viewModel.getInputBahanMutable(bahan)
                                                            .observe(AddResepActivity.this, new Observer<Value>() {
                                                                @Override
                                                                public void onChanged(Value value) {
                                                                    if (value.getValue() == 1){
                                                                        Toast.makeText(AddResepActivity.this, "Jalan jalan", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    viewModel.getInputBahanMutable(bahan).removeObserver(this);
                                                                    Log.d(TAG, "Input : "+value.getMessage());
                                                                }
                                                            });
                                                    Log.d(TAG, "Langkah resep : "+i);
                                                    Toast.makeText(AddResepActivity.this, "bahan : "+i, Toast.LENGTH_SHORT).show();
                                                }
                                                viewModel.getBahanMutable().removeObserver(this);
                                                deleteBahan();
                                                viewModel.getLangkahMutable().removeObservers(AddResepActivity.this);
                                                viewModel.getLangkahMutable()
                                                        .observe(AddResepActivity.this, new Observer<List<LangkahEntity>>() {
                                                            @Override
                                                            public void onChanged(List<LangkahEntity> langkahEntities) {
                                                                if (langkahEntities.size() > 0){
                                                                    int ketLangkah = 1;
                                                                    for (int i=0; i<langkahEntities.size(); i++){
                                                                        Steps steps = new Steps();
                                                                        steps.setIdResep(idResep);
                                                                        steps.setLangkah(langkahEntities.get(i).getLangkah());
                                                                        steps.setKet(String.valueOf(ketLangkah));
                                                                        ketLangkah++;
                                                                        viewModel.getInputLangkahMutable(steps).removeObservers(AddResepActivity.this);
                                                                        viewModel.getInputLangkahMutable(steps)
                                                                                .observe(AddResepActivity.this, new Observer<Value>() {
                                                                                    @Override
                                                                                    public void onChanged(Value value) {
                                                                                        if (value.getValue() == 1){
                                                                                        }
                                                                                        Log.d(TAG, "Input : "+value.getMessage());
                                                                                        viewModel.getInputLangkahMutable(steps).removeObserver(this);
                                                                                        finish();
                                                                                    }
                                                                                });
                                                                        Log.d(TAG, "Langkah resep : "+i);
                                                                        Toast.makeText(AddResepActivity.this, "Langkah : "+i, Toast.LENGTH_SHORT).show();
                                                                    }
                                                                    viewModel.getLangkahMutable().removeObserver(this);
                                                                    deleteLangkah();
                                                                    progressDialog.dismiss();
                                                                    Toast.makeText(AddResepActivity.this, "Berhasil upload", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        });
                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(AddResepActivity.this, "Gagal upload", Toast.LENGTH_SHORT).show();
                        }
                        viewModel.getInputResepMutable(resep).removeObserver(this);
                    }
                });
    }

    private void deleteLangkah() {
        viewModel.getLangkahMutable()
                .observe(this, new Observer<List<LangkahEntity>>() {
                    @Override
                    public void onChanged(List<LangkahEntity> langkahEntities) {
                        for (LangkahEntity langkahEntity : langkahEntities){
                            viewModel.removeLangkahGambarByIdLangkah(langkahEntity.getId());
                        }
                        viewModel.removeAllLangkah();
                    }
                });
    }

    private void deleteBahan() {
        viewModel.getBahanMutable()
                .observe(this, new Observer<List<BahanEntity>>() {
                    @Override
                    public void onChanged(List<BahanEntity> bahanEntities) {
                        for (BahanEntity bahanEntity : bahanEntities){
                            viewModel.removeBahanGambarByIdBahan(bahanEntity.getId());
                        }
                        viewModel.removeAllBahan();
                    }
                });
    }

    private void showLoading(Boolean isShowLoading) {
        progressDialog.setMessage("Proses ...");
        if (isShowLoading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }


    private void loadLangkah() {
        viewModel.getLangkahMutable()
                .observe(this, new Observer<List<LangkahEntity>>() {
                    @Override
                    public void onChanged(List<LangkahEntity> langkahEntities) {
                        langkahInputAdapter.setLangkahEntityList(langkahEntities);
                    }
                });
    }

    private void loadBahan() {
        viewModel.getBahanMutable()
                .observe(this, new Observer<List<BahanEntity>>() {
                    @Override
                    public void onChanged(List<BahanEntity> bahanEntities) {
                        bahanInputAdapter.setBahanList(bahanEntities);
                    }
                });
    }

    private void loadKategori() {
        List<String> listKategori = new ArrayList<>();
        viewModel.getKategoriMutable()
                .observe(this, new Observer<KategoriResponse>() {
                    @Override
                    public void onChanged(KategoriResponse kategoriResponse) {
                        List<Kategori> kategoriList = kategoriResponse.getKategoriList();
                        for (int i=0; i<kategoriList.size(); i++){
                            listKategori.add(kategoriList.get(i).getNama_kategori());
                            listIdKategori.add(kategoriList.get(i).getId_kategori());
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                                R.layout.item_spinner, R.id.weekofday, listKategori);
                        binding.spKategori.setAdapter(adapter);
                    }
                });
    }

    private void addImage(){
        typeInput = Utils.TYPE_INPUT_THUMB;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, ADD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_IMAGE){
            if (resultCode == RESULT_OK && data != null){
                Uri imageUri = data.getData();
                binding.ivResep.setVisibility(View.VISIBLE);
                binding.layoutBtnAddImage.setVisibility(View.INVISIBLE);
                binding.tvGantiGambar.setVisibility(View.VISIBLE);

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    new LoadBitmapConvertAsync(this, this).execute();
                    binding.ivResep.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }else if (requestCode == ADD_IMAGE_BAHAN){
            if (resultCode == RESULT_OK && data != null){
                Uri imageUri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    new LoadBitmapConvertAsync(this, this).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onBahanListener(String result) {
        loadBahan();
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHandleIntent(int idBahan, int position, int type) {
        typeInput = type;
        this.idBahan = idBahan;
        positionImage = position;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, ADD_IMAGE_BAHAN);
    }

    @Override
    public void bitmapToString(String imgConvert) {
        if (typeInput == Utils.TYPE_INPUT_THUMB){
            imageThumbs = imgConvert;
        }else if (typeInput == Utils.TYPE_INPUT_BAHAN) {
            BahanGambarEntity bahanGambarEntity = new BahanGambarEntity();
            bahanGambarEntity.setIdBahan(idBahan);
            bahanGambarEntity.setGambar(imgConvert);
            viewModel.insertBahanGambar(bahanGambarEntity);
//        Todo : LoadGambarBahan
            bahanInputAdapter.loadGambar(idBahan, positionImage, true);
        }else if (typeInput == Utils.TYPE_INPUT_LANGKAH){
            LangkahGambarEntity langkahGambarEntity = new LangkahGambarEntity();
            langkahGambarEntity.setIdLangkah(idLangkah);
            langkahGambarEntity.setGambar(imgConvert);
            viewModel.insertLangkahGambar(langkahGambarEntity);
            langkahInputAdapter.loadGambar(idLangkah, positionImage, true);
        }
        Toast.makeText(this, "Berhasil Input Gambar", Toast.LENGTH_SHORT).show();

//        Todo : GambarlangkahProses
    }

    @Override
    public void onHandleIntentLangkah(int idLangkah, int position, int type) {
        typeInput = type;
        this.idLangkah = idLangkah;
        positionImage = position;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, ADD_IMAGE_BAHAN);
    }

    @Override
    public void onLangkahListener(String result) {
        loadLangkah();
        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
    }

    private class LoadBitmapConvertAsync extends AsyncTask<Void, Void, String>{
        private WeakReference<Context> weakContext;
        ConvertBitmap convertBitmap;

        public LoadBitmapConvertAsync(Context context, ConvertBitmap convertBitmap) {
            this.weakContext = new WeakReference<>(context);
            this.convertBitmap = convertBitmap;
        }

        @Override
        protected String doInBackground(Void... voids) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
            byte[] imgByte = byteArrayOutputStream.toByteArray();
            String imageBitmap = Base64.encodeToString(imgByte, Base64.DEFAULT);
            return imageBitmap;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            weakContext.get();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            convertBitmap.bitmapToString(s);
        }
    }
}
