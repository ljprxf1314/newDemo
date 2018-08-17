package com.ljp.greendaodemo.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.ljp.greendaodemo.bean.UrlBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "URL_BEAN".
*/
public class UrlBeanDao extends AbstractDao<UrlBean, String> {

    public static final String TABLENAME = "URL_BEAN";

    /**
     * Properties of entity UrlBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Ip = new Property(1, String.class, "ip", false, "IP");
        public final static Property Domain_name = new Property(2, String.class, "domain_name", false, "DOMAIN_NAME");
        public final static Property Is_select = new Property(3, String.class, "is_select", false, "IS_SELECT");
    }


    public UrlBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UrlBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"URL_BEAN\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"IP\" TEXT," + // 1: ip
                "\"DOMAIN_NAME\" TEXT," + // 2: domain_name
                "\"IS_SELECT\" TEXT);"); // 3: is_select
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"URL_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UrlBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(2, ip);
        }
 
        String domain_name = entity.getDomain_name();
        if (domain_name != null) {
            stmt.bindString(3, domain_name);
        }
 
        String is_select = entity.getIs_select();
        if (is_select != null) {
            stmt.bindString(4, is_select);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UrlBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(2, ip);
        }
 
        String domain_name = entity.getDomain_name();
        if (domain_name != null) {
            stmt.bindString(3, domain_name);
        }
 
        String is_select = entity.getIs_select();
        if (is_select != null) {
            stmt.bindString(4, is_select);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public UrlBean readEntity(Cursor cursor, int offset) {
        UrlBean entity = new UrlBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ip
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // domain_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // is_select
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UrlBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setIp(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDomain_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIs_select(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final String updateKeyAfterInsert(UrlBean entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(UrlBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UrlBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}