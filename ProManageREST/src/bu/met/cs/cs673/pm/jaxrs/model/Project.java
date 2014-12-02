package bu.met.cs.cs673.pm.jaxrs.model;

import java.util.Date;
import java.util.List;


public class Project 
{
	private static final String OWNER = "project_leader";
	private int id;
	private String name;
	private String description;
	private String status;
	private Date startDate;
	private Date endDate;
	private List<Member> members;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	public String getOwner() 
	{
		String owner = null;
		
		if (members != null)
		{
			for (Member m : members)
			{
				if (OWNER.equals(m.getRoleName()))
				{
					owner = m.getUserName();
				}
			}
		}
		
		return owner;
	}
}
