package com.lisn.business_3.services;

import com.lisn.api.facade.template.IProvider;

/**
 * “我的”模块的所有对外公开的数据接口
 * 这个文件是api后缀的。如果要编辑接口，在这里改
 * 整个项目编译之后，此.api会自动生成一个同名的.java文件。不要去编辑这个.java文件。
 */
public interface MineOpenServiceApi extends IProvider {

    /**
     * 加入这里有一个用户名，需要反馈给外界
     *
     * @return
     */
    public String accountNo();

    public void showAccountNo();
}
