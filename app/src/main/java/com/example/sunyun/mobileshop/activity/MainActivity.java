package com.example.sunyun.mobileshop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sunyun.mobileshop.R;
import com.example.sunyun.mobileshop.fragment.NavigationFragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        //把大容器添加到activity_base
        //通过getFragmentManage创建一个事务
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        NavigationFragment navigationFragment = new NavigationFragment();
        fragmentTransaction.add(R.id.main_fram,navigationFragment).commit();
    }


}
