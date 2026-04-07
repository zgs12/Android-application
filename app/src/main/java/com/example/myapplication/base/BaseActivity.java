package com.example.myapplication.base;

import android.os.Bundle;

import com.example.mvp.mvp.view.LifeCycleMvpActivity;
import com.example.myapplication.ViewInject;


public abstract class BaseActivity extends LifeCycleMvpActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayout = annotation.mainlayoutid();
            if (mainLayout > 0) {
                setContentView(mainLayout);
                bindView();
            } else {
                throw new RuntimeException("mainlayoutid() must be > 0");
            }
        }
    }

    public abstract void bindView();

}
