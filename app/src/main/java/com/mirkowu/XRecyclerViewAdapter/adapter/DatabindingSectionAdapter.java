package com.mirkowu.XRecyclerViewAdapter.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirkowu.XRecyclerViewAdapter.R;
import com.mirkowu.library.BaseRVHolder;


/**
 * Created by DELL on 2017/6/28.
 */

public class DatabindingSectionAdapter<T extends SectionInterface> extends BaseSectionAdapter<T, BaseRVHolder> {
    int variable;
    int headerVariable;

    public DatabindingSectionAdapter(@LayoutRes int mSectionHeadResId, int headerVariable, @LayoutRes int mLayoutResId, int variable) {
        super(mSectionHeadResId, mLayoutResId);
        this.variable = variable;
        this.headerVariable = headerVariable;
    }


    @Override
    protected void convertHead(BaseRVHolder holder, T data, int position) {
        ViewDataBinding binding = (ViewDataBinding) holder.itemView
                .getTag(R.id.XRVAdapter_databinding_support);
        binding.setVariable(headerVariable, data);
        binding.executePendingBindings();
    }

    @Override
    public void onBindVH(BaseRVHolder holder, T data, int position) {
        ViewDataBinding binding = (ViewDataBinding) holder.itemView
                .getTag(R.id.XRVAdapter_databinding_support);
        binding.setVariable(variable, data);
        binding.executePendingBindings();
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.XRVAdapter_databinding_support, binding);
        return view;
    }
}
