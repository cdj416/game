package com.alipayjf.game.ui.rechargerecord;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityRechargeRecordBinding;

public class RechargeRecordActivity extends CustomActivity {
    private RechargeRecordViewMode viewMode;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge_record;
    }

    @Override
    protected void initView() {
        setTitle("充值记录");
        //开启刷新
        setEnableRefresh(true);
        ActivityRechargeRecordBinding binding = ActivityRechargeRecordBinding.bind(mView);
        viewMode = new RechargeRecordViewMode(this,binding);
        binding.setViewModel(viewMode);
    }

    @Override
    public void refreshData() {
        viewMode.getData();
    }
}
