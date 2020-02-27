package com.bawei.demoday01_0121.model;

import com.bawei.demoday01_0121.contract.LoginContract;
import com.bawei.demoday01_0121.entity.LoginEntity;
import com.bawei.demoday01_0121.service.LoginService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121.model
 * ClassName:   LoginModel
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:39
 */
public class LoginModel implements LoginContract.IModel {
    @Override
    public void login(String phone, String pwd, CCaaback cCaaback) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/")
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        retrofit.create(LoginService.class)
                .getLogin(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        if (cCaaback != null) {
                            cCaaback.success(loginEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (cCaaback != null) {
                            cCaaback.failure(throwable);
                        }
                    }
                });
    }
}
