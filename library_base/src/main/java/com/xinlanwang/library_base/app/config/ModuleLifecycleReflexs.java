package com.xinlanwang.library_base.app.config;

/**
 * Created by goldze on 2018/6/21 0021.
 * 组件生命周期反射类名管理，在这里注册需要初始化的组件，通过反射动态调用各个组件的初始化方法
 * 注意：以下模块中初始化的Module类不能被混淆
 */

public class ModuleLifecycleReflexs {
    private static final String CommonInit = "com.xinlanwang.library_common.CommonModuleInit";
    //main模块
    private static final String MainInit = "com.xinlanwang.module_main.MainModuleAppInit";
    //用户模块
    private static final String UserInit = "com.xinlanwang.module_mine.MineModuleAppInit";
    //公共页面业务模块
    private static final String CommonPageInit = "com.xinlanwang.module_common_page.CommonPageModuleAppInit";
    //主页业务模块
    private static final String HomeInit = "ccom.xinlanwang.module_home.HomeModuleAppInit";


    public static String[] initModuleNames = {CommonInit, MainInit,CommonPageInit, HomeInit,UserInit};
}
