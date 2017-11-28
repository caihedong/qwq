package com.example.administrator.big_student_zuoye.base;

/**
 * Created by Administrator on 2017/11/27.
 */
public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;

    public void setVM(M m,V v){
        baseModel=m;
        baseView=v;
        this.OnStart();
    }

    public abstract void OnStart();
}
