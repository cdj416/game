package com.alipayjf.game.ui.personinfo;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityPersoninfoBinding;

public class PersonInfoActivity extends CustomActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personinfo;
    }

    @Override
    protected void initView() {
        setTitle("个人信息");
        ActivityPersoninfoBinding binding = ActivityPersoninfoBinding.bind(mView);
        PersonInfoViewModel viewModel = new PersonInfoViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
