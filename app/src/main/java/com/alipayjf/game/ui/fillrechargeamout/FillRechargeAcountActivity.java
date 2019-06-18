package com.alipayjf.game.ui.fillrechargeamout;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityFillRechargeAmountBinding;

public class FillRechargeAcountActivity extends CustomActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_fill_recharge_amount;
    }

    @Override
    protected void initView() {
        setTitle("填写金额");
        ActivityFillRechargeAmountBinding binding = ActivityFillRechargeAmountBinding.bind(mView);
        FillRechargeAcountViewModel viewModel = new FillRechargeAcountViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
