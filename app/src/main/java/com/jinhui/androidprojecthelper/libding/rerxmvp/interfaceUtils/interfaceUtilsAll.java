package com.jinhui.androidprojecthelper.libding.rerxmvp.interfaceUtils;

import com.jinhui.androidprojecthelper.libding.entity.GetListRsp;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.BaseModel;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.BasePresenter;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.BaseView;

import java.util.Map;


import rx.Observable;

/**
 * 描述：
 * Created by qyh on 2016/12/28.
 */
public interface interfaceUtilsAll {

    interface Model extends BaseModel {
        //请求获取数据
        Observable<GetListRsp> getListData(Map<String, String> params);
    }
    interface View extends BaseView {
        //返回获取的数据
        void showListData(GetListRsp getListRsp);
    }

    abstract  class Presenter extends BasePresenter<View,Model> {
        public abstract  void getFirstListDataRequest(Map<String, String> params);
    }

}
