package com.alipayjf.game.ui.recharge;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityRechargeBinding;

public class RechargeActivity extends CustomActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void initView() {
        setTitle("选择银行信息");
        ActivityRechargeBinding binding = ActivityRechargeBinding.bind(mView);
        RechargeViewModel viewModel = new RechargeViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
