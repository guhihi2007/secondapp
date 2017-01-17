package secondapp.gpp.com.secondapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import secondapp.gpp.com.secondapp.service.MyService;
import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.base.BaseFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    public static final String TAG = "Service";
    private ViewPager viewPager;
    private ArrayList<Fragment> list_fm = new ArrayList<>();
    private FragmentManager fragmentManager = getSupportFragmentManager();

    private LinearLayout layout_f1;
    private LinearLayout layout_f2;
    private LinearLayout layout_f3;
    private LinearLayout layout_f4;

    private LinearLayout id_jx_bt;
    private LinearLayout id_ph_bt;
    private LinearLayout id_fl_bt;
    private LinearLayout id_gl_bt;

    private ImageView jingxuan_IV;
    private ImageView paihang_IV;
    private ImageView fenlei_IV;
    private ImageView guanli_IV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "Activity---onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        resetImageBt(1);
        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return list_fm.get(position);
            }

            @Override
            public int getCount() {
                return list_fm.size();
            }
        });
        viewPager.addOnPageChangeListener(new MyOnPageListener());
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "Activity---onStart()");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.v(TAG, "Activity---onResume()");

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v(TAG, "Activity---onPause()");

        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.v(TAG, "Activity---onStop()");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG, "Activity---onDestroy()");
        stopService(new Intent(this,MyService.class));
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.v(TAG, "Activity---onRestart()");


        super.onRestart();

    }


    public void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        layout_f1 = (LinearLayout) findViewById(R.id.f1);
        layout_f2 = (LinearLayout) findViewById(R.id.f2);
        layout_f3 = (LinearLayout) findViewById(R.id.f3);
        layout_f4 = (LinearLayout) findViewById(R.id.f4);

        BaseFragment f1 = new Fragment1();
        BaseFragment f2 = new Fragment2();
        BaseFragment f3 = new Fragment3();
        BaseFragment f4 = new Fragment4();

        list_fm.add(f1);
        list_fm.add(f2);
        list_fm.add(f3);
        list_fm.add(f4);

        id_jx_bt = (LinearLayout) findViewById(R.id.id_jx_bt);
        id_ph_bt = (LinearLayout) findViewById(R.id.id_ph_bt);
        id_gl_bt = (LinearLayout) findViewById(R.id.id_gl_bt);
        id_fl_bt = (LinearLayout) findViewById(R.id.id_fl_bt);

        jingxuan_IV = (ImageView) findViewById(R.id.jingxuan_IV);
        paihang_IV = (ImageView) findViewById(R.id.paihang_IV);
        fenlei_IV = (ImageView) findViewById(R.id.fenlei_IV);
        guanli_IV = (ImageView) findViewById(R.id.guanli_IV);

    }

    public void initListener() {
        id_jx_bt.setOnClickListener(this);
        id_ph_bt.setOnClickListener(this);
        id_fl_bt.setOnClickListener(this);
        id_gl_bt.setOnClickListener(this);
    }

    public void resetImageBt(int id) {
        switch (id) {
            case 1:
                jingxuan_IV.setImageResource(R.mipmap.credit_level_filling);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 2:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level_filling);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 3:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level_filling);
                guanli_IV.setImageResource(R.mipmap.credit_level);
                break;
            case 4:
                jingxuan_IV.setImageResource(R.mipmap.credit_level);
                paihang_IV.setImageResource(R.mipmap.credit_level);
                fenlei_IV.setImageResource(R.mipmap.credit_level);
                guanli_IV.setImageResource(R.mipmap.credit_level_filling);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_jx_bt:
                viewPager.setCurrentItem(0);
                resetImageBt(1);
                break;
            case R.id.id_ph_bt:
                viewPager.setCurrentItem(1);
                resetImageBt(2);
                break;
            case R.id.id_fl_bt:
                viewPager.setCurrentItem(2);
                resetImageBt(3);
                break;
            case R.id.id_gl_bt:
                viewPager.setCurrentItem(3);
                resetImageBt(4);
                break;
        }
    }

    class MyOnPageListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    resetImageBt(1);
                    break;
                case 1:
                    resetImageBt(2);
                    break;
                case 2:
                    resetImageBt(3);
                    break;
                case 3:
                    resetImageBt(4);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}

//单独用ViewPager如下代码
//        layout_page1 = (LinearLayout) findViewById(R.id.page1);
//        layout_page2 = (LinearLayout) findViewById(R.id.page2);
//        layout_page3 = (LinearLayout) findViewById(R.id.page3);
//        layout_page4 = (LinearLayout) findViewById(R.id.page4);
//
//        layoutInflater = getLayoutInflater();
//        View view_page1 = layoutInflater.inflate(R.layout.page1, null);
//        View view_page2 = layoutInflater.inflate(R.layout.page2, null);
//        View view_page3 = layoutInflater.inflate(R.layout.page3, null);
//        View view_page4 = layoutInflater.inflate(R.layout.page4, null);
//
//        view_list.add(view_page1);
//        view_list.add(view_page2);
//        view_list.add(view_page3);
//        view_list.add(view_page4);

//        list_tv1=(TextView)findViewById(R.id.list_tv1);
//        list_tv2=(TextView)findViewById(R.id.list_tv2);
//        list_bt=(Button)findViewById(R.id.list_bt);
//    private ArrayList<View> view_list = new ArrayList<>();
//    private LinearLayout layout_page1;
//    private LinearLayout layout_page2;
//    private LinearLayout layout_page3;
//    private LinearLayout layout_page4;
//    private LayoutInflater layoutInflater;
//        viewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return view_list.size();
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(view_list.get(position));
//                return view_list.get(position);
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView(view_list.get(position));
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//        });


