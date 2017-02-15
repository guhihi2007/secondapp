package secondapp.gpp.com.secondapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/2/15.
 */

public class MyDrawerLayout extends Activity {

    private DrawerLayout drawerLayout;
    private RelativeLayout leftLayout;
    private RelativeLayout rightLayout;
    private ListView listView;
    private TextView textView;
    private ImageView imageView;
    private Button button;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);

//        LayoutInflater layoutInflater= LayoutInflater.from(this);
//        view=layoutInflater.inflate(R.layout.drawerlayout,null,false);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        leftLayout=(RelativeLayout) findViewById(R.id.left);
        rightLayout=(RelativeLayout) findViewById(R.id.right);

        listView=(ListView)findViewById(R.id.drawer_listview);

//        textView=(TextView) findViewById(R.id.drawer_list_tv1);
//        imageView=(ImageView) findViewById(R.id.drawer_list_image);
//        button=(Button) findViewById(R.id.drawer_list_bt);

        listView.setAdapter(new MyAdapter(this));
    }

}
