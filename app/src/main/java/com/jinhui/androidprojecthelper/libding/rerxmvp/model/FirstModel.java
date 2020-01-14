package com.jinhui.androidprojecthelper.libding.rerxmvp.model;

import java.util.Map;

import com.jinhui.androidprojecthelper.libding.entity.GetListRsp;
import com.jinhui.androidprojecthelper.libding.http.manager.RetrofitManager;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.baserx.RxSchedulers;
import com.jinhui.androidprojecthelper.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import rx.Observable;
import rx.functions.Func1;

/**
 * 描述：
 * Created by qyh on 2016/12/28.
 */

public class FirstModel implements interfaceUtilsAll.Model {
    @Override
    public Observable<GetListRsp> getListData(Map<String, String> params) {

        return RetrofitManager.getInstance().service.getListData(params)
                .map(new Func1<GetListRsp, GetListRsp>() {

                    @Override
                    public GetListRsp call(GetListRsp getListRsp) {
                        return getListRsp;
                    }
                }).compose(RxSchedulers.<GetListRsp>io_main());
    }

}
