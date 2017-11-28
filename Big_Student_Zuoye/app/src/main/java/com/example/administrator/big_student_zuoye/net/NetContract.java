package com.example.administrator.big_student_zuoye.net;

import com.example.administrator.big_student_zuoye.base.BaseModel;
import com.example.administrator.big_student_zuoye.base.BasePresenter;
import com.example.administrator.big_student_zuoye.base.BaseView;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface NetContract {

    interface View extends BaseView {
      void show(String ss);
    }

    interface Model extends BaseModel {
        void getDataFormNet(String url,Callbacks callbacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void OnStart() {

        }
        public abstract void getDataFormModel(String url);
    }
}