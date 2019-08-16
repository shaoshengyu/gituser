package com.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Sellhouseinfo {
    private Integer houseid;

    private Integer ownerid;

    private Integer mediaid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private String rentlength;

    private String locationqu;
    
    private String locationcity;
    
    private String locationprovince;

    private String space;

    private String housestatus;

    private String houseimage;

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public Integer getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public Integer getMediaid() {
		return mediaid;
	}

	public void setMediaid(Integer mediaid) {
		this.mediaid = mediaid;
	}

	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRentlength() {
		return rentlength;
	}

	public void setRentlength(String rentlength) {
		this.rentlength = rentlength;
	}

	public String getLocationqu() {
		return locationqu;
	}

	public void setLocationqu(String locationqu) {
		this.locationqu = locationqu;
	}

	public String getLocationcity() {
		return locationcity;
	}

	public void setLocationcity(String locationcity) {
		this.locationcity = locationcity;
	}

	public String getLocationprovince() {
		return locationprovince;
	}

	public void setLocationprovince(String locationprovince) {
		this.locationprovince = locationprovince;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getHousestatus() {
		return housestatus;
	}

	public void setHousestatus(String housestatus) {
		this.housestatus = housestatus;
	}

	public String getHouseimage() {
		return houseimage;
	}

	public void setHouseimage(String houseimage) {
		this.houseimage = houseimage;
	}

    
}