package com.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Transactioninfo {
    private Integer transid;

    private Integer customid;

    private Integer mediaid;

    private Integer ownerid;

    private Integer houseid;

    private String transtatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    
  
	public Date getCreatetime() {
		return createtime;
	}
   
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getTransid() {
		return transid;
	}

	public void setTransid(Integer transid) {
		this.transid = transid;
	}

	public Integer getCustomid() {
		return customid;
	}

	public void setCustomid(Integer customid) {
		this.customid = customid;
	}

	public Integer getMediaid() {
		return mediaid;
	}

	public void setMediaid(Integer mediaid) {
		this.mediaid = mediaid;
	}

	public Integer getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public String getTranstatus() {
		return transtatus;
	}

	public void setTranstatus(String transtatus) {
		this.transtatus = transtatus;
	}

  
}