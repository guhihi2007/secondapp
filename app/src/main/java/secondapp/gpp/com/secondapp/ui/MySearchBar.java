package secondapp.gpp.com.secondapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MySearchBar extends FragmentActivity implements Initial, View.OnClickListener {

    private LinearLayout search_page;
    private ImageView search_img;
    private EditText search_et;
    private ImageView search_bt;
    private Button search_page_btn1;
    private Button search_page_btn2;
    private Button search_page_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);
        InitView();
        InitListener();
    }

    @Override
    public void InitView() {
        search_page=(LinearLayout)findViewById(R.id.search_page);
        search_img=(ImageView)findViewById(R.id.search_img);
        search_et=(EditText) findViewById(R.id.search_et);
        search_bt=(ImageView)findViewById(R.id.search_bt);
        search_page_btn1 =(Button) findViewById(R.id.search_page_btn1);
        search_page_btn2 =(Button) findViewById(R.id.search_page_btn2);
        search_page_btn3 =(Button) findViewById(R.id.search_page_btn3);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.search_framelayout,new Search_fragment1());
        ft.commit();
    }

    @Override
    public void InitListener() {
        search_img.setOnClickListener(this);
        search_bt.setOnClickListener(this);

        search_et.setOnClickListener(this);

        search_page_btn1.setOnClickListener(this);
        search_page_btn2.setOnClickListener(this);
        search_page_btn3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm1 =getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        switch (v.getId()){
            case R.id.title_img:
                break;
            case R.id.title_tv:

                break;
            case R.id.title_bt:
                break;
            case R.id.search_page_btn1:
                ft1.add(R.id.search_framelayout,new Search_fragment1());
                break;
            case R.id.search_page_btn2:
                ft1.add(R.id.search_framelayout,new Search_fragment2());
                break;
            case R.id.search_page_btn3:
                ft1.add(R.id.search_framelayout,new Search_fragment3());
                break;
        }
        ft1.commit();
    }
}
