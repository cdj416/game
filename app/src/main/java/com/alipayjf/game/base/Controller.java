package com.alipayjf.game.base;

import android.util.Log;

import com.alipayjf.game.util.GsonUtil;
import com.google.gson.Gson;

import net.lemonsoft.lemonbubble.LemonBubble;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class Controller {
    /**
     * post请求方式
     */
    public static synchronized  <T> void postData(CustomActivity mActivity,
                                                  final String path,
                                                  Map<String,String> maps,
                                                  Map<String,String> headerParams,
                                                  final Class<T> dataBean,
                                                  final RetrofitListener<T> listener) {
        //开启加载动画
        LemonBubble.showRoundProgress(mActivity, "等待中...");

        RequestParams params = new RequestParams(path);
        if(maps != null){
            //组装常规参数
            Set<String> set = maps.keySet();
            for (String s : set) {
                String key = s;
                String value = maps.get(s);
                params.addBodyParameter(key, value);
            }
        }
        if(headerParams != null){
            //组装头部参数
            Set<String> headSet = headerParams.keySet();
            for (String hs : headSet) {
                String hKey = hs;
                String hValue = headerParams.get(hs);
                params.addHeader(hKey, hValue);
            }
        }
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("cdj","====="+result);
                try {
                    T data = GsonUtil.getGson().fromJson(result,dataBean);
                    //请求成功并解析成功反馈结果
                    if(listener != null){
                        listener.onSuccess(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //解析出错
                    if(listener != null){
                        listener.onError("解析异常！");
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //请求错误反馈信息
                if(listener != null){
                    listener.onError(ex.getMessage());
                }
            }
            @Override
            public void onCancelled(CancelledException cex) {
                //取消请求反馈信息
                if(listener != null){
                    listener.onError(cex.getMessage());
                }
            }
            @Override
            public void onFinished() {
                //关闭刷新
                if(listener != null){
                    listener.closeRefresh();
                }
            }
        });

    }
    /**
     * get请求方式
     */
    public static synchronized  <T> void getData(String path,
                                                 Map<String,String> maps,
                                                 Map<String,String> headerParams,
                                                 final Class<T> dataBean,
                                                 final RetrofitListener<T> listener) {

        RequestParams params = new RequestParams(path);
        if(maps != null){
            //组装常规参数
            Set<String> set = maps.keySet();
            for (String s : set) {
                String key = s;
                String value = maps.get(s);
                params.addBodyParameter(key, value);
                Log.e("cdj","========"+value);
            }
        }
        if(headerParams != null){
            //组装头部参数
            Set<String> headSet = headerParams.keySet();
            for (String hs : headSet) {
                String hKey = hs;
                String hValue = headerParams.get(hs);
                params.addHeader(hKey, hValue);
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("cdj","====="+result);
                try {
                    T data = GsonUtil.getGson().fromJson(result,dataBean);
                    //请求成功并解析成功反馈结果
                    if(listener != null){
                        listener.onSuccess(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //解析出错
                    if(listener != null){
                        listener.onError("解析异常！");
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //请求错误反馈信息
                if(listener != null){
                    listener.onError(ex.getMessage());
                }
            }
            @Override
            public void onCancelled(CancelledException cex) {
                //取消请求反馈信息
                if(listener != null){
                    listener.onError(cex.getMessage());
                }
            }
            @Override
            public void onFinished() {
                //关闭刷新
                if(listener != null){
                    listener.closeRefresh();
                }
            }
        });

    }

    /*
    * json传递方式
    * */
    public static synchronized  <T> void postData(CustomActivity mActivity,
                                                  String path,
                                                  Map<String,String> maps,
                                                  final Class<T> dataBean,
                                                  final RetrofitListener<T> listener) {
        //开启加载动画
        LemonBubble.showRoundProgress(mActivity, "等待中...");

        RequestParams params = new RequestParams(path);
        if(maps != null){
            Gson gson = new Gson();
            String dataJson = gson.toJson(maps);
            Log.e("cdj","=====json==="+dataJson);
            params.setAsJsonContent(true);
            params.setBodyContent(dataJson);
        }
        x.http().post(params, getCallback(dataBean,listener));

    }
    /*
    * json传递方式
    * */
    public static synchronized  <T> void postData(CustomActivity mActivity,
                                                  String path,
                                                  String jsonParams,
                                                  final Class<T> dataBean,
                                                  final RetrofitListener<T> listener) {
        //开启加载动画
        LemonBubble.showRoundProgress(mActivity, "等待中...");

        RequestParams params = new RequestParams(path);
        params.setAsJsonContent(true);
        params.setBodyContent(jsonParams);
        x.http().post(params, getCallback(dataBean,listener));

    }
    /*
    * json传递方式
    * */
    public static synchronized  <T> void postJsonData(String path,
                                                  Map<String,String> maps,
                                                  Map<String,String> headerParams,
                                                  final Class<T> dataBean,
                                                  final RetrofitListener<T> listener) {

        RequestParams params = new RequestParams(path);
        if(maps != null){
            Gson gson = new Gson();
            String dataJson = gson.toJson(maps);
            Log.e("cdj","=====json==="+dataJson);
            params.setAsJsonContent(true);
            params.setBodyContent(dataJson);
        }
        if(headerParams != null){
            //组装头部参数
            Set<String> headSet = headerParams.keySet();
            for (String hs : headSet) {
                String hKey = hs;
                String hValue = headerParams.get(hs);
                params.addHeader(hKey, hValue);
            }
        }
        x.http().post(params, getCallback(dataBean,listener));

    }

    /*
    * 单个文件上传
    * */
    public static synchronized  <T> void uploadingImg(CustomActivity mActivity,
                                                      String path, File file,Class<T> dataBean,
                                                      RetrofitListener<T> listener){
        //开启加载动画
        LemonBubble.showRoundProgress(mActivity, "上传文件中...");
        RequestParams params = new RequestParams(path);
        params.setMultipart(true);
        params.addBodyParameter("file",file);//设置上传的文件路径
        x.http().post(params, getCallback(dataBean,listener));
    }



    /*
    * json传递方式
    * */
    public static synchronized <T> void myRequest(String path,String json,
                                                  Map<String,String> headerParams,
                                                  final Class<T> dataBean,
                                                  final RetrofitListener<T> listener){
        RequestParams params = new RequestParams(path);
        params.setAsJsonContent(true);
        params.setBodyContent(json);
        if(headerParams != null){
            //组装头部参数
            Set<String> headSet = headerParams.keySet();
            for (String hs : headSet) {
                String hKey = hs;
                String hValue = headerParams.get(hs);
                params.addHeader(hKey, hValue);
            }
        }
        x.http().post(params, getCallback(dataBean,listener));
    }


    /*
    * callback
    * */
    private static <T> Callback.CommonCallback<String> getCallback(final Class<T> dataBean,
                                                                   final RetrofitListener<T> listener){
        return new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("cdj","====="+result);
                try {
                    T data = GsonUtil.getGson().fromJson(result,dataBean);
                    //请求成功并解析成功反馈结果
                    if(listener != null){
                        listener.onSuccess(data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    //解析出错
                    if(listener != null){
                        listener.onError("解析异常！");
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                //请求错误反馈信息
                if(listener != null){
                    listener.onError(ex.getMessage());
                }
            }
            @Override
            public void onCancelled(CancelledException cex) {
                //取消请求反馈信息
                if(listener != null){
                    listener.onError(cex.getMessage());
                }
            }
            @Override
            public void onFinished() {
                //关闭刷新
                if(listener != null){
                    listener.closeRefresh();
                }
            }
        };
    }

}
