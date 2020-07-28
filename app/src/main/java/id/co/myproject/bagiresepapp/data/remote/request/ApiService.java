package id.co.myproject.bagiresepapp.data.remote.request;

import java.util.List;

import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.remote.model.Bahan;
import id.co.myproject.bagiresepapp.data.remote.model.Feedback;
import id.co.myproject.bagiresepapp.data.remote.model.Komentar;
import id.co.myproject.bagiresepapp.data.remote.model.Resep;
import id.co.myproject.bagiresepapp.data.remote.model.Steps;
import id.co.myproject.bagiresepapp.data.remote.model.Value;
import id.co.myproject.bagiresepapp.data.remote.model.response.BahanResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.KategoriResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.KomentarResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.LoginResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.ResepResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.StepsResponse;
import id.co.myproject.bagiresepapp.data.remote.model.response.UserResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("login_user.php")
    Observable<LoginResponse> loginUserRequest(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("registrasi_user.php")
    Observable<LoginResponse> registerUserRequest(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("lupa_password.php")
    Observable<Value> lupaPasswordRequest(
            @Field("id_user") String idUser,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("cek_email.php")
    Observable<LoginResponse> cekEmailRequest(
            @Field("email") String email
    );

    @GET("tampil_popular.php")
    Observable<ResepResponse> popularRequest();

    @GET("tampil_resep.php")
    Observable<ResepResponse> resepRequest();

    @GET("tampil_kategori.php")
    Observable<KategoriResponse> kategoriRequest();

    @GET("tampil_resep.php")
    Observable<ResepResponse> resepByIdRequest(
            @Query("id_resep") String idResep
    );

    @GET("tampil_resep.php")
    Observable<ResepResponse> resepByAkunRequest(
            @Query("id_user") String idUser
    );

    @GET("tampil_resep.php")
    Observable<Resep> resepByAkunLainnyaRequest(
            @Query("id_user") String idUser,
            @Query("id_resep") String idResep
    );

    @GET("tampil_step.php")
    Observable<StepsResponse> stepsResepRequest(
            @Query("id_resep") String idResep
    );

    @GET("tampil_bahan.php")
    Observable<BahanResponse> bahanResepRequest(
            @Query("id_resep") String idResep
    );

    @GET("tampil_user.php")
    Single<UserResponse> userRequest(
            @Query("id_user") String idUser
    );

    @GET("tampil_komentar.php")
    Observable<KomentarResponse> komentarRequest(
        @Query("id_resep") String idResep
    );

    @POST("input_komentar.php")
    Observable<Value> inputKomentar(
            @Body Komentar komentar
    );

    @FormUrlEncoded
    @POST("tambah_followers.php")
    Observable<Value> addFollowers(
            @Field("id_followers") String idFollowers,
            @Field("id_followed") String idFollowed,
            @Field("id_following") String idFollowing
    );

    @FormUrlEncoded
    @POST("tambah_like.php")
    Observable<Value> addLike(
            @Field("id_resep") String idResep,
            @Field("id_user") String idUser
    );

    @GET("cek_like.php")
    Observable<Value> cekLike(
            @Query("id_resep") String idResep,
            @Query("id_user") String idUser
    );

    @GET("cek_followers.php")
    Observable<Value> cekFollowers(
            @Query("id_followed") String idFollowed,
            @Query("id_following") String idFollowing
    );

    @GET("tampil_resep.php")
    Observable<ResepResponse> getResepSaya(
            @Query("id_resep_saya") String id_resep_saya
    );


    @POST("input_feedback.php")
    Observable<Value> inputFeedback(
            @Body Feedback feedback
    );

    @POST("input_resep.php")
    Call<Value> inputResepRequest(
            @Body Resep resep
    );

    @POST("input_bahan.php")
    Call<Value> inputBahanRequest(
            @Body Bahan bahan
    );

    @POST("input_langkah.php")
    Call<Value> inputLangkahRequest(
            @Body Steps steps
    );

    @POST("input_langkah_gambar.php")
    Call<Value> inputLangkahGambarRequest(
            @Body LangkahGambarEntity langkahGambarEntity
    );
}
