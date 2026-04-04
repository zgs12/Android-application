package com.example.myapplication;

import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.IView activity) {
        super(activity);
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {

            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
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

    // 防止空指针
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
