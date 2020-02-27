package com.bawei.demoday01_0121;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.EncryptUtils;
import com.bumptech.glide.provider.EncoderRegistry;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().hide();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobile.bwstudent.com/")
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


        final UserService userService = retrofit.create(UserService.class);

        final EditText userPhone = findViewById(R.id.et_phone);
        final EditText userPwd = findViewById(R.id.et_pwd);

        Button butLogin = findViewById(R.id.but_login);
        Button butRegister = findViewById(R.id.but_register);
        //登录
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                String phone = userPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {//判空
                    return;
                }

                String uspwd = userPwd.getText().toString();
                if (TextUtils.isEmpty(uspwd)) {//判空
                    return;
                }

                String upwd = EncryptUtils.encryptMD5ToString(uspwd);//MD5加密

                String pwd = upwd.substring(0, 8);


                userService.getLoginData(phone,pwd)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<UserEntity>() {
                            @SuppressLint("CheckResult")
                            @Override
                            public void accept(UserEntity userEntity) throws Exception {
                                if (userEntity != null) {
                                    //结果
                                    Toast.makeText(UserActivity.this, userEntity.getMessage(), Toast.LENGTH_SHORT).show();
                                    if (userEntity.getMessage().equals("登录成功")){
                                        Intent intent = new Intent(UserActivity.this, MineActivity.class);
                                        intent.putExtra("headPic",userEntity.getResult().getHeadPic());
                                        startActivity(intent);
                                    }
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });



            }
        });

        butRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = userPhone.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    return;
                }

                String uspwd = userPwd.getText().toString();
                if (TextUtils.isEmpty(uspwd)) {
                    return;
                }

                String upwd = EncryptUtils.encryptMD5ToString(uspwd);

                String pwd = upwd.substring(0, 8);


                userService.getRegisterData(phone,pwd)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<UserEntity>() {
                            @Override
                            public void accept(UserEntity userEntity) throws Exception {
                                if (userEntity != null) {
                                    Toast.makeText(UserActivity.this, userEntity.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });
            }
        });

    }
}
