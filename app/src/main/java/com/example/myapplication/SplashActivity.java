package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivitySplashBinding;


@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView{
    private FullScreenVideoView mVideoView;
    private TextView mTvTimer;
    private com.example.myapplication.databinding.ActivitySplashBinding binding;
    private ISplashActivityContract.IPresenter timerPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup content = findViewById(android.R.id.content);
        binding = ActivitySplashBinding.bind(content.getChildAt(0));
        mTvTimer = binding.tvTimer;
        mVideoView = binding.vvPlay;
        initTimerPrensenter();
        initListener();
        initVideo();



    }

    private void initTimerPrensenter() {
        timerPresenter = new SplashTimerPresenter(this);
        timerPresenter.initTimer();
    }



    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sun));

    }

    private void initListener() {
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();

            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        timerPresenter.onDestroy();
//    }

    public void setTvTimer(String s) {
        mTvTimer.setText(s);
    }
}

