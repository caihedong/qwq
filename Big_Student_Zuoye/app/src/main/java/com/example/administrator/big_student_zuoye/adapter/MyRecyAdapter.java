package com.example.administrator.big_student_zuoye.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.big_student_zuoye.R;
import com.example.administrator.big_student_zuoye.bean.MyData;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.ViewHolder> {
    private List<MyData.DataBean> list;
    private Context mContext;

    public MyRecyAdapter(List<MyData.DataBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recy_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyData.DataBean dataBean = list.get(position);
        holder.mDescription.setText(dataBean.getDescription());
        holder.mTitle.setText(dataBean.getTitle());
        Glide.with(mContext).load(list.get(position).getThumb()).into(holder.mImage);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mDescription, mTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.ImageView);
            mDescription = itemView.findViewById(R.id.Text_Description);
            mTitle = itemView.findViewById(R.id.Text_Title);
        }
    }
}
