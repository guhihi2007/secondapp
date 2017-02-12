package secondapp.gpp.com.secondapp.DesignMode;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyDialog extends Dialog implements Initial, View.OnClickListener {

    private Context context;
    private TextView Msg_tv;
    private Button cancel_btn;
    private Button ok_btn;


    public MyDialog(Context context) {
        super(context, R.style.MyDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog);
        Window window = getWindow();
        window.setGravity(Gravity.CENTER);
        InitView();
        InitListener();
    }

    @Override
    public void InitView() {
        Msg_tv = (TextView) findViewById(R.id.msg_tv);
        cancel_btn = (Button) findViewById(R.id.cancel_btn);
        ok_btn = (Button) findViewById(R.id.ok_btn);
    }

    @Override
    public void InitListener() {
        cancel_btn.setOnClickListener(this);
        ok_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }


}
