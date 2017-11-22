package com.ztz.recyclerview.model;


import com.ztz.recyclerview.bean.ShopBean;

/**
 * Created by TR on 2017/11/22.
 */

public interface MainModelCallBack {
    void success(ShopBean bean);
    void failure(Exception e);
}
