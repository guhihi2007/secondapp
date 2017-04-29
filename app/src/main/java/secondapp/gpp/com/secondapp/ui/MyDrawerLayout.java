package secondapp.gpp.com.secondapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/2/15.
 */

public class MyDrawerLayout extends Activity implements Initial {

    private DrawerLayout drawerLayout;
    private RelativeLayout leftLayout;
    private RelativeLayout rightLayout;
    private ListView listView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        InitView();
        InitListener();
    }

    @Override
    public void InitView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        leftLayout = (RelativeLayout) findViewById(R.id.left);
        listView = (ListView) findViewById(R.id.drawer_listview);
//        toolbar = (Toolbar) findViewById(R.id.L_toolbar);
    }

    @Override
    public void InitListener() {
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//        setActionBar(toolbar);
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_string, R.string.close_string);
//        actionBarDrawerToggle.syncState();
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }
}
