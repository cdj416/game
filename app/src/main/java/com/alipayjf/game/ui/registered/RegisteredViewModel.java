package com.alipayjf.game.ui.registered;

import android.text.TextUtils;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityRegisteredBinding;
import com.alipayjf.game.entity.PhoneCodeBean;
import com.alipayjf.game.entity.RegisteredBean;
import com.alipayjf.game.util.Countdown;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class RegisteredViewModel extends CustomViewModel {
    private ActivityRegisteredBinding binding;

    public RegisteredViewModel(CustomActivity mActivity, ActivityRegisteredBinding binding) {
        super(mActivity);
        this.binding = binding;

    }

    //获取验证码
    public BindingCommand getCodeOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //binding.tvGetCode.setClickable(false);
            if(TextUtils.isEmpty(binding.etPhone.getText().toString())){
                LemonBubble.showError(mActivity,"请填写手机号！",2000);
                return;
            }
            getCode();
        }
    });

    //注册
    public BindingCommand registeredOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //binding.tvGetCode.setClickable(false);
            if(TextUtils.isEmpty(binding.etPhone.getText().toString())){
                LemonBubble.showError(mActivity,"请填写手机号！",2000);
                return;
            }
            if(TextUtils.isEmpty(binding.phoneCode.getText().toString())){
                LemonBubble.showError(mActivity,"请填写验证码！",2000);
                return;
            }
            if(TextUtils.isEmpty(binding.passWord.getText().toString())){
                LemonBubble.showError(mActivity,"请填写密码！",2000);
                return;
            }
            //注册去
            submitRegist();
        }
    });

    //跳转到登录页面
    public BindingCommand goLoginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            mActivity.finish();
        }
    });

    /*
    * 请求验证码
    * */
    private void getCode(){
        clearParams().setParams("phone",binding.etPhone.getText().toString());
        Controller.getData(Constants.GET_CODE,getParams(),null, PhoneCodeBean.class,this);
    }

    /*
    * 注册请求
    * */
    private void submitRegist(){
        clearParams().setParams("username",binding.etPhone.getText().toString())
                .setParams("password",binding.passWord.getText().toString())
                .setParams("validateCode",binding.phoneCode.getText().toString());
        Controller.postData(mActivity,Constants.REGIST,getParams(), RegisteredBean.class,this);
    }



    @Override
    public void onSuccess(Object data) {
        if(data instanceof PhoneCodeBean){
            PhoneCodeBean bean = (PhoneCodeBean)data;
            if(bean.getCode() == 200){
                LemonBubble.showRight(mActivity, "验证码发送成功！", 2000);
                //倒计时开始
                new Countdown(binding.tvGetCode,60).startCountdown();
            }else{
                LemonBubble.showError(mActivity, bean.getMessage(), 2000);
            }
        }

        if(data instanceof RegisteredBean){
            RegisteredBean registeredBean = (RegisteredBean)data;
            if(registeredBean.getCode() == 200){
                mActivity.showSuccess("注册成功！");
            }else{
                LemonBubble.showError(mActivity,registeredBean.getMessage(),2000);
            }
        }
    }
}
