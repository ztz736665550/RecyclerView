package com.ztz.recyclerview.presenter;

import com.ztz.recyclerview.activity.ShopCartActivity;
import com.ztz.recyclerview.bean.ShopBean;
import com.ztz.recyclerview.model.MainModel;
import com.ztz.recyclerview.model.MainModelCallBack;
import com.ztz.recyclerview.view.MainViewListener;

/**
 * Created by TR on 2017/11/22.
 */

public class MainPresenter {

    private MainViewListener listener;
    private MainModel mainModel;
    public MainPresenter(ShopCartActivity listener){
        this.listener = listener ;
        this.mainModel = new MainModel();
    }

    public void getData(){

        mainModel.getData(new MainModelCallBack() {

            @Override
            public void success(ShopBean bean) {

                if(listener != null){
                    listener.success(bean);
                }
            }

            @Override
            public void failure(Exception e) {

                if(listener != null){
                    listener.failure(e);
                }
            }
        });
    }
    /**
     * 防止内存泄漏
     */
    public void detach(){
        listener = null;
    }

}