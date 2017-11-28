package com.example.administrator.big_student_zuoye.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.big_student_zuoye.app.App;
import com.example.administrator.big_student_zuoye.net.NetContract;
import com.example.administrator.big_student_zuoye.net.NetModel;
import com.example.administrator.big_student_zuoye.net.NetPresenter;
import com.example.administrator.big_student_zuoye.utils.Tuitls;

/**
 * Created by Administrator on 2017/11/27.
 */
public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {
    private View view;
    public P mPresenter;
    public M mModel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(getLayoutId(),container,false);
        App.mLastFragment=this;
        mPresenter= Tuitls.getT(this,0);
        mModel=Tuitls.getT(this,1);
        if (this instanceof BaseView){
            mPresenter.setVM(mModel,this);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutId();
}
