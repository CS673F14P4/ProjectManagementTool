package bu.met.cs.cs673.pm.jaxrs.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import bu.met.cs.cs673.pm.dao.TaskDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.TaskMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Task;
import bu.met.cs.cs673.pm.util.UserUtil;

@Path("/project/{projectid}/story/{storyid}/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource 
{

	@GET
	@Path("{taskid}")
	public Task getTask(@PathParam("taskid") int taskid)
	{
		Task task = null;
		
		TaskDAO dao = new TaskDAO();
		bu.met.cs.cs673.pm.dto.Task taskDTO = dao.getTask(taskid);
		
		task = TaskMapper.mapTask(taskDTO);
		
		return task;
	}
	
	@GET
	public List<Task> getTasks(@PathParam("storyid") int storyId)
	{

		List<Task> tasks = new ArrayList<Task>();

		TaskDAO taskDAO = new TaskDAO();
		List<bu.met.cs.cs673.pm.dto.Task> tasksByStory = taskDAO
				.getTasksByStory(storyId);
		System.out.println("taks by story"+storyId);
		for (bu.met.cs.cs673.pm.dto.Task taskDTO : tasksByStory) 
		{
			Task mapTask = TaskMapper.mapTask(taskDTO);
			System.out.println(mapTask.getName());
			tasks.add(mapTask);
		}

		return tasks;
	}
	
	@POST
	public int addtask(@Context SecurityContext context, Task task) 
	{
		
		int taskId = -1;

		//retrieve the userid for the logged in user
		String username = context.getUserPrincipal().getName();
		int userId = UserUtil.getUserId(username);
		
		bu.met.cs.cs673.pm.dto.Task taskDTO = TaskMapper.mapTask(task);
		taskDTO.setOwner(userId);
		taskDTO.setLastModifiedUser(userId);
		
		//create the task and grab its id to return from the service
		TaskDAO dao = new TaskDAO();
		taskId = dao.createTask(taskDTO);

		return taskId;
	}
	
	@PUT
	public Task updatetask(@Context SecurityContext context, Task task)
	{
		//retrieve the userid for the logged in user
		String username = context.getUserPrincipal().getName();
		int userId = UserUtil.getUserId(username);
		
		bu.met.cs.cs673.pm.dto.Task taskDTO = TaskMapper.mapTask(task);
		taskDTO.setLastModifiedUser(userId);

		//create the task and grab its id to return from the service
		TaskDAO dao = new TaskDAO();
		taskDTO = dao.updateTask(taskDTO);
		
		Task updatedtask = TaskMapper.mapTask(taskDTO);

		return updatedtask;
		
	}


}
