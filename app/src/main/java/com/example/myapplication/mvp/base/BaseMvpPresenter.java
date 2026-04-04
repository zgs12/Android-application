package com.example.myapplication.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.mvp.IMvpView;
import com.example.myapplication.mvp.presenter.LifeCircleMvpPresenter;

public abstract class BaseMvpPresenter<T extends IMvpView>  extends LifeCircleMvpPresenter<T> {
    public BaseMvpPresenter(T view) {
        super(view);
    }
    @Override
    public void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void attachView() {

    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState, Intent intent, Object o) {

    }


}
