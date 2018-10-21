package com.pygrow.xblog.myblog.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
* @author E先生
* @version 创建时间：2018年9月7日 下午5:08:55
* @ClassName ToolUtil
* @Description 工具类
*/
public class ToolUtil {
	
	/**
	 * 判断是否为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if(obj==null) {
			return true;
		}
		if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        return false;
	}
	

}
