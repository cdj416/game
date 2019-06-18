package com.alipayjf.game.ui.reflectiverecord.reflectivercord_detail;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityReflectiveDetailBinding;

public class ActivityRefectiverCordDetail extends CustomActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reflective_detail;
    }

    @Override
    protected void initView() {
        setTitle("提现详情");
        ActivityReflectiveDetailBinding binding = ActivityReflectiveDetailBinding.bind(mView);
        ReflectiverCordDectailViewModel viewModel = new ReflectiverCordDectailViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
