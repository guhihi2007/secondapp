package secondapp.gpp.com.secondapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/8.
 */

public class MyService extends Service {

    public static final String TAG = "Service";
    MediaPlayer mediaPlayer;

    public MyBinder myBinder = new MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this,R.raw.shang);
        Log.v(TAG, "调用MyService--onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "调用MyService--onStartCommannd");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Log.v(TAG, "调用MyService--onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "调用MyService--onBind");
        return myBinder;

    }

    class MyBinder extends Binder {
        public static final String TAG = "Service";
        public void startDownload(){
            Log.v(TAG,"调用MyBinder.startDownload方法");
        }
    }
}
