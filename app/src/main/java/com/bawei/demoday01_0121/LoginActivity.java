package com.bawei.demoday01_0121;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.demoday01_0121.base.BaseActivity;
import com.bawei.demoday01_0121.contract.LoginContract;
import com.bawei.demoday01_0121.entity.LoginEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.IView {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.but_zhuce)
    Button butZhuce;
    @BindView(R.id.but_denglu)
    Button butDenglu;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();

            if (loginEntity.getResult().equals("0000")){
                finish();


            }
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }


    @OnClick({R.id.but_zhuce, R.id.but_denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_zhuce:
                if (TextUtils.isEmpty(etPhone.getText().toString()) && TextUtils.isEmpty(etPwd.getText().toString())){
                    return;
                }
                mPresenter.login(etPhone.getText().toString(),etPwd.getText().toString());
                break;
            case R.id.but_denglu:
                if (TextUtils.isEmpty(etPhone.getText().toString()) && TextUtils.isEmpty(etPwd.getText().toString())){
                    return;
                }
                mPresenter.login(etPhone.getText().toString(),etPwd.getText().toString());
                break;
        }
    }
}
