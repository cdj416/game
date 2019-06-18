package com.alipayjf.game.ui.legalize;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.alipayjf.game.R;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.databinding.ActivityLegalizeBinding;
import com.luck.picture.lib.config.PictureConfig;

public class LegalizeActivity extends CustomActivity {
    private ActivityLegalizeBinding binding;
    private LegalizeViewModel viewModel;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_legalize;
    }

    @Override
    protected void initView() {
        setTitle("认证");
        binding = ActivityLegalizeBinding.bind(mView);
        viewModel = new LegalizeViewModel(this,binding);
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                if(viewModel.getNowClick() == LegalizeViewModel.WXCLICK){
                    binding.wxImg.onActivityResult(requestCode, resultCode,data);
                }else{
                    binding.applyImg.onActivityResult(requestCode, resultCode,data);
                }

                break;

        }
    }


}
