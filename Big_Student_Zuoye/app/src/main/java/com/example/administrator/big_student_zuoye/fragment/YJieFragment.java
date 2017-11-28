package com.example.administrator.big_student_zuoye.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.big_student_zuoye.R;
import com.example.administrator.big_student_zuoye.adapter.MyRecyAdapter;
import com.example.administrator.big_student_zuoye.base.BaseFragment;
import com.example.administrator.big_student_zuoye.bean.MyData;
import com.example.administrator.big_student_zuoye.net.NetContract;
import com.example.administrator.big_student_zuoye.net.NetModel;
import com.example.administrator.big_student_zuoye.net.NetPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class YJieFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {

    private List<MyData.DataBean> list = new ArrayList<>();
    private MyRecyAdapter mAdapter;
    private RecyclerView mRecy;
    @Override
    protected void initData() {
        mPresenter.getDataFormModel("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&controller=content&catid=14&page=1&action=index&time=0");
    }

    @Override
    protected void initView(View view) {
        mRecy=view.findViewById(R.id.RecyView_Yjie);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        mRecy.setLayoutManager(manager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yjie;
    }

    @Override
    public void show(String ss) {
        Gson gson = new Gson();
        MyData myData = gson.fromJson(ss, MyData.class);
        list= myData.getData();
        mAdapter=new MyRecyAdapter(list,getActivity());
        mRecy.setAdapter(mAdapter);
    }
}
