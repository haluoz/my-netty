package com.lxj.common.scanner;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
@Data
public class Invoker {
    private Method method;
    private Object target;

    /**
     * 创建对象
     * @param method
     * @param target
     * @return
     */
    public static Invoker createInvoker(Method method, Object target) {
        Invoker invoker = new Invoker();
        invoker.setMethod(method);
        invoker.setTarget(target);
        return invoker;
    }

    /**
     * 反射调用
     * @param params
     * @return
     */
    public Object invoke(Object... params){
        try {
            return method.invoke(target, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
