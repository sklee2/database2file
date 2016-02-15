package com.hyulib;

import com.hyulib.userInfo.domain.UserInfo;
import com.hyulib.userInfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Db2fileApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(Db2fileApplication.class);

	@Autowired
	UserInfoService userInfoService;
	public static void main(String[] args) {
		SpringApplication.run(Db2fileApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (String option : args) {
			sb.append(" ").append(option);
		}
		sb = sb.length() == 0 ? sb.append("No Options Specified") : sb;
		System.out.println(sb);
		logger.info(String.format("WAR launched with following options: %s", sb.toString()));
		System.out.println(userInfoService.getUserInfo("000A011982"));
		for (String option : args) {
			System.out.println(option);
		}
		List users = userInfoService.getFromToUserInfo(args[0], args[1]);
		for (Object user : users) {
			System.out.println(user);
		}
		for (Object userIdName : users) {
			System.out.print(((UserInfo)userIdName).getUserId() + " ");
			System.out.println(((UserInfo) userIdName).getUserName() + " ");
		}

		for (Object user2 : users) {
			String userId= ((UserInfo)user2).getUserId();
			String userInfo = user2.toString();
			makeFile(userId,userInfo);
		}
	}

	public void makeFile(String fileName, String str){
		try {
			FileWriter fileWriter = new FileWriter(fileName+".xml");
			fileWriter.write((str));
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
