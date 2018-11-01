package com.pygrow.xblog.myblog.util;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
	
	
	/**
	 * 获取时间
	 * @return 返回短时间格式 yyyy-MM-dd
	 * @throws ParseException 
	 */
	public static Date getNowDateShort() throws ParseException {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(currentTime);
//	    ParsePosition pos = new ParsePosition(8);
	    Date currentTime_2 = formatter.parse(dateString);
	    return currentTime_2;
	  }
	
	/**
	 * 获取时间二
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
//	    Date currentTime = new Date();
//	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    String dateString = formatter.format(currentTime);
//	    ParsePosition pos = new ParsePosition(8);
//	    Date currentTime_2 = formatter.parse(dateString, pos);
//	    return currentTime_2;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date());
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	  }
	
    /**
	   * 获取现在时间
	   * @return 返回短时间字符串格式yyyy-MM-dd
	   */
	
	/**
	 * 
	 * @return
	 */
	  public static String getStringDateShort() {
	    Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String dateString = formatter.format(currentTime);
	    return dateString;
	  }
	 
	  /**
	   * 获取时间 
	   * @return 小时:分;秒 HH:mm:ss
	   */
	  public static String getTimeShort() {
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    Date currentTime = new Date();
	    String dateString = formatter.format(currentTime);
	    return dateString;
	  }
	 
	

}
