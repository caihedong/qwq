package com.example.administrator.big_student_zuoye.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.big_student_zuoye.app.App;
import com.example.administrator.big_student_zuoye.utils.Tuitls;

/**
 * Created by Administrator on 2017/11/27.
 */
public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.baseActivity=this;
        mPresenter= Tuitls.getT(this,0);
        mModel=Tuitls.getT(this,1);
        if (this instanceof BaseView){
            mPresenter.setVM(mModel,this);
        }
        initView();
    }

    protected abstract void initView();



    protected abstract int getLayoutId();
}
