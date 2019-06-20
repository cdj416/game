package com.alipayjf.game.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.alipayjf.game.util.SharedPreferencesUtil;
import com.google.gson.Gson;

import net.lemonsoft.lemonbubble.LemonBubble;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomViewModel implements RetrofitListener {
    protected CustomActivity mActivity;
    private Map<String,String> params;
    private Map<String,String> headParams;
    private JSONObject JsonParams;
    protected UserSession userSession;
    protected Gson gson;

    public CustomViewModel(CustomActivity mActivity) {
        this.mActivity = mActivity;
        gson = new Gson();
        getUserSession();
    }

    /*
     * 页面首次打开需要加载数据的方法
     * */
    protected void lazyLoad(){
    }

    /*
    * 加载一些控件的方法
    * */
    protected void initView(){

    }

    /*
    * 当activity再次出现在栈顶时刷新
    * */
    protected void onResume(){

    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(mActivity,clz);
        if(bundle != null){
            intent.putExtra("bundle",bundle);
        }
        mActivity.startActivity(intent);
    }

    /*
    * 组装json参数
    * */
    public CustomViewModel setJsonParams(String key,Object value){
        if(JsonParams == null){
            JsonParams = new JSONObject();
        }
        try {
            JsonParams.put(key,value);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return this;
    }
    /*
     * 清空json参数集
     * */
    protected CustomViewModel clearJsonParams(){
        if(JsonParams != null){
            JsonParams = null;
        }
        return this;
    }

    /*
    * 获取json参数集
    * */
    public JSONObject getJsonParams(){
        return this.JsonParams;
    }

    /*
    * 组装参数
    * */
    public CustomViewModel setParams(String key,String value){
        if(params == null){
            params = new HashMap<>();
        }
        params.put(key,value);
        return this;
    }

    /*
    * 清空参数集
    * */
    protected CustomViewModel clearParams(){
        if(params != null){
            params.clear();
        }
        return this;
    }

    /*
    * 获取参数集合
    * */
    protected Map<String,String> getParams(){
        return this.params;
    }
    /*
    * 组装头部参数
    * */
    public CustomViewModel setHeadParams(String key,String value){
        if(headParams == null){
            headParams = new HashMap<>();
        }
        headParams.put(key,value);
        return this;
    }

    /*
    * 清空头部参数集
    * */
    protected CustomViewModel clearHeadParams(){
        if(headParams != null){
            headParams.clear();
        }
        return this;
    }

    /*
    * 获取头部参数集合
    * */
    protected Map<String,String> getHeadParams(){
        return this.headParams;
    }

    /*
     * 关闭刷新的回调方法
     * */
    @Override
    public void closeRefresh() {
        mActivity.closeRefresh();
    }

    /*
     * 请求失败的回调
     * */
    @Override
    public void onError(String description) {
        LemonBubble.showError(mActivity, "出错啦！", 2000);
    }

    /*
    * 获取userSession
    * */
    private void getUserSession(){
        userSession = (UserSession) SharedPreferencesUtil.getBean(mActivity,"userSession");
    }

    /*
    * 判断是否对象是否有值
    * */
    public boolean isValue(Object obj){
        if(obj == null || TextUtils.isEmpty(obj.toString()) || "null".equals(obj.toString())){
            return false;
        }
        return true;
    }
}
