package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.MyFile;

public interface FileService {
	public List<MyFile> getFilesByParentId(String id);
	public void addFile(MyFile myFile);
}
