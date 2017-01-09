package secondapp.gpp.com.secondapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
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
    private Button service_bind;
    private Button service_unbind;
    private MyService.MyBinder myBinder;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test);
        InitView();
        InitListener();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.service_start:
                Log.v(TAG, "启动按钮");
                intent = new Intent();
                intent.setClass(this, MyService.class);
                this.startService(intent);
                break;
            case R.id.service_stop:
                this.stopService(intent);
                Log.v(TAG, "停止按钮");
                break;
            case R.id.service_bind:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,serviceConnection,BIND_AUTO_CREATE);
                Log.v(TAG, "绑定按钮");

                break;
            case R.id.service_unbind:
                unbindService(serviceConnection);
                Log.v(TAG, "解绑按钮");

                break;
        }
    }

    @Override
    public void InitView() {

        service_start = (Button) findViewById(R.id.service_start);
        service_stop = (Button) findViewById(R.id.service_stop);
        service_bind = (Button) findViewById(R.id.service_bind);
        service_unbind = (Button) findViewById(R.id.service_unbind);


    }

    @Override
    public void InitListener() {
        service_start.setOnClickListener(this);
        service_stop.setOnClickListener(this);
        service_bind.setOnClickListener(this);
        service_unbind.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.stopService(intent);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}