package com.alipayjf.game.ui.registered;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityRegisteredBinding;

public class RegisteredActivity extends CustomActivity {
    private RegisteredViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_registered;
    }

    @Override
    protected void initView() {
        setTitle("注册账号");
        ActivityRegisteredBinding binding = ActivityRegisteredBinding.bind(mView);
        viewModel = new RegisteredViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
