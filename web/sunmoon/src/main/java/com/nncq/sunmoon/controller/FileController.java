package com.nncq.sunmoon.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.nncq.sunmoon.entity.MyFile;
import com.nncq.sunmoon.service.FileService;
import com.nncq.sunmoon.tools.StaticValues;

import net.sf.json.JSONObject;

/**
 * 文件读取
 * 
 * @author 拉布拉多是条狗
 *
 */
@RequestMapping("file")
@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "getFilesByParentId", method = RequestMethod.GET)
	public void getFilesByParentId(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		List<MyFile> list = fileService.getFilesByParentId(id);
		json.put("code", 0);
		json.put("data", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(HttpServletResponse response, HttpServletRequest request, String id) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询

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
					try {
						myFileName = new String(myFileName.getBytes("ISO-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名 按照年月日时分秒进行命名
						String fileName = (new Date()).getTime() + "."
								+ myFileName.substring(myFileName.lastIndexOf(".") + 1);
						// 定义上传路径
						try {

							String path = StaticValues.RELEASE_RECRUIT_DISK + fileName;
							// 存文件
							File localFile = new File(path);
							file.transferTo(localFile);
							MyFile myFile = new MyFile();
							myFile.setFile_name(myFileName);
							myFile.setFile_url(path);
							myFile.setParent_id(id);
							myFile.setFile_type("recruit");
							fileService.addFile(myFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		}

		json.put("code", 100);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查看文件
	 * @param response
	 * @param path
	 * @throws Exception
	 */
	@RequestMapping(value = "getFile", method = RequestMethod.GET)
	public static void getPhoto(HttpServletResponse response, String path) throws Exception {
		String type = "";
		String fileType = path.substring(path.lastIndexOf(".") + 1);
		if (fileType.equals("png") || fileType.equals("Png") || fileType.equals("PNG") || fileType.equals("Jpg")
				|| fileType.equals("jpg") || fileType.equals("JPG")) {
			type="image/"+fileType;
		}else if (fileType.equals("pdf")){
			type="application/pdf";
		}
		File file = new File(path);
		if (file.exists()) {
			FileInputStream fis;
			fis = new FileInputStream(file);
			long size = file.length();
			byte[] temp = new byte[(int) size];
			fis.read(temp, 0, (int) size);
			fis.close();
			byte[] data = temp;
			response.setContentType(type);
			OutputStream out = response.getOutputStream();
			out.write(data);
			out.flush();
			out.close();
		}else {
			response.getWriter().println("找不到文件");
		}
	}
	
	/**
	 * 验证是否支持在线查看
	 * @param response
	 * @param request
	 * @param path
	 */
	@RequestMapping(value = "verifyFile", method = RequestMethod.GET)
	public void verifyFile(HttpServletResponse response, HttpServletRequest request, String path) {
		JSONObject json = new JSONObject();
		response.setCharacterEncoding("UTF-8");
		// 执行查询
		String fileType = path.substring(path.lastIndexOf(".") + 1);
		if (fileType.equals("png") || fileType.equals("Png") || fileType.equals("PNG") || fileType.equals("Jpg")
				|| fileType.equals("jpg") || fileType.equals("JPG")||fileType.equals("pdf")||fileType.equals("Pdf")||fileType.equals("PDF")) {
			json.put("code", 100);
		}else {
			json.put("code", 101);
		}
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载文件
	 * @param path
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "downLoadFile", method = RequestMethod.GET)
	public void downLoadFile(String path,String fileName, HttpServletResponse response) throws Exception {
		File f = new File(path);
		if (fileName==null) {
			fileName = f.getName();
		}else {
			fileName+="."+f.getName().substring(f.getName().lastIndexOf(".") + 1);
		}
		InputStream inStream = new FileInputStream(f);
		response.reset();
		response.setContentType("bin");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		byte[] b = new byte[100];
		int len;
		try {
			while ((len = inStream.read(b)) > 0)
				response.getOutputStream().write(b, 0, len);
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
