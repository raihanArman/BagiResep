package id.co.myproject.bagiresepapp.data.local.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.co.myproject.bagiresepapp.data.local.entity.BahanEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity;
import id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity;
import id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity;
import io.reactivex.Observable;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookmarkEntity> __insertionAdapterOfBookmarkEntity;

  private final EntityInsertionAdapter<RencanaEntity> __insertionAdapterOfRencanaEntity;

  private final EntityInsertionAdapter<BahanEntity> __insertionAdapterOfBahanEntity;

  private final EntityInsertionAdapter<BahanGambarEntity> __insertionAdapterOfBahanGambarEntity;

  private final EntityInsertionAdapter<LangkahEntity> __insertionAdapterOfLangkahEntity;

  private final EntityInsertionAdapter<LangkahGambarEntity> __insertionAdapterOfLangkahGambarEntity;

  private final SharedSQLiteStatement __preparedStmtOfRemoveBookmarkById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatusRencana;

  private final SharedSQLiteStatement __preparedStmtOfRemoveRencanaById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBahan;

  private final SharedSQLiteStatement __preparedStmtOfRemoveBahanById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAllBahan;

  private final SharedSQLiteStatement __preparedStmtOfRemoveBahanGambarById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveBahanGambarByIdBahan;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLangkah;

  private final SharedSQLiteStatement __preparedStmtOfRemoveLangkahById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveAllLangkah;

  private final SharedSQLiteStatement __preparedStmtOfRemoveLangkahGambarById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveLangkahGambarByIdLangkah;

  public DatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookmarkEntity = new EntityInsertionAdapter<BookmarkEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_bookmark` (`id`,`id_resep`,`id_user`,`title_resep`,`poster_resep`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookmarkEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getIdResep() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIdResep());
        }
        if (value.getIdUser() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIdUser());
        }
        if (value.getTitleResep() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitleResep());
        }
        if (value.getPosterResep() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPosterResep());
        }
      }
    };
    this.__insertionAdapterOfRencanaEntity = new EntityInsertionAdapter<RencanaEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_rencana` (`id`,`id_resep`,`id_user`,`title_resep`,`poster_resep`,`status`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RencanaEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getIdResep() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIdResep());
        }
        if (value.getIdUser() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIdUser());
        }
        if (value.getTitleResep() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTitleResep());
        }
        if (value.getPosterResep() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPosterResep());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStatus());
        }
      }
    };
    this.__insertionAdapterOfBahanEntity = new EntityInsertionAdapter<BahanEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_bahan` (`id`,`bahan`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BahanEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getBahan() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBahan());
        }
      }
    };
    this.__insertionAdapterOfBahanGambarEntity = new EntityInsertionAdapter<BahanGambarEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_gambar_bahan` (`id`,`id_bahan`,`gambar`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BahanGambarEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdBahan());
        if (value.getGambar() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGambar());
        }
      }
    };
    this.__insertionAdapterOfLangkahEntity = new EntityInsertionAdapter<LangkahEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_langkah` (`id`,`langkah`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LangkahEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getLangkah() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLangkah());
        }
      }
    };
    this.__insertionAdapterOfLangkahGambarEntity = new EntityInsertionAdapter<LangkahGambarEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_gambar_langkah` (`id`,`id_langkah`,`gambar`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LangkahGambarEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdLangkah());
        if (value.getGambar() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGambar());
        }
      }
    };
    this.__preparedStmtOfRemoveBookmarkById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_bookmark WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStatusRencana = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tb_rencana SET status = ? WHERE id_resep = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveRencanaById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_rencana WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateBahan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tb_bahan SET bahan = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveBahanById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_bahan WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAllBahan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_bahan";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveBahanGambarById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_gambar_bahan WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveBahanGambarByIdBahan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_gambar_bahan WHERE id_bahan = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLangkah = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tb_langkah SET langkah = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveLangkahById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_langkah WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveAllLangkah = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_langkah";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveLangkahGambarById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_gambar_langkah WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveLangkahGambarByIdLangkah = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_gambar_langkah WHERE id_langkah = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertToBookmark(final BookmarkEntity bookmarkEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBookmarkEntity.insert(bookmarkEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertToRencana(final RencanaEntity rencanaEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRencanaEntity.insert(rencanaEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertToBahan(final BahanEntity bahanEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBahanEntity.insert(bahanEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertToBahanGambar(final BahanGambarEntity bahanGambarEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBahanGambarEntity.insert(bahanGambarEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLangkah(final LangkahEntity langkahEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLangkahEntity.insert(langkahEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertlangkahGambar(final LangkahGambarEntity langkahGambarEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLangkahGambarEntity.insert(langkahGambarEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void removeBookmarkById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveBookmarkById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveBookmarkById.release(_stmt);
    }
  }

  @Override
  public void updateStatusRencana(final String status, final String idResep) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatusRencana.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    if (idResep == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, idResep);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateStatusRencana.release(_stmt);
    }
  }

  @Override
  public void removeRencanaById(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveRencanaById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveRencanaById.release(_stmt);
    }
  }

  @Override
  public void updateBahan(final int idBahan, final String bahan) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBahan.acquire();
    int _argIndex = 1;
    if (bahan == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, bahan);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idBahan);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBahan.release(_stmt);
    }
  }

  @Override
  public void removeBahanById(final int idBahan) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveBahanById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idBahan);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveBahanById.release(_stmt);
    }
  }

  @Override
  public void removeAllBahan() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAllBahan.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveAllBahan.release(_stmt);
    }
  }

  @Override
  public void removeBahanGambarById(final int idGambar) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveBahanGambarById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idGambar);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveBahanGambarById.release(_stmt);
    }
  }

  @Override
  public void removeBahanGambarByIdBahan(final int idBahan) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveBahanGambarByIdBahan.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idBahan);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveBahanGambarByIdBahan.release(_stmt);
    }
  }

  @Override
  public void updateLangkah(final int idLangkah, final String langkah) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLangkah.acquire();
    int _argIndex = 1;
    if (langkah == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, langkah);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idLangkah);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateLangkah.release(_stmt);
    }
  }

  @Override
  public void removeLangkahById(final int idLangkah) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveLangkahById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idLangkah);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveLangkahById.release(_stmt);
    }
  }

  @Override
  public void removeAllLangkah() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveAllLangkah.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveAllLangkah.release(_stmt);
    }
  }

  @Override
  public void removeLangkahGambarById(final int idGambar) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveLangkahGambarById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idGambar);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveLangkahGambarById.release(_stmt);
    }
  }

  @Override
  public void removeLangkahGambarByIdLangkah(final int idLangkah) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveLangkahGambarByIdLangkah.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, idLangkah);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveLangkahGambarByIdLangkah.release(_stmt);
    }
  }

  @Override
  public Observable<List<BookmarkEntity>> getBookmarkByUser(final String idUser) {
    final String _sql = "SELECT * FROM tb_bookmark WHERE id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    return RxRoom.createObservable(__db, false, new String[]{"tb_bookmark"}, new Callable<List<BookmarkEntity>>() {
      @Override
      public List<BookmarkEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdResep = CursorUtil.getColumnIndexOrThrow(_cursor, "id_resep");
          final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
          final int _cursorIndexOfTitleResep = CursorUtil.getColumnIndexOrThrow(_cursor, "title_resep");
          final int _cursorIndexOfPosterResep = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_resep");
          final List<BookmarkEntity> _result = new ArrayList<BookmarkEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BookmarkEntity _item;
            _item = new BookmarkEntity();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpIdResep;
            _tmpIdResep = _cursor.getString(_cursorIndexOfIdResep);
            _item.setIdResep(_tmpIdResep);
            final String _tmpIdUser;
            _tmpIdUser = _cursor.getString(_cursorIndexOfIdUser);
            _item.setIdUser(_tmpIdUser);
            final String _tmpTitleResep;
            _tmpTitleResep = _cursor.getString(_cursorIndexOfTitleResep);
            _item.setTitleResep(_tmpTitleResep);
            final String _tmpPosterResep;
            _tmpPosterResep = _cursor.getString(_cursorIndexOfPosterResep);
            _item.setPosterResep(_tmpPosterResep);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public boolean checkBookmark(final String idResep, final String idUser) {
    final String _sql = "SELECT * FROM tb_bookmark WHERE id_resep = ? AND id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idResep == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idResep);
    }
    _argIndex = 2;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public BookmarkEntity getItemBookmark(final String idResep, final String idUser) {
    final String _sql = "SELECT * FROM tb_bookmark WHERE id_resep = ? AND id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idResep == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idResep);
    }
    _argIndex = 2;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdResep = CursorUtil.getColumnIndexOrThrow(_cursor, "id_resep");
      final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
      final int _cursorIndexOfTitleResep = CursorUtil.getColumnIndexOrThrow(_cursor, "title_resep");
      final int _cursorIndexOfPosterResep = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_resep");
      final BookmarkEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new BookmarkEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpIdResep;
        _tmpIdResep = _cursor.getString(_cursorIndexOfIdResep);
        _result.setIdResep(_tmpIdResep);
        final String _tmpIdUser;
        _tmpIdUser = _cursor.getString(_cursorIndexOfIdUser);
        _result.setIdUser(_tmpIdUser);
        final String _tmpTitleResep;
        _tmpTitleResep = _cursor.getString(_cursorIndexOfTitleResep);
        _result.setTitleResep(_tmpTitleResep);
        final String _tmpPosterResep;
        _tmpPosterResep = _cursor.getString(_cursorIndexOfPosterResep);
        _result.setPosterResep(_tmpPosterResep);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Observable<List<RencanaEntity>> getRencanaByUser(final String idUser,
      final String status) {
    final String _sql = "SELECT * FROM tb_rencana WHERE id_user = ? AND status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    _argIndex = 2;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return RxRoom.createObservable(__db, false, new String[]{"tb_rencana"}, new Callable<List<RencanaEntity>>() {
      @Override
      public List<RencanaEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdResep = CursorUtil.getColumnIndexOrThrow(_cursor, "id_resep");
          final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
          final int _cursorIndexOfTitleResep = CursorUtil.getColumnIndexOrThrow(_cursor, "title_resep");
          final int _cursorIndexOfPosterResep = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_resep");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<RencanaEntity> _result = new ArrayList<RencanaEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RencanaEntity _item;
            _item = new RencanaEntity();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpIdResep;
            _tmpIdResep = _cursor.getString(_cursorIndexOfIdResep);
            _item.setIdResep(_tmpIdResep);
            final String _tmpIdUser;
            _tmpIdUser = _cursor.getString(_cursorIndexOfIdUser);
            _item.setIdUser(_tmpIdUser);
            final String _tmpTitleResep;
            _tmpTitleResep = _cursor.getString(_cursorIndexOfTitleResep);
            _item.setTitleResep(_tmpTitleResep);
            final String _tmpPosterResep;
            _tmpPosterResep = _cursor.getString(_cursorIndexOfPosterResep);
            _item.setPosterResep(_tmpPosterResep);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item.setStatus(_tmpStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public boolean checkRencana(final String idResep, final String idUser) {
    final String _sql = "SELECT * FROM tb_rencana WHERE id_resep = ? AND id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idResep == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idResep);
    }
    _argIndex = 2;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RencanaEntity getItemRencana(final String idResep, final String idUser) {
    final String _sql = "SELECT * FROM tb_rencana WHERE id_resep = ? AND id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (idResep == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idResep);
    }
    _argIndex = 2;
    if (idUser == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idUser);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdResep = CursorUtil.getColumnIndexOrThrow(_cursor, "id_resep");
      final int _cursorIndexOfIdUser = CursorUtil.getColumnIndexOrThrow(_cursor, "id_user");
      final int _cursorIndexOfTitleResep = CursorUtil.getColumnIndexOrThrow(_cursor, "title_resep");
      final int _cursorIndexOfPosterResep = CursorUtil.getColumnIndexOrThrow(_cursor, "poster_resep");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final RencanaEntity _result;
      if(_cursor.moveToFirst()) {
        _result = new RencanaEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpIdResep;
        _tmpIdResep = _cursor.getString(_cursorIndexOfIdResep);
        _result.setIdResep(_tmpIdResep);
        final String _tmpIdUser;
        _tmpIdUser = _cursor.getString(_cursorIndexOfIdUser);
        _result.setIdUser(_tmpIdUser);
        final String _tmpTitleResep;
        _tmpTitleResep = _cursor.getString(_cursorIndexOfTitleResep);
        _result.setTitleResep(_tmpTitleResep);
        final String _tmpPosterResep;
        _tmpPosterResep = _cursor.getString(_cursorIndexOfPosterResep);
        _result.setPosterResep(_tmpPosterResep);
        final String _tmpStatus;
        _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        _result.setStatus(_tmpStatus);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BahanEntity> getBahan() {
    final String _sql = "SELECT * FROM tb_bahan";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfBahan = CursorUtil.getColumnIndexOrThrow(_cursor, "bahan");
      final List<BahanEntity> _result = new ArrayList<BahanEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BahanEntity _item;
        _item = new BahanEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpBahan;
        _tmpBahan = _cursor.getString(_cursorIndexOfBahan);
        _item.setBahan(_tmpBahan);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BahanGambarEntity> getBahanGambar(final int idBahan) {
    final String _sql = "SELECT * FROM tb_gambar_bahan WHERE id_bahan = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idBahan);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdBahan = CursorUtil.getColumnIndexOrThrow(_cursor, "id_bahan");
      final int _cursorIndexOfGambar = CursorUtil.getColumnIndexOrThrow(_cursor, "gambar");
      final List<BahanGambarEntity> _result = new ArrayList<BahanGambarEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BahanGambarEntity _item;
        _item = new BahanGambarEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdBahan;
        _tmpIdBahan = _cursor.getInt(_cursorIndexOfIdBahan);
        _item.setIdBahan(_tmpIdBahan);
        final String _tmpGambar;
        _tmpGambar = _cursor.getString(_cursorIndexOfGambar);
        _item.setGambar(_tmpGambar);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LangkahEntity> getLangkah() {
    final String _sql = "SELECT * FROM tb_langkah";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfLangkah = CursorUtil.getColumnIndexOrThrow(_cursor, "langkah");
      final List<LangkahEntity> _result = new ArrayList<LangkahEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LangkahEntity _item;
        _item = new LangkahEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpLangkah;
        _tmpLangkah = _cursor.getString(_cursorIndexOfLangkah);
        _item.setLangkah(_tmpLangkah);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<LangkahGambarEntity> getLangkahGambar(final int idLangkah) {
    final String _sql = "SELECT * FROM tb_gambar_langkah WHERE id_langkah = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idLangkah);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdLangkah = CursorUtil.getColumnIndexOrThrow(_cursor, "id_langkah");
      final int _cursorIndexOfGambar = CursorUtil.getColumnIndexOrThrow(_cursor, "gambar");
      final List<LangkahGambarEntity> _result = new ArrayList<LangkahGambarEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LangkahGambarEntity _item;
        _item = new LangkahGambarEntity();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdLangkah;
        _tmpIdLangkah = _cursor.getInt(_cursorIndexOfIdLangkah);
        _item.setIdLangkah(_tmpIdLangkah);
        final String _tmpGambar;
        _tmpGambar = _cursor.getString(_cursorIndexOfGambar);
        _item.setGambar(_tmpGambar);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
