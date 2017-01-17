package secondapp.gpp.com.secondapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/7.
 */

public abstract class BaseFragment extends Fragment {
    public View view;
    public TextView title_tv;
    public ListView listView;
    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext=getActivity();
    }

}
