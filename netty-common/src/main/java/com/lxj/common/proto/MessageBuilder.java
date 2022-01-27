package com.lxj.common.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageV3;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
public class MessageBuilder {

    private static final int crcCode = 0xabef0101;

    /**
     * 响应封装
     * @param module
     * @param cmd
     * @param resultType
     * @param data
     * @return
     */
    public static MessageModule.Message getResponseMessage(String module, String cmd, MessageModule.ResultType resultType,
                                                           GeneratedMessageV3 data){
        return MessageModule.Message.newBuilder()
                .setCrcCode(crcCode)
                .setModule(module)
                .setCmd(cmd)
                .setResultType(resultType)
                .setMessageType(MessageModule.MessageType.RESPONSE)
                .setBody(ByteString.copyFrom(data.toByteArray())).build();
    }

    /**
     * 请求封装
     * @param module
     * @param cmd
     * @param data
     * @return
     */
    public static MessageModule.Message getRequestMessage(String module, String cmd, GeneratedMessageV3 data){
        return MessageModule.Message.newBuilder()
                .setCrcCode(crcCode)
                .setModule(module)
                .setCmd(cmd)
                .setMessageType(MessageModule.MessageType.REQUEST)
                .setBody(ByteString.copyFrom(data.toByteArray())).build();
    }
}
