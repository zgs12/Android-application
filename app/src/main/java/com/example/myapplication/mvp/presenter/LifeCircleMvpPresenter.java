package com.example.myapplication.mvp.presenter;

import com.example.myapplication.mvp.ILifeCycle;
import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.MvpControler;

import java.lang.ref.WeakReference;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCycle {
    protected WeakReference<T> weakRefrence;

    protected LifeCircleMvpPresenter() {
        super();
    }

    protected LifeCircleMvpPresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpControler mvpControler = iMvpView.getMvpControler();
        mvpControler.savePresenter(this);
    }

    private void attachView(IMvpView iMvpView) {
        if (weakRefrence == null) {
            weakRefrence = new WeakReference<T>((T) iMvpView);
        } else {
            T view = (T) weakRefrence.get();
            if (view != iMvpView) {
                weakRefrence = new WeakReference<T>((T) iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakRefrence = null;
    }

    public T getView() {
        T view = weakRefrence != null ? (T) weakRefrence.get() : null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
        
    }

    protected abstract T getEmptyView();
}
