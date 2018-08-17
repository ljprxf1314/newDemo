package com.ljp.greendaodemo.db;

import android.content.Context;

import com.ljp.greendaodemo.App;
import com.ljp.greendaodemo.bean.RecordsBean;
import com.ljp.greendaodemo.greendao.RecordsBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/11
 *     desc   : 数据库dao类操作封装
 *     version: 1.0
 * </pre>
 */

public class RecordsBeanDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, RecordsBean stu) {
        App.getInstance().getDaoSession().getRecordsBeanDao().insert(stu);
    }

    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<RecordsBean> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        App.getInstance().getDaoSession().getRecordsBeanDao().insertInTx(list);
    }
    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param RecordsBean
     */
    public static void saveData(Context context, RecordsBean RecordsBean) {
        App.getInstance().getDaoSession().getRecordsBeanDao().save(RecordsBean);
    }
    /**
     * 删除数据至数据库
     *
     * @param context
     * @param RecordsBean 删除具体内容
     */
    public static void deleteData(Context context, RecordsBean RecordsBean) {
        App.getInstance().getDaoSession().getRecordsBeanDao().delete(RecordsBean);
    }
    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        App.getInstance().getDaoSession().getRecordsBeanDao().deleteByKey(id);
    }
    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        App.getInstance().getDaoSession().getRecordsBeanDao().deleteAll();
    }
    /**
     * 更新数据库
     *
     * @param context
     * @param RecordsBean
     */
    public static void updateData(Context context, RecordsBean RecordsBean) {
        App.getInstance().getDaoSession().getRecordsBeanDao().update(RecordsBean);
    }
    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<RecordsBean> queryAll(Context context) {
        QueryBuilder<RecordsBean> builder = App.getInstance().getDaoSession().getRecordsBeanDao().queryBuilder();
        return builder.build().list();
    }

    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<RecordsBean> queryPaging( int pageSize, int pageNum,Context context){
        RecordsBeanDao RecordsBeanDao = App.getInstance().getDaoSession().getRecordsBeanDao();
        List<RecordsBean> listMsg = RecordsBeanDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }

}
