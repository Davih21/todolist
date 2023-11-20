package br.com.davioliveira.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class Utils {

    public static void copyNonNullProperties(Object source, Object tardget){
        BeanUtils.copyProperties(source, tardget, getNullPropertyNamas(source));
    }

    public static String[] getNullPropertyNamas(Object soucer){
        final BeanWrapper src = new BeanWrapperImpl(soucer);
        
            PropertyDescriptor[] pds = src.getPropertyDescriptors();
            Set<String> emptyNames = new HashSet<>();

            for(PropertyDescriptor pd: pds){
                Object srcValue = src.getPropertyValue(pd.getName());
                if(srcValue == null) {
                    emptyNames.add(pd.getName());
                }
            }

            String[] result = new String[emptyNames.size()];
            return emptyNames.toArray(result);
        }
    
}
