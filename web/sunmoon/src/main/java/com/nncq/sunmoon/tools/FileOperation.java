package com.nncq.sunmoon.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.json.JSONArray;

public class FileOperation {

	static JSONArray namespace;
	
	static String lin="";
	/**
	 * 删除文件夹以及所有目录文件
	 * @param file
	 */
	public static void DeleteFolder(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) { // 遍历File[]数组
					DeleteFolder(f);
				}
			}
			file.delete();
		}
	}
	
	public static void copyDirByNameSpace(String sourcePath, String newPath,JSONArray nameSpace,String lin) throws IOException {
		FileOperation.lin=lin;
		namespace=nameSpace;
		copyDir(sourcePath, newPath);
	}
	
	
	public static String getNewName(String oldname) {
		String newName="";
		if (namespace.get(0).toString().equals("&姓名&")) {
			newName=oldname.split("-")[0];
		}else if (namespace.get(0).toString().equals("&编号&")) {
			newName=oldname.split("-")[1];
		}else {
			newName+=namespace.get(0).toString();
		}
		for (int i = 1; i < namespace.size(); i++) {
			if (namespace.get(i).toString().equals("&姓名&")) {
				newName+=lin+oldname.split("-")[0];
			}else if (namespace.get(i).toString().equals("&编号&")) {
				newName+=lin+oldname.split("-")[1];
			}else {
				newName+=lin+namespace.get(i).toString();
			}
		}
		return newName+"."+oldname.split("\\.")[1];
	}

	/**
	 * 拷贝文件夹
	 * @param sourcePath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyDir(String sourcePath, String newPath) throws IOException {
		File file = new File(sourcePath);
		String[] filePath = file.list();

		if (!(new File(newPath)).exists()) {
			(new File(newPath)).mkdir();
		}

		for (int i = 0; i < filePath.length; i++) {
			if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
				copyDir(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
			}
			if (new File(sourcePath + file.separator + filePath[i]).isFile()) {
				copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + getNewName(filePath[i]));
			}

		}
	}

	/**
	 * 拷贝文件
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;

        byte[] buffer=new byte[2097152];
        int readByte = 0;
        while((readByte = in.read(buffer)) != -1){
            out.write(buffer, 0, readByte);
        }
    
        in.close();
        out.close();
    }

}
