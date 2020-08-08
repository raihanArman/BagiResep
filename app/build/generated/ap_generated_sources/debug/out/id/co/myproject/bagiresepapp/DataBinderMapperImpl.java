package id.co.myproject.bagiresepapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import id.co.myproject.bagiresepapp.databinding.ActivityAddResepBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ActivityDetailResepBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ActivityLoginBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ActivityMainBindingImpl;
import id.co.myproject.bagiresepapp.databinding.DialogFeedbackBindingImpl;
import id.co.myproject.bagiresepapp.databinding.DialogPeringatanBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentChatBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentFavoriteBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentForgotPassBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentForgotPassDialogBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentHomeBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentMyResepBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentSignInBindingImpl;
import id.co.myproject.bagiresepapp.databinding.FragmentSignUpBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemBahanBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemBahanGambarInputBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemBahanInputBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemKategoriBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemKomentarBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemLangkahGambarInputBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemLangkahInputBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemRencanaBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemResep2BindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemResepHomeBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemResepPopularBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemSpinnerBindingImpl;
import id.co.myproject.bagiresepapp.databinding.ItemStepsBindingImpl;
import id.co.myproject.bagiresepapp.databinding.LayoutAkunUserBindingImpl;
import id.co.myproject.bagiresepapp.databinding.LayoutBahanInputBindingImpl;
import id.co.myproject.bagiresepapp.databinding.LayoutCommentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDRESEP = 1;

  private static final int LAYOUT_ACTIVITYDETAILRESEP = 2;

  private static final int LAYOUT_ACTIVITYLOGIN = 3;

  private static final int LAYOUT_ACTIVITYMAIN = 4;

  private static final int LAYOUT_DIALOGFEEDBACK = 5;

  private static final int LAYOUT_DIALOGPERINGATAN = 6;

  private static final int LAYOUT_FRAGMENTCHAT = 7;

  private static final int LAYOUT_FRAGMENTFAVORITE = 8;

  private static final int LAYOUT_FRAGMENTFORGOTPASS = 9;

  private static final int LAYOUT_FRAGMENTFORGOTPASSDIALOG = 10;

  private static final int LAYOUT_FRAGMENTHOME = 11;

  private static final int LAYOUT_FRAGMENTMYRESEP = 12;

  private static final int LAYOUT_FRAGMENTSIGNIN = 13;

  private static final int LAYOUT_FRAGMENTSIGNUP = 14;

  private static final int LAYOUT_ITEMBAHAN = 15;

  private static final int LAYOUT_ITEMBAHANGAMBARINPUT = 16;

  private static final int LAYOUT_ITEMBAHANINPUT = 17;

  private static final int LAYOUT_ITEMKATEGORI = 18;

  private static final int LAYOUT_ITEMKOMENTAR = 19;

  private static final int LAYOUT_ITEMLANGKAHGAMBARINPUT = 20;

  private static final int LAYOUT_ITEMLANGKAHINPUT = 21;

  private static final int LAYOUT_ITEMRENCANA = 22;

  private static final int LAYOUT_ITEMRESEP2 = 23;

  private static final int LAYOUT_ITEMRESEPHOME = 24;

  private static final int LAYOUT_ITEMRESEPPOPULAR = 25;

  private static final int LAYOUT_ITEMSPINNER = 26;

  private static final int LAYOUT_ITEMSTEPS = 27;

  private static final int LAYOUT_LAYOUTAKUNUSER = 28;

  private static final int LAYOUT_LAYOUTBAHANINPUT = 29;

  private static final int LAYOUT_LAYOUTCOMMENT = 30;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(30);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.activity_add_resep, LAYOUT_ACTIVITYADDRESEP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.activity_detail_resep, LAYOUT_ACTIVITYDETAILRESEP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.dialog_feedback, LAYOUT_DIALOGFEEDBACK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.dialog_peringatan, LAYOUT_DIALOGPERINGATAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_chat, LAYOUT_FRAGMENTCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_favorite, LAYOUT_FRAGMENTFAVORITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_forgot_pass, LAYOUT_FRAGMENTFORGOTPASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_forgot_pass_dialog, LAYOUT_FRAGMENTFORGOTPASSDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_my_resep, LAYOUT_FRAGMENTMYRESEP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_sign_in, LAYOUT_FRAGMENTSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.fragment_sign_up, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_bahan, LAYOUT_ITEMBAHAN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_bahan_gambar_input, LAYOUT_ITEMBAHANGAMBARINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_bahan_input, LAYOUT_ITEMBAHANINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_kategori, LAYOUT_ITEMKATEGORI);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_komentar, LAYOUT_ITEMKOMENTAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_langkah_gambar_input, LAYOUT_ITEMLANGKAHGAMBARINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_langkah_input, LAYOUT_ITEMLANGKAHINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_rencana, LAYOUT_ITEMRENCANA);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_resep_2, LAYOUT_ITEMRESEP2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_resep_home, LAYOUT_ITEMRESEPHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_resep_popular, LAYOUT_ITEMRESEPPOPULAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_spinner, LAYOUT_ITEMSPINNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.item_steps, LAYOUT_ITEMSTEPS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.layout_akun_user, LAYOUT_LAYOUTAKUNUSER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.layout_bahan_input, LAYOUT_LAYOUTBAHANINPUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(id.co.myproject.bagiresepapp.R.layout.layout_comment, LAYOUT_LAYOUTCOMMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDRESEP: {
          if ("layout/activity_add_resep_0".equals(tag)) {
            return new ActivityAddResepBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_resep is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDETAILRESEP: {
          if ("layout/activity_detail_resep_0".equals(tag)) {
            return new ActivityDetailResepBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_detail_resep is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGFEEDBACK: {
          if ("layout/dialog_feedback_0".equals(tag)) {
            return new DialogFeedbackBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_feedback is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGPERINGATAN: {
          if ("layout/dialog_peringatan_0".equals(tag)) {
            return new DialogPeringatanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_peringatan is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHAT: {
          if ("layout/fragment_chat_0".equals(tag)) {
            return new FragmentChatBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_chat is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAVORITE: {
          if ("layout/fragment_favorite_0".equals(tag)) {
            return new FragmentFavoriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_favorite is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGOTPASS: {
          if ("layout/fragment_forgot_pass_0".equals(tag)) {
            return new FragmentForgotPassBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgot_pass is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGOTPASSDIALOG: {
          if ("layout/fragment_forgot_pass_dialog_0".equals(tag)) {
            return new FragmentForgotPassDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgot_pass_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMYRESEP: {
          if ("layout/fragment_my_resep_0".equals(tag)) {
            return new FragmentMyResepBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_my_resep is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNIN: {
          if ("layout/fragment_sign_in_0".equals(tag)) {
            return new FragmentSignInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_in is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUP: {
          if ("layout/fragment_sign_up_0".equals(tag)) {
            return new FragmentSignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBAHAN: {
          if ("layout/item_bahan_0".equals(tag)) {
            return new ItemBahanBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_bahan is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBAHANGAMBARINPUT: {
          if ("layout/item_bahan_gambar_input_0".equals(tag)) {
            return new ItemBahanGambarInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_bahan_gambar_input is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMBAHANINPUT: {
          if ("layout/item_bahan_input_0".equals(tag)) {
            return new ItemBahanInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_bahan_input is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMKATEGORI: {
          if ("layout/item_kategori_0".equals(tag)) {
            return new ItemKategoriBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_kategori is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMKOMENTAR: {
          if ("layout/item_komentar_0".equals(tag)) {
            return new ItemKomentarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_komentar is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLANGKAHGAMBARINPUT: {
          if ("layout/item_langkah_gambar_input_0".equals(tag)) {
            return new ItemLangkahGambarInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_langkah_gambar_input is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLANGKAHINPUT: {
          if ("layout/item_langkah_input_0".equals(tag)) {
            return new ItemLangkahInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_langkah_input is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRENCANA: {
          if ("layout/item_rencana_0".equals(tag)) {
            return new ItemRencanaBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_rencana is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRESEP2: {
          if ("layout/item_resep_2_0".equals(tag)) {
            return new ItemResep2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_resep_2 is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRESEPHOME: {
          if ("layout/item_resep_home_0".equals(tag)) {
            return new ItemResepHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_resep_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMRESEPPOPULAR: {
          if ("layout/item_resep_popular_0".equals(tag)) {
            return new ItemResepPopularBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_resep_popular is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSPINNER: {
          if ("layout/item_spinner_0".equals(tag)) {
            return new ItemSpinnerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_spinner is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMSTEPS: {
          if ("layout/item_steps_0".equals(tag)) {
            return new ItemStepsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_steps is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTAKUNUSER: {
          if ("layout/layout_akun_user_0".equals(tag)) {
            return new LayoutAkunUserBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_akun_user is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTBAHANINPUT: {
          if ("layout/layout_bahan_input_0".equals(tag)) {
            return new LayoutBahanInputBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_bahan_input is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTCOMMENT: {
          if ("layout/layout_comment_0".equals(tag)) {
            return new LayoutCommentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_comment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(18);

    static {
      sKeys.put(1, "Kategori");
      sKeys.put(0, "_all");
      sKeys.put(2, "bahan");
      sKeys.put(3, "entity");
      sKeys.put(4, "forgotDialog");
      sKeys.put(5, "forgotPass");
      sKeys.put(6, "imageBgHome");
      sKeys.put(7, "kategori");
      sKeys.put(8, "komentar");
      sKeys.put(9, "langkah");
      sKeys.put(10, "profil");
      sKeys.put(11, "profilImage");
      sKeys.put(12, "resep");
      sKeys.put(13, "signIn");
      sKeys.put(14, "signUp");
      sKeys.put(15, "steps");
      sKeys.put(16, "timeStampFormat");
      sKeys.put(17, "user");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(30);

    static {
      sKeys.put("layout/activity_add_resep_0", id.co.myproject.bagiresepapp.R.layout.activity_add_resep);
      sKeys.put("layout/activity_detail_resep_0", id.co.myproject.bagiresepapp.R.layout.activity_detail_resep);
      sKeys.put("layout/activity_login_0", id.co.myproject.bagiresepapp.R.layout.activity_login);
      sKeys.put("layout/activity_main_0", id.co.myproject.bagiresepapp.R.layout.activity_main);
      sKeys.put("layout/dialog_feedback_0", id.co.myproject.bagiresepapp.R.layout.dialog_feedback);
      sKeys.put("layout/dialog_peringatan_0", id.co.myproject.bagiresepapp.R.layout.dialog_peringatan);
      sKeys.put("layout/fragment_chat_0", id.co.myproject.bagiresepapp.R.layout.fragment_chat);
      sKeys.put("layout/fragment_favorite_0", id.co.myproject.bagiresepapp.R.layout.fragment_favorite);
      sKeys.put("layout/fragment_forgot_pass_0", id.co.myproject.bagiresepapp.R.layout.fragment_forgot_pass);
      sKeys.put("layout/fragment_forgot_pass_dialog_0", id.co.myproject.bagiresepapp.R.layout.fragment_forgot_pass_dialog);
      sKeys.put("layout/fragment_home_0", id.co.myproject.bagiresepapp.R.layout.fragment_home);
      sKeys.put("layout/fragment_my_resep_0", id.co.myproject.bagiresepapp.R.layout.fragment_my_resep);
      sKeys.put("layout/fragment_sign_in_0", id.co.myproject.bagiresepapp.R.layout.fragment_sign_in);
      sKeys.put("layout/fragment_sign_up_0", id.co.myproject.bagiresepapp.R.layout.fragment_sign_up);
      sKeys.put("layout/item_bahan_0", id.co.myproject.bagiresepapp.R.layout.item_bahan);
      sKeys.put("layout/item_bahan_gambar_input_0", id.co.myproject.bagiresepapp.R.layout.item_bahan_gambar_input);
      sKeys.put("layout/item_bahan_input_0", id.co.myproject.bagiresepapp.R.layout.item_bahan_input);
      sKeys.put("layout/item_kategori_0", id.co.myproject.bagiresepapp.R.layout.item_kategori);
      sKeys.put("layout/item_komentar_0", id.co.myproject.bagiresepapp.R.layout.item_komentar);
      sKeys.put("layout/item_langkah_gambar_input_0", id.co.myproject.bagiresepapp.R.layout.item_langkah_gambar_input);
      sKeys.put("layout/item_langkah_input_0", id.co.myproject.bagiresepapp.R.layout.item_langkah_input);
      sKeys.put("layout/item_rencana_0", id.co.myproject.bagiresepapp.R.layout.item_rencana);
      sKeys.put("layout/item_resep_2_0", id.co.myproject.bagiresepapp.R.layout.item_resep_2);
      sKeys.put("layout/item_resep_home_0", id.co.myproject.bagiresepapp.R.layout.item_resep_home);
      sKeys.put("layout/item_resep_popular_0", id.co.myproject.bagiresepapp.R.layout.item_resep_popular);
      sKeys.put("layout/item_spinner_0", id.co.myproject.bagiresepapp.R.layout.item_spinner);
      sKeys.put("layout/item_steps_0", id.co.myproject.bagiresepapp.R.layout.item_steps);
      sKeys.put("layout/layout_akun_user_0", id.co.myproject.bagiresepapp.R.layout.layout_akun_user);
      sKeys.put("layout/layout_bahan_input_0", id.co.myproject.bagiresepapp.R.layout.layout_bahan_input);
      sKeys.put("layout/layout_comment_0", id.co.myproject.bagiresepapp.R.layout.layout_comment);
    }
  }
}
