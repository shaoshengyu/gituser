package com.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Blackuser {
    private Integer blackid;

    private Integer userid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private String description;

	public Integer getBlackid() {
		return blackid;
	}

	public void setBlackid(Integer blackid) {
		this.blackid = blackid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

   
}