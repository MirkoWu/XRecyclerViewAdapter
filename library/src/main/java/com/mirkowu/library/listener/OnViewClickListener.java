package com.mirkowu.library.listener;

import android.view.View;

/**
 * Created by MirkoWu on 2017/3/17 0017.
 */

public interface OnViewClickListener<Dao> {
    void onViewClick(View view, Dao data, int position);
}
