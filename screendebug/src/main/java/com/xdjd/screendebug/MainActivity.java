package com.xdjd.screendebug;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ala.libmodbusapi.libmodbusapi;
import com.xdjd.screendebug.adapter.PLCTypeAdapter;
import com.xdjd.screendebug.base.BaseActivity;
import com.xdjd.screendebug.bean.PlcTypeBean;
import com.xdjd.utils.UIUtils;
import com.xdjd.view.GridSpacingItemDecoration;
import com.xdjd.view.MyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.serialnum)
    EditText mSerialnum;
    @BindView(R.id.busid)
    EditText mBusid;
    @BindView(R.id.button_ok)
    Button mButtonOk;
    @BindView(R.id.rv_paytype)
    RecyclerView mRvPaytype;

    private List<PlcTypeBean> listPlcType;
    PLCTypeAdapter adapter;

    private static libmodbusapi ModbusLib;
    private String serial = "ttyS1";
    private static int ibusid = 1;
    private int fid = 0; // file handler to the serial port

    private boolean isOK = false;

    private final String TAG = "大屏测试程序";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    public void initData() {
        initList();

        adapter = new PLCTypeAdapter(this);
        adapter.setData(listPlcType);

        int spanCount = 4;
        int spacing = UIUtils.dp2px(10);
        boolean includeEdge = true;
        mRvPaytype.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        MyGridLayoutManager layoutManager = new MyGridLayoutManager(this, 4);
        layoutManager.setScrollEnabled(true);
        mRvPaytype.setLayoutManager(layoutManager);
        mRvPaytype.setAdapter(adapter);

        adapter.setListener(new PLCTypeAdapter.OnPlcTypeListener() {
            @Override
            public void onUp(int i) {

            }

            @Override
            public void onDown(int i) {

            }
        });
    }

    private void initList(){
        listPlcType = new ArrayList<>();
        listPlcType.add(new PlcTypeBean("M24","X轴上进",2072,5));
        listPlcType.add(new PlcTypeBean("M23","X轴点出",2071,5));
        listPlcType.add(new PlcTypeBean("M25","Z轴点下",2073,5));
        listPlcType.add(new PlcTypeBean("M26","Z轴点上",2074,5));
        listPlcType.add(new PlcTypeBean("M27","A轴右点",2075,5));
        listPlcType.add(new PlcTypeBean("M28","A轴左点",2076,5));
        listPlcType.add(new PlcTypeBean("M29","夹手开",2077,5));
        listPlcType.add(new PlcTypeBean("M30","夹手闭",2078,5));
        listPlcType.add(new PlcTypeBean("M70","C轴右点",2118,5));
        listPlcType.add(new PlcTypeBean("M71","C轴左点",2119,5));
        listPlcType.add(new PlcTypeBean("M72","皮带点动",2120,5));
        listPlcType.add(new PlcTypeBean("M85","皮带连续",2133,5));
        listPlcType.add(new PlcTypeBean("M74","空调手动开",2122,5));
        listPlcType.add(new PlcTypeBean("M75","空调手动关",2123,5));
        listPlcType.add(new PlcTypeBean("M77","灯箱手动开",2125,5));
        listPlcType.add(new PlcTypeBean("M78","灯箱手动关",2126,5));
        listPlcType.add(new PlcTypeBean("M3","回原点",2051,5));
        listPlcType.add(new PlcTypeBean("M2","手动取水",2050,5));
        listPlcType.add(new PlcTypeBean("D896","取水位置",4992,6));
    }

    @OnClick({R.id.button_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                ibusid = Integer.parseInt(mBusid.getText().toString());
                String serial = mSerialnum.getText().toString();
                fid = ModbusLib.init_modbus("/dev/" + serial, ibusid,9600, 8, 1, 'E',4000, 4000);
                if(fid == 0) {
                    Log.e(TAG, " init modbus success . fid = " + fid);
                }else {
                    Log.e(TAG, " init modbus fail . fid = " + fid);
                }
                toast(" fid = " + fid );
                isOK = true;
                break;
        }
    }
}
