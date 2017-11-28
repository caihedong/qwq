package com.example.administrator.big_student_zuoye.net;

import com.example.administrator.big_student_zuoye.base.BaseModel;

/**
* Created by TMVPHelper on 2017/11/27
*/
public class NetPresenter extends NetContract.Presenter{

    @Override
    public void getDataFormModel(String url) {
        baseModel.getDataFormNet(url, new Callbacks() {
            @Override
            public void succ(String result) {
                baseView.show(result);
            }
        });
    }
}