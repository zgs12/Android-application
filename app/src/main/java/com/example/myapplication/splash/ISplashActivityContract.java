package com.example.myapplication.splash;

import com.example.mvp.mvp.ILifeCycle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpControler;


public interface ISplashActivityContract {
    IView emptyView = new IView() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

    interface IView extends IMvpView {

        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCycle {
        void initTimer();
    }
}
