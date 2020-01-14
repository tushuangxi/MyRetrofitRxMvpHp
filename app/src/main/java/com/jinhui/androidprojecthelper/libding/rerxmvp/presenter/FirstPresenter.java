package com.jinhui.androidprojecthelper.libding.rerxmvp.presenter;

import java.util.Map;

import com.jinhui.androidprojecthelper.R;
import com.jinhui.androidprojecthelper.libding.entity.GetListRsp;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.baserx.RxSubscriber;
import com.jinhui.androidprojecthelper.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

/**
 * 描述：
 * Created by qyh on 2016/12/28.
 */
public class FirstPresenter extends interfaceUtilsAll.Presenter{

    @Override
    public void getFirstListDataRequest(Map<String, String> params) {

        mRxManage.add(mModel.getListData(params).subscribe(new RxSubscriber<GetListRsp>(mContext,false) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }
            @Override
            protected void _onNext(GetListRsp getListRsp) {
                mView.showListData(getListRsp);
                mView.stopLoading();
            }
            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
