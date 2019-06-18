package com.alipayjf.game.ui.reflectiverecord;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityReflectiveRecordBinding;

public class ReflectiveRecordActivity extends CustomActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reflective_record;
    }
    ReflectiveRecordViewModel viewModel;
    @Override
    protected void initView() {
        setTitle("提现记录");
        ActivityReflectiveRecordBinding binding = ActivityReflectiveRecordBinding.bind(mView);
        viewModel = new ReflectiveRecordViewModel(this,binding);
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }
}
