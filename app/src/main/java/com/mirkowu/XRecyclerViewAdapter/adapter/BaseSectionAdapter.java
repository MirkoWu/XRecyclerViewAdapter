package com.mirkowu.XRecyclerViewAdapter.adapter;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

import com.mirkowu.library.BaseRVAdapter;
import com.mirkowu.library.BaseRVHolder;


/**
 * Created by DELL on 2017/6/28.
 */

public abstract class BaseSectionAdapter<T extends SectionInterface, VH extends BaseRVHolder> extends BaseRVAdapter<T, VH> {
    private int mSectionHeadResId;
    public static final int SECTION_HEADER_VIEW = 0x010101011;

    public BaseSectionAdapter( @LayoutRes int mSectionHeadResId,@LayoutRes int mLayoutResId) {
        super(mLayoutResId);
        this.mSectionHeadResId = mSectionHeadResId;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        switch (holder.getItemViewType()) {
            case SECTION_HEADER_VIEW:
                setFullSpan(holder);
                convertHead(holder, mData.get(holder.getLayoutPosition() - getHeaderLayoutCount()),position);
                break;
            default:
                super.onBindViewHolder(holder, position);
                break;
        }
    }


    @Override
    protected int getDefItemViewType(int position) {
        return mData.get(position).isHeader() ? SECTION_HEADER_VIEW : 0;
    }

    @Override
    protected VH onCreateDefViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SECTION_HEADER_VIEW)
            return createBaseViewHolder(getItemView(mSectionHeadResId, parent));

        return super.onCreateDefViewHolder(parent, viewType);
    }


    protected abstract void convertHead(BaseRVHolder holder, T data,int position);

}
