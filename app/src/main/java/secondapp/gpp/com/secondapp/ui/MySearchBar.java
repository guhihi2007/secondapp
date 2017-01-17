package secondapp.gpp.com.secondapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/1/6.
 */

public class MySearchBar extends Activity implements Initial, View.OnClickListener {

    private LinearLayout search_page;
    private ImageView search_img;
    private EditText search_et;
    private ImageView search_bt;

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

    }

    @Override
    public void InitListener() {
        search_img.setOnClickListener(this);
        search_bt.setOnClickListener(this);

        search_et.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_img:
                break;
            case R.id.title_tv:

                break;
            case R.id.title_bt:
                break;
        }
    }
}
