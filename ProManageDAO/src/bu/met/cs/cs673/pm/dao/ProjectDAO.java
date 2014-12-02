package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bu.met.cs.cs673.pm.dto.Member;
import bu.met.cs.cs673.pm.dto.Project;

/**
 * 
 * @author Luis Marion
 */
public class ProjectDAO 
{

	public static String PROJECT_LEADER_ROLE = "project_leader";
	
	public int createProject(Project project, int userId)
	{
		int projectId = -1;

		if (project == null || userId <= 0)
		{
			projectId = -1;
		}
		else
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
			
			try 
			{
				//insert the project store its id for next insert
				int numrows = session.insert("insertProject", project);
				
				if (numrows > 0)
				{
					projectId = project.getId();
					Member member = new Member(projectId, userId, PROJECT_LEADER_ROLE);

					//insert the initial project leader member as the person who created the project
					session.insert("insertMember", member);
					
					session.commit();
				}
				else
				{
					session.rollback();
				}
			} 
			finally 
			{
			  session.close();
			}
		}
		
		return projectId;
	}
	
	public Project getProject(int projectId)
	{
		Project project = new Project();
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			project = (Project) session.selectOne("getProject", projectId);
		} 
		finally 
		{
		  session.close();
		}
		
		return project;
	}
	
	public List<Project> getProjects(int userId)
	{
		List<Project> projects = null;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			projects = session.selectList("getProjectsByUser", userId);
		} 
		finally 
		{
		  session.close();
		}
		
		return projects;
	}
	
	public boolean updateProject()
	{
		return false;
	}
	
	public boolean deleteProject(int projectId)
	{
		boolean success = false;
		
		int rows = -1;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			//delete any members associated to this project
			session.delete("deleteAllProjectMembers", projectId);
			
			//then delete the project itself
			rows = session.delete("deleteProject", projectId);

			//commit
			session.commit();
		} 
		finally 
		{
		  session.close();
		}
		
		if (rows > 0)
		{
			success = true;
		}
		
		return success;
	}
	
}
