package com.lisn.example.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;


import com.lisn.api.SRouter;
import com.lisn.example.R;
import com.lisn.example.ui.bottom.BottomAdapter;
import com.lisn.example.ui.bottom.TabTitle;
import com.lisn.example.util.DrawableUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.lisn.common.RouterPathConst;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_bottom)
    RecyclerView mRvBottom;

    //******************************************  生命周期函数   *******************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Fragment路由的相关参数

        SRouter.getInstance().initFragmentParameters(this, R.id.content_frame, new SRouter.OnFragmentChangedLis() {
            @Override
            public void setTab(String routePath) {
                mAdapter.setSelection(findPositionByRoutePath(routePath));//找到这个routePath对应的position，然后切换下面的tab
            }
        });

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottom();
        initContentFrame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SRouter.getInstance().release();// 很诡异的一个问题。静态变量难道不会随着进程被杀而释放内存么，还要我在onDestroy里面手动释放
    }

    //*************************    中间内容区      ***********************************

    private void initContentFrame() {
        if (titleObjectList != null && titleObjectList.size() > 0) {
            SRouter.getInstance().build(titleObjectList.get(0).getRoutePath()).navigation();
        }
    }

    //*************************   中间内容区OVER    ***********************************

    //***************************       底部       ***************************************
    private BottomAdapter mAdapter;

    /**
     * 初始化底部
     */
    private void initBottom() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvBottom.setLayoutManager(linearLayoutManager);

        mAdapter = new BottomAdapter(this, getBottomSetting());
        mAdapter.setOnItemClickListener(new BottomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String fragmentRoutePath) {
                mAdapter.setSelection(position);
                if (!TextUtils.isEmpty(fragmentRoutePath)) {
                    Object navigation = SRouter.getInstance().build(fragmentRoutePath).navigation();
                    Log.e("---", "onItemClick: " + navigation);
                }
            }
        });
        mRvBottom.setAdapter(mAdapter);
    }

    private List<TabTitle> titleObjectList = new ArrayList<>();//底部TAB的数据

    /**
     * 按照routePath，找到routePath所在位置
     *
     * @param routePath
     * @return
     */
    private int findPositionByRoutePath(String routePath) {
        int position = 0;
        for (int i = 0; i < titleObjectList.size(); i++) {
            if (titleObjectList.get(i).getRoutePath().equals(routePath)) {
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * 导航栏配置
     *
     * @return
     */
    private List<TabTitle> getBottomSetting() {
        //本来这里应该要读取配置文件，然后配置文字和颜色，还有图标,暂时写死
        titleObjectList.add(new TabTitle(
                RouterPathConst.PATH_FRAGMENT_TAB1,
                R.string.tag_name_tab1,
                R.color.home_tab_text_selector,
                DrawableUtil.getStateListDrawable(this, R.mipmap.a_tabbar_tab1, R.mipmap.a_tabbar_home_p)));
        titleObjectList.add(new TabTitle(
                RouterPathConst.PATH_FRAGMENT_TAB2,
                R.string.tag_name_tab2,
                R.color.home_tab_text_selector,
                DrawableUtil.getStateListDrawable(this, R.mipmap.a_tabbar_tab2, R.mipmap.a_tabbar_trade_p)));
        titleObjectList.add(new TabTitle(
                RouterPathConst.PATH_FRAGMENT_TAB3,
                R.string.tag_name_tab3,
                R.color.home_tab_text_selector,
                DrawableUtil.getStateListDrawable(this, R.mipmap.a_tabbar_tab3, R.mipmap.a_tabbar_market_p)));
        titleObjectList.add(new TabTitle(
                RouterPathConst.PATH_FRAGMENT_TAB4,
                R.string.tag_name_tab4,
                R.color.home_tab_text_selector,
                DrawableUtil.getStateListDrawable(this, R.mipmap.a_tabbar_tab4, R.mipmap.a_tabbar_me_p)));


        return titleObjectList;
    }

    //***************************底部OVER***************************************

}
