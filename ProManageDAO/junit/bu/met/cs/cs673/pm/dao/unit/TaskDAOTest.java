package bu.met.cs.cs673.pm.dao.unit;

import java.sql.Date;
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
        
        task.setStoryId(1);
        task.setName("unitTestTask");
        task.setDescription("This is a unit test task");
        task.setDueDate(Date.valueOf("2014-12-25"));
        task.setOwner(1);
        task.setEstimate(4);
        task.setRemaining(2);
        task.setStatus("in_progress");
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
		List<Task> tasks = dao.getTasksByStory(1);
		
		for (Task p : tasks)
		{
			System.out.println("task: " + p.getName());
		}
		
		assertNotNull(tasks);
		assertTrue(tasks.size() > 0);
	}
	
	@Test
	public void testUpdateTask()
	{
		TaskDAO dao = new TaskDAO();
		
		int taskId = dao.createTask(task);
		
		Task newTask = dao.getTask(taskId);
		
		newTask.setId(taskId);
		newTask.setName("someTaskUpdateName");
		
		Task updatedTask = dao.updateTask(newTask);
		
		dao.deleteTask(taskId);
		
		assertEquals(updatedTask.getName(), "someTaskUpdateName");
	}
}