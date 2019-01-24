package com.nncq.sunmoon.entity;

//总文件表
public class MyFile {
	private int file_id;// 文件id
	private String file_name;// 文件名字
	private String file_url;// 文档地址
	private String file_type;// 文件类型
	private String parent_id;// 所属父类id

	public MyFile() {

	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "File [file_id=" + file_id + ", file_name=" + file_name + ", file_url=" + file_url + ", file_type="
				+ file_type + ", parent_id=" + parent_id + "]";
	}

	public MyFile(int file_id, String file_name, String file_url, String file_type, String parent_id) {
		super();
		this.file_id = file_id;
		this.file_name = file_name;
		this.file_url = file_url;
		this.file_type = file_type;
		this.parent_id = parent_id;
	}


}
