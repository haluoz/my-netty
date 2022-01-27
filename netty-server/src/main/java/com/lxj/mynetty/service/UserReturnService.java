package com.lxj.mynetty.service;

import com.lxj.common.annotation.Cmd;
import com.lxj.common.annotation.Module;
import com.lxj.common.proto.MessageModule;
import org.springframework.stereotype.Service;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
@Service
@Module(module = "user-return")
public class UserReturnService {
    @Cmd(cmd = "save-return")
    public void saveReturn (MessageModule.ResultType resultType, byte[] data){
        if (MessageModule.ResultType.SUCCESS.equals(resultType)){
            System.out.println("save success");
        }else{
            System.out.println("save failure");
        }
    }

    @Cmd(cmd = "update-return")
    public void updateReturn (MessageModule.ResultType resultType, byte[] data){
        if (MessageModule.ResultType.SUCCESS.equals(resultType)){
            System.out.println("update success");
        }else{
            System.out.println("update failure");
        }
    }
}
