package bu.met.cs.cs673.pm.dao.unit;

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

	@Test
	public void testGetProject()
	{
		ProjectDAO dao = new ProjectDAO();
		Project project = dao.getProject(1);
		
		assertNotNull(project);
	}
}
