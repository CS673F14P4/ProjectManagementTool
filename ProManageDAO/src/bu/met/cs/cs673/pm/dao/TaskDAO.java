package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bu.met.cs.cs673.pm.dto.Task;

/**
 * 
 * @author Ray
 */
public class TaskDAO 
{

	public int createTask(Task task)
	{
		int success = -1;
		
		if (task == null)
		{
			success = -1;
		}
		else
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
			
			try 
			{
				success = session.insert("insertTask", task);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
	
		if (success > 0)
		{
			success = task.getId();
		}
		
		return success;
	}
	
	public Task getTask(int taskId)
	{
		System.out.println("getTask");
		Task task = new Task();
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			task = (Task) session.selectOne("getTask", taskId);
		} 
		finally 
		{
		  session.close();
		}
		
		return task;
	}
	

	public List<Task> getTasks(int storyId)
	{
		List<Task> tasks = null;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			tasks = session.selectList("getTasksByStory", storyId);
		} 
		finally 
		{
		  session.close();
		}
		
		return tasks;
	}
	
	
	public boolean updateTask()
	{
		return false;
	}
	
	public boolean deleteTask(int taskId)
	{
		boolean success = false;
		
		int rows = -1;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			rows = session.delete("deleteTask", taskId);
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
