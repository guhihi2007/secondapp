package secondapp.gpp.com.secondapp.service;

import android.os.Binder;

/**
 * Created by Administrator on 2017/1/15.
 */

public class MyBinder extends Binder {
    public MyService getService(){
        return new MyService();
    }
}
