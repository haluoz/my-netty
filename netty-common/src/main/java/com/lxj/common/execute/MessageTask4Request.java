package com.lxj.common.execute;

import com.lxj.common.proto.MessageBuilder;
import com.lxj.common.proto.MessageModule;
import com.lxj.common.proto.Result;
import com.lxj.common.scanner.Invoker;
import com.lxj.common.scanner.InvokerTable;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
public class MessageTask4Request implements Runnable {
    private MessageModule.Message message;

    private ChannelHandlerContext context;

    private final static String invokerReturn = "-return";

    @Override
    public void run() {
        String module = message.getModule();
        String cmd = message.getCmd();
        byte[] data = message.getBody().toByteArray();
        Invoker invoker = InvokerTable.get(module, cmd);
        Result<?> result = (Result<?>) invoker.invoke(data);
        context.writeAndFlush(MessageBuilder.getResponseMessage(
                module+invokerReturn, cmd+invokerReturn,
                result.getResultType(), result.getContent()));

    }

    public MessageTask4Request(MessageModule.Message message, ChannelHandlerContext context) {
        this.message = message;
        this.context = context;
    }
}
