package com.bawei.demoday01_0121.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.demoday01_0121.base.base_mvp.BasePresenter;
import com.bawei.demoday01_0121.base.base_mvp.IBaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121.base
 * ClassName:   BaseActivity
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:24
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity  implements IBaseView {
    protected P mPresenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        bind = ButterKnife.bind(this);
        mPresenter = initPresenter();

        if (mPresenter != null) {
            mPresenter.attach(this);
        }

        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int layoutId();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
        if (mPresenter != null) {
            mPresenter.detach();
        }
    }
}
