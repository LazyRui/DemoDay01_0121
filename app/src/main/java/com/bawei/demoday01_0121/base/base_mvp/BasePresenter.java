package com.bawei.demoday01_0121.base.base_mvp;

import java.lang.ref.WeakReference;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121.base.base_mvp
 * ClassName:   BasePresenter
 * Description: Java类的作用
 * Author: LazyRui
 * CreateDate: 2020/2/27 16:22
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> {
    protected M mModel;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        mModel = initModel();
    }

    public void attach(V v) {
        weakReference = new WeakReference<>(v);
    }

    public void detach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected abstract M initModel();

    public V getView() {
        return weakReference.get();
    }

}
