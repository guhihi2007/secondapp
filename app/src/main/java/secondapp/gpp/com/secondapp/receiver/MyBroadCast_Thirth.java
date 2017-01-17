package secondapp.gpp.com.secondapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/14.
 */

public class MyBroadCast_Thirth extends BroadcastReceiver {

    public static final String TAG = "BroadCast";

    public MyBroadCast_Thirth() {
        Log.v("BroadCast", "MyBroadCast_Thirth Constructor");
    }


    @Override
    public void onReceive(Context context, Intent intent) {
//        String str=getResultExtras(true).getString("Msg");
//        String str= intent.getStringExtra("Msg");
//        Log.v(TAG,"MyBroadCast_Thirth:"+str);
    }
}
