package bu.met.cs.cs673.pm.jaxrs.mapper;

import bu.met.cs.cs673.pm.jaxrs.model.Task;

public class TaskMapper {

	public static Task mapTask(final bu.met.cs.cs673.pm.dto.Task taskDTO) {
		Task task = new Task();
		
		task.setId(taskDTO.getId());
		task.setStoryId(taskDTO.getStoryId());
		task.setName(taskDTO.getName());
		task.setDescription(taskDTO.getDescription());
		task.setCreateDate(taskDTO.getCreateDate());
		task.setDueDate(taskDTO.getDueDate());
		task.setOwner(taskDTO.getOwner());
		task.setLastModifiedDate(taskDTO.getLastModifiedDate());
		task.setLastModifiedUser(taskDTO.getLastModifiedUser());

		return task;
	}

	public static bu.met.cs.cs673.pm.dto.Task mapTask(final Task task)

	{
		bu.met.cs.cs673.pm.dto.Task taskDTO = new bu.met.cs.cs673.pm.dto.Task();

		taskDTO.setId(task.getId());
		taskDTO.setStoryId(task.getStoryId());
		taskDTO.setName(task.getName());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setCreateDate(task.getCreateDate());
		taskDTO.setDueDate(task.getDueDate());
		taskDTO.setOwner(task.getOwner());
		taskDTO.setLastModifiedDate(task.getLastModifiedDate());
		taskDTO.setLastModifiedUser(task.getLastModifiedUser());

		return taskDTO;
	}

}
