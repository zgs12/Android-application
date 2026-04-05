package com.example.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.ViewInject;
import com.example.myapplication.mvp.view.LifeCycleMvpActivity;
import com.example.myapplication.mvp.view.LifeCycleMvpFragment;

public abstract class BaseFragment extends LifeCycleMvpFragment {

    protected Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainLayout = annotation.mainlayoutid();
            if (mainLayout > 0) {
                mView = initFragmentView(inflater, mainLayout);
                bindView(mView);
            } else {
                throw new RuntimeException("mainlayoutid() must be > 0");
            }
        }
        return mView;
    }

    private View initFragmentView(LayoutInflater inflater, int mainLayout) {
        return inflater.from(mContext).inflate(mainLayout, null);
    }

    public abstract void bindView(View view);

}
