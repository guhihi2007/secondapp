package secondapp.gpp.com.secondapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/2/15.
 */

public class TableLayoutActivity extends Activity implements Initial,View.OnClickListener {

    private TextView tv;
    private TextView tv1;
    private TextView tv2;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout_test);
        InitView();
        InitListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enter_tv:
                Toast.makeText(this,"第一个TextVIew",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tr_tv1:
                Toast.makeText(this,"行内TextVIew--1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tr_tv2:
                Toast.makeText(this,"行内TextVIew--2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:
                Toast.makeText(this,"行内Button--1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this,"行外Button",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void InitView() {
        tv = (TextView) findViewById(R.id.enter_tv);
        tv1 = (TextView) findViewById(R.id.tr_tv1);
        tv2 = (TextView) findViewById(R.id.tr_tv2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
    }

    @Override
    public void InitListener() {
        tv.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }
}
