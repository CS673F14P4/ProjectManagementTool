package bu.met.cs.cs673.pm.dto;

import java.sql.Timestamp;

public class User {

	private int userid;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Timestamp create_time;

    public User(){
		
	}
    
	public User(int userid, String email, String username, String password, String firstname, String lastname, Timestamp create_time){
		
		this.userid = userid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.create_time = create_time;
		
	}
	
	public int getUserId() {
        return userid;
	}
	
	 public void setUserId(int userid) {
         this.userid = userid;
	 }

    public String getEmail() {
            return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFirstname() {
            return firstname;
    }

    public void setFirstname(String firstname) {
            this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }	
	
    public Timestamp getCreate_Time() {
        return create_time;
    }
    

    public void setCreate_Time(Timestamp create_time) {
    	this.create_time = create_time;
    }
    
}
