package com.lisn.annotation;

import java.util.Map;

import com.lisn.annotation.facade.model.RouteMeta;

/**
 * 路由 接口类
 * 路由的作用就是：注册Activity 或者 Fragment 或者 Provider
 */
public interface IRouterS {

    void onLoad(Map<String, RouteMeta> routes);

}
