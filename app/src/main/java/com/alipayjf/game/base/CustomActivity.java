package com.alipayjf.game.base;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.alipayjf.game.R;
import com.alipayjf.game.custom_view.TitleView;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import net.lemonsoft.lemonbubble.LemonBubble;

import io.reactivex.annotations.Nullable;


public abstract class CustomActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    //加载器
    public View mView;
    //父类中的标题栏
    private TitleView mainTitle;
    //父类中的刷新控件
    private SmartRefreshLayout refresh;
    //子类中的主要布局内容
    private FrameLayout mainView;
    //加载动画
    private FrameLayout loading;

    //页面效果
    private RelativeLayout load_box;
    private TextView isEmpty,isTvErr;
    public static final int SHOW_ERR = 0X1;//显示错误页面
    public static final int SHOW_EMPTY = 0X2;//显示空数据页面
    public static final int SHOW_DATA = 0X3;//显示数据页面

    //跳转处理需要的对象
    private Class<?> clz;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //禁止使用横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //加载父布局
        setContentView(R.layout.activity_custom);

        loading = findViewById(R.id.loading);
        mainTitle = findViewById(R.id.mainTitle);
        mainView = findViewById(R.id.mainView);
        //加载主布局
        mView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        mainView.addView(mView);
        refresh = findViewById(R.id.refresh);

        //加载提示布局
        initPrompt();
        //初始化刷新控件
        setOnRefresh();
        //加载子布局视图
        initView();
    }

    /*
     * 加载页面显示效果
     * */
    private void initPrompt(){
        load_box = findViewById(R.id.load_box);
        isEmpty = findViewById(R.id.isEmpty);
        isTvErr = findViewById(R.id.isErr);
    }

    /*
     * 初始化加载控件各个设置
     * */
    private void setOnRefresh(){
        //关闭滚动到底部自动加载
        refresh.setEnableAutoLoadMore(false);
        //设置刷新监听
        refresh.setOnRefreshListener(onRefresh());
        //设置主题颜色
        refresh.setPrimaryColors(0xFFF2F2F2);
        //初始刷新动画
        refresh.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //初始化加载动画
        refresh.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        //关闭上拉加载更多
        setEnableLoadMore(false);
        //是否开启自动刷新
        setAutoRefresh(false);
        //是否开启刷新功能
        setEnableRefresh(false);
    }

    /*
    * 是否开启上拉加载(默认不开启)
    * */
    public void setEnableLoadMore(boolean flag){
        if(refresh != null){
            refresh.setEnableLoadMore(flag);
        }
    }

    /*
    * 是否开启自动刷新(默认不开启)
    * */
    public void setAutoRefresh(boolean flag){
        if(flag){
            refresh.autoRefresh();
        }
    }

    /*
    * 是否开启刷新功能（默认不开启）
    * */
    public void setEnableRefresh(boolean flag){
        if(refresh != null){
            refresh.setEnableRefresh(flag);
        }
    }

    /*
     * 下拉刷新监听
     * */
    private OnRefreshListener onRefresh() {
        return new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshData();
            }
        };
    }

    /*
     * 设置标题
     * */
    protected void setTitle(String title){
        mainTitle.setCentreText(title);
    }
    /*
     * 获取标题控件
     * */
    protected TitleView getMainTitle(){
        return this.mainTitle;
    }

    /*
    * 隐藏标题
    * */
    protected void hideTitle(boolean flag){
        if(flag){
            mainTitle.setVisibility(View.GONE);
        }
    }

    /*
    * 隐藏左边返回键
    * */
    protected void hideTitleLeft(){
        mainTitle.hideLeft();
    }

    /*
     * 加载布局文件
     * */
    protected abstract int getLayoutId();

    /*
     * 加载布局控件
     * */
    protected abstract void initView();

    /*
    * 刷新调用的函数
    * */
    public void refreshData(){

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
    * 加载动画的关闭
    * */
    public void closeLoading(){
        loading.setVisibility(View.GONE);
    }

    /*
    * 加载动画的开启
    * */
    public void openLoading(){
        loading.setVisibility(View.VISIBLE);
    }
    /*
     * 关闭刷新的回调方法
     * */
    public void closeRefresh() {
        if(refresh != null){
            refresh.finishRefresh();
        }
    }

    /**
     * 跳转页面
     */
    public void startActivity() {
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if(bundle != null){
            intent.putExtra("bundle",bundle);
        }
        startActivity(intent);
    }

    /*
    * 成功提示弹框，并过三秒关掉当前activity
    * */
    public void showSuccess(String message){
        LemonBubble.showRight(this,message,2000);
        handler.postDelayed(runnableClose, 2000);
    }
    /*
    * 成功提示弹框，并过三秒关掉当前activity
    * */
    public void showSuccess(String message,Class<?> clz, Bundle bundle){
        this.clz = clz;
        this.bundle = bundle;
        LemonBubble.showRight(this,message,2000);
        handler.postDelayed(runnableClose, 2000);
    }

    /*
    * 错误提示
    * */
    public void showErr(String message){
        LemonBubble.showError(this,message,2000);
    }

    /*
    * 关闭当前页面
    * */
    Runnable runnableClose = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void run() {
            if(clz != null){
                startActivity();
            }
            finish();
        }
    };
}
