package com.alipayjf.game.ui.personinfo;

import android.util.Log;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.base.MyApplication;
import com.alipayjf.game.databinding.ActivityPersoninfoBinding;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.UserInfoBean;
import com.alipayjf.game.ui.legalize.LegalizeActivity;
import com.alipayjf.game.util.CalculationUtil;
import com.google.gson.Gson;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class PersonInfoViewModel extends CustomViewModel {
    private UserInfoBean userInfoBean;
    private ActivityPersoninfoBinding binding;

    public PersonInfoViewModel(CustomActivity mActivity, ActivityPersoninfoBinding binding) {
        super(mActivity);
        this.binding = binding;
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
    * 初始化用户信息
    * */
    private void setUserInfo(){
        binding.infoName.setText(getText(userInfoBean.getResult().getAccountName()));
        binding.infoCard.setText(getText(userInfoBean.getResult().getCardNo()));
        binding.infoCardName.setText(getText(userInfoBean.getResult().getBankName()));
        binding.infoCardAddress.setText(getText(userInfoBean.getResult().getDepositBankName()));
        binding.infoMinPrice.setText(CalculationUtil.getPrice(userInfoBean.getResult().getMinFee()));
        binding.infoManPrice.setText(CalculationUtil.getPrice(userInfoBean.getResult().getMaxFee()));
    }

    /*
    * 修改用户信息
    * */
    public BindingCommand submit = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if(check()){
                changeData();
                updata();
            }
        }
    });

    /*
    * 去修改二维码
    * */
    public BindingCommand toUpdataImg = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(LegalizeActivity.class,null);
        }
    });

    /*
    * 请求修改用户信息
    * */
    private void updata(){
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        Gson gson = new Gson();
        String dataJson = gson.toJson(userInfoBean.getResult());
        Controller.myRequest(Constants.SAVEUSER,dataJson,getHeadParams(), BaseBean.class,this);
    }

    /*
    * 判断信息是否填写完成
    * */
    private boolean check(){
        if(!isValue(binding.infoName.getText().toString())){
            LemonBubble.showError(mActivity,"请填写姓名！",2000);
            return false;
        }
        if(!isValue(binding.infoCard.getText().toString())){
            LemonBubble.showError(mActivity,"请填写卡号！",2000);
            return false;
        }
        if(!isValue(binding.infoCardName.getText().toString())){
            LemonBubble.showError(mActivity,"请填写银行！",2000);
            return false;
        }
        if(!isValue(binding.infoCardAddress.getText().toString())){
            LemonBubble.showError(mActivity,"请填写开户行！",2000);
            return false;
        }
        if(!isMaxPrice(binding.infoManPrice.getText().toString())){
            LemonBubble.showError(mActivity,"请填写正确最大金额！",2000);
            return false;
        }
        if(!isMinPrice(binding.infoMinPrice.getText().toString())){
            LemonBubble.showError(mActivity,"请填写正确最小金额！",2000);
            return false;
        }
        return true;
    }

    /*
    * 更改本地数据
    * */
    private void changeData(){
        userInfoBean.getResult().setAccountName(binding.infoName.getText().toString());
        userInfoBean.getResult().setCardNo(binding.infoCard.getText().toString());
        userInfoBean.getResult().setBankName(binding.infoCardName.getText().toString());
        userInfoBean.getResult().setDepositBankName(binding.infoCardAddress.getText().toString());
        userInfoBean.getResult().setMinFee(Integer.valueOf(binding.infoMinPrice.getText().toString()));
        userInfoBean.getResult().setMaxFee(Integer.valueOf(binding.infoManPrice.getText().toString()));
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof UserInfoBean){
            userInfoBean = (UserInfoBean)data;
            if(userInfoBean.getCode() == 200){
                setUserInfo();
            }
        }
        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                Log.e("cdj","======"+ MyApplication.getInstance().getApplicationContext());
                //new PromptDialog().showText(MyApplication.getInstance().getApplicationContext(),"测试");
                mActivity.finish();
            }
        }
    }

    /*
    * 返回设置值
    * */
    private String getText(Object obj){
        return isValue(obj) ? obj.toString() :"";
    }

    /*
    * 最大金额判断
    * */
    private boolean isMaxPrice(String price){
        int maxPrice;
        try {
            maxPrice = Integer.valueOf(price);
            if(maxPrice <= 0){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /*
    * 判断最小金额
    * */
    private boolean isMinPrice(String price){
        int minPrice;
        try {
            minPrice = Integer.valueOf(price);
            if(minPrice <= 0){
                return false;
            }
            if(minPrice > Integer.valueOf(binding.infoManPrice.getText().toString())){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
