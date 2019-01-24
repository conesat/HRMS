package com.nncq.sunmoon.dao;

import java.util.List;

import com.nncq.sunmoon.entity.MyFile;

public interface FileDao {
	public List<MyFile> getFilesByParentId(String id);
	public void addFile(MyFile myFile);
}
