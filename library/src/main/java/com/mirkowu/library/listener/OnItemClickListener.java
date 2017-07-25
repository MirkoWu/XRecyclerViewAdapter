package com.mirkowu.library.listener;

import android.view.View;

/**
 * Created by MirkoWu on 2017/3/17 0017.
 */

public interface OnItemClickListener<Dao> {
    /**
     * @param itemView The view within the ViewHolder that was clicked.
     * @param data
     * @param position
     */
    void onItemClickListener(View itemView, Dao data, int position);
}
