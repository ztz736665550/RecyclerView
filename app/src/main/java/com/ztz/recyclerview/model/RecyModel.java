package com.ztz.recyclerview.model;

import com.ztz.recyclerview.bean.MusicBean;
import com.ztz.recyclerview.okhttp.AbstractUiCallBack;
import com.ztz.recyclerview.okhttp.OkhttpUtils;

/**
 * Created by TR on 2017/11/22.
 */

public class RecyModel {

    public void RequestDate(int a, final RecyModleCallBack recyModleCallBack) {
         OkhttpUtils.getInstance().asy(null, "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=15&offset="+a, new AbstractUiCallBack<MusicBean>() {
             @Override
             public void success(MusicBean musicBean) {
                 if (musicBean != null) {
                     recyModleCallBack.success(musicBean);
                 }
             }

             @Override
             public void failure(Exception e) {
                recyModleCallBack.failed(e);
             }
         });
    }


}
