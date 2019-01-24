package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.FileDao;
import com.nncq.sunmoon.entity.MyFile;
import com.nncq.sunmoon.service.FileService;

@Transactional
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDao fileDao;

	public List<MyFile> getFilesByParentId(String id) {
		List<MyFile> re = null;
		try {
			re = fileDao.getFilesByParentId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void addFile(MyFile myFile) throws RuntimeException{
		fileDao.addFile(myFile);
	}

}
