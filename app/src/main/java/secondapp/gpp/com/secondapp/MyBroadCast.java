package secondapp.gpp.com.secondapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/14.
 */

public class MyBroadCast extends BroadcastReceiver {

    public  MyBroadCast(){
        Log.v("BroadCast","调用MyBroadCast Constructor");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("BroadCast","调用onReceive Method");
    }
}
