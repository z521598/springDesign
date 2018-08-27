package com.github.util;

/**
 * Created by langshiquan on 2018/8/26.
 */
public class StringUtils {
    public static String toString(Object[] objects) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (Object obj : objects) {
            stringBuffer.append(obj.toString()).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
