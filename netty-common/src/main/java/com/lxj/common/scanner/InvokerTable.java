package com.lxj.common.scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
public class InvokerTable {
    private static Map<String, Map<String, Invoker>> invokerMap = new ConcurrentHashMap<>();

    /**
     * 添加invoker
     * @param module
     * @param cmd
     * @param invoker
     */
    public static void addInvoker(String module, String cmd, Invoker invoker){
        Map<String, Invoker> map = InvokerTable.invokerMap.get(module);
        if (map == null){
            map = new HashMap<>();
            invokerMap.put(module,map);
        }
        map.put(cmd,invoker);
    }

    /**
     * 获得invoker
     * @param module
     * @param cmd
     * @return
     */
    public static Invoker get(String module, String cmd){
        Map<String, Invoker> map = invokerMap.get(module);
        if (map != null){
            return map.get(cmd);
        }
        return null;
    }
}
