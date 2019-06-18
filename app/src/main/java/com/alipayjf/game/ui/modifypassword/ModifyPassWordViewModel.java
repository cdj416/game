package com.alipayjf.game.ui.modifypassword;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityModifyPasswordBinding;
import com.alipayjf.game.entity.BaseBean;

import net.lemonsoft.lemonbubble.LemonBubble;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class ModifyPassWordViewModel extends CustomViewModel {
    private ActivityModifyPasswordBinding binding;

    public ModifyPassWordViewModel(CustomActivity mActivity, ActivityModifyPasswordBinding binding) {
        super(mActivity);
        this.binding = binding;
    }

    //修改密码
    public BindingCommand submit = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            updataPassword();
        }
    });

    /*
    * 确认修改
    * */
    private void updataPassword(){
        if(!isValue(binding.oldPassword.getText().toString())){
            LemonBubble.showError(mActivity,"请填写旧密码！",2000);
            return;
        }
        if(!isValue(binding.nowPassword.getText().toString())){
            LemonBubble.showError(mActivity,"请填写新密码！",2000);
            return;
        }

        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        setJsonParams("password",binding.nowPassword.getText().toString())
                .setJsonParams("oldPassword",binding.oldPassword.getText().toString());
        Controller.myRequest(Constants.UPDATAPASSORD,getJsonParams().toString(),getHeadParams(), BaseBean.class,this);
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof BaseBean){
            BaseBean bean = (BaseBean)data;
            if(bean.getCode() == 200){
                mActivity.finish();
            }else{
                LemonBubble.showError(mActivity,bean.getMessage(),2000);
            }
        }
    }
}
