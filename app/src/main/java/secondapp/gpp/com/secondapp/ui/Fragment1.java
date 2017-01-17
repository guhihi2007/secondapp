package secondapp.gpp.com.secondapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.R;
import secondapp.gpp.com.secondapp.base.BaseFragment;

/**
 * Created by Administrator on 2017/1/3.
 */

public class Fragment1 extends BaseFragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.f1,null,false);
        listView =(ListView)view.findViewById(R.id.f1_listview);
        title_tv=(TextView)view.findViewById(R.id.title_tv);
        title_tv.setOnClickListener(this);
        listView.setAdapter(new MyAdapter(mContext));
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
