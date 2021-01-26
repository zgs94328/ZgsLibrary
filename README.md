#ZgsLibrary 轻量级的Android 快速开发框架基础库

## 概述

<p align="center">
	<img src="xdroid_logo_128.png"/>
</p>

Android快速开发框架，我是根据自己的使用习惯集合了常用的框架作为封装，绝大部分代码来自kunji

**ZgsLibrary全新文档**

[![](https://jitpack.io/v/limedroid/XDroidMvp.svg)](https://jitpack.io/#limedroid/XDroidMvp)

<p align="center">
	<img src="art/XdroidMvp_total.png"/>
</p>


支持：

* `BaseLibActivity`、`BaseDbLibActivity`、`BaseLibFragment`、`BaseDbLibFragment`、`BaseSmartListFragment`等基类，可快速进行开发
* 完整封装`XRecyclerView`，可实现绝大部分需求
* `XStateController`、`XRecyclerContentLayout`实现loading、error、empty、content四种状态的自由切换
* 实现了`Memory`、`Disk`、`SharedPreferences`三种方式的缓存，可自由扩展
* 内置了`RxBus`，可自由切换到其他事件订阅库
* 内置`Glide`，可自由切换其他图片加载库
* 可输出漂亮的`Log`，支持`Json`、`Xml`、`Throwable`等，蝇量级实现
* 内置链式路由
* 内置常用工具类：`package`、`random`、`file`...,提供的都是非常常用的方法
* 内置加密工具类 `XCodec`，你想要的加密姿势都有


<p align="center">
	<img src="mvp.png"/>
</p>


**先睹为快**

BaseActivity：
根据需求创建自己的baseActivity继承BaseLibActivity或者BaseLibDbLibActivity
在里面封装初始化功能
你可以这么使用:



```java
public abstract class BasePagerFragment extends XFragment<PBasePager>{

   @Override
    public void initData(Bundle savedInstanceState) {
        getP().loadData(getType(), 1);	//调用P方法
    }

   public void showData(int page, GankResults model) {
        if (page > 1) {
            getAdapter().addData(model.getResults());
        } else {
            getAdapter().setData(model.getResults());
        }

        contentLayout.getRecyclerView().setPage(page, MAX_PAGE);

        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
    }
    
	 @Override
    public PBasePager newP() {
        return new PBasePager();
    }}
    
    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_pager;
    }
```

PBasePager

```java
public class PBasePager extends XPresent<BasePagerFragment> {
    protected static final int PAGE_SIZE = 10;


    public void loadData(String type, final int page) {
        Api.getGankService().getGankData(type, PAGE_SIZE, page)
                .compose(XApi.<GankResults>getApiTransformer())
                .compose(XApi.<GankResults>getScheduler())
                .subscribe(new ApiSubcriber<GankResults>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error); //调用V方法
                    }

                    @Override
                    public void onNext(GankResults gankResults) {
                        getV().showData(page, gankResults);
                    }
                });
    }
}
```

## Setup


## 通过JitPack引入

### step1 在根目录的gradle文件中配置:
```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://maven.google.com" }
        maven { url "https://jitpack.io" }
    }
}
```

### step2 添加依赖:
```groovy
dependencies {
	   implementation 'com.github.limedroid:XDroidMvp:v2.0.1'
}
```


## Demo效果

<p align="center">
	<img src="art/snapshot_2.png"/>
</p>

<p align="center">
	<img src="art/snapshot_1.png"/>
</p>


## 使用框架

* [x5webview](https://x5.tencent.com/)腾讯封装的webview
* [MMKV](https://github.com/trello/RxLifecycle)
* [RxPermissions](https://github.com/tbruyelle/RxPermissions)动态权限申请
* [glide](https://github.com/square/retrofit) 图片加载
* [BaseRecyclerViewAdapterHelper](https://github.com/square/retrofit) adapter
* [MagicIndicator](https://github.com/square/retrofit) 滑动tab
* [BannerViewPager](https://github.com/tbruyelle/RxPermissions)banner轮播
* [BottomNavigationViewEx](https://github.com/tbruyelle/RxPermissions)底部导航
* [loadsir](https://github.com/tbruyelle/RxPermissions)状态页面
* [autosize](https://github.com/tbruyelle/RxPermissions)百分比适配框架
* [smart](https://github.com/tbruyelle/RxPermissions)下拉刷新
* [immersionbar](https://github.com/tbruyelle/RxPermissions)沉浸式状态栏


## 更新日志

* 2021-01-25 创建



## TODO

* [x] wiki
* [x] demo

## About Me

**Email** : 37368562@qq.com

**ZgsLibrary交流群**：暂无



若您在使用过程中遇到任何问题，欢迎提问 **37368562@qq.com** 群或者是邮件反馈，谢谢您的关注。如果喜欢，记得star fork。


