package com.lxj.common.proto;

import com.google.protobuf.GeneratedMessageV3;
import lombok.Data;

/**
 * 通用返回结果类
 * @author Xingjing.Li
 * @since 2021/10/28
 */
@Data
public class Result<T extends GeneratedMessageV3> {
    private MessageModule.ResultType resultType;
    private T content;

    public static <T extends GeneratedMessageV3> Result<T> success(){
        Result<T> result = new Result<>();
        MessageModule.ResultType resultType = MessageModule.ResultType.SUCCESS;
        return result;
    }

    public static <T extends GeneratedMessageV3> Result<T> success(T content){
        Result<T> result = new Result<>();
        MessageModule.ResultType resultType = MessageModule.ResultType.SUCCESS;
        result.content = content;
        return result;
    }

    public static <T extends GeneratedMessageV3> Result<T> failure(){
        Result<T> result = new Result<>();
        MessageModule.ResultType resultType = MessageModule.ResultType.FAILURE;
        return result;
    }

    public static <T extends GeneratedMessageV3> Result<T> failure(T content){
        Result<T> result = new Result<>();
        MessageModule.ResultType resultType = MessageModule.ResultType.FAILURE;
        result.content = content;
        return result;
    }
}
