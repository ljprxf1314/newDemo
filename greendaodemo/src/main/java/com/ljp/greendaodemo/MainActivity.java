package com.ljp.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ljp.greendaodemo.bean.RecordsBean;
import com.ljp.greendaodemo.greendao.RecordsBeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.iv_arrow)
    ImageView mIvArrow;
    @BindView(R.id.ll_arrow)
    LinearLayout mLlArrow;
    @BindView(R.id.account_ll)
    RelativeLayout mAccountLl;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.ll_account_right)
    LinearLayout mLlAccountRight;

    private RecordsBeanDao mRecordsBeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecordsBeanDao = App.getInstance().getDaoSession().getRecordsBeanDao();

        //insert 增
        //loadAll 查询所有列表
        //deleteByKey 删除
        //update 改
        //insertOrReplace 修改或者替换（有的话就修改，没有则替换）
        //dao.queryBuilder().where(dao.date.eq(str)).build().listLazy(); 查找符合某一字段的所有元素
        //查询指定用户
//        public static List<UserInfo> SearchUserInfo(int id){
//            //惰性加载
//            List<UserInfo> list =  mUserInfoDao.queryBuilder().where(UserInfoDao.Properties.Id.eq(id)).list();
//            return list;
//        }


        //（1）@Entity 实体标识
        //        @nameInDb 在数据库中的名字，如不写则为实体中类名
        //        @indexes 索引
        //        @createInDb 是否创建表，默认为true,false时不创建
        //        @schema 指定架构名称为实体
        //        @active 无论是更新生成都刷新
        //（2）@Id 每条数据对应的位置，必写项
        //（3）@Property(nameInDb = "") 表示该属性将作为表的一个字段,其中nameInDb属性值是在数据库中对应的字段名称,
        //      可以自定义字段名,例如可以定一个跟实体对象字段不一样的字段名
        //（4）@NotNull 不为null
        //（5）@Unique 唯一约束   该属性值必须在数据库中是唯一值
        //（6）@ToMany 一对多 referencedJoinProperty
        //（7）@OrderBy 排序
        //（8）@ToOne 一对一 关系表
        //（9）@Transient 不保存于数据库
        //（10）@generated 由greendao产生的构造函数或方法

    }

    @OnClick({R.id.ll_arrow, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_arrow:
                List<RecordsBean> list = mRecordsBeanDao.loadAll();
                if (list !=null && list.size()>0){
                    Log.e("登录信息",mRecordsBeanDao.loadAll().toString());
                }else{
                    Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_btn:
                if (TextUtils.isEmpty(mEtAccount.getText()) || TextUtils.isEmpty(mEtPwd.getText())){
                    Toast.makeText(this,"请填写账号或密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                mRecordsBeanDao.insert(new RecordsBean(null,mEtAccount.getText().toString(),
                        mEtPwd.getText().toString(),StringUtils.getDate(),"00"));
                break;
        }
    }
}
