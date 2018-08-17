package com.ljp.greendaodemo.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ljp.greendaodemo.bean.RecordsBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RECORDS_BEAN".
*/
public class RecordsBeanDao extends AbstractDao<RecordsBean, Long> {

    public static final String TABLENAME = "RECORDS_BEAN";

    /**
     * Properties of entity RecordsBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Account = new Property(1, String.class, "account", false, "ACCOUNT");
        public final static Property Password = new Property(2, String.class, "password", false, "PASSWORD");
        public final static Property Login_time = new Property(3, String.class, "login_time", false, "LOGIN_TIME");
        public final static Property Code = new Property(4, String.class, "code", false, "CODE");
    }


    public RecordsBeanDao(DaoConfig config) {
        super(config);
    }
    
    public RecordsBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RECORDS_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ACCOUNT\" TEXT," + // 1: account
                "\"PASSWORD\" TEXT," + // 2: password
                "\"LOGIN_TIME\" TEXT," + // 3: login_time
                "\"CODE\" TEXT);"); // 4: code
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RECORDS_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RecordsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        String login_time = entity.getLogin_time();
        if (login_time != null) {
            stmt.bindString(4, login_time);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(5, code);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RecordsBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(2, account);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(3, password);
        }
 
        String login_time = entity.getLogin_time();
        if (login_time != null) {
            stmt.bindString(4, login_time);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(5, code);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RecordsBean readEntity(Cursor cursor, int offset) {
        RecordsBean entity = new RecordsBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // account
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // password
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // login_time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // code
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RecordsBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAccount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPassword(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLogin_time(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCode(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RecordsBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RecordsBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RecordsBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}