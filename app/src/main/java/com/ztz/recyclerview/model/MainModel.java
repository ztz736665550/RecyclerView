package com.ztz.recyclerview.model;

import com.ztz.recyclerview.bean.ShopBean;
import com.ztz.recyclerview.okhttp.AbstractUiCallBack;
import com.ztz.recyclerview.okhttp.OkhttpUtils;

/**
 * Created by TR on 2017/11/22.
 */

public class MainModel {

    public void getData(final MainModelCallBack callBack){

        OkhttpUtils.getInstance().asy(null, "http://120.27.23.105/product/getCarts?uid=100", new AbstractUiCallBack<ShopBean>() {
            @Override
            public void success(ShopBean bean) {

                callBack.success(bean);
            }
            @Override
            public void failure(Exception e) {

                callBack.failure(e);
            }
        });
    }
}
