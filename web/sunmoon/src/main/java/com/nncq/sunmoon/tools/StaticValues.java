package com.nncq.sunmoon.tools;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nncq.sunmoon.entity.MyFile;
import com.nncq.sunmoon.entity.Power;
import com.nncq.sunmoon.service.PowerService;
import com.nncq.sunmoon.service.impl.PowerServiceImpl;

/**
 * 静态数据
 * 
 * @author duoduo
 *
 */
public class StaticValues {

	/**
	 * 权限列表
	 */
	public static Map<String, Integer> powerMap = new HashMap<String, Integer>();

	/**
	 * 项目文件存放路径
	 */
	public static final String PROJECT_DISK = "D:/sun_moon/";

	/**
	 * 申请招聘文件存放目录
	 */
	public static final String RELEASE_RECRUIT_DISK = PROJECT_DISK + "release_recruit/files/";
	
	/**
	 * 合同模板地址
	 */
	public static final String COMPANY_CONTRACT_DISK = PROJECT_DISK + "company/contract/files/";
	
	/**
	 * 职员文件地址
	 */
	public static final String STAFF_DISK = PROJECT_DISK + "staff/";

	/**
	 * 初始化文件夹
	 */
	static {
		File file=new File(RELEASE_RECRUIT_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
		file=new File(COMPANY_CONTRACT_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
		file=new File(STAFF_DISK);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 获取权限列表
	 * 
	 * @return
	 */
	public static String getPowerMap() {
		String re = "";
		for (String string : powerMap.keySet()) {
			re += string + " ";
		}
		return re;
	}

}
