package com.lisn.business_3.services;

import android.content.Context;
import android.widget.Toast;

import com.lisn.annotation.SRoute;
import com.lisn.common.RouterPathConst;


@SRoute(RouterPathConst.PATH_PROVIDER_MINE) // 数据交互的Provider，必须用接口SimpleName来注册
public class MineServiceImpl implements MineOpenServiceApi {

    private Context mContext;

    @Override
    public String accountNo() {
        return "accountNo,hello!";
    }

    @Override
    public void showAccountNo() {
        Toast.makeText(mContext, accountNo(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
