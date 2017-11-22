package com.ztz.recyclerview.view;

import com.ztz.recyclerview.bean.MusicBean;

/**
 * Created by TR on 2017/11/22.
 */

public interface RecyViewCallBack {
    void success(MusicBean musicBean);
    void failed(Exception e);
}
