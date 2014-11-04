package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bu.met.cs.cs673.pm.dto.Project;

/**
 * 
 * @author Luis Marion
 */
public class ProjectDAO 
{

	public int createProject(Project project)
	{
		int success = -1;
		
		if (project == null)
		{
			success = -1;
		}
		else
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
			
			try 
			{
				success = session.insert("insertProject", project);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
	
		if (success > 0)
		{
			success = project.getId();
		}
		
		return success;
	}
	
	public Project getProject(int projectId)
	{
		System.out.println("getProject");
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
	
	public List<Project> getProjects()
	{
		List<Project> projects = null;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			projects = session.selectList("getProjectsByUser");
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
			rows = session.delete("deleteProject", projectId);
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
