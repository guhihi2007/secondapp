package secondapp.gpp.com.secondapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/17.
 */

public class Search_fragment2 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.search_fragment2,container,false);
        return view;
    }
}
