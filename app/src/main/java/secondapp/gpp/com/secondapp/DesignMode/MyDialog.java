package secondapp.gpp.com.secondapp.DesignMode;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import secondapp.gpp.com.secondapp.Initial;
import secondapp.gpp.com.secondapp.R;

/**
 * Created by Administrator on 2017/2/12.
 */

public class MyDialog extends Dialog implements Initial,View.OnClickListener {

    private Context context;
    private Button cancel_btn;
    private Button ok_btn;
    private TextView Msg_tv;
    private CancelListener mCancel;
    private OkListener mOk;
    private int themeResId;
    public void setOkListener(OkListener mOk) {
        this.mOk = mOk;
    }

    public void setCancelListener(CancelListener mCancel) {
        this.mCancel = mCancel;
    }

    public void setThemeResId(int themeResId){
        this.themeResId=themeResId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog);
        InitView();
        InitListener();
    }

    public MyDialog(Context context) {
        super(context,R.style.MyDialog);
        this.context = context;
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    public void InitView() {
        cancel_btn = (Button) findViewById(R.id.cancel_btn);
        ok_btn = (Button) findViewById(R.id.ok_btn);
        Msg_tv = (TextView) findViewById(R.id.msg_tv);
    }

    @Override
    public void InitListener() {
        cancel_btn.setOnClickListener(this);
        ok_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_btn:
                if (mCancel!=null){
                    mCancel.onClick(v);
                }
                break;
            case R.id.ok_btn:
                if (mOk!=null){
                    mOk.onClick(v);
                }
                break;
        }
    }

    public static class MyDialogBuilder {
        private Context context;
        private String Msg;
        private String Title;
        private String cancel_btn_tv;
        private String ok_btn_tv;
        private int ResId;
        private MyDialog myDialog;
        private View.OnClickListener cancel;
        private View.OnClickListener ok;
        public MyDialogBuilder(Context context) {
            myDialog = new MyDialog(context);
            this.context = context;
        }

        public MyDialogBuilder setMsg(String msg) {
            Msg = msg;
            return this;
        }

        public MyDialogBuilder setTitle(String title) {
            Title = title;
            return this;
        }

        public MyDialogBuilder setCancel_btn_tv(String cancel_btn_tv) {
            this.cancel_btn_tv = cancel_btn_tv;
            return this;
        }

        public MyDialogBuilder setOk_btn_tv(String ok_btn_tv) {
            this.ok_btn_tv = ok_btn_tv;
            return this;
        }

        public MyDialogBuilder setResId(int ResId) {
            this.ResId = ResId;
            return this;
        }

        public MyDialogBuilder setOnCancelListener(View.OnClickListener listener) {
            this.cancel = listener;
            return this;
        }

        public MyDialogBuilder setOnOKListener(View.OnClickListener listener) {
           this.ok = listener;
            return this;
        }

        public MyDialog create() {
            return new MyDialog(context);
        }
    }

    public interface CancelListener {
        void onClick(View view);
    }

    public interface OkListener {
        void onClick(View view);
    }



}
