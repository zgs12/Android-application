package com.example.myapplication.main.shanghai.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.main.shanghai.dto.Shanghaibean;
import com.example.myapplication.main.shanghai.view.ShanghaiDetailActivity;

import java.util.ArrayList;

public class ShanghaiAdapter extends RecyclerView.Adapter {


    private final ArrayList<Shanghaibean> mData;
    private final Context mContext;
    private final boolean mIsHor;
    private final RecyclerView.RecycledViewPool recycledViewPool;

    public ShanghaiAdapter(Context context, ArrayList<Shanghaibean> data, boolean isHor) {
        recycledViewPool = new RecyclerView.RecycledViewPool();
        mContext = context;
        mData = data;
        mIsHor = isHor;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Shanghaibean.IShanghaiItemType.VERTICAL) {
            View inflat = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent, false);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflat);
            return viewHolder;
        } else if (viewType == Shanghaibean.IShanghaiItemType.HORIZONTAL) {
            View inflat = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment_rv, null);
            ShanghaiViewHolderRv viewHolder = new ShanghaiViewHolderRv(inflat);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Shanghaibean shanghaibean = mData.get(position);
        if (holder instanceof ShanghaiViewHolder) {
            ((ShanghaiViewHolder) holder).mTv.setText(mData.get(position).getmDec());
            ((ShanghaiViewHolder) holder).mIv.setVisibility(shanghaibean.isShowImg() ? View.VISIBLE : View.GONE);
            ((ShanghaiViewHolder) holder).itemView.setTag(position);
        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv) holder).mRecycleView.setAdapter(new ShanghaiAdapter(mContext, shanghaibean.getData(), true));
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getmItemType();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIv;
        public TextView mTv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    ShanghaiDetailActivity.start((Activity) mContext, mIv);
                }
            });
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {
        public RecyclerView mRecycleView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecycleView = itemView.findViewById(R.id.item_shanghai_rv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            mRecycleView.setLayoutManager(linearLayoutManager);
            mRecycleView.setRecycledViewPool(recycledViewPool);
        }
    }
}

