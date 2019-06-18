package com.alipayjf.game.util;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.alipayjf.game.R;
import com.alipayjf.game.entity.UserInfoBean;

public class CustomDialog {

    /*
     * 点击事件的回调 接口
     * */
    public interface DialogClick{
        void dialogClick(View v);
    }

    /*
    * 点击回调具体金额值
    * */
    public interface DialogReturnText{
        void returnText(String text);
    }

    public static void showGoLegalize(Context mContext, UserInfoBean userInfoBean,final DialogClick dialogClick){
        final Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        View view = View.inflate(mContext, R.layout.dialog_go_legalize,null);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.main_menu_animStyle);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView tishi = ((TextView)view.findViewById(R.id.message));
        TextView button = ((TextView)view.findViewById(R.id.submit));
        String strText = "";
        if(userInfoBean.getResult().getStatus() == 0){
            strText = "请认证";
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialogClick != null){
                        dialogClick.dialogClick(view);
                    }
                }
            });
        }
        if(userInfoBean.getResult().getStatus() == 1){
            strText = "审核中，请耐心等待！";
            button.setBackgroundColor(0xff5F5F5F);
        }
        if(userInfoBean.getResult().getStatus() == 3){
            strText = "审核失败，请重新提交审核，失败原因："+userInfoBean.getResult().getRemark();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialogClick != null){
                        dialogClick.dialogClick(view);
                    }
                }
            });
        }
        tishi.setText(strText);
    }

    //提现金额弹框
    public static void showWithdrawDialog(final Context mContext, final String priceText, final DialogReturnText returnText){
        final Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        View view = View.inflate(mContext, R.layout.dialog_withdraw,null);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.bottom_in_out);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView message = view.findViewById(R.id.message);
        message.setText("可提现金额为"+CalculationUtil.getPrice(priceText)+"元");
        final EditText price = view.findViewById(R.id.price);
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(returnText != null){
                    if(!TextUtils.isEmpty(price.getText().toString())){
                        dialog.dismiss();
                        returnText.returnText(price.getText().toString());
                    }else{
                        new PromptDialog().showText(mContext,"请输入金额");
                    }

                }
            }
        });
    }
}
