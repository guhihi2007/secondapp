package secondapp.gpp.com.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/3.
 */

public class Fragment2 extends BaseFragment  implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.f2,null,false);
        title_tv=(TextView)view.findViewById(R.id.title_tv);
        title_tv.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_tv:
                Intent intent =new Intent();
                intent.setClass(getActivity(),MySearchBar.class);
                startActivity(intent);
                break;
        }
    }
}
