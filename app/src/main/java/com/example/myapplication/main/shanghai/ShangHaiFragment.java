package com.example.myapplication.main.shanghai;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ViewInject;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.databinding.FragmentShanghaiBinding;
import com.example.myapplication.main.shanghai.adapter.ShanghaiAdapter;
import com.example.myapplication.main.shanghai.dto.ShanghaiDataManager;
import com.example.myapplication.main.shanghai.dto.Shanghaibean;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

@ViewInject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {

    private com.example.myapplication.databinding.FragmentShanghaiBinding binding;

    @Override
    public void bindView(View view) {
        binding = FragmentShanghaiBinding.bind(view);
        initRecycleView();
        initListener();
    }

    private void initRecycleView() {
        binding.shanghaiRecycleview.setLayoutManager(new LinearLayoutManager(mContext));
        binding.shanghaiRecycleview.setAdapter(new ShanghaiAdapter(mContext, ShanghaiDataManager.getData(), false));
    }

    private void initListener() {
//        binding.shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (-verticalOffset < appBarLayout.getMeasuredHeight() / 2) {
//                    binding.tvShanghaiWelcome.setVisibility(View.INVISIBLE);
//                } else {
//                    binding.tvShanghaiWelcome.setVisibility(View.VISIBLE);
//                }
//            }
//        });
    }
}

