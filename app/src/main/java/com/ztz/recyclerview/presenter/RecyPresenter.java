package com.ztz.recyclerview.presenter;

import com.ztz.recyclerview.MainActivity;
import com.ztz.recyclerview.bean.MusicBean;
import com.ztz.recyclerview.model.RecyModel;
import com.ztz.recyclerview.model.RecyModleCallBack;

/**
 * Created by TR on 2017/11/22.
 */

public class RecyPresenter {
    private MainActivity recyViewCallBack;
    private final RecyModel model;
    public RecyPresenter(MainActivity recyViewCallBack) {
        this.recyViewCallBack = recyViewCallBack;
        this.model = new RecyModel();
    }
    public void RequestData(int a){
        model.RequestDate(a,new RecyModleCallBack() {
            @Override
            public void success(MusicBean musicBean) {
                recyViewCallBack.success(musicBean);
            }

            @Override
            public void failed(Exception e) {
                recyViewCallBack.failed(e);
            }
        });
    }
}
