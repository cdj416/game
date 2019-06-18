package com.alipayjf.game.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.alipayjf.game.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class PromptDialog {

    private TimerTask mTimerTask;
    private Map<Integer, Timer> mTimerMap;
    private int secod = 3;
    private Dialog dialog;
    private TextView content;

    private final int CLOSE = 1;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case CLOSE:
                    if(null != dialog){
                        dialog.dismiss();
                    }
                    break;
            }
        }
    };

    public void showText(Context mContext, String text){
        createDialog(mContext,text);
        mTimerMap = new HashMap<>();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                secod --;
                if(secod <= 0){
                    mHandler.sendEmptyMessage(CLOSE);
                }
            }
        };
        if(mTimerMap.get(0) == null){
            Timer timer = new Timer();
            mTimerMap.put(0,timer);
            mTimerMap.get(0).schedule(mTimerTask,0,1000);
        }
    }

    private void createDialog(Context mContext, String text){
        if(dialog == null){
            //1、使用Dialog、设置style
            dialog = new Dialog(mContext, R.style.promtDialog);
            //2、设置布局
            View view = View.inflate(mContext, R.layout.dialog_prompt,null);
            dialog.setContentView(view);
            Window window = dialog.getWindow();
            //设置弹出位置
            window.setGravity(Gravity.CENTER);
            //设置弹出动画
            window.setWindowAnimations(R.style.main_menu_animStyle);
            //设置对话框大小
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            content = dialog.findViewById(R.id.content);
            dialog.setCanceledOnTouchOutside(false);
        }
        content.setText(text);
        dialog.show();

    }

}
