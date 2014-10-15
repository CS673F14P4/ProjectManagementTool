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

	public int createProject()
	{
		return -1;
	}
	
	public Project getProject(int projectId)
	{
		System.out.println("getProject");
		Project project = new Project();
		
		SqlSessionFactory factory = DAOSingleton.getInstance().getSqlSessionFactory();
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
		
		SqlSessionFactory factory = DAOSingleton.getInstance().getSqlSessionFactory();
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
	
	public boolean deleteProject()
	{
		return false;
	}
	
}
