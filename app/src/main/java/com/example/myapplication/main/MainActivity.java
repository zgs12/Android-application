package com.example.myapplication.main;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ViewInject;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.main.tools.MainConstantTool;

@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {
    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);
    private Boolean isChangeTopOrBottom = false;
    private com.example.myapplication.databinding.ActivityMainBinding binding;
    private FrameLayout flMainContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void bindView() {
        ViewGroup content = findViewById(android.R.id.content);
        binding = ActivityMainBinding.bind(content.getChildAt(0));
        flMainContent = binding.flMainContent;
        changeAnime(binding.rgMainBottom, binding.rgMainTop);
        initListener();
        initHomeFragment();
    }

    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    private void initListener() {
        binding.facMainHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.fac_main_home:
                        isChangeTopOrBottom = !isChangeTopOrBottom;
                        if (isChangeTopOrBottom) {
                            changeAnime(binding.rgMainTop, binding.rgMainBottom);
                            handleTopPosition();
                        } else {
                            changeAnime(binding.rgMainBottom, binding.rgMainTop);
                            handleBottomPosition();
                        }
                        break;
                }
            }
        });
        binding.rgMainShanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.replaceFragment(MainConstantTool.SHANHAI);
            }
        });
        binding.rgMainHangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
            }

        });
        binding.rgMainBeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.replaceFragment(MainConstantTool.BEIJING);
            }

        });
        binding.rgMainShenzhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
            }

        });
    }

    private void handleBottomPosition() {
        if (mPresenter.getmTopPosition() != MainConstantTool.HANGZHOU) {
            mPresenter.replaceFragment(MainConstantTool.SHANHAI);
            binding.rgMainShanghai.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
            binding.rgMainHangzhou.setChecked(true);
        }
    }

    private void handleTopPosition() {
        if (mPresenter.getmBottomPosition() != MainConstantTool.SHENZHEN) {
            mPresenter.replaceFragment(MainConstantTool.BEIJING);
            binding.rgMainBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
            binding.rgMainShenzhen.setChecked(true);
        }

    }

    private void changeAnime(RadioGroup gone, RadioGroup show) {
        gone.clearAnimation();
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_transtate_hide);
        animationGone.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                gone.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        show.clearAnimation();
        show.setVisibility(View.VISIBLE);
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_transtate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}