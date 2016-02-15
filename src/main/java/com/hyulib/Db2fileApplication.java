package com.hyulib;

import com.hyulib.marcxml.domain.CtMaster;
import com.hyulib.marcxml.service.CtMasterService;
import com.hyulib.userInfo.domain.UserInfo;
import com.hyulib.userInfo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.List;

@SpringBootApplication
public class Db2fileApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(Db2fileApplication.class);

//	@Autowired
//	UserInfoService userInfoService;

    @Autowired
    CtMasterService ctMasterService;

	public static void main(String[] args) {
		SpringApplication.run(Db2fileApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
        if (args.length == 0)
        {
            logger.info("No arguments!");
            System.exit(0);
        } else {
            logger.info("OK! Two arguments.");

////////////////////// PostgreSQL
//    //		StringBuilder sb = new StringBuilder();
//    //		for (String option : args) {
//    //			sb.append(" ").append(option);
//    //		}
//    //		sb = sb.length() == 0 ? sb.append("No Options Specified") : sb;
//    //		System.out.println(sb);
//    //		logger.info(String.format("WAR launched with following options: %s", sb.toString()));
//
//            for (String option : args) {
//                System.out.println(option);
//            }
//            List<UserInfo> users = userInfoService.getFromToUserInfo(args[0], args[1]);
//
//            users.forEach(System.out::println);
//            for (Object userIdName : users) {
//                System.out.print(((UserInfo)userIdName).getUserId() + " ");
//                System.out.println(((UserInfo) userIdName).getUserName() );
//            }
//
//            for (Object user2 : users) {
//                String fileName= ((UserInfo)user2).getUserId();
//                String userInfoString = user2.toString();
//                makeFile(fileName,userInfoString);
//            }



//////////////// Oracle
//            System.out.println(ctMasterService.getCtMaster("000001665485"));

            List<CtMaster> ctMasters = ctMasterService.getFromToCtMaster(args[0], args[1]);

            for (Object ctMaster : ctMasters) {
                String fileName= ((CtMaster)ctMaster).getControlNo();
                System.out.println(fileName);
                String marcXmlData =  ((CtMaster)ctMaster).getMarcXmlData();
//                String marcXml = URLEncoder.encode(marcXmlData,"UTF-8");
                makeFile(fileName,marcXmlData);
            }


		}
	}

	public void makeFile(String fileName, String str){
		try {
//			FileWriter fileWriter = new FileWriter(fileName+".xml");
//
//			fileWriter.write(str);
//			fileWriter.close();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName+".xml");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();




        } catch (IOException e) {
			e.printStackTrace();
		}
	}

}
