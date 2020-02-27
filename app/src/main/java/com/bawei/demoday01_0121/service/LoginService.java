package com.bawei.demoday01_0121.service;

import com.bawei.demoday01_0121.entity.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121.service
 * ClassName:   LoginService
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:40
 */
public interface LoginService {

    @POST("")
    @FormUrlEncoded
    Observable<LoginEntity> getLogin(@Field("phone") String phone, @Field("pwd") String pwd);

}
