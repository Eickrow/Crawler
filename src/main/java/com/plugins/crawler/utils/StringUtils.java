package com.plugins.crawler.utils;

/**
 * Created by david.yun on 2017/5/24.
 */
public class StringUtils {
    public static String nvl(Object object) {
        if (object == null) {
            return "";
        }
        return object.toString().trim();
    }
}
