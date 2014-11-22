package bu.met.cs.cs673.pm.dao.unit;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import bu.met.cs.cs673.pm.dao.TaskDAO;
import bu.met.cs.cs673.pm.dto.Task;

/**
 * TaskDAOTest
 * 
 * 
 * @author Ray
 */
public class TaskDAOTest extends TestCase 
{

	private Task task;
	
	@Override
    protected void setUp() throws Exception
    {
        task = new Task();
        
        task.setName("unitTestTask");
        task.setDescription("This is a unit test task");
        task.setStartDate(new java.util.Date());
        task.setEndDate(new java.util.Date());
        task.setCreateUser(1);
        task.setLastModifiedUser(1);
    }

	@Test
	public void testCreateTask()
	{
		TaskDAO dao = new TaskDAO();
		int taskId = dao.createTask(task);
		
		System.out.println("id: " + taskId);
		
		assertTrue(taskId > 0);
		
		boolean success = dao.deleteTask(taskId);
		assertTrue(success);
	}
	

	@Test
	public void testGetTask()
	{
		TaskDAO dao = new TaskDAO();
		Task task = dao.getTask(1);
		
		System.out.println("task: " + task.getName());
		
		assertNotNull(task);
	}
	
	@Test
	public void testGetTasksByStory()
	{
		TaskDAO dao = new TaskDAO();
		List<Task> tasks = dao.getTasksByStory(3);
		
		for (Task p : tasks)
		{
			System.out.println("task: " + p.getName());
		}
		
		assertNotNull(tasks);
		assertTrue(tasks.size() > 0);
	}
	
}