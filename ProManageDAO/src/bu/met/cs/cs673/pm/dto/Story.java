package bu.met.cs.cs673.pm.dto;

import java.util.Date;

/*
 * Daniel Abramowitz
 * Last Edited 10/15/2014
 */

public class Story {
	
	private int id;
	private String name;
	private int priority;
	private String description;
	private int createUser;
	private Date createDate;
	private Date lastModifiedDate;
	private int lastModifiedUser;
	
	public int getIdstory() {
		return id;
	}
	
	public void setIdstory(int id){
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setTitle(String name) {
		this.name = name;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(int lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

}
