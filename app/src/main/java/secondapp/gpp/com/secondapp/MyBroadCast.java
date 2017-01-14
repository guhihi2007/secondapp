package secondapp.gpp.com.secondapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/14.
 */

public class MyBroadCast extends BroadcastReceiver {

    public static final String TAG = "BroadCast";

    public MyBroadCast() {
        Log.v("BroadCast", "调用MyBroadCast Constructor");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("Msg");
        Log.v(TAG, "MyBroadCast:"+str);
//        abortBroadcast();
//        Bundle bundle= new Bundle();
//        bundle.putString("Msg",str+"--MyBroadCast");
//        setResultExtras(bundle);
//        Log.v("BroadCast","调用onReceive Method");

        Intent service = new Intent();
        service.setClass(context,MyService.class);
        context.startService(service);
        Log.v(TAG,"屏幕解锁，启动service");
    }
}
