package com.cha5.pojo;

public class GameBean {

	private String zhanghao;
	
	private String system;
	
	private String qvfu;
	
	private String job;
	
	public GameBean() {

	}
	
	public GameBean(String zhanghao, String system, String qvfu, String job) {
		super();
		this.zhanghao = zhanghao;
		this.system = system;
		this.qvfu = qvfu;
		this.job = job;
	}


	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getQvfu() {
		return qvfu;
	}

	public void setQvfu(String qvfu) {
		this.qvfu = qvfu;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
