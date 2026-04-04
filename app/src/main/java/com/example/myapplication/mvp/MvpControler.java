package com.example.myapplication.mvp;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.mvp.presenter.LifeCircleMvpPresenter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MvpControler implements ILifeCycle {
    //存放的是P层的实例
    private Set<ILifeCycle> lifeCircles = new HashSet<>();

    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            next.onCreate(saveInstanceState, intent, getArguments);
        }

    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            if (getArguments == null) {
                getArguments = new Bundle();
            }
            next.onActivityCreated(saveInstanceState, intent, getArguments);
        }
    }

    @Override
    public void onStart() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onStart();
        }
    }

    @Override
    public void onResume() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onResume();
        }
    }

    @Override
    public void onPause() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onPause();
        }
    }

    @Override
    public void onStop() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onStop();
        }
    }

    @Override
    public void onDestroy() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onDestroy();
        }
    }

    @Override
    public void onRestart() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onRestart();
        }
    }

    @Override
    public void destroyView() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.destroyView();
        }
    }

    @Override
    public void onViewDestroy() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onViewDestroy();
        }
    }

    @Override
    public void attachView() {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.attachView();
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            next.onNewIntent(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            next.onSaveInstanceState(outState);
        }
    }


    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Object o) {
        Iterator<ILifeCycle> iterator = this.lifeCircles.iterator();
        while (iterator.hasNext()) {
            ILifeCycle next = iterator.next();
            if (intent == null) {
                intent = new Intent();
            }
            next.onActivityCreate(savedInstanceState, intent, o);
        }
    }

    public <T extends IMvpView> void savePresenter(LifeCircleMvpPresenter<T> tLifeCircleMvpPresenter) {
        this.lifeCircles.add(tLifeCircleMvpPresenter);
    }
}
