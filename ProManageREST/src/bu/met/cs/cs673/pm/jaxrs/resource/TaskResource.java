package bu.met.cs.cs673.pm.jaxrs.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bu.met.cs.cs673.pm.dao.TaskDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.TaskMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Task;

@Path("/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

	@GET
	@Path("{storyid}")
	public List<Task> getTasksByStory(@PathParam("storyid") int storyId) {

		List<Task> tasks = new ArrayList<Task>();

		TaskDAO taskDAO = new TaskDAO();
		List<bu.met.cs.cs673.pm.dto.Task> tasksByStory = taskDAO
				.getTasksByStory(storyId);

		for (bu.met.cs.cs673.pm.dto.Task taskDTO : tasksByStory) {
			Task mapTask = TaskMapper.mapTask(taskDTO);
			tasks.add(mapTask);
		}

		return tasks;

	}

}
