package NhomLTWeb.model;

public class UserRole {
	
	private String userID;
	private String roleName;
	
	
	public UserRole(String userID, String roleName) {
		super();
		this.userID = userID;
		this.roleName = roleName;
	}


	public UserRole() {
		super();
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
}
