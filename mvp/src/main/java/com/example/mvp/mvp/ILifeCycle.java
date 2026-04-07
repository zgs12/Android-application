package com.example.mvp.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ILifeCycle {

    void onCreate(Bundle saveInstanceState, Intent intent, Bundle getArguments);

    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState);
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
