package com.xdjd.screendebug.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.xdjd.screendebug.R;
import com.xdjd.screendebug.bean.PlcTypeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/9/7
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class PLCTypeAdapter extends RecyclerView.Adapter<PLCTypeAdapter.MyViewHolder> {

    List<PlcTypeBean> list;
    Context mContext;
    OnPlcTypeListener listener;

    public PLCTypeAdapter(Context context) {
        mContext = context;
    }

    public void setListener(OnPlcTypeListener listener) {
        this.listener = listener;
    }

    public void setData(List<PlcTypeBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plctype, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        PlcTypeBean bean = list.get(position);

        holder.mTvName.setText(bean.getCode()+"-"+bean.getName());

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (listener!=null){
                    switch (event.getAction()){
                        case MotionEvent.ACTION_UP://抬起
                            listener.onUp(position);
                            break;
                        case MotionEvent.ACTION_DOWN://按下
                            listener.onDown(position);
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public interface OnPayTypeListener {
        void onPayType(int i);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.btn_name)
        Button mTvName;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnPlcTypeListener {
        void onUp(int i);

        void onDown(int i);
    }
}
