package com.alipayjf.game.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alipayjf.game.R;
import com.alipayjf.game.util.SharedPreferencesUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import net.lemonsoft.lemonbubble.LemonBubble;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class CustomFragment extends Fragment implements RetrofitListener{

    private boolean isFragmentVisible;
    private boolean isReuseView;
    private boolean isFirstVisible;
    private View rootView;
    private Context mContext;
    private View mView;
    private SmartRefreshLayout refresh;

    //下面是当前基础布局
    private FrameLayout mainView;
    //页面效果
    private RelativeLayout load_box;
    private TextView isEmpty,isTvErr;
    public final int SHOW_ERR = 0X1;//显示错误页面
    public final int SHOW_EMPTY = 0X2;//显示空数据页面
    public final int SHOW_DATA = 0X3;//显示数据页面

    private Map<String,String> params;
    private Map<String,String> headParams;
    protected UserSession userSession;
    /*
     * 当创建多个Fragment时，通过传递参数来识别
     * */
    public CustomFragment setArguments(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("_type", type);
        setArguments(bundle);
        return this;
    }

    /*
     * 获取当前的类型
     * */
    public String getFragType() {
        Bundle bundle = getArguments();
        return bundle.getString("_type", "");
    }

    /*
     * 高版本需要走这个方法
     * */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /*
     * 低版本需要走这个方法
     * */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //setUserVisibleHint()在Fragment创建时会先被调用一次，传入isVisibleToUser = false
    //如果当前Fragment可见，那么setUserVisibleHint()会再次被调用一次，传入isVisibleToUser = true
    //如果Fragment从可见->不可见，那么setUserVisibleHint()也会被调用，传入isVisibleToUser = false
    //总结：setUserVisibleHint()除了Fragment的可见状态发生变化时会被回调外，在new Fragment()时也会被回调
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //setUserVisibleHint()有可能在fragment的生命周期外被调用
        if (rootView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible();
            isFirstVisible = false;
        }
        if (isVisibleToUser) {
            onFragmentVisibleChange(true);
            isFragmentVisible = true;
            return;
        }
        if (isFragmentVisible) {
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null)
            mView = inflater.inflate(R.layout.fragment_custom, container, false);
        mainView = mView.findViewById(R.id.mainView);
        refresh = mView.findViewById(R.id.refresh);
        //加载主布局
        View childView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);
        mainView.addView(childView);
        initPrompt(mView);
        getUserSession();
        initView(mView);
        setOnRefresh();
        return mView;
    }

    /*
     * 初始化加载控件各个设置
     * */
    private void setOnRefresh(){
        //开启上拉加载更多功能
        refresh.setEnableLoadMore(false);
        //设置刷新监听
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshData();
            }
        });
        //设置主题颜色
        refresh.setPrimaryColors(0xFF13B6A5);
        //初始刷新动画
        //refresh.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //初始化加载动画
        //refresh.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //如果setUserVisibleHint()在rootView创建前调用时，那么
        //就等到rootView创建完后才回调onFragmentVisibleChange(true)
        //保证onFragmentVisibleChange()的回调发生在rootView创建完成之后，以便支持ui操作
        if (rootView == null) {
            rootView = view;
            if (getUserVisibleHint()) {
                if (isFirstVisible) {
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        super.onViewCreated(isReuseView && rootView != null ? rootView : view, savedInstanceState);
    }

    /**
     * 去除setUserVisibleHint()多余的回调场景，保证只有当fragment可见状态发生变化时才回调
     * 回调时机在view创建完后，所以支持ui操作，解决在setUserVisibleHint()里进行ui操作有可能报null异常的问题
     *
     * 可在该回调方法里进行一些ui显示与隐藏
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {
        try {
            /*if (isVisible) {
                if (mRefreshState == STATE_REFRESHING) {
                    mRefreshListener.onRefreshing();
                }
            } else {
                mRefreshListener.onRefreshFinish();
            }*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 在fragment首次可见时回调，可用于加载数据，防止每次进入都重复加载数据
     */
    protected void onFragmentFirstVisible() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        initVariable();
    }

    private void initVariable() {
        isFirstVisible = true;
        isFragmentVisible = false;
        rootView = null;
        isReuseView = true;
    }

    public abstract int getLayoutId();
    public abstract void initView(View mView);
    public void refreshData(){

    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getContext(),clz);
        if(bundle != null){
            intent.putExtra("bundle",bundle);
        }
        getContext().startActivity(intent);
    }

    /*
     * 加载页面显示效果
     * */
    private void initPrompt(View mView){
        load_box = mView.findViewById(R.id.load_box);
        isEmpty = mView.findViewById(R.id.isEmpty);
        isTvErr = mView.findViewById(R.id.isErr);
    }

    /*
     * 显示页面效果切换
     * */
    public void setPromtView(int type){
        if(type == SHOW_ERR){
            mainView.setVisibility(View.GONE);
            load_box.setVisibility(View.VISIBLE);
            isTvErr.setVisibility(View.VISIBLE);
            isEmpty.setVisibility(View.GONE);
        }else if(type == SHOW_EMPTY){
            mainView.setVisibility(View.GONE);
            load_box.setVisibility(View.VISIBLE);
            isTvErr.setVisibility(View.GONE);
            isEmpty.setVisibility(View.VISIBLE);
        }else{
            load_box.setVisibility(View.GONE);
            mainView.setVisibility(View.VISIBLE);
        }
    }
    /*
     * 组装参数
     * */
    public CustomFragment setParams(String key,String value){
        if(params == null){
            params = new HashMap<>();
        }
        params.put(key,value);
        return this;
    }
    /*
     * 清空参数集
     * */
    protected CustomFragment clearParams(){
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
    public CustomFragment setHeadParams(String key,String value){
        if(headParams == null){
            headParams = new HashMap<>();
        }
        headParams.put(key,value);
        return this;
    }

    /*
     * 清空头部参数集
     * */
    protected CustomFragment clearHeadParams(){
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
     * 获取userSession
     * */
    private void getUserSession(){
        userSession = (UserSession) SharedPreferencesUtil.getBean(getContext(),"userSession");
    }

    /*
     * 关闭刷新的回调方法
     * */
    @Override
    public void closeRefresh() {
        if(refresh != null){
            refresh.finishRefresh();
        }
    }

    /*
     * 请求失败的回调
     * */
    @Override
    public void onError(String description) {
        LemonBubble.showError(getContext(), "出错啦！", 2000);
    }

}
