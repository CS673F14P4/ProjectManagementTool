
package bu.met.cs.cs673.pm.dto;

import java.util.Date;

/*
 * Daniel Abramowitz
 * Last Edited 11/19/2014
 */

public class Story {
	
	private int id;
	private int projectid;
	private String name;
	private int status;
	private Date dueDate;
	private int estimate;
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
	public void setName(String name) {
		this.name = name;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	
	public String toString()
	{
		return ("Name: "+ this.getName()+" Status: " +this.getStatus() +" Description: "+this.getDescription()+ " ProjectId: " +this.getProjectid());
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

