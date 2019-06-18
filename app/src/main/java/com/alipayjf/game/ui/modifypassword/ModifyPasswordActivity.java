package com.alipayjf.game.ui.modifypassword;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityModifyPasswordBinding;

public class ModifyPasswordActivity extends CustomActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_password;
    }

    @Override
    protected void initView() {
        setTitle("修改密码");
        ActivityModifyPasswordBinding binding = ActivityModifyPasswordBinding.bind(mView);
        ModifyPassWordViewModel viewModel = new ModifyPassWordViewModel(this,binding);
        binding.setViewModel(viewModel);
    }
}
