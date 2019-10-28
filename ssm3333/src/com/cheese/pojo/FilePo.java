package com.cheese.pojo;

import org.springframework.web.multipart.MultipartFile;

public class FilePo {
	
	private MultipartFile myfile;
	
	public MultipartFile getMyfile() {
		return myfile;
	}
	public void setMyfile(MultipartFile myfile) {
		this.myfile = myfile;
	}

}
