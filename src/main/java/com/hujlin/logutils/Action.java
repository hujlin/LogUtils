package com.echeng.app.logutils;

/**
 * Created by che on 2017/4/14.
 */

public enum Action {

    //关闭日志输出
    CLOSE_LOG,

    //先清空本地保存的日志(删除)
    CLEAR_LOG,

    //先清空本地保存的日志再添加
    CLEAR_APPEND_LOG,

    //在本地保存的额日志后追加日志
    APPEND_LOG,

    //上传日志
    UP_LOG,

    //输出系统日志
    NORMAL_LOG

}
