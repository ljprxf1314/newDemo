package com.ljp.gridcount;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     author : lijipei
 *     time   : 2018/7/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class MyAdapter extends BaseAdapter {

    List<Float> list;
    private OnItemListener listener;

    private int index;
    private EditText mEtNum;

    public void setListener(OnItemListener listener) {
        this.listener = listener;
    }

    public void setData(List<Float> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_num, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mEtNum.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        holder.mEtNum.setText(list.get(position)+"");

        final ViewHolder holder2 = holder;
        holder.mEtNum.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    index = position;
                    mEtNum = holder2.mEtNum;
                    holder2.mEtNum.setSelection(mEtNum.getText().length());
                    holder2.mEtNum.setSelectAllOnFocus(true);//全部选中方式
                    holder2.mEtNum.addTextChangedListener(textWatcher);
                } else {
                    holder2.mEtNum.removeTextChangedListener(textWatcher);
                }
            }
        });

        return view;
    }

        private TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0, s.toString().indexOf(".") + 3);
                        mEtNum.setText(s);
                        mEtNum.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    mEtNum.setText(s);
                    mEtNum.setSelection(2);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                listener.onItem(index, editable.toString());
            }
        };

    public interface OnItemListener {
        void onItem(int i,String num);
    }

    class ViewHolder {
        @BindView(R.id.et_num)
        EditText mEtNum;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
