package secondapp.gpp.com.secondapp.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/1/8.
 */

public class MyService extends Service {

    public static final String TAG = "Service";
    MediaPlayer mediaPlayer;

    /**
     * 首次创建服务时，系统将调用此方法
     * 来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "调用MyService--onCreate");
    }

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG, "调用MyService--onStartCommannd");
        Integer str = intent.getIntExtra("position", 110);

        int id = intent.getIntExtra("start",1);
        if (id==0){
            startForeground(1,new Notification());
        }else {
            stopForeground(true);
        }
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
//        bindService(intent,MyAdapter.InitServiceConn(),BIND_AUTO_CREATE);
        if (mediaPlayer!=null)
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }





    /**
     * 服务销毁时的回调
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
//        unbindService(MyAdapter.InitServiceConn());
//        mediaPlayer.stop();
        Log.v(TAG, "调用MyService--onDestroy");
    }


    /**
     * 用绑定服务时才会调用
     * 必须要实现的方法
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "调用MyService--onBind");
//        Integer str = intent.getIntExtra("position", 110);
//        Log.v(TAG, "position:" + str);
//        startService(intent);
        return new MyBinder();

    }
    public void startDownload() {
        Log.v(TAG, "调用MyBinder.startDownload方法");
    }
}
