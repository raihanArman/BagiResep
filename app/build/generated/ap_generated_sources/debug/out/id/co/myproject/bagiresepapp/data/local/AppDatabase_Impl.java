package id.co.myproject.bagiresepapp.data.local;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao;
import id.co.myproject.bagiresepapp.data.local.dao.DatabaseDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile DatabaseDao _databaseDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_bookmark` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_resep` TEXT, `id_user` TEXT, `title_resep` TEXT, `poster_resep` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_rencana` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_resep` TEXT, `id_user` TEXT, `title_resep` TEXT, `poster_resep` TEXT, `status` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_bahan` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bahan` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_gambar_bahan` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_bahan` INTEGER NOT NULL, `gambar` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_langkah` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `langkah` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_gambar_langkah` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_langkah` INTEGER NOT NULL, `gambar` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '194d3a875ab2020cef16a677f77f75da')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tb_bookmark`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_rencana`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_bahan`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_gambar_bahan`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_langkah`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_gambar_langkah`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTbBookmark = new HashMap<String, TableInfo.Column>(5);
        _columnsTbBookmark.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbBookmark.put("id_resep", new TableInfo.Column("id_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbBookmark.put("id_user", new TableInfo.Column("id_user", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbBookmark.put("title_resep", new TableInfo.Column("title_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbBookmark.put("poster_resep", new TableInfo.Column("poster_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbBookmark = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbBookmark = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbBookmark = new TableInfo("tb_bookmark", _columnsTbBookmark, _foreignKeysTbBookmark, _indicesTbBookmark);
        final TableInfo _existingTbBookmark = TableInfo.read(_db, "tb_bookmark");
        if (! _infoTbBookmark.equals(_existingTbBookmark)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_bookmark(id.co.myproject.bagiresepapp.data.local.entity.BookmarkEntity).\n"
                  + " Expected:\n" + _infoTbBookmark + "\n"
                  + " Found:\n" + _existingTbBookmark);
        }
        final HashMap<String, TableInfo.Column> _columnsTbRencana = new HashMap<String, TableInfo.Column>(6);
        _columnsTbRencana.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbRencana.put("id_resep", new TableInfo.Column("id_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbRencana.put("id_user", new TableInfo.Column("id_user", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbRencana.put("title_resep", new TableInfo.Column("title_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbRencana.put("poster_resep", new TableInfo.Column("poster_resep", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbRencana.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbRencana = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbRencana = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbRencana = new TableInfo("tb_rencana", _columnsTbRencana, _foreignKeysTbRencana, _indicesTbRencana);
        final TableInfo _existingTbRencana = TableInfo.read(_db, "tb_rencana");
        if (! _infoTbRencana.equals(_existingTbRencana)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_rencana(id.co.myproject.bagiresepapp.data.local.entity.RencanaEntity).\n"
                  + " Expected:\n" + _infoTbRencana + "\n"
                  + " Found:\n" + _existingTbRencana);
        }
        final HashMap<String, TableInfo.Column> _columnsTbBahan = new HashMap<String, TableInfo.Column>(2);
        _columnsTbBahan.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbBahan.put("bahan", new TableInfo.Column("bahan", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbBahan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbBahan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbBahan = new TableInfo("tb_bahan", _columnsTbBahan, _foreignKeysTbBahan, _indicesTbBahan);
        final TableInfo _existingTbBahan = TableInfo.read(_db, "tb_bahan");
        if (! _infoTbBahan.equals(_existingTbBahan)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_bahan(id.co.myproject.bagiresepapp.data.local.entity.BahanEntity).\n"
                  + " Expected:\n" + _infoTbBahan + "\n"
                  + " Found:\n" + _existingTbBahan);
        }
        final HashMap<String, TableInfo.Column> _columnsTbGambarBahan = new HashMap<String, TableInfo.Column>(3);
        _columnsTbGambarBahan.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbGambarBahan.put("id_bahan", new TableInfo.Column("id_bahan", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbGambarBahan.put("gambar", new TableInfo.Column("gambar", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbGambarBahan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbGambarBahan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbGambarBahan = new TableInfo("tb_gambar_bahan", _columnsTbGambarBahan, _foreignKeysTbGambarBahan, _indicesTbGambarBahan);
        final TableInfo _existingTbGambarBahan = TableInfo.read(_db, "tb_gambar_bahan");
        if (! _infoTbGambarBahan.equals(_existingTbGambarBahan)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_gambar_bahan(id.co.myproject.bagiresepapp.data.local.entity.BahanGambarEntity).\n"
                  + " Expected:\n" + _infoTbGambarBahan + "\n"
                  + " Found:\n" + _existingTbGambarBahan);
        }
        final HashMap<String, TableInfo.Column> _columnsTbLangkah = new HashMap<String, TableInfo.Column>(2);
        _columnsTbLangkah.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbLangkah.put("langkah", new TableInfo.Column("langkah", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbLangkah = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbLangkah = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbLangkah = new TableInfo("tb_langkah", _columnsTbLangkah, _foreignKeysTbLangkah, _indicesTbLangkah);
        final TableInfo _existingTbLangkah = TableInfo.read(_db, "tb_langkah");
        if (! _infoTbLangkah.equals(_existingTbLangkah)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_langkah(id.co.myproject.bagiresepapp.data.local.entity.LangkahEntity).\n"
                  + " Expected:\n" + _infoTbLangkah + "\n"
                  + " Found:\n" + _existingTbLangkah);
        }
        final HashMap<String, TableInfo.Column> _columnsTbGambarLangkah = new HashMap<String, TableInfo.Column>(3);
        _columnsTbGambarLangkah.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbGambarLangkah.put("id_langkah", new TableInfo.Column("id_langkah", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbGambarLangkah.put("gambar", new TableInfo.Column("gambar", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbGambarLangkah = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbGambarLangkah = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbGambarLangkah = new TableInfo("tb_gambar_langkah", _columnsTbGambarLangkah, _foreignKeysTbGambarLangkah, _indicesTbGambarLangkah);
        final TableInfo _existingTbGambarLangkah = TableInfo.read(_db, "tb_gambar_langkah");
        if (! _infoTbGambarLangkah.equals(_existingTbGambarLangkah)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_gambar_langkah(id.co.myproject.bagiresepapp.data.local.entity.LangkahGambarEntity).\n"
                  + " Expected:\n" + _infoTbGambarLangkah + "\n"
                  + " Found:\n" + _existingTbGambarLangkah);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "194d3a875ab2020cef16a677f77f75da", "99c2d68801fe53cef96ecd2e9a177c75");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tb_bookmark","tb_rencana","tb_bahan","tb_gambar_bahan","tb_langkah","tb_gambar_langkah");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tb_bookmark`");
      _db.execSQL("DELETE FROM `tb_rencana`");
      _db.execSQL("DELETE FROM `tb_bahan`");
      _db.execSQL("DELETE FROM `tb_gambar_bahan`");
      _db.execSQL("DELETE FROM `tb_langkah`");
      _db.execSQL("DELETE FROM `tb_gambar_langkah`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DatabaseDao databaseDao() {
    if (_databaseDao != null) {
      return _databaseDao;
    } else {
      synchronized(this) {
        if(_databaseDao == null) {
          _databaseDao = new DatabaseDao_Impl(this);
        }
        return _databaseDao;
      }
    }
  }
}
