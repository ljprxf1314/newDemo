package com.ljp.gridcount;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.gv_list)
    NoScrollGridView mGvList;
    @BindView(R.id.tv_result)
    TextView mTvResult;
    @BindView(R.id.ll)
    LinearLayout mLl;
    @BindView(R.id.btn)
    Button mBtn;

    List<Float> listNum;
    @BindView(R.id.btn_clear)
    Button mBtnClear;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        listNum = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            listNum.add(0f);
        }

        adapter = new MyAdapter();
        mGvList.setAdapter(adapter);

        adapter.setData(listNum);
        adapter.setListener(new MyAdapter.OnItemListener() {
            @Override
            public void onItem(int i, String num) {
                if (num == null || num.length() == 0) {
                    listNum.set(i, 0f);
                } else {
                    BigDecimal bg = new BigDecimal(num);
                    listNum.set(i, bg.floatValue());
                }
            }
        });

    }

    @OnClick({R.id.btn, R.id.btn_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                sort();
                break;
            case R.id.btn_clear:
                for (int i = 0; i < listNum.size(); i++) {
                    listNum.set(i, 0f);
                }
                adapter.notifyDataSetChanged();
                break;
        }
    }

    private void sort() {
        List<Float> list = new ArrayList<>();
        list.addAll(listNum);
        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            Log.e("----" + i, list.get(i) + "");
//        }
        List<Float> list2 = list.subList(3, 13);
//        for (int i = 0; i < list2.size(); i++) {
//            Log.e("list2----" + i, list2.get(i) + "");
//        }
        BigDecimal average = BigDecimal.ZERO;
        for (int i = 0; i < list2.size(); i++) {
            BigDecimal bg;
            if (list2.get(i) == null || list2.get(i) == 0f) {
                bg = BigDecimal.ZERO;
            } else {
                bg = new BigDecimal(list2.get(i));
            }
            average = average.add(bg);
        }
//        Log.e("----1", average.divide(new BigDecimal(list2.size())).toString());
//        Log.e("----2", average.divide(new BigDecimal(list2.size()), 2, BigDecimal.ROUND_HALF_UP).toString());
//        Log.e("----3", average.divide(new BigDecimal(list2.size()), 2, BigDecimal.ROUND_HALF_UP).
//                setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        String str = average.divide(new BigDecimal(list2.size()), 2, BigDecimal.ROUND_HALF_UP).
                setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        mTvResult.setText(str);
//        adapter.notifyDataSetChanged();
    }
}
