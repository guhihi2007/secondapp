package secondapp.gpp.com.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/1/3.
 */

public class Fragment2 extends BaseFragment  implements View.OnClickListener {

    private Button start;
    private Button stop;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.f2,null,false);
        title_tv=(TextView)view.findViewById(R.id.title_tv);
        start=(Button) view.findViewById(R.id.start_Foreground);
        stop=(Button) view.findViewById(R.id.stop_Foreground);
        title_tv.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Intent start_intent = new Intent(getActivity(),MyService.class);
        switch (v.getId()){
            case R.id.title_tv:
                Intent intent =new Intent();
                intent.setClass(getActivity(),MySearchBar.class);
                startActivity(intent);
                break;
            case R.id.start_Foreground:
                start_intent.putExtra("start",0);
                getActivity().startService(start_intent);
                break;
            case R.id.stop_Foreground:
                start_intent.putExtra("stop",1);
                getActivity().startService(start_intent);
                break;
        }
    }
}
