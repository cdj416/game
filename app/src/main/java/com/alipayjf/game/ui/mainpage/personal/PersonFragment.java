package com.alipayjf.game.ui.mainpage.personal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomFragment;
import com.alipayjf.game.custom_view.ColumnItemView;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.UserInfoBean;
import com.alipayjf.game.ui.fillrechargeamout.FillRechargeAcountActivity;
import com.alipayjf.game.ui.legalize.LegalizeActivity;
import com.alipayjf.game.ui.login.LoginActivity;
import com.alipayjf.game.ui.modifypassword.ModifyPasswordActivity;
import com.alipayjf.game.ui.personinfo.PersonInfoActivity;
import com.alipayjf.game.ui.rechargerecord.RechargeRecordActivity;
import com.alipayjf.game.ui.reflectiverecord.ReflectiveRecordActivity;
import com.alipayjf.game.util.CalculationUtil;
import com.alipayjf.game.util.CustomDialog;

import net.lemonsoft.lemonbubble.LemonBubble;

public class PersonFragment extends CustomFragment implements View.OnClickListener, CustomDialog.DialogReturnText,CustomDialog.DialogClick {
    private ColumnItemView personInfo,modifyPassword,
            rechargeRecord,reflectiveRecord,contactCustomer
            ,customerPhone;
    private Button fillRecharge,withdraw;
    private TextView goOut,money;
    private UserInfoBean userInfoBean;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView(View mView) {
        personInfo = mView.findViewById(R.id.personInfo);
        modifyPassword = mView.findViewById(R.id.modifyPassword);
        rechargeRecord = mView.findViewById(R.id.rechargeRecord);
        reflectiveRecord = mView.findViewById(R.id.reflectiveRecord);
        contactCustomer = mView.findViewById(R.id.contactCustomer);
        customerPhone = mView.findViewById(R.id.customerPhone);
        fillRecharge = mView.findViewById(R.id.fillRecharge);
        withdraw = mView.findViewById(R.id.withdraw);
        goOut = mView.findViewById(R.id.goOut);
        money = mView.findViewById(R.id.money);

        personInfo.setOnClickListener(this);
        modifyPassword.setOnClickListener(this);
        rechargeRecord.setOnClickListener(this);
        reflectiveRecord.setOnClickListener(this);
        contactCustomer.setOnClickListener(this);
        customerPhone.setOnClickListener(this);
        fillRecharge.setOnClickListener(this);
        withdraw.setOnClickListener(this);
        goOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.personInfo:
                startActivity(PersonInfoActivity.class,null);
                break;
            case R.id.modifyPassword:
                startActivity(ModifyPasswordActivity.class,null);
                break;
            case R.id.rechargeRecord:
                startActivity(RechargeRecordActivity.class,null);
                break;
            case R.id.reflectiveRecord:
                startActivity(ReflectiveRecordActivity.class,null);
                break;
            case R.id.contactCustomer:
                String url="mqqwpa://im/chat?chat_type=wpa&uin=306316934";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
            case R.id.customerPhone:
                //Intent dialIntent =  new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + "18183185173"));//直接拨打电话
                //startActivity(dialIntent);
                break;
            case R.id.fillRecharge:
                startActivity(FillRechargeAcountActivity.class,null);
                break;
            case R.id.withdraw:
                CustomDialog.showWithdrawDialog(getContext(),userInfoBean.getResult().getTotal_points()+"",this);
                break;
            case R.id.goOut:
                startActivity(LoginActivity.class,null);
                ((Activity)getContext()).finish();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getUserInfo();
    }

    /*
     * 请求用户信息
     * */
    private void getUserInfo(){
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.GETUSERINFO,null,getHeadParams(), UserInfoBean.class,this);
    }

    @Override
    public void returnText(String text) {
        clearParams().setParams("userId",userSession.getUserId()+"")
                .setParams("fee",text);
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.CASHOUT,getParams(),getHeadParams(), BaseBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                LemonBubble.showRight(getContext(), "提现成功！", 2000);
            }else{
                LemonBubble.showError(getContext(), bean.getMessage(), 2000);
            }
        }

        if(data instanceof UserInfoBean){
            userInfoBean = (UserInfoBean)data;
            if(userInfoBean.getCode() == 200){
                if(userInfoBean.getResult().getStatus() != 2){
                    CustomDialog.showGoLegalize(getContext(),userInfoBean,this);
                }
                money.setText(CalculationUtil.getPrice(userInfoBean.getResult().getTotal_points()));
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
}
