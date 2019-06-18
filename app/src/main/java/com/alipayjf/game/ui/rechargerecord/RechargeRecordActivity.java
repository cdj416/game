package com.alipayjf.game.ui.rechargerecord;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityRechargeRecordBinding;

public class RechargeRecordActivity extends CustomActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge_record;
    }

    @Override
    protected void initView() {
        setTitle("充值记录");
        ActivityRechargeRecordBinding binding = ActivityRechargeRecordBinding.bind(mView);
        RechargeRecordViewMode viewMode = new RechargeRecordViewMode(this,binding);
        binding.setViewModel(viewMode);
    }
}
