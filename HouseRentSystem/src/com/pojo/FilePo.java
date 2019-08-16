package com.pojo;

import org.springframework.web.multipart.MultipartFile;

public class FilePo {
	
	private String descripition;
	private MultipartFile myfile;
	public String getDescripition() {
		return descripition;
	}
	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}
	public MultipartFile getMyfile() {
		return myfile;
	}
	public void setMyfile(MultipartFile myfile) {
		this.myfile = myfile;
	}

}
