package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayout = annotation.mainlayoutid();
            if (mainLayout > 0) {
                setContentView(mainLayout);
            } else {
                throw new RuntimeException("mainlayoutid() must be > 0");
            }
        }
    }

}
