package com.echeng.app.logutils;

import android.os.Environment;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by che on 2017/4/14.
 */

public class Log {

    private static Logger gLogger;
    private static String name = Environment.getExternalStorageDirectory() + File.separator + "log4j.log";
    private static Action action;
    static LogConfigurator logConfigurator = null;
    static UploadFileListener uploadFileListener;

    public static void init(Action actionFlag) {

        action = actionFlag;
        logConfigurator = new LogConfigurator();
        logConfigurator.setFileName(name);
        logConfigurator.setRootLevel(Level.DEBUG);
        logConfigurator.setLevel("org.apache", Level.ERROR);
        logConfigurator.configure();
    }

    public static void detach() {
        if (gLogger != null) {
            gLogger = null;
        }
        if (logConfigurator!=null){

        }


    }

    public static void init(String fileName, Action actionFlag) {
        name = fileName;
        init(actionFlag);
    }

    public static boolean check() {
        if (logConfigurator == null) {
            try {
                throw new Exception("请先调用init方法,init有两个重载方法 默认是把日志文件再放根目录下/log4j.log");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    /**
     *
     */
    public static void upLoadLog4jFile(UploadFileListener context) {
        uploadFileListener = context;
    }

    public static void d(String tag, String message) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.debug(message);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.debug(message);
                break;
            case NORMAL_LOG:
                android.util.Log.d(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }
    }

    private static void uploadFile() {
        String filePath = logConfigurator.getFileName();
        if (Utils.isFileExists(filePath)) {
            File file = new File(filePath);
            if (uploadFileListener != null) {
                uploadFileListener.upload(file);
            }
        }
    }

    public static void i(String tag, String message) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.info(message);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.info(message);
                break;
            case NORMAL_LOG:
                android.util.Log.i(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }
    }

    public static void w(String tag, String message) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.warn(message);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.warn(message);
                break;
            case NORMAL_LOG:
                android.util.Log.w(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }

    }

    public static void w(String tag, String message, Throwable throwable) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.warn(message, throwable);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.warn(message, throwable);
                break;
            case NORMAL_LOG:
                android.util.Log.w(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }

    }

    public static void e(String tag, String message) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.error(message);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.error(message);
                break;
            case NORMAL_LOG:
                android.util.Log.e(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }
    }

    public static void e(String tag, String message, Throwable throwable) {
        if (!check()) return;
        gLogger = Logger.getLogger(tag);
        String fileName = logConfigurator.getFileName();
        switch (action) {
            case APPEND_LOG:
                gLogger.error(message, throwable);
                break;
            case CLEAR_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                break;
            case CLEAR_APPEND_LOG:
                if (Utils.isFileExists(fileName))
                    Utils.deleteFile(fileName);
                init(action);
                gLogger.error(message, throwable);
                break;
            case NORMAL_LOG:
                android.util.Log.e(tag, message);
                break;
            case UP_LOG:
                uploadFile();
                break;
            case CLOSE_LOG:
                break;
        }
    }

}
