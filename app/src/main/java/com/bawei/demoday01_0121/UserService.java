package com.bawei.demoday01_0121;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121
 * ClassName:   UserService
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/26 16:35
 */
public interface UserService {
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<UserEntity> getLoginData(@Field("phone") String phone, @Field("pwd") String pwd);

    @POST("small/user/v1/register")
    @FormUrlEncoded
    Observable<UserEntity> getRegisterData(@Field("phone") String phone, @Field("pwd") String pwd);
}
