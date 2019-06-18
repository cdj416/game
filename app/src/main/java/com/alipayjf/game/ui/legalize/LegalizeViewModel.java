package com.alipayjf.game.ui.legalize;

import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.custom_view.SelectPictureView;
import com.alipayjf.game.databinding.ActivityLegalizeBinding;
import com.alipayjf.game.entity.BaseBean;
import com.alipayjf.game.entity.RenZhengBean;
import com.alipayjf.game.entity.UploadImgBean;
import com.alipayjf.game.entity.UserInfoBean;
import com.google.gson.Gson;

import net.lemonsoft.lemonbubble.LemonBubble;

import java.io.File;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class LegalizeViewModel extends CustomViewModel implements SelectPictureView.LoadCompleted {
    private ActivityLegalizeBinding binding;
    private UserInfoBean infoBean;
    public static final int WXCLICK = 0X1;//标识选择的是微信
    public static final int APLIYCLICK = 0X2;//标识选择的是支付宝
    private int nowClick = WXCLICK;//当前选择

    public LegalizeViewModel(CustomActivity mActivity, ActivityLegalizeBinding binding) {
        super(mActivity);
        this.binding = binding;
        binding.wxImg.setCompleted(this);
        binding.applyImg.setCompleted(this);
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
    * 设置二维码图片
    * */
    private void setImg(UserInfoBean infoBean){
        if(isValue(infoBean.getResult().getWxCodeUrl())){
            binding.wxImg.showImg(infoBean.getResult().getWxCodeUrl());
        }
        if(isValue(infoBean.getResult().getZfbCodeUrl())){
            binding.applyImg.showImg(infoBean.getResult().getZfbCodeUrl());
        }
    }

    //微信付款码点击事件
    public BindingCommand WXClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            nowClick = WXCLICK;
            binding.wxImg.selectPhoto(mActivity);
        }
    });

    //微信付款码点击事件
    public BindingCommand apliyClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            nowClick = APLIYCLICK;
            binding.applyImg.selectPhoto(mActivity);
        }
    });

    //提交点击事件
    public BindingCommand submitClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            submitData();
        }
    });

    /*
    * 提交信息
    * */
    private void submitData(){
        clearHeadParams().setHeadParams("Content-Type","application/json")
                .setHeadParams("Access-Token",userSession.getToken());
        String dataJson;
        if(infoBean.getResult().getStatus() == 0 || infoBean.getResult().getStatus() == 3){
            RenZhengBean renZhengBean = new RenZhengBean();
            renZhengBean.setId(infoBean.getResult().getId()+"");
            RenZhengBean.WxFileBean wb = new RenZhengBean.WxFileBean();
            wb.setUrl(infoBean.getResult().getWxCodeUrl());
            renZhengBean.setWxFile(wb);

            RenZhengBean.ZfbFileBean zb = new RenZhengBean.ZfbFileBean();
            zb.setUrl(infoBean.getResult().getZfbCodeUrl());
            renZhengBean.setZfbFile(zb);
            dataJson = gson.toJson(renZhengBean);
        }else{
            dataJson = gson.toJson(infoBean.getResult());
        }

        Controller.myRequest(Constants.SAVEUSER,dataJson,getHeadParams(), BaseBean.class,this);
    }

    /*
    * 返回当前选择项
    * */
    public int getNowClick(){
        return this.nowClick;
    }

    @Override
    public void onSuccess(Object data) {
        if(data instanceof UserInfoBean){
            infoBean = (UserInfoBean)data;
            if(infoBean.getCode() == 200){
                setImg(infoBean);
            }
        }
        if(data instanceof UploadImgBean){
            UploadImgBean imgBean = (UploadImgBean)data;
            if(nowClick == WXCLICK && isValue(imgBean.getUrl())){
                infoBean.getResult().setWxCodeUrl(imgBean.getUrl());
            }
            if(nowClick == APLIYCLICK && isValue(imgBean.getUrl())){
                infoBean.getResult().setZfbCodeUrl(imgBean.getUrl());
            }
            LemonBubble.showRight(mActivity, "图片上传成功！", 2000);
        }

        if(data instanceof BaseBean){
            //BaseBean bean = (BaseBean)data;
            mActivity.finish();
        }
    }

    /*
    * 上传图片
    * */
    @Override
    public void uploadImg(File file) {
        Controller.uploadingImg(mActivity, Constants.UPLOADIMG,file, UploadImgBean.class,this);
    }
}
