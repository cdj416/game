package com.alipayjf.game.ui.recharge;

import android.view.View;
import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.entity.SpannerBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class SpannerAdapter extends BaseQuickAdapter<SpannerBean.ResultBean, BaseViewHolder> {
    public SpannerAdapter() {
        super(R.layout.item_spanner);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpannerBean.ResultBean item) {
        helper.setText(R.id.content,item.getName());
        if(item.isSelect()){
            ((TextView)helper.getView(R.id.content)).setTextColor(0xff13B6A5);
            helper.getView(R.id.select).setVisibility(View.VISIBLE);
        }else{
            helper.getView(R.id.select).setVisibility(View.GONE);
            ((TextView)helper.getView(R.id.content)).setTextColor(0xff000000);
        }
        helper.addOnClickListener(R.id.content);
    }
}
