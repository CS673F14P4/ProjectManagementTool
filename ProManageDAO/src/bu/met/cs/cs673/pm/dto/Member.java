package bu.met.cs.cs673.pm.dto;

public class Member 
{
	private int projectId;
	private int userId;
	private String roleName;
	
	public Member()
	{
		
	}
	
	public Member(int projectId, int userId, String roleName)
	{
		this.projectId = projectId;
		this.userId = userId;
		this.roleName = roleName;
	}
	
	public int getProjectId() 
	{
		return projectId;
	}
	public void setProjectId(int projectId) 
	{
		this.projectId = projectId;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getRoleName() 
	{
		return roleName;
	}
	public void setRoleName(String roleName) 
	{
		this.roleName = roleName;
	}
}
