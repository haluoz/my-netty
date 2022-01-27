package com.lxj.mynetty.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lxj.common.annotation.Cmd;
import com.lxj.common.annotation.Module;
import com.lxj.common.proto.Result;
import com.lxj.common.proto.UserModule;
import org.springframework.stereotype.Service;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
@Service
@Module(module = "user")
public class UserService {

    @Cmd(cmd = "save")
    public Result<?> save(byte[] data) {
        UserModule.User user = null;
        try {
            user = UserModule.User.parseFrom(data);
            System.out.println(user.getUserId()+","+user.getUsername());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return Result.failure();
        }
        return Result.success(user);
    }

    @Cmd(cmd = "update")
    public Result<?> udpate(byte[] data){
        UserModule.User user = null;
        try {
            user = UserModule.User.parseFrom(data);
            System.out.println(user.getUserId()+","+user.getUsername());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            return Result.failure();
        }
        return Result.success(user);
    }
}
