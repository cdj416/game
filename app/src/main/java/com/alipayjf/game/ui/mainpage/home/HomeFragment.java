package com.alipayjf.game.ui.mainpage.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomFragment;
import com.alipayjf.game.base.MessageEvent;
import com.alipayjf.game.custom_view.MainHeaderView;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.HomeBean;
import com.alipayjf.game.entity.UserInfoBean;
import com.alipayjf.game.ui.legalize.LegalizeActivity;
import com.alipayjf.game.util.CustomDialog;
import com.alipayjf.game.util.SharedPreferencesUtil;
import com.alipayjf.game.util.WebSocketUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.decoration.RecycleViewDivider;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class HomeFragment extends CustomFragment implements CustomDialog.DialogClick {

    private MainHeaderView mainHeaderView;
    private TextView clickRefresh;
    private RecyclerView mRecyclerView;
    private HomeAdapter adapter;
    private UserInfoBean userInfoBean;
    private HomeBean homeBean;

    //判断是否已经初始化了
    private boolean isLoad = false;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View mView) {
        if(!isLoad){
            mainHeaderView = mView.findViewById(R.id.mainHeaderView);
            clickRefresh = mView.findViewById(R.id.clickRefresh);
            mRecyclerView = mView.findViewById(R.id.mRecyclerView);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.VERTICAL, 1, getResources().getColor(R.color.color_F1F1F1)));
        adapter = new HomeAdapter();
        mRecyclerView.setAdapter(adapter);
        isLoad = true;

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                getSubmit(homeBean.getResult().getList().get(position).getId());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        //请求下数据
        getUserInfo();
    }

    /*
     * 请求用户信息
     * */
    private void getUserInfo(){
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.GETUSERINFO,null,getHeadParams(), UserInfoBean.class,this);
    }

    /*
     * 请求用户充值记录
     * */
    private void getUserRecRecord(UserInfoBean infoBean){
        clearParams().setParams("userId",infoBean.getResult().getId()+"");
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Controller.postJsonData(Constants.SELECTPAGE,getParams(),getHeadParams(), HomeBean.class,this);
    }

    /*
    * 确定收款接口
    * */
    private void getSubmit(int orderId){
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.SUBMITPRICE+orderId,null,getHeadParams(), BaseBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof UserInfoBean){
            userInfoBean = (UserInfoBean)data;
            if(userInfoBean.getCode() == 200){
                userSession.setUserId(userInfoBean.getResult().getId());
                SharedPreferencesUtil.putBean(getContext(),"userSession",userSession);
                mainHeaderView.setHeadData(userInfoBean);

                if(userInfoBean.getResult().getStatus() != 2){
                    CustomDialog.showGoLegalize(getContext(),userInfoBean,this);
                }else{
                    getUserRecRecord(userInfoBean);
                    if(!WebSocketUtil.getInstance().isConnection()){
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                WebSocketUtil.getInstance().connection(userInfoBean.getResult().getId());
                            }
                        }).start();
                    }
                }

            }
        }
        if(data instanceof HomeBean){
            homeBean = (HomeBean)data;
            if(homeBean.getCode() == 200){
                adapter.setNewData(homeBean.getResult().getList());
            }
        }

        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                getUserInfo();
            }
        }
    }

    /*
    * 刷新数据
    * */
    @Override
    public void refreshData(){
        getUserInfo();
    }

    @Override
    public void dialogClick(View v) {
        Intent intent = new Intent(getContext(), LegalizeActivity.class);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(MessageEvent message) {
        Log.e("cdj","========收到websoket消息====");
        //请求下数据
        getUserInfo();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
