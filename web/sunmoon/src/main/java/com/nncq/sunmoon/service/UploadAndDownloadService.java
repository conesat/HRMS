package com.nncq.sunmoon.service;

import javax.servlet.http.HttpServletRequest;


public interface UploadAndDownloadService {
	  public int addFile(HttpServletRequest request, String path,String id,String fileType);
}
