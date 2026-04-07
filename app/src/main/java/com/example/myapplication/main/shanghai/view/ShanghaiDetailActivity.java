package com.example.myapplication.main.shanghai.view;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.example.myapplication.R;
import com.example.myapplication.ViewInject;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.databinding.ActivityShanghaiDetailBinding;

@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {

    private com.example.myapplication.databinding.ActivityShanghaiDetailBinding binding;
    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";

    @Override
    public void bindView() {
        ViewGroup content = findViewById(android.R.id.content);
        binding = ActivityShanghaiDetailBinding.bind(content.getChildAt(0));
        initAnimation();
        initGetNet();
    }

    private void initGetNet() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").get().build(); //建造者设计模式
        Call call = client.newCall(request);
        call.enqueue(new okhttp3.Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    private void initAnimation() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            ViewCompat.setTransitionName(binding.ivShanghaiDetail, mActivityOptionsCompat);
            startPostponedEnterTransition();
        }
    }

    /**
     * 用于安卓5.0以上转场动画: 共享元素动画
     **/
    public static void start(Activity activity, View view) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity, ShanghaiDetailActivity.class);
            Pair pair = new Pair<>(view, mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, (View) pair.first, (String) pair.second);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
