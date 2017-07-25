package com.mirkowu.library.bean;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public abstract class SectionBean<T> {
    public boolean isHeader;
    public T t;
    public String header;

    public SectionBean(boolean isHeader, String header) {
        this.isHeader = isHeader;
        this.header = header;
        this.t = null;
    }

    public SectionBean(T t) {
        this.isHeader = false;
        this.header = null;
        this.t = t;
    }
}
