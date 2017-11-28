package com.example.administrator.big_student_zuoye.app;

import android.app.Application;

import com.example.administrator.big_student_zuoye.base.BaseActivity;
import com.example.administrator.big_student_zuoye.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/27.
 */
public class App extends Application {
    public static BaseActivity baseActivity;
    public static BaseFragment mLastFragment;
}
