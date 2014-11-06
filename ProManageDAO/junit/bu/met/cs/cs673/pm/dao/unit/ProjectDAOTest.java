package bu.met.cs.cs673.pm.dao.unit;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.dto.Project;

/**
 * ProjectDAOTest
 * 
 * 
 * @author Luis Marion
 */
public class ProjectDAOTest extends TestCase 
{

	private Project project;
	
	@Override
    protected void setUp() throws Exception
    {
        project = new Project();
        
        project.setName("unitTestProject");
        project.setDescription("This is a unit test project");
        project.setStartDate(new java.util.Date());
        project.setEndDate(new java.util.Date());
        project.setCreateUser(1);
        project.setLastModifiedUser(1);
    }

	@Test
	public void testCreateProject()
	{
		ProjectDAO dao = new ProjectDAO();
		int projectId = dao.createProject(project);
		
		System.out.println("id: " + projectId);
		
		assertTrue(projectId > 0);
		
		boolean success = dao.deleteProject(projectId);
		assertTrue(success);
	}
	

	@Test
	public void testGetProject()
	{
		ProjectDAO dao = new ProjectDAO();
		Project project = dao.getProject(1);
		
		System.out.println("project: " + project.getName());
		
		assertNotNull(project);
	}
	
	@Test
	public void testGetProjectsByUser()
	{
		ProjectDAO dao = new ProjectDAO();
		List<Project> projects = dao.getProjects(3);
		
		for (Project p : projects)
		{
			System.out.println("project: " + p.getName());
		}
		
		assertNotNull(projects);
		assertTrue(projects.size() > 0);
	}
	
}
