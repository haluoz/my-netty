package com.lxj.mynetty.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lxj.common.annotation.Cmd;
import com.lxj.common.annotation.Module;
import com.lxj.common.proto.Result;
import com.lxj.common.proto.UserModule;
import org.springframework.stereotype.Service;

@Service
@Module(module = "user")
public class UserService {

	//	自动注入相关的spring bean (Service)

	@Cmd(cmd = "save")
	public Result<?> save(byte[] data) {
		UserModule.User user = null;
		try {
			user = UserModule.User.parseFrom(data);
			System.err.println(" save ok , userId: " + user.getUserId() + " ,userName: " + user.getUsername());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(user);
	}

	@Cmd(cmd = "update")
	public Result<?> update(byte[] data) {
		UserModule.User user = null;
		try {
			user = UserModule.User.parseFrom(data);
			System.err.println(" update ok , userId: " + user.getUserId() + " ,userName: " + user.getUsername());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
			return Result.failure();
		}
		return Result.success(user);
	}

}
