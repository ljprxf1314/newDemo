package com.ljp.greendaodemo.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ljp.greendaodemo.bean.RecordsBean;
import com.ljp.greendaodemo.bean.UrlBean;

import com.ljp.greendaodemo.greendao.RecordsBeanDao;
import com.ljp.greendaodemo.greendao.UrlBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig recordsBeanDaoConfig;
    private final DaoConfig urlBeanDaoConfig;

    private final RecordsBeanDao recordsBeanDao;
    private final UrlBeanDao urlBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        recordsBeanDaoConfig = daoConfigMap.get(RecordsBeanDao.class).clone();
        recordsBeanDaoConfig.initIdentityScope(type);

        urlBeanDaoConfig = daoConfigMap.get(UrlBeanDao.class).clone();
        urlBeanDaoConfig.initIdentityScope(type);

        recordsBeanDao = new RecordsBeanDao(recordsBeanDaoConfig, this);
        urlBeanDao = new UrlBeanDao(urlBeanDaoConfig, this);

        registerDao(RecordsBean.class, recordsBeanDao);
        registerDao(UrlBean.class, urlBeanDao);
    }
    
    public void clear() {
        recordsBeanDaoConfig.clearIdentityScope();
        urlBeanDaoConfig.clearIdentityScope();
    }

    public RecordsBeanDao getRecordsBeanDao() {
        return recordsBeanDao;
    }

    public UrlBeanDao getUrlBeanDao() {
        return urlBeanDao;
    }

}
