package com.example.administrator.big_student_zuoye.fragmnetbuilder;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.big_student_zuoye.app.App;
import com.example.administrator.big_student_zuoye.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/27.
 */
public class FragmentBuilder  {

    public static volatile FragmentBuilder fragmentBuilder;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private BaseFragment fragment;

    public FragmentBuilder() {
    }

    public static FragmentBuilder getInStance(){
        if (fragmentBuilder==null){
            synchronized (FragmentBuilder.class){
                fragmentBuilder=new FragmentBuilder();
            }
        }
        return fragmentBuilder;
    }

    public FragmentBuilder init(){
        manager = App.baseActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        return this;
    }

    public FragmentBuilder add(int cotainerId, Class<? extends BaseFragment> fragmentClass,boolean isChihdFragment){
        String tag = fragmentClass.getSimpleName();
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(cotainerId,fragment,tag);
                transaction.addToBackStack(tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (App.mLastFragment!=null){
            transaction.hide(App.mLastFragment);
        }

        if (!isChihdFragment){
            if (App.mLastFragment!=null){
                transaction.hide(App.mLastFragment);
            }
        }
        transaction.show(fragment);
        return this;
    }
    public void Builder(){
        App.mLastFragment=fragment;
        transaction.commit();
    }
}
