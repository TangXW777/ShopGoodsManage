package com.tang.tools;

import java.text.SimpleDateFormat;

/**
 * ʱ�����ڹ�����
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
	
	// ��������(����Ϊ��ӵ�����)
	public static java.util.Date showWarranty(java.util.Date date, int days){
		long addSum = (days * 24 * 60 * 60 * 1000);
		return new java.util.Date(date.getTime() + addSum);
	}
	
	/*  === ֱ��ʹ�ñ�ǩ��ʽ������ =======
	public String writeDate(java.util.Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		return sdf.format(date);
	}
	*/
}
