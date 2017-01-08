package secondapp.gpp.com.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/1/8.
 */

public class ServiceActivity extends Activity implements Initial, View.OnClickListener {
    public static final String TAG = "Service";

    private Button service_start;
    private Button service_stop;
//    private Button service_play;
//    private MyService myService;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test);
        InitView();
        InitListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.stopService(intent);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.service_start:
                Log.v(TAG,"启动service");
                this.startService(intent);
                break;
            case R.id.service_stop:
                this.stopService(intent);
                Log.v(TAG,"停止service");
                break;
//            case R.id.service_play:
//                break;
        }
    }

    @Override
    public void InitView() {
        intent = new Intent();
        intent.setClass(this,MyService.class);
        service_start = (Button) findViewById(R.id.service_start);
        service_stop = (Button) findViewById(R.id.service_stop);
//        service_play = (Button) findViewById(R.id.service_play);

    }

    @Override
    public void InitListener() {
//        service_play.setOnClickListener(this);
        service_start.setOnClickListener(this);
        service_stop.setOnClickListener(this);

    }
}
