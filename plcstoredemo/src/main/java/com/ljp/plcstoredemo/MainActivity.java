package com.ljp.plcstoredemo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.ljp.plcstoredemo.adapter.StoreBoxAdapter;
import com.ljp.plcstoredemo.bean.StoreBoxBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_list)
    RecyclerView mRvList;

    private List<StoreBoxBean> list = new ArrayList<>();
    private StoreBoxAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去掉actionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        initList();
    }

    private void initList(){
        list.add(new StoreBoxBean(1,6,"",0));

        list.add(new StoreBoxBean(3,20,"",0));
        list.add(new StoreBoxBean(5,34,"",0));
        list.add(new StoreBoxBean(7,48,"",0));
        list.add(new StoreBoxBean(9,62,"",0));
        list.add(new StoreBoxBean(11,76,"",0));
        list.add(new StoreBoxBean(12,83,"",0));
        list.add(new StoreBoxBean(13,90,"",0));
        list.add(new StoreBoxBean(14,97,"",0));
        list.add(new StoreBoxBean(15,104,"",0));
        list.add(new StoreBoxBean(16,111,"",0));


        list.add(new StoreBoxBean(2,13,"",0));
        list.add(new StoreBoxBean(4,27,"",0));
        list.add(new StoreBoxBean(6,41,"",0));
        list.add(new StoreBoxBean(8,55,"",0));
        list.add(new StoreBoxBean(10,69,"",0));

        adapter = new StoreBoxAdapter(this);
        adapter.setData(list);

        int spanCount = 8;
        int spacing = UIUtils.dp2px(1);
        boolean includeEdge = true;
        mRvList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        MyGridLayoutManager layoutManager = new MyGridLayoutManager(this, 8);
        layoutManager.setScrollEnabled(false);
        mRvList.setLayoutManager(layoutManager);
        mRvList.setAdapter(adapter);


    }

}
