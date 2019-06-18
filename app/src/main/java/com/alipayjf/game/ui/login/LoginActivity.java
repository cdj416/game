package com.alipayjf.game.ui.login;
import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityLoginBinding;

public class LoginActivity extends CustomActivity {
    private LoginViewMode viewMode;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setTitle("登录账号");
        hideTitleLeft();
        ActivityLoginBinding binding = ActivityLoginBinding.bind(mView);
        viewMode = new LoginViewMode(this,binding);
        binding.setViewModel(viewMode);
    }

}
