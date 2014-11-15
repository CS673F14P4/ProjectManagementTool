package bu.met.cs.cs673.pm.jaxrs.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.dao.StoryDAO;
import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.ProjectMapper;
import bu.met.cs.cs673.pm.jaxrs.mapper.StoryMapper;
import bu.met.cs.cs673.pm.jaxrs.mapper.UserMapper;
import bu.met.cs.cs673.pm.jaxrs.mapper.UserWrapper;
import bu.met.cs.cs673.pm.jaxrs.model.Project;
import bu.met.cs.cs673.pm.jaxrs.model.Story;
import bu.met.cs.cs673.pm.jaxrs.model.User;
import bu.met.cs.cs673.pm.jaxrs.wrapper.StoryWrapper;

@Path("/project")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {

	@GET
	public String test() {
		System.out.println("test");
		return "test";
	}

	@GET
	@Path("{projectid}")
	public Project getProject(@PathParam("projectid") int projectid) {

		System.out.println(">>> getProject");

		Project project = null;

		ProjectDAO dao = new ProjectDAO();
		bu.met.cs.cs673.pm.dto.Project projectDTO = dao.getProject(projectid);

		project = ProjectMapper.mapProject(projectDTO);

		System.out.println("<<< getProject");

		return project;
	}

	@GET
	@Path("{projectid}/stories")
	public StoryWrapper getStoriesByProject(
			@PathParam("projectid") int projectid) {

		List<Story> stories = new ArrayList<Story>();

		StoryDAO storyDAO = new StoryDAO();
		List<bu.met.cs.cs673.pm.dto.Story> storiesByProject = storyDAO
				.storyByProject(projectid);
		System.out.println(storiesByProject.size());
		for (bu.met.cs.cs673.pm.dto.Story storyDTO : storiesByProject) {
			Story story = StoryMapper.mapStory(storyDTO);
			stories.add(story);
		}

		StoryWrapper storyWrapper = new StoryWrapper();
		storyWrapper.setStories(stories);

		return storyWrapper;

	}

	@GET
	@Path("{projectid}/members")
	public UserWrapper getMembersProject(@PathParam("projectid") int projectid) {

		List<User> users = new ArrayList<User>();

		UserDAO userDAO = new UserDAO();
		List<bu.met.cs.cs673.pm.dto.User> usersByProject = userDAO
				.getUserByProject(projectid);
		System.out.println(usersByProject.size());
		for (bu.met.cs.cs673.pm.dto.User userDTO : usersByProject) {
			User user = UserMapper.mapUser(userDTO);
			users.add(user);
		}

		UserWrapper userWrapper = new UserWrapper();

		userWrapper.setUsers(users);

		return userWrapper;

	}

	@PUT
	public boolean addProject(@QueryParam("name") String name,
			@QueryParam("description") String description,
			@QueryParam("startdate") String startDate,
			@QueryParam("enddate") String endDate) {
		boolean success = false;

		return success;
	}
}
