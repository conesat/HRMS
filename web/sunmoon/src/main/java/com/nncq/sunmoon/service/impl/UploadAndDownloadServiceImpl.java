package com.nncq.sunmoon.service.impl;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nncq.sunmoon.dao.UploadAndDownloadDao;
import com.nncq.sunmoon.entity.MyFile;
import com.nncq.sunmoon.service.UploadAndDownloadService;

@Transactional
@Service
public class UploadAndDownloadServiceImpl implements UploadAndDownloadService {

	@Autowired
	private UploadAndDownloadDao uploadAndDownloadDao;

	public int addFile(HttpServletRequest request, String path, String parentId, String fileType)
			throws RuntimeException {

		int re = 100;
		System.out.println(path);

		File proFile = new File(path);
		if (!proFile.exists()) {
			proFile.mkdirs();
		}

		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名 按照年月日时分秒进行命名
						String fileName = (new Date()).getTime() + "."
								+ myFileName.substring(myFileName.lastIndexOf(".") + 1);
						// 定义上传路径
						try {
							path = path + fileName;
							// 存文件
							File localFile = new File(path);
							file.transferTo(localFile);
							MyFile myFile = new MyFile();
							myFile.setFile_name(myFileName);
							myFile.setFile_url(path);
							myFile.setParent_id(parentId);
							myFile.setFile_type(fileType);
							uploadAndDownloadDao.addFile(myFile);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							re = 101;
						}
					}
				}
			}

		}
		return re;

	}

}
