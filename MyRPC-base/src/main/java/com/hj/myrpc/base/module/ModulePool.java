package com.hj.myrpc.base.module;

import com.hj.myrpc.base.annotation.ModuleInject;
import com.hj.myrpc.base.annotation.MyModule;
import com.hj.myrpc.base.utils.PackageScanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author hujin
 */
public class ModulePool {
    private static final Logger logger=LoggerFactory.getLogger(ModulePool.class);

    private static Map<Class<?>, IModule> moduleMap =new HashMap<>();

    static {
        initModule();
    }
    public static void initModule(){
        Set<Class<?>> moduleSet= PackageScanUtil.classScan("com.hj.myrpc", MyModule.class);
        moduleSet.forEach(clazz->{
            try {
                IModule module=(IModule) clazz.newInstance();
                moduleMap.put(clazz,module);
            } catch (Exception e) {
                logger.error(String.format("create module %s fail",clazz),e);
                throw new RuntimeException(e);
            }
        });

        for(Map.Entry<Class<?>,IModule> entry:moduleMap.entrySet()){
            Class<?> key = entry.getKey();
            IModule value = entry.getValue();
            for(Field field:key.getDeclaredFields()){
                Annotation annotation = field.getAnnotation(ModuleInject.class);
                if(annotation!=null){
                    boolean accessible= field.isAccessible();
                    field.setAccessible(true);
                    try {
                        field.set(value,moduleMap.get(field.getType()));
                    } catch (Exception e) {
                        logger.error(String.format("module value {} set failed %s fail",field.getType()),e);
                        throw new RuntimeException(e);
                    }
                    field.setAccessible(accessible);
                }
            }
        }

    }

    public static <T extends IModule> T getModule(Class<T> clazz){
        return (T)moduleMap.get(clazz);
    }

}
