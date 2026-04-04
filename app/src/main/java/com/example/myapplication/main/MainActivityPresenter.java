package com.example.myapplication.main;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.main.shanghai.BeiJingiFragment;
import com.example.myapplication.main.shanghai.HangZhouFragment;
import com.example.myapplication.main.shanghai.ShangHaiFragment;
import com.example.myapplication.main.shanghai.ShenZhenFragment;
import com.example.myapplication.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {


    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckedId;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }


    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initHomeFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);
    }

    //切换
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }
        Fragment mFragment = mFragments[mCurrentFragmentIndex];
        if (mFragment != null) {
            addAndShowFragment(mFragment);
            setCurChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurChecked(mCurrentFragmentIndex);
        }

    }

    private void setCurChecked(int mCurrentFragmentIndex) {
        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case 0:
                mCurrentCheckedId = R.id.rg_main_shanghai;
                break;
            case 1:
                mCurrentCheckedId = R.id.rg_main_hangzhou;
                break;
            case 2:
                mCurrentCheckedId = R.id.rg_main_beijing;
                break;
            case 3:
                mCurrentCheckedId = R.id.rg_main_shenzhen;
                break;

        }
    }

    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case 0:
                fragment = new ShangHaiFragment();
                break;
            case 1:
                fragment = new HangZhouFragment();
                break;
            case 2:
                fragment = new BeiJingiFragment();
                break;
            case 3:
                fragment = new ShenZhenFragment();
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    private void addAndShowFragment(Fragment mFragment) {
        if (mFragment.isAdded()) {
            getView().showFragment(mFragment);
        } else {
            getView().addFragment(mFragment);
        }
    }

    private void hideFragment(Fragment mFragment) {
        if (mFragment != null && mFragment.isAdded() && mFragment.isVisible()) {
            getView().hideFragment(mFragment);
        }
    }

    @Override
    public int getCurrentCheckedIndex() {
        return mCurrentFragmentIndex;
    }
}
