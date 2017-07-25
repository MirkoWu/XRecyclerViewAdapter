package com.mirkowu.library.listener;

import android.view.View;

/**
 * Created by MirkoWu on 2017/3/17 0017.
 */

public interface OnItemLongClickListener<Dao> {
    void onItemLongClickListener(View view, Dao data, int position);

}
