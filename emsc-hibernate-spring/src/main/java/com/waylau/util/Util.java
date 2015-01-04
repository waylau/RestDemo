/**
 * 
 */
/**
 * @author waylau.com
 * 2015年1月2日
 */
package com.waylau.util;

 
/** 
 * 通用工具类 
 */  
public class Util {  
  
  
    /** 
     * 判断字符串是否为空 
     *  
     * @param str 
     *            字符串 
     * @return true：为空； false：非空 
     */  
    public static boolean isNull(String str) {  
        if (str != null && !str.trim().equals("")) {  
            return false;  
        } else {  
            return true;  
        }  
    }
}
