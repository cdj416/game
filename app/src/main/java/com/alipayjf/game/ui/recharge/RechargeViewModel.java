package com.alipayjf.game.ui.recharge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipayjf.game.R;
import com.alipayjf.game.base.Constants;
import com.alipayjf.game.base.Controller;
import com.alipayjf.game.base.CustomActivity;
import com.alipayjf.game.base.CustomViewModel;
import com.alipayjf.game.custom_view.BubblePopupWindow;
import com.alipayjf.game.databinding.ActivityRechargeBinding;
import com.alipayjf.game.entity.BankBean;
import com.alipayjf.game.entity.FillrechargeAcountBean;
import com.alipayjf.game.entity.SpannerBean;
import com.alipayjf.game.util.CalculationUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;

import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

public class RechargeViewModel extends CustomViewModel {

    private Bundle bundle;
    private ActivityRechargeBinding binding;
    private SpannerAdapter adapter;
    private SpannerBean bean;
    private BankBean bankBean;

    //气泡弹框
    private BubblePopupWindow topWindow;
    private LayoutInflater layoutInflater;
    private View bubbleView;
    private RecyclerView mRecyclerView;
    private int popupWindWidth;

    public RechargeViewModel(CustomActivity mActivity, ActivityRechargeBinding binding) {
        super(mActivity);
        this.binding = binding;
        initView();
        lazyLoad();
    }

    //初始化值
    @Override
    protected void initView(){
        bundle = mActivity.getIntent().getBundleExtra("bundle");
        binding.rPrice.setRightText(CalculationUtil.getPrice(bundle.getInt("price"))+"元");
        binding.rOrderId.setRightText(bundle.getInt("orderId")+"");
        binding.rOrderId.setRightTextColor(R.color.colorAccent);

        ViewTreeObserver vto = binding.content.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                popupWindWidth = px2dip(mActivity,binding.content.getWidth());
            }
        });
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    //请求数据
    @Override
    protected void lazyLoad() {
        clearParams().setParams("orderId",bundle.getInt("orderId")+"");
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.GETBANK,getParams(),getHeadParams(), SpannerBean.class,this);
    }

    //请求银行具体信息
    private void getBank(String bankId){
        clearParams().setParams("orderId",bundle.getInt("orderId")+"")
        .setParams("bankId",bankId);
        clearHeadParams().setHeadParams("Access-Token",userSession.getToken());
        Controller.getData(Constants.GETBANKCARD,getParams(),getHeadParams(), BankBean.class,this);
    }

    //选择其他银行
    public BindingCommand selectOher = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            binding.other.setImageResource(R.mipmap.show_more);
            showPopoWind();
        }
    });
    //提交充值
    public BindingCommand submit = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            savePrice();
        }
    });

    //保存充值金额
    private void savePrice(){
        try {
            clearHeadParams().setHeadParams("Content-Type","application/json")
                    .setHeadParams("Access-Token",userSession.getToken());
            setJsonParams("userId",userSession.getUserId())
                    .setJsonParams("chargeFee",CalculationUtil.getPrice(bundle.getInt("price")))
                    .setJsonParams("bankCardId",bankBean.getResult().getId())
                    .setJsonParams("bankId",bankBean.getResult().getBankId())
                    .setJsonParams("userId",userSession.getUserId())
                    .setJsonParams("id",bundle.getInt("orderId")+"");
            Log.e("cdj","==两个有啥不一样==="+getJsonParams().toString());
            Controller.myRequest(Constants.SAVEPRICE,getJsonParams().toString(),getHeadParams(), FillrechargeAcountBean.class,this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    /*
     * 展示气泡弹框并可复制文字
     * */
    @SuppressLint("NewApi")
    private void showPopoWind(){
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(mActivity);
            topWindow = new BubblePopupWindow(mActivity);
            bubbleView = layoutInflater.inflate(R.layout.popupwindow_bank, null);
            mRecyclerView = bubbleView.findViewById(R.id.mRecyclerView);
            setViewWidth(popupWindWidth);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
            adapter = new SpannerAdapter();
            mRecyclerView.setAdapter(adapter);
            adapter.setNewData(bean.getResult());
            topWindow.setBubbleView(bubbleView);//添加内容

            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    try {
                        for(int i =0 ; i < bean.getResult().size() ; i++){
                            bean.getResult().get(i).setSelect(false);
                        }
                        bean.getResult().get(position).setSelect(true);
                        adapter.setNewData(bean.getResult());
                        binding.other.setImageResource(R.mipmap.page_turning_right);
                        binding.content.setText(bean.getResult().get(position).getName());
                        getBank(bean.getResult().get(position).getId()+"");
                        topWindow.dismiss();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
        topWindow.show(binding.content, Gravity.BOTTOM,0);//显示气泡

    }

    /*
    * 设置宽度
    * */
    private void setViewWidth(int width){
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) mRecyclerView.getLayoutParams();
        linearParams.width=((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, mActivity.getResources().getDisplayMetrics()));
        mRecyclerView.setLayoutParams(linearParams);
    }

    @Override
    public void onSuccess(Object data) {
        try {
            if(data instanceof SpannerBean){
                bean = (SpannerBean)data;
                if(bean.getCode() == 200){
                    bean.getResult().get(0).setSelect(true);
                    binding.content.setText(bean.getResult().get(0).getName());
                    getBank(bean.getResult().get(0).getId()+"");
                }
            }

            if(data instanceof BankBean){
                bankBean = (BankBean)data;
                if(bankBean.getCode() == 200){
                    binding.cardBankName.setRightText(bankBean.getResult().getAddress());
                    binding.cardName.setRightText(bankBean.getResult().getCardName());
                    binding.cardNo.setRightText(bankBean.getResult().getCardNo());
                }
            }
            if(data instanceof FillrechargeAcountBean){
                FillrechargeAcountBean bean = (FillrechargeAcountBean)data;
                if(bean.getCode() == 200){
                    mActivity.showSuccess(bean.getMessage());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
