package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioGroup;

import com.example.myapplication.databinding.ActivityMainBinding;

@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private Boolean isChangeTopOrBottom = false;
    private com.example.myapplication.databinding.ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup content = findViewById(android.R.id.content);
        binding = ActivityMainBinding.bind(content.getChildAt(0));
        changeAnime(binding.rgMainBottom, binding.rgMainTop);
        binding.facMainHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.fac_main_home:
                        isChangeTopOrBottom = !isChangeTopOrBottom;
                        if(isChangeTopOrBottom){
                            changeAnime(binding.rgMainTop, binding.rgMainBottom);
                        } else {
                            changeAnime(binding.rgMainBottom, binding.rgMainTop);
                        }
                        break;
                }
            }
        });

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

        show.clearAnimation();
        show.setVisibility(View.VISIBLE);
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_transtate_show);
        show.startAnimation(animationShow);
    }
}