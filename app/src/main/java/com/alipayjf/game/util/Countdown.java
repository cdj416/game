package com.alipayjf.game.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.alipayjf.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

    private TextView tv;
    private long time;
    private Timer timer = new Timer();

    public Countdown(TextView tv,long time){
        this.tv = tv;
        this.time = time;
    }

    private TimerTask task = new TimerTask(){
        @Override
        public void run() {
            time--;
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    if(time < 0){
                        tv.setText("获取短信验证码");
                        tv.setBackgroundResource(R.drawable.shape_radius3_ffb400);
                        tv.setClickable(true);
                        timer.cancel();
                    }else{
                        tv.setText(time+"秒后重新获取");
                    }
                    break;
            }
        }
    };

    /*
    * 短信验证倒计时
    * */
    public void startCountdown(){
        tv.setBackgroundResource(R.drawable.shape_radius3_cccccc);
        if(time > 0)tv.setClickable(false);
        timer.schedule(task,0,1000);
    }
}
