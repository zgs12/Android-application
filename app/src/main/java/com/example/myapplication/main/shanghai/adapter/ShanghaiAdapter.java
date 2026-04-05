package com.example.myapplication.main.shanghai.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.main.shanghai.dto.Shanghaibean;

import java.util.ArrayList;

public class ShanghaiAdapter extends RecyclerView.Adapter {


    private final ArrayList<Shanghaibean> mData;
    private final Context mContext;

    public ShanghaiAdapter(Context context, ArrayList<Shanghaibean> data) {
        mContext = context;
        mData = data;
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
        } else if (holder instanceof ShanghaiViewHolderRv) {
            ((ShanghaiViewHolderRv) holder).mRecycleView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            ((ShanghaiViewHolderRv) holder).mRecycleView.setAdapter(new ShanghaiAdapter(mContext, shanghaibean.getData()));
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
        }
    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {
        public RecyclerView mRecycleView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecycleView = itemView.findViewById(R.id.item_shanghai_rv);

        }
    }
}

