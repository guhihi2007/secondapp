package secondapp.gpp.com.secondapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/18.
 */

public class f4_social extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f4_social,container,false);
        return view;
    }

}
