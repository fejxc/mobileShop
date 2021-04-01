package com.example.sunyun.mobileshop.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.sunyun.mobileshop.R;

/**
 * Created by sunyun on 2021/4/1.
 */

public class NavigationFragment extends Fragment  implements  View.OnClickListener{

    private LinearLayout itemLinerHome;
    private LinearLayout itemLinearCategory;

    private ImageView itemImgeHome;
    private ImageView itemImgeCategory;

    private android.app.FragmentTransaction fragmentTransaction;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);
        return view;
    }

    private void initView(View view){
        //获取线性布局和图片控件
        itemLinerHome = view.findViewById(R.id.item_linear_home);
        itemLinerHome.setOnClickListener(this);

        itemLinearCategory = view.findViewById(R.id.item_linear_cart);
        itemLinearCategory.setOnClickListener(this);

        itemImgeHome = view.findViewById(R.id.item_linear_home_img);
        itemImgeCategory = view.findViewById(R.id.item_linear_category_img);

    }

    @Override
    public void onClick(View v) {
        //标签栏功能切换
        setTabSelected(v.getId());

    }
     private void setTabSelected(int id){
         //初始化图片白色
         itemImgeHome.setImageResource(R.drawable.tab_item_home_focus);
         itemImgeHome.setImageResource(R.drawable.tab_item_cart_focus);

         //添加事务
         fragmentTransaction = getFragmentManager().beginTransaction();

         //小容器隐藏
         if(homeFragment!=null){
             fragmentTransaction.hide(homeFragment);
         }
         if(categoryFragment!=null){
             fragmentTransaction.hide(categoryFragment);
         }

         switch (id){
             case R.id.item_linear_home:
                 itemImgeHome.setImageResource(R.drawable.tab_item_home_normal);
                 if(homeFragment == null){
                     homeFragment = new HomeFragment();
                     fragmentTransaction.add(R.id.content,homeFragment);
                 }else {
                     fragmentTransaction.show(homeFragment);
                 }
                 break;
             case R.id.item_linear_cart:
                 itemImgeCategory.setImageResource(R.drawable.tab_item_cart_normal);
                 if(categoryFragment == null){
                     categoryFragment = new CategoryFragment();
                     fragmentTransaction.add(R.id.content,categoryFragment);
                 }else {
                     fragmentTransaction.show(categoryFragment);
                 }
                 break;
         }
         //事务提交
         fragmentTransaction.commit();
     }
}
