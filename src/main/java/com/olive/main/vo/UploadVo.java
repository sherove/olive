package com.olive.main.vo;

public class UploadVo {
	private String name;
	private String subject;
	private String fileName;
	private String writedate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "UploadVo [name=" + name + ", subject=" + subject + ", fileName=" + fileName + ", writedate=" + writedate
				+ "]";
	}
	
}
