package com.ljp.plcstoredemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljp.plcstoredemo.GridSpacingItemDecoration;
import com.ljp.plcstoredemo.R;
import com.ljp.plcstoredemo.UIUtils;
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
        //单个商家的商品列表不需要滑动，所以在这里禁止掉商品item的滑动事件
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(parent.getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        holder.childAdapter = new BoxItemAdapter();
        holder.mRvChild.setLayoutManager(linearLayoutManager);
        holder.mRvChild.setAdapter(holder.childAdapter);

        int spanCount = 1;
        int spacing = UIUtils.dp2px(1);
        boolean includeEdge = true;//是否包含边缘
        holder.mRvChild.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        //下面两句是防止刷新商品的recyclerView导致商家recyclerView也发生滑动
        holder.mRvChild.setFocusableInTouchMode(false);
        holder.mRvChild.requestFocus();
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        StoreBoxBean bean = list.get(position);

        holder.mTvCode.setText(bean.getCode() + "");

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
        @BindView(R.id.rv_child)
        RecyclerView mRvChild;
        BoxItemAdapter childAdapter;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
