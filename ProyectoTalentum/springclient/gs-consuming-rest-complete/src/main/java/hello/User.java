package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private String id;
	private String name;
	private String mail;
	private String password;
	private boolean superuser;
	private int points;
	private String joindate;
	private String username;
	
	public User() {
		
	}
	
	/*public User(String name, String mail, String password, boolean superuser, String username) {
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.superuser = superuser;
		this.username = username;
		this.points = -1;
		this.superuser = false;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSuperuser() {
		return superuser;
	}

	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{id=" + id 
				+ ", name=" + name + ", mail=" + mail + ", password=" + password + ", superuser="
				+ superuser + ", points=" + points + ", joindate=" + joindate + ", username=" + username + "}";
	}

}
