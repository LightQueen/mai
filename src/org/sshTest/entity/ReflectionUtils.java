package org.sshTest.entity;

import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;


public class ReflectionUtils {
	public static List fetchElementPropertyToList(Collection collection, String propertyName){  
        List list = new ArrayList();  
          
        try {  
            for(Object obj: collection){  
                list.add(PropertyUtils.getProperty(obj, propertyName));  
            }  
        } catch (Exception e) {  
            e.printStackTrace();    
        }  
          
        return list;  
    }
	
	
	 public static String fetchElementPropertyToString(Collection collection, String propertyName,   
	            String seperator){  
	        List list = fetchElementPropertyToList(collection, propertyName);  
	        return StringUtils.join(list, seperator);  
	    }  
}
