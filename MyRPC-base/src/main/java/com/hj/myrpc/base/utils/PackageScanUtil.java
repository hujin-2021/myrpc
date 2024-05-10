package com.hj.myrpc.base.utils;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hujin
 */
public class PackageScanUtil {
    public static Set<Class<?>> classScan(String packageName,Class<? extends Annotation> annotation){
        Reflections reflections=new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public static Set<Field> fieldScan(String packageName,Class<? extends Annotation> annotation){
        Reflections reflections=new Reflections(packageName);
        return reflections.getFieldsAnnotatedWith(annotation);
    }
}
