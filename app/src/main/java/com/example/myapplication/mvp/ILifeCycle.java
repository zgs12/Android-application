package com.example.myapplication.mvp;

import android.content.Intent;
import android.os.Bundle;

public interface ILifeCycle {


    void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments);
    void onActivityCreated(Bundle saveInstanceState, Intent intent, Bundle getArguments);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void onRestart();
    void destroyView();
    void onViewDestroy();
    void onNewIntent(Intent intent);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void onSaveInstanceState(Bundle outState);
    void attachView();

    void onActivityCreate(Bundle savedInstanceState, Intent intent, Object o);
}
