package com.xianzhifengshui.base;

import android.os.Bundle;
import android.os.Handler;

import com.xianzhifengshui.utils.ConstUtils;
import com.xianzhifengshui.utils.KLog;
import com.xianzhifengshui.utils.SPUtils;
import com.xianzhifengshui.utils.ToastUtils;
import com.xianzhifengshui.widget.dialog.NomalProgressDialog;
import com.zhy.autolayout.AutoLayoutActivity;


/**
 * 作者: 陈冠希
 * 日期: 2016/9/28.
 * 描述: 自定义Activity基类
 */
public class BaseActivity extends AutoLayoutActivity {
    protected String TAG;
    public BaseApplication app;
    public SPUtils sp;
    public boolean isActive;
    private boolean couldDoubleBackExit;
    private boolean pressedOnce;
    private NomalProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }




    private void init() {
        TAG = getClass().getSimpleName();
        sp = new SPUtils(this,AppConfig.SP_NAME);
        app = (BaseApplication) this.getApplication();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isActive = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
    }

    @Override
    public void onBackPressed() {
        if (!couldDoubleBackExit){
            super.onBackPressed();
        }else {
            if (pressedOnce){
                System.exit(0);
                return;
            }
            pressedOnce = true;
            showToast("再按一次退出程序");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pressedOnce = false;
                }
            }, ConstUtils.SEC*2);
        }
    }

    /**
     * 设置是否可以双击退出
     * @param couldDoubleBackExit true 开启双击退出
     */
    public void setCouldDoubleBackExit(boolean couldDoubleBackExit) {
        this.couldDoubleBackExit = couldDoubleBackExit;
    }

    /**
     * 显示Toast
     * @param text 内容
     */
    public void showToast(String text){
        ToastUtils.showToast(this,text);
    }

    /**
     * 打印普通log日志
     * @param objects 日志内容
     */
    public void log(Object... objects){
        KLog.d(TAG, objects);
    }

    /**
     * 打印Jsonlog日志
     * @param json json字符串
     */
    public void logJson(String json){
        KLog.json(TAG, json);
    }

    /**
     * 显示progressDialog
     */
    public void showWaiting(){
        if (progressDialog == null) {
            progressDialog = new NomalProgressDialog.Builder(this)
                    .setCancleable(false)
                    .build();
        }
        progressDialog.show();
    }

    /**
     * 隐藏progressDialog
     */
    public void closeWait(){
        if (progressDialog != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progressDialog.dismiss();
                }
            },ConstUtils.SEC);

        }
    }
}