package bu.met.cs.cs673.pm.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

/*
 * Olufemi Odegbile
 */

@XmlRootElement(name = "user")
public class User {

	private int userid;
    private String email;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Date createDate;
    private Date lastModifiedDate;

    public User(){
		
	}
    
	public User(int userid, String email, String username, String password, String firstname, String lastname, Date createDate, Date lastModifiedDate){
		
		this.userid = userid;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
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
	
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
    	this.createDate = createDate;
    }
    
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    public void setLastModifiedDate(Date lastModifiedDate) {
    	this.lastModifiedDate = lastModifiedDate;
    }


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
