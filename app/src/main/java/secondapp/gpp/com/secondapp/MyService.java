package secondapp.gpp.com.secondapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2017/1/8.
 */

public class MyService extends Service {

    public static final String TAG = "Service";
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this,R.raw.shang);
        Log.v(TAG, "Service---onCreate");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "Service---onStartCommannd");
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Log.v(TAG, "Service---onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "Service---onBind");
        return null;

    }
}
