package bu.met.cs.cs673.pm.dto;

import java.util.Date;
/**
 * 
 * @author Luis Marion
 */
public class Project
{
	private int id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Date createDate;
	private int createUser;
	private Date lastModifiedDate;
	private int lastModifiedUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public int getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(int lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
}
