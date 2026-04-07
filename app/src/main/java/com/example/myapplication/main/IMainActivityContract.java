package com.example.myapplication.main;

import androidx.fragment.app.Fragment;

import com.example.mvp.mvp.ILifeCycle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpControler;


public interface IMainActivityContract {
    IMainActivityContract.IView emptyView = new IMainActivityContract.IView() {


        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {


        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

    interface IView extends IMvpView {
        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCycle {
        void initHomeFragment();

        int getCurrentCheckedIndex();

        void replaceFragment(int i);

        int getmTopPosition();
        int getmBottomPosition();
    }

}
