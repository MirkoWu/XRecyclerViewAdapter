package com.mirkowu.library.listener;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MirkoWu on 2017/3/17 0017.
 */

public interface OnViewTouchListener<Dao> {
    void onViewTouch(View view, MotionEvent event, int position, Dao data);

}
