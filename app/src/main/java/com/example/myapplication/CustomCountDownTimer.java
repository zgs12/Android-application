package com.example.myapplication;

import android.os.Handler;

public class CustomCountDownTimer implements Runnable {


    private int time;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;
    private int countDowntime;

    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler) {
        handler = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
        handler.postDelayed(this, 1000);
    }
    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                countDownHandler.onTicker(countDowntime);
            }
            if  (countDowntime == 0) {
                cancel();
                if (countDownHandler != null) {
                    countDownHandler.onFinish();
                }
            } else {
                countDowntime = time--;
                handler.postDelayed(this, 1000);
            }

        }
    }
    public void start() {
        isRun = true;
        handler.post(this);
    }
    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }
    public interface ICountDownHandler {
        //倒计时回调
        void onTicker(int time);
        //倒计时完成
        void onFinish();
    }
}
