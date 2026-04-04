package com.example.myapplication;

public class SplashTimerPresenter {

    private CustomCountDownTimer timer;
    private final SplashActivity mActivity;

    public SplashTimerPresenter(SplashActivity activity) {
        this.mActivity = activity;
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {

            @Override
            public void onTicker(int time) {
                mActivity.setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                mActivity.setTvTimer("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
}
