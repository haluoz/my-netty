package com.lxj.common.scanner;

import com.lxj.common.annotation.Cmd;
import com.lxj.common.annotation.Module;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 在bean初始化之后
 * 找到@module的bean对象
 * 然后找到@cmd注解的方法
 * 最后创建invoker，并加入invokertable里
 * @author Xingjing.Li
 * @since 2021/10/28
 */
@Component
public class NettyScanner implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //获得class的类型
        Class<?> clazz = bean.getClass();
        boolean isPresent = clazz.isAnnotationPresent(Module.class);
        if (isPresent){
            Method[] methods = clazz.getMethods();
            if (methods != null && methods.length > 0){
                for (Method method : methods) {
                    Module module = clazz.getAnnotation(Module.class);
                    Cmd cmd = method.getAnnotation(Cmd.class);
                    if (cmd == null){
                        continue;
                    }
                    String moduleValue = module.module();
                    String cmdValue = cmd.cmd();
                    //只需要moduleValue和cmdValue对应的反射对象保存起来
                    if(InvokerTable.get(moduleValue, cmdValue) == null){
                        InvokerTable.addInvoker(moduleValue, cmdValue, Invoker.createInvoker(method, bean));
                    }else{
                        System.out.println("模块对应的命令已存在");
                    }
                }
            }
        }
        return bean;
    }
}
