package com.lxj.common.execute;

import com.lxj.common.proto.MessageModule;
import com.lxj.common.scanner.Invoker;
import com.lxj.common.scanner.InvokerTable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Xingjing.Li
 * @since 2021/10/28
 */
public class MessageTask4Response implements Runnable {
    private MessageModule.Message message;
    private ChannelHandlerContext context;

    public MessageTask4Response (MessageModule.Message message, ChannelHandlerContext context){
        this.context = context;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            // xxx-return
            String module = this.message.getModule();
            String cmd = this.message.getCmd();
            //响应的结果
            MessageModule.ResultType resultType = this.message.getResultType();
            byte[] data = this.message.getBody().toByteArray();
            Invoker invoker = InvokerTable.get(module, cmd);
            invoker.invoke(resultType, data);
        } finally {
            ReferenceCountUtil.release(message);
        }

    }
}
