package com.tang.tools;

import java.text.SimpleDateFormat;

/**
 * 时间日期工具类
 * @author Administrator
 *
 */
public class DateChange {
	// util.Date -> sql.Date
	public static java.sql.Date util2Sql(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	
	// sql.Date -> util.Date
	public static java.util.Date sql2Util(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
	
	// 保质期至(参数为添加的天数)
	public static java.util.Date showWarranty(java.util.Date date, int days){
		long addSum = (days * 24 * 60 * 60 * 1000);
		return new java.util.Date(date.getTime() + addSum);
	}
	
	/*  === 直接使用标签格式化日期 =======
	public String writeDate(java.util.Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(date);
	}
	*/
}
