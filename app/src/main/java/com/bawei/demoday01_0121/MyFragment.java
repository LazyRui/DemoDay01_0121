package com.bawei.demoday01_0121;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * ProjectName: DemoDay01_0121
 * PackageName: com.bawei.demoday01_0121
 * ClassName:   MyFragment
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/2/21_13:43
 */
public class MyFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_my,null);

        textView = view.findViewById(R.id.tv_show);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String name = arguments.getString("name");
            textView.setText(name);
        }

    }

    public static MyFragment getInstance(String value) {
        Bundle bundle = new Bundle();

        bundle.putString("name",value);

        MyFragment myFragment = new MyFragment();
        myFragment.setArguments(bundle);
        return myFragment;
    }

}
