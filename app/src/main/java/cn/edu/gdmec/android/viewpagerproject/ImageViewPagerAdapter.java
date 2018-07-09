package cn.edu.gdmec.android.viewpagerproject;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ImageViewPagerAdapter extends AppCompatActivity {

    private ViewPager mViewPager;

    private int[] mLayoutIDs = {
            R.layout.view_first,
            R.layout.view_second,
            R.layout.view_thrid
    };
    private List<View> mViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_adapter);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        //初始化数据

        mViews = new ArrayList<>();

        for (int index = 0; index <mLayoutIDs.length ; index++) {
            final View view = getLayoutInflater().inflate(mLayoutIDs[index],null);
            mViews.add(view);
        }

        //List<View>

        //设置
        mViewPager.setAdapter(mPagerAdapter);

        }



    PagerAdapter mPagerAdapter = new PagerAdapter() {

        @Override
        public int getCount() {
            return mLayoutIDs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //position当前位置
        //这个方法是返回给Object
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //return super.instantiateItem(container, position);
            //要把每次的视图view添加进去  mViews 为所有的数据
            View child = mViews.get(position);
            //ViewGroup
            container.addView(child);
            //返回当前的视图
            return child;
        }
        //释放它
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView(mViews.get(position));
        }
    };
}
