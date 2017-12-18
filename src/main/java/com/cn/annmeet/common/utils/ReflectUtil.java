package com.cn.annmeet.common.utils;

import java.lang.reflect.Field;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cn.annmeet.domain.CustInfo;

public class ReflectUtil {
	private static Logger logger = Logger.getLogger(ReflectUtil.class);
	public static Object StrsTurnObject(String[] strs,Class clazz) throws Exception{
		Field [] fields = clazz.getDeclaredFields(); 
		Object obj =clazz.newInstance();
		if(strs.length==0||strs.length!=fields.length) {
			logger.error("字符串数组和实体类字段不对应");
			return null;
		}
		for(int i=0; i<fields.length;i++) {
			fields[i].setAccessible(true);
			if(fields[i].getType().equals(Long.class) || fields[i].getType().equals(long.class)){  
				fields[i].set(obj, Long.parseLong(strs[i]));  
            }else if(fields[i].getType().equals(String.class)){  
            	fields[i].set(obj, strs[i]);  
            } else if(fields[i].getType().equals(Double.class) || fields[i].getType().equals(double.class)){  
            	fields[i].set(obj, Double.parseDouble(strs[i]));  
            } else if(fields[i].getType().equals(Integer.class) || fields[i].getType().equals(int.class)){  
            	fields[i].set(obj, Integer.parseInt(strs[i]));  
            } else if(fields[i].getType().equals(java.util.Date.class)){  
            	fields[i].set(obj, Date.parse(strs[i]));  
            }else{  
                continue;  
            }  
					
		}
		return obj;
	}
}
