package com.example.myapplication;

import com.example.myapplication.mvp.CustomCountDownTimer;
import com.example.myapplication.SplashActivity;
import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter {

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    @Override
    protected IMvpView getEmptyView() {
        return null;
    }
}
