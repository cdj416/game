package com.alipayjf.game.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.RetrofitListener;
import com.alipayjf.game.base.UserSession;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.UserInfoBean;
import com.alipayjf.game.util.CalculationUtil;
import com.alipayjf.game.util.SharedPreferencesUtil;

import net.lemonsoft.lemonbubble.LemonBubble;

import java.util.HashMap;
import java.util.Map;

public class MainHeaderView extends LinearLayout implements View.OnClickListener, RetrofitListener {

    private TextView balance,income,badRecord,grabOrder;

    private UserSession userSession;
    private UserInfoBean infoBean;
    private boolean status;

    public MainHeaderView(Context context) {
        super(context);
        initLayoutView();
    }

    public MainHeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initLayoutView();
    }

    public MainHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayoutView();
    }

    public void initLayoutView() {
        View view = View.inflate(getContext(), R.layout.view_main_header, this);
        balance = view.findViewById(R.id.balance);
        income = view.findViewById(R.id.income);
        badRecord = view.findViewById(R.id.badRecord);
        grabOrder = view.findViewById(R.id.grabOrder);

        grabOrder.setOnClickListener(this);

        userSession = (UserSession) SharedPreferencesUtil.getBean(getContext(),"userSession");
    }

    /*
    * 初始化值
    * */
    public void setHeadData(UserInfoBean infoBean){
        this.infoBean = infoBean;
        try {
            balance.setText(CalculationUtil.getPrice(infoBean.getResult().getTotal_points()));
            income.setText(CalculationUtil.divide(infoBean.getResult().getEarn_points()+"","100",2));
            badRecord.setText(infoBean.getResult().getBadRecord()+"");
            if(infoBean.getResult().getOrder_status() == 1){
                grabOrder.setText("结束抢单");
            }
            if(infoBean.getResult().getOrder_status() == 0){
                grabOrder.setText("开始抢单");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        if("开始抢单".equals(grabOrder.getText().toString())){
            status = true;
        }
        if("结束抢单".equals(grabOrder.getText().toString())){
            status = false;
        }

        goQiang(status);
    }

    /*
     * 抢单接口
     * */
    private void goQiang(boolean status){
        Map<String,String> headParams = new HashMap<>();
        Map<String,String> params = new HashMap<>();

        if(status){
            headParams.put("Access-Token",userSession.getToken());
            params.put("userId",infoBean.getResult().getId()+"");
            params.put("status",1+"");
        }else{
            headParams.put("Access-Token",userSession.getToken());
            params.put("userId",infoBean.getResult().getId()+"");
            params.put("status",0+"");
        }

        Controller.getData(Constants.GRABORDER,params,headParams, BaseBean.class,this);
    }


    @Override
    public void onSuccess(Object data) {
        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                if(status){
                    LemonBubble.showRight(getContext(),"开始抢单！",2000);
                }else{
                    LemonBubble.showRight(getContext(),"结束抢单！",2000);
                }
                if(status){
                    grabOrder.setText("结束抢单");
                }else{
                    grabOrder.setText("开始抢单");
                }
            }else{
                if(status){
                    status = false;
                }else{
                    status = true;
                }
                LemonBubble.showError(getContext(),bean.getMessage(),2000);
            }
        }
    }

    @Override
    public void onError(String description) {

    }

    @Override
    public void closeRefresh() {

    }
}
