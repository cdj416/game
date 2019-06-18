package com.alipayjf.game.ui.mainpage;
import android.view.KeyEvent;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends CustomActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTitle("码商系统");
        hideTitleLeft();
        binding = ActivityMainBinding.bind(mView);
        viewModel = new MainViewModel(this,binding);
        binding.setViewModel(viewModel);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return viewModel.onSupportNavigateUp();
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode== KeyEvent.KEYCODE_BACK){
            moveTaskToBack(true);
            return true;//不执行父类点击事件
        }
        return super.onKeyDown(keyCode, event);//继续执行父类其他点击事件
    }
}
