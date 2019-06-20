package com.alipayjf.game.ui.login;

import android.text.TextUtils;

import com.alipayjf.game.base.UserSession;
import com.alipayjf.game.ui.mainpage.MainActivity;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityLoginBinding;
import com.alipayjf.game.entity.LoginBean;
import com.alipayjf.game.ui.registered.RegisteredActivity;
import com.alipayjf.game.util.SharedPreferencesUtil;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class LoginViewMode extends CustomViewModel {

    private ActivityLoginBinding binding;

    public LoginViewMode(CustomActivity mActivity, ActivityLoginBinding binding) {
        super(mActivity);
        this.binding = binding;
    }


    //登录点击事件
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            login();
        }
    });

    //注册点击事件
    public BindingCommand registeredOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            startActivity(RegisteredActivity.class,null);
        }
    });

    /*
    * 登录
    * */
    private void login(){
        if(TextUtils.isEmpty(binding.etPhone.getText().toString())){
            LemonBubble.showError(mActivity,"请填写手机号码！",2000);
            return;
        }
        if(TextUtils.isEmpty(binding.etPassword.getText().toString())){
            LemonBubble.showError(mActivity,"请输入密码！",2000);
            return;
        }
        clearParams().setParams("username",binding.etPhone.getText().toString())
                .setParams("password",binding.etPassword.getText().toString());
        /*clearParams().setParams("username","17784495260")
                .setParams("password","123456");*/
        /*clearParams().setParams("username","18183185173")
                .setParams("password","123");*/
        Controller.postData(mActivity, Constants.LOGIN,getParams(),null, LoginBean.class,this);
    }


    @Override
    public void onSuccess(Object data) {
        if(data instanceof LoginBean){
            LoginBean loginBean = (LoginBean)data;
            if(loginBean.getCode() == 200){
                UserSession userSession = new UserSession();
                userSession.setToken(loginBean.getResult().getToken());
                userSession.setUsername(loginBean.getResult().getUsername());
                SharedPreferencesUtil.putBean(mActivity,"userSession",userSession);
                //startActivity(MainActivity.class,null);
                //mActivity.finish();
                mActivity.showSuccess("登录成功！",MainActivity.class,null);
            }else{
                LemonBubble.showError(mActivity,loginBean.getMessage(),2000);
            }
        }
    }
}
