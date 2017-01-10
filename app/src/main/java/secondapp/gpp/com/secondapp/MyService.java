package secondapp.gpp.com.secondapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
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
    public ServiceConnection serviceConnection;
    public MyBinder myBinder = new MyBinder();
//    private Integer str;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "调用MyService--onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "调用MyService--onStartCommannd");
        Integer str = intent.getIntExtra("position", 110);

        switch (str) {
            case 0:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(this, R.raw.shang);
                break;
            case 1:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(this, R.raw.god);
                break;
            case 2:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(this, R.raw.silent);
                break;
            case 3:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(this, R.raw.dream);
                break;
        }
        bindService(intent,MyAdapter.InitServiceConn(),BIND_AUTO_CREATE);
        if (mediaPlayer!=null)
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindService(MyAdapter.InitServiceConn());
        mediaPlayer.stop();
        Log.v(TAG, "调用MyService--onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "调用MyService--onBind");
//        Integer str = intent.getIntExtra("position", 110);
//        Log.v(TAG, "position:" + str);
//        startService(intent);
        return null;

    }

    class MyBinder extends Binder {
        public static final String TAG = "Service";

        public void startDownload() {
            Log.v(TAG, "调用MyBinder.startDownload方法");
        }
    }

    public ServiceConnection getserviceConnection() {
        return serviceConnection = new ServiceConnection() {
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
}
