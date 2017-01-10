package secondapp.gpp.com.secondapp;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Administrator on 2017/1/3.
 */

public class MyAdapter extends BaseAdapter {
    public static final String TAG = "Service";

    ViewHolder viewHolder;
    LayoutInflater layoutInflater;
    Context context;

    public MyAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        InitServiceConn();

    }

    @Override
    public int getCount() {
        return DataArray.getArryList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView1 = (TextView) convertView.findViewById(R.id.list_tv1);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_image);
            viewHolder.button = (Button) convertView.findViewById(R.id.list_bt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView1.setText(DataArray.getArryList().get(position).get("Item").toString());
        viewHolder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "文本：" + position + "");
                Log.v(TAG, "id：" + v.getId() + "");
                Toast.makeText(context, "" + (position + 1) + " 你点了我一下", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, MyService.class);
                intent.putExtra("position", position);
                context.startService(intent);
//                context.bindService(intent,InitServiceConn(),context.BIND_AUTO_CREATE);
//                Log.v(TAG,"按钮："+position+"");
//                Log.v(TAG,"id："+v.getId()+"");
                String str = DataArray.getArryList().get(position).get("Item").toString();
                Toast.makeText(context, "" + str + " 开始播放....", Toast.LENGTH_SHORT).show();

//                Toast.makeText(context,""+(position+1)+ " 开始播放....",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    public static ServiceConnection InitServiceConn() {
        MyService myService = new MyService();
        ServiceConnection serviceConnection = myService.getserviceConnection();
        return serviceConnection;
    }

    public final class ViewHolder {
        public TextView textView1;
        public ImageView imageView;
        public Button button;
    }
}
