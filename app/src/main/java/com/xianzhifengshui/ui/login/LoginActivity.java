package com.xianzhifengshui.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xianzhifengshui.R;
import com.xianzhifengshui.base.BaseActivity;

/**
 * 用户登录页面
 */
public class LoginActivity extends BaseActivity implements LoginContract.View,View.OnClickListener {

    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBtn;
    private ImageButton backBtn;
    private TextView forgetPwdBtn;
    private TextView signBtn;

    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initViews();
    }

    private void initData() {
        presenter = new LoginPresenter(this);
    }

    private void initViews() {
        backBtn = (ImageButton) findViewById(R.id.btn_login_back);
        userNameEt = (EditText) findViewById(R.id.edit_username_login);
        passwordEt = (EditText) findViewById(R.id.edit_password_login);
        loginBtn = (Button) findViewById(R.id.btn_login);
        forgetPwdBtn = (TextView) findViewById(R.id.btn_login_forget_pwd);
        signBtn = (TextView) findViewById(R.id.btn_login_sign);
        backBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        forgetPwdBtn.setOnClickListener(this);
        signBtn.setOnClickListener(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected boolean isNeedToolbar() {
        return false;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                //登录逻辑
                String userName = userNameEt.getText().toString().trim();
                String passWord = passwordEt.getText().toString().trim();
                presenter.login(userName,passWord);
                break;
            case R.id.btn_login_back:
                //返回上一级页面
                finish();
                break;
            case R.id.btn_login_forget_pwd:
                //TODO:跳转到忘记密码页面

                break;
            case R.id.btn_login_sign:
                //TODO:跳转到注册页面

                break;
            default:
                break;
        }
    }

    @Override
    public void showLoginSuccess(String message) {
        showToast(message);
        finish();
    }

    @Override
    public void showLoginFalure(String message) {
        showToast(message);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void showWaitingDialog() {
        showWaiting();
    }

    @Override
    public void closeWaitingDialog() {
        closeWait();
    }

    @Override
    public void showTip(String text) {
        showToast(text);
    }
}
