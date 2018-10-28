package com.ljp.plcstoredemo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private int qsNowIndex = 32;//当前取水位置
    private int usableStore = 24;//可用库存
    private int actualStore = 29;//实际库存
    private int supplyIndex = 11;//补货格子编号

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
        list.add(new StoreBoxBean(13,90,"",0));
        list.add(new StoreBoxBean(15,104,"",0));


        list.add(new StoreBoxBean(2,13,"",0));
        list.add(new StoreBoxBean(4,27,"",0));
        list.add(new StoreBoxBean(6,41,"",0));
        list.add(new StoreBoxBean(8,55,"",0));
        list.add(new StoreBoxBean(10,69,"",0));
        list.add(new StoreBoxBean(12,83,"",0));
        list.add(new StoreBoxBean(14,97,"",0));
        list.add(new StoreBoxBean(16,111,"",0));

        adapter = new StoreBoxAdapter(this);
        adapter.setData(list);

        int spanCount = 8;
        int spacing = UIUtils.dp2px(2);
        boolean includeEdge = true;
        mRvList.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        MyGridLayoutManager layoutManager = new MyGridLayoutManager(this, 8);
        layoutManager.setScrollEnabled(false);
        mRvList.setLayoutManager(layoutManager);
        mRvList.setAdapter(adapter);

        //1.获取当前取水位置的格子编号
        int qsIndexCode = qsNowIndex/7;//取水位置编号
        int qsIndexNum = 0;//取水位置格子剩余数量
        if (qsNowIndex >= 0 && qsNowIndex<=6){//在第一格位置
            qsIndexNum = 7-qsNowIndex;
        }else{
            qsIndexNum = 7-(qsNowIndex)%7;
        }
        qsIndexCode = qsIndexNum>0?qsIndexCode+1:qsIndexCode;
        if (qsIndexCode==0){
            qsIndexCode = 1;
        }
        log("取水位置起始格子编号:"+qsIndexCode+"--箱子剩余水量:"+qsIndexNum);
        //2.可用库存格子位置
        int usableNum = qsNowIndex + usableStore - 1;
        if (usableNum>111){
            usableNum = usableNum - 111 - 1;
        }
//        if (usableNum <= 111 && usableNum>= 56){
//            usableNum = usableNum - (111+1);
//        }else if (usableNum >=0 && usableNum<=55){
//
//        }
//        int usableCode = (usableNum/7) + (usableNum%7>0?1:0);
        log("可用库存位置:"+usableNum+"---可用库存位置编号:"+getStoreCode(usableNum));
    }

    /**
     * 返回当前位置的编号
     * @param nowIndex
     * @return
     */
    private int getStoreCode(int nowIndex){
        int indexCode = nowIndex/7;//取水位置编号
        int qsIndexNum = 0;//取水位置格子剩余数量
        if (nowIndex >= 0 && nowIndex<=6){//在第一格位置
            qsIndexNum = 7-nowIndex;
        }else{
            qsIndexNum = 7-(nowIndex)%7;
        }
        indexCode = qsIndexNum>0?indexCode+1:indexCode;
        if (indexCode==0){
            indexCode = 1;
        }
        return indexCode;
    }

    private int getStoreNum(){
        int usableNum = qsNowIndex + usableStore - 1;
        if (usableNum>111){
            usableNum = usableNum - 111 - 1;
        }
        return usableNum;
    }

    private void log(String str){
        Log.e("补水",str);
    }
}
