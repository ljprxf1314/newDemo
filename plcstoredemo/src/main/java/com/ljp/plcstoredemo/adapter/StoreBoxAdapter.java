package com.ljp.plcstoredemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljp.plcstoredemo.R;
import com.ljp.plcstoredemo.bean.StoreBoxBean;

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

public class StoreBoxAdapter extends RecyclerView.Adapter<StoreBoxAdapter.MyViewHolder> {

    List<StoreBoxBean> list;
    Context mContext;
    OnPayTypeListener listener;

    public StoreBoxAdapter(Context context) {
        mContext = context;
    }

    public void setListener(OnPayTypeListener listener) {
        this.listener = listener;
    }

    public void setData(List<StoreBoxBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store_box, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        StoreBoxBean bean = list.get(position);

        holder.mTvCode.setText(bean.getCode()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onStoreBox(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public interface OnPayTypeListener {
        void onStoreBox(int i);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_code)
        TextView mTvCode;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
