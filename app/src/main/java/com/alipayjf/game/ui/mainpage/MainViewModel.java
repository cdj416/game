package com.alipayjf.game.ui.mainpage;

import android.util.Log;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.databinding.ActivityMainBinding;
import com.alipayjf.game.util.BottomNavigationUtils;
import com.alipayjf.game.util.WsListener;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;

import me.majiajie.pagerbottomtabstrip.NavigationController;

public class MainViewModel extends CustomViewModel {
    private ActivityMainBinding binding;
    private NavController mNavController;

    private final int[] PAGE_IDS = {
            R.id.homePage,
            R.id.personPage,
    };

    public MainViewModel(CustomActivity mActivity, ActivityMainBinding binding) {
        super(mActivity);
        this.binding = binding;
        initView();
    }

    /*
    * 初始化顶部
    * */
    @Override
    protected void initView() {
        mNavController = Navigation.findNavController(mActivity, R.id.mNavController);
        NavigationController navigationController = binding.mNavigation.material()
                .addItem(R.mipmap.home_select, "首页",0xff13B6A5)
                .addItem(R.mipmap.person_select, "我的",0xff13B6A5)
                .build();
        BottomNavigationUtils.setupWithNavController(PAGE_IDS, navigationController, mNavController);
    }



    /*
    * 回调
    * */
    public boolean onSupportNavigateUp(){
        return mNavController.navigateUp();
    }

    @Override
    public void onSuccess(Object data) {

    }
}
