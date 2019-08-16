package com.cheese.pojo;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Integer userState;
    
    private String userPicture;
    
    private Integer departmentId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	
	
	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}
	

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public User(){
		
	}

	public User(String userName, String userPassword, String userEmail) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	
	public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public User(Integer userId, String userName, String userPassword, String userEmail, Integer userState,
			String userPicture, Integer departmentId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userState = userState;
		this.userPicture = userPicture;
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userState=" + userState + 
				", userPicture=" + userPicture +", departmentId=" + departmentId +"]";
	}

}