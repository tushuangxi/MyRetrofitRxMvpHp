package com.jinhui.androidprojecthelper.libding.rerxmvp.view.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import com.jinhui.androidprojecthelper.R;
import com.jinhui.androidprojecthelper.libding.entity.GetListRsp;
import com.jinhui.androidprojecthelper.libding.http.ServiceMapParams;
import com.jinhui.androidprojecthelper.libding.rerxmvp.base.BaseFragment;
import com.jinhui.androidprojecthelper.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.jinhui.androidprojecthelper.libding.rerxmvp.model.FirstModel;
import com.jinhui.androidprojecthelper.libding.rerxmvp.presenter.FirstPresenter;
import com.jinhui.androidprojecthelper.libding.wighit.LoadingDialog;

/**
 * 描述：
 * Created by qyh on 2016/12/10.
 */
public class FirstTabFragment extends BaseFragment<FirstPresenter,FirstModel> implements interfaceUtilsAll.View {

    private  int SIZE=20;
    @BindView(R.id.rv_content)
    public RecyclerView rv_content;
    @BindView(R.id.toolbar_title)
    public TextView toolbar_title;
    private Context mContext;

    @Override
    protected int getLayoutResource() {
        mContext = getActivity();
        return R.layout.fragment_firtst;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {

        mPresenter.getFirstListDataRequest(ServiceMapParams.getGetListRspMapParams());
        toolbar_title.setText("妹纸");
    }

    @Override
    public void showListData(GetListRsp getListRsp) {

        Toast.makeText(mContext,getListRsp.getFemale().iterator().next().getName(),Toast.LENGTH_SHORT).show();
    }
    //如果使用内嵌的加载提示，需要在这里处理，，
    // 我使用的LoadingDialog的方法，加载成功自动消失，所以不用处理进度消失等事件
    @Override
    public void showLoading(String title) {
        LoadingDialog.showDialogForLoading(getActivity());
    }

    @Override
    public void stopLoading() {
        LoadingDialog.cancelDialogForLoading();
    }
    //加载失败提示，根据需要自己处理
    @Override
    public void showErrorTip(String msg) {
    }

//    //刷新
//    @Override
//    public void onRefreshLayoutBeginRefreshing(RefreshLayout refreshLayout) {
//        System.out.println("onRefreshLayoutBeginRefreshing===");
//        mPresenter.getFirstListDataRequest(ServiceMapParams.getGetListRspMapParams());
//    }
//
//    //加载更多
//    @Override
//    public boolean onRefreshLayoutBeginLoadingMore(RefreshLayout refreshLayout) {
//        SIZE+=20;
//        mPresenter.getFirstListDataRequest(ServiceMapParams.getGetListRspMapParams());
//        return true;
//    }
}
