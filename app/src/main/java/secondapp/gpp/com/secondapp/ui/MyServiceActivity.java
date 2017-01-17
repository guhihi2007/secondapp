package secondapp.gpp.com.secondapp.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.receiver.MyBroadCast;
import secondapp.gpp.com.secondapp.receiver.MyBroadCast_Sec;
import secondapp.gpp.com.secondapp.receiver.MyBroadCast_Thirth;
import secondapp.gpp.com.secondapp.service.MyBinder;
import secondapp.gpp.com.secondapp.service.MyService;

/**
 * Created by Administrator on 2017/1/8.
 */

public class MyServiceActivity extends Activity implements Initial, View.OnClickListener {

    public static final String TAG = "Service";

    private Button service_start;
    private Button service_stop;
    private Button service_bind;
    private Button service_unbind;
    private MyService myService;
    private Intent intent;
    private MyBroadCast myBroadCast;
    private MyBroadCast_Sec myBroadCast_sec;
    private MyBroadCast_Thirth myBroadCast_thirth;
    private Button sendBC_bt;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_test);
        InitView();
        InitListener();

    }

    @Override
    protected void onStart() {
        super.onStart();
        registerRec();
    }

    @Override
    public void InitView() {

        service_start = (Button) findViewById(R.id.service_start);
        service_stop = (Button) findViewById(R.id.service_stop);
        service_bind = (Button) findViewById(R.id.service_bind);
        service_unbind = (Button) findViewById(R.id.service_unbind);

        sendBC_bt = (Button) findViewById(R.id.f3_btn);
        textView = (TextView) findViewById(R.id.f3_tv);

    }

    @Override
    public void InitListener() {
        service_start.setOnClickListener(this);
        service_stop.setOnClickListener(this);
        service_bind.setOnClickListener(this);
        service_unbind.setOnClickListener(this);

        sendBC_bt.setOnClickListener(this);

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
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
                Log.v(TAG, "绑定按钮");

                break;
            case R.id.service_unbind:
                unbindService(serviceConnection);
                Log.v(TAG, "解绑按钮");
                break;
            case R.id.f3_btn:
                Log.v(TAG, "发送广播");
                Intent bc_intent = new Intent("com.gpp.secondapp");
                bc_intent.putExtra("Msg", "Send message by BroadCast");
//                String MyBroadCast ="com.gpp.secondapp";
//                bc_intent.setAction(MyBroadCast);
                //send Normal BroadCast
//                MyServiceActivity.this.sendBroadcast(bc_intent);
//                MyServiceActivity.this.sendOrderedBroadcast(bc_intent,"permission ok");
                sendOrderedBroadcast(bc_intent, null);
                break;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinder myBinder = (MyBinder) service;
            myService = myBinder.getService();
            myService.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void registerRec() {
        //动态注册MyBroadCastReceiver
        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.gpp.secondapp");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
//        intentFilter.setPriority(1000);
        myBroadCast = new MyBroadCast();
        registerReceiver(myBroadCast, intentFilter);

        //动态注册MyBroadCastReceiver_sec
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.gpp.secondapp");
//        intentFilter2.setPriority(999);
        myBroadCast_sec = new MyBroadCast_Sec();
        registerReceiver(myBroadCast_sec, intentFilter2);

        //动态注册MyBroadCastReceiver_thirth
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("com.gpp.secondapp");
//        intentFilter3.setPriority(998);
        myBroadCast_thirth = new MyBroadCast_Thirth();
        registerReceiver(myBroadCast_thirth, intentFilter3);
    }

    private void unregisterRec() {
        //解除注册Receiver
        unregisterReceiver(myBroadCast);
        unregisterReceiver(myBroadCast_sec);
        unregisterReceiver(myBroadCast_thirth);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterRec();
        Log.v("BroadCast", "activity_onStop,unregisterReceiver");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.stopService(intent);
    }

}
