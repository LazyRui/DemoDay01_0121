package com.bawei.demoday01_0121.contract;

import com.bawei.demoday01_0121.base.base_mvp.IBaseModel;
import com.bawei.demoday01_0121.base.base_mvp.IBaseView;
import com.bawei.demoday01_0121.entity.LoginEntity;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121.contract
 * ClassName:   LoginContract
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:32
 */
public interface LoginContract {
    interface IModel extends IBaseModel{
        void login(String phone,String pwd,CCaaback cCaaback);
        interface CCaaback{
            void success(LoginEntity loginEntity);
            void failure(Throwable throwable);
        }
    }
    interface IView extends IBaseView{
        void success(LoginEntity loginEntity);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void login(String phone,String pwd);
    }
}
