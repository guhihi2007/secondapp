package secondapp.gpp.com.secondapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.TimeUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/3.
 */

public class Fragment4 extends BaseFragment implements Initial, View.OnClickListener {

    public static final String TT = "F4";

    private TextView f4_Life_news;
    private TextView f4_Social_news;
    private TextView f4_Military_news;
    private TextView f4_Entertainment_news;
    private ViewPager viewPager;
    private List<Fragment> list;
    private Fragment f4_1;
    private Fragment f4_2;
    private Fragment f4_3;
    private Fragment f4_4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(TT, "on_create");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.v(TT, "on_create_view");
        view = inflater.inflate(R.layout.f4, container, false);
        InitView();
        InitListener();
        return view;
    }

    @Override
    public void onDestroy() {
        Log.v(TT, "on_destroy");
        super.onDestroy();

    }

    @Override
    public void onDestroyView() {
        Log.v(TT, "destroy_view");
        super.onDestroyView();
    }

    @Override
    public void InitView() {
        list = new ArrayList<>();
        f4_1 = new f4_social();
        f4_2 = new f4_entertain();
        f4_3 = new f4_military();
        f4_4 = new f4_life();
        list.add(f4_1);
        list.add(f4_2);
        list.add(f4_3);
        list.add(f4_4);

        f4_Social_news = (TextView) view.findViewById(R.id.f4_Social_news);
        f4_Entertainment_news = (TextView) view.findViewById(R.id.f4_Entertainment_news);
        f4_Military_news = (TextView) view.findViewById(R.id.f4_Military_news);
        f4_Life_news = (TextView) view.findViewById(R.id.f4_Life_news);

        viewPager = (ViewPager) view.findViewById(R.id.f4_vp);

    }

    @Override
    public void InitListener() {
//        FragmentManager fm = getFragmentManager();//如果下面用了此manager，导致切换回来内容为空
        f4_Social_news.setOnClickListener(this);
        f4_Social_news.setBackgroundColor(Color.GREEN);
        f4_Entertainment_news.setOnClickListener(this);
        f4_Military_news.setOnClickListener(this);
        f4_Life_news.setOnClickListener(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        reSetColor(position);
                        break;
                    case 1:
                        reSetColor(position);
                        break;
                    case 2:
                        reSetColor(position);
                        break;
                    case 3:
                        reSetColor(position);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void reSetColor(int position) {
        switch (position) {
            case 0:
                f4_Social_news.setBackgroundColor(Color.GREEN);
                f4_Entertainment_news.setBackgroundColor(Color.WHITE);
                f4_Military_news.setBackgroundColor(Color.WHITE);
                f4_Life_news.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                f4_Social_news.setBackgroundColor(Color.WHITE);
                f4_Entertainment_news.setBackgroundColor(Color.GREEN);
                f4_Military_news.setBackgroundColor(Color.WHITE);
                f4_Life_news.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                f4_Social_news.setBackgroundColor(Color.WHITE);
                f4_Entertainment_news.setBackgroundColor(Color.WHITE);
                f4_Military_news.setBackgroundColor(Color.GREEN);
                f4_Life_news.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                f4_Social_news.setBackgroundColor(Color.WHITE);
                f4_Entertainment_news.setBackgroundColor(Color.WHITE);
                f4_Military_news.setBackgroundColor(Color.WHITE);
                f4_Life_news.setBackgroundColor(Color.GREEN);
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }


}
