package com.example.administrator.big_student_zuoye.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.big_student_zuoye.R;
import com.example.administrator.big_student_zuoye.adapter.MyObtainAdapter;
import com.example.administrator.big_student_zuoye.adapter.MyRecyAdapter;
import com.example.administrator.big_student_zuoye.base.BaseFragment;
import com.example.administrator.big_student_zuoye.base.BasePresenter;
import com.example.administrator.big_student_zuoye.bean.MyData;
import com.example.administrator.big_student_zuoye.bean.MyObtain;
import com.example.administrator.big_student_zuoye.net.NetContract;
import com.example.administrator.big_student_zuoye.net.NetModel;
import com.example.administrator.big_student_zuoye.net.NetPresenter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObtainFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private Banner mBanner;
    private RecyclerView mRecy;
    private List<MyObtain.DataBean> mList = new ArrayList<>();
    private ArrayList<String> list1 = new ArrayList<>();
    private MyObtainAdapter mAdapter;
    private boolean boo=true;

    @Override
    protected void initData() {
        mPresenter.getDataFormModel("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&catid=5&controller=content&action=index&page=1&time=0");
    }

    @Override
    protected void initView(View view) {

        if (boo) {
            list1.add("http://upload.univs.cn/2017/0424/1493040123828.jpg");
            list1.add("http://upload.univs.cn/2017/0424/thumb_640_314_1493022268406.jpg");
            list1.add("http://upload.univs.cn/2017/0417/thumb_640_314_1492433907753.png");
            boo = false;
        }
        mBanner = view.findViewById(R.id.Banner);
        mBanner.setImages(list1)
                .isAutoPlay(false)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImage())
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
        mRecy = view.findViewById(R.id.RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_obtain;
    }

    @Override
    public void show(String ss) {
        Gson gson = new Gson();
        MyObtain myObtain = gson.fromJson(ss, MyObtain.class);
        mList = myObtain.getData();
        mAdapter = new MyObtainAdapter(mList, getActivity());
        mRecy.setAdapter(mAdapter);
    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }
}