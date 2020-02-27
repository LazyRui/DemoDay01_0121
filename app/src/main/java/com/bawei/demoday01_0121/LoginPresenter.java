package com.bawei.demoday01_0121;

import com.bawei.demoday01_0121.base.base_mvp.BasePresenter;
import com.bawei.demoday01_0121.contract.LoginContract;
import com.bawei.demoday01_0121.entity.LoginEntity;
import com.bawei.demoday01_0121.model.LoginModel;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121
 * ClassName:   LoginPresenter
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:43
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.IView> implements LoginContract.IPresenter {
    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }

    @Override
    public void login(String phone, String pwd) {
        mModel.login(phone, pwd, new LoginContract.IModel.CCaaback() {
            @Override
            public void success(LoginEntity loginEntity) {
                getView().success(loginEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
