package secondapp.gpp.com.secondapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/14.
 */

public class MyBroadCast_Sec extends BroadcastReceiver {

    public static final String TAG = "BroadCast";

    public MyBroadCast_Sec() {
        Log.v("BroadCast", "MyBroadCast_Sec Constructor");
    }


    @Override
    public void onReceive(Context context, Intent intent) {
//        String str=getResultExtras(true).getString("Msg");
//                intent.getStringExtra("Msg");
//        Log.v(TAG,"MyBroadCast_Sec:"+str);
//        abortBroadcast();
//        Bundle bundle = new Bundle();
//        bundle.putString("Msg",str+"--Second");
//        setResultExtras(bundle);
    }
}
