package com.ztz.recyclerview.model;

import com.ztz.recyclerview.bean.MusicBean;

/**
 * Created by TR on 2017/11/22.
 */

public interface RecyModleCallBack {
    void success(MusicBean musicBean);
    void failed(Exception e);
}
