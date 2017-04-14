package com.echeng.app.logutils;

import java.io.File;

/**
 * Created by che on 2017/4/14.
 */

public class Utils {

    public static boolean isFileExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            path = null;
            return false;
        }
        return true;
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
