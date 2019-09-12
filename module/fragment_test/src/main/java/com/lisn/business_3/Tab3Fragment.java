package com.lisn.business_3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lisn.annotation.SRoute;



import com.lisn.common.RouterPathConst;

@SRoute(RouterPathConst.PATH_FRAGMENT_TAB3)
public class Tab3Fragment extends Fragment {
    public Tab3Fragment() {
    }

    public static Tab3Fragment newInstance(Bundle bundle) {
        Tab3Fragment tab3Fragment = new Tab3Fragment();
        tab3Fragment.setArguments(bundle);
        return tab3Fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab3, null);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
