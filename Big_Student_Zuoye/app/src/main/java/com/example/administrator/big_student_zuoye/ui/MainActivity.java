package com.example.administrator.big_student_zuoye.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.administrator.big_student_zuoye.R;
import com.example.administrator.big_student_zuoye.adapter.MyFragmentPagerAdapter;
import com.example.administrator.big_student_zuoye.base.BaseActivity;
import com.example.administrator.big_student_zuoye.fragment.CampusFragment;
import com.example.administrator.big_student_zuoye.fragment.ClassroomFragment;
import com.example.administrator.big_student_zuoye.fragment.HeadlinesFragment;
import com.example.administrator.big_student_zuoye.fragment.MotionFragment;
import com.example.administrator.big_student_zuoye.fragment.ObtainFragment;
import com.example.administrator.big_student_zuoye.fragment.YJieFragment;
import com.example.administrator.big_student_zuoye.net.NetModel;
import com.example.administrator.big_student_zuoye.net.NetPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<NetPresenter, NetModel> implements View.OnClickListener{
    private List<Fragment> mList = new ArrayList<>();
    private List<String> mTitle = new ArrayList<>();
    private ObtainFragment obtainFragment;
    private HeadlinesFragment headlinesFragment;
    private MotionFragment motionFragment;
    private ClassroomFragment classroomFragment;
    private CampusFragment campusFragment;
    private YJieFragment yJieFragment;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyFragmentPagerAdapter mAdapter;
    private Button mBtn_Jia;

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.TabLayout);
        mViewPager = (ViewPager) findViewById(R.id.ViewPager);
        obtainFragment = new ObtainFragment();
        headlinesFragment = new HeadlinesFragment();
        motionFragment = new MotionFragment();
        classroomFragment = new ClassroomFragment();
        campusFragment = new CampusFragment();
        yJieFragment=new YJieFragment();
        mList.add(obtainFragment);
        mList.add(headlinesFragment);
        mList.add(motionFragment);
        mList.add(classroomFragment);
        mList.add(campusFragment);
        mList.add(yJieFragment);
        mTitle.add("就业");
        mTitle.add("头条");
        mTitle.add("课堂");
        mTitle.add("活动");
        mTitle.add("校园");
        mTitle.add("一节一推选");
        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), mList, mTitle);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

//        mBtn_Jia= (Button) findViewById(R.id.Btn_Jia);
//        mBtn_Jia.setOnClickListener(this);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        mTabLayout.setSelected(true);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.Btn_Jia:
//                 if (mBtn_Jia==null){
//                     mBtn_Jia.setTextColor(Color.BLACK);
//                     mBtn_Jia.setCursorVisible(true);
//
//                 }else {
//                     mBtn_Jia.setTextColor(Color.RED);
//                     mBtn_Jia.setSelected(false);
//                 }
//                Intent intent=new Intent(MainActivity.this,MoreActivity.class);
//                startActivity(intent);
//                break;
        }
    }
}
