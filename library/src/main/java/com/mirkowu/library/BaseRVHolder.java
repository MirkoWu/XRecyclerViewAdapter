package com.mirkowu.library;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;


/**
 * Created by Administrator on 2016/9/5 0005.
 */
public class BaseRVHolder extends RecyclerView.ViewHolder {

    public boolean isSelected;
    /**
     * Views indexed with their IDs
     */
    private final SparseArray<View> views;

    public HashSet<Integer> getNestViews() {
        return nestViews;
    }

    private final HashSet<Integer> nestViews;

    public <T extends View> T $(int resId) {
        return (T) itemView.findViewById(resId);
    }

    public <T extends View> T $(View view, int id) {
        return (T) view.findViewById(id);
    }

    public BaseRVHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<View>();
        this.nestViews = new HashSet<>();
    }
    
    /**
     * 待改进
     *
     * @param resId
     * @param str
     * @return
     */
    public BaseRVHolder setText(@IdRes int resId, String str) {
        ((TextView) $(resId)).setText(str);
        return this;
    }

    public BaseRVHolder setText(@IdRes int resId, @StringRes int strResId) {
        ((TextView) $(resId)).setText(strResId);
        return this;
    }

    public BaseRVHolder setImage(@IdRes int resId, @DrawableRes int strResId) {
        ((ImageView) $(resId)).setImageResource(strResId);
        return this;
    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The BaseRVHolder for chaining.
     */
    public BaseRVHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param tag    The tag;
     * @return The BaseRVHolder for chaining.
     */
    public BaseRVHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * Sets the tag of the view.
     *
     * @param viewId The view id.
     * @param key    The key of tag;
     * @param tag    The tag;
     * @return The BaseRVHolder for chaining.
     */
    public BaseRVHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * Sets the checked status of a checkable.
     *
     * @param viewId  The view id.
     * @param checked The checked status;
     * @return The BaseRVHolder for chaining.
     */
    public BaseRVHolder setChecked(int viewId, boolean checked) {
        View view = getView(viewId);
        // View unable cast to Checkable
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(checked);
        } else if (view instanceof CheckedTextView) {
            ((CheckedTextView) view).setChecked(checked);
        }
        return this;
    }

    /**
     * Sets the adapter of a adapter view.
     *
     * @param viewId  The view id.
     * @param adapter The adapter;
     * @return The BaseRVHolder for chaining.
     */
    public BaseRVHolder setAdapter(int viewId, Adapter adapter) {
        AdapterView view = getView(viewId);
        view.setAdapter(adapter);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}

