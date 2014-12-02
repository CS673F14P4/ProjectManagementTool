package bu.met.cs.cs673.pm.jaxrs.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.ProjectMapper;
import bu.met.cs.cs673.pm.jaxrs.mapper.UserMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Project;
import bu.met.cs.cs673.pm.jaxrs.model.User;
import bu.met.cs.cs673.pm.util.UserUtil;

@Path("/project")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource 
{
	@GET
	@Path("{projectid}")
	public Project getProject(@PathParam("projectid") int projectid) 
	{

		System.out.println(">>> getProject");

		Project project = null;

		ProjectDAO dao = new ProjectDAO();
		bu.met.cs.cs673.pm.dto.Project projectDTO = dao.getProject(projectid);

		project = ProjectMapper.mapProject(projectDTO);

		System.out.println("<<< getProject");

		return project;
	}

	@GET
	public List<Project> getProjects(@Context SecurityContext sc) 
	{
		System.out.println(">>> getProjects");

		List<Project> projects = null;
		
		String username = sc.getUserPrincipal().getName();
		
		if (username != null) {
			UserDAO userDAO = new UserDAO();
			bu.met.cs.cs673.pm.dto.User userDTO = userDAO
					.getUserByName(username);
			ProjectDAO dao = new ProjectDAO();
			List<bu.met.cs.cs673.pm.dto.Project> projectDTOs = dao
					.getProjects(userDTO.getUserId());

			projects = ProjectMapper.mapProjects(projectDTOs);
		}

		System.out.println("<<< getProjects");

		return projects;
	}

	@GET
	@Path("{projectid}/members")
	public List<User> getMembersProject(@PathParam("projectid") int projectid) 
	{

		List<User> users = new ArrayList<User>();

		UserDAO userDAO = new UserDAO();
		List<bu.met.cs.cs673.pm.dto.User> usersByProject = userDAO
				.getUserByProject(projectid);
		System.out.println(usersByProject.size());
		for (bu.met.cs.cs673.pm.dto.User userDTO : usersByProject) {
			User user = UserMapper.mapUser(userDTO);
			users.add(user);
		}

		return users;

	}
	
	@POST
	public int addProject(@Context SecurityContext sc, Project project) 
	{
		
		int projectId = -1;

		//retrieve the userid for the logged in user
		String username = sc.getUserPrincipal().getName();
		int userId = UserUtil.getUserId(username);
		
		bu.met.cs.cs673.pm.dto.Project projectDTO = ProjectMapper.mapProject(project);
		projectDTO.setCreateUser(userId);
		projectDTO.setLastModifiedUser(userId);
		
		//create the project and grab its id to return from the service
		ProjectDAO dao = new ProjectDAO();
		projectId = dao.createProject(projectDTO, userId);
		

		return projectId;
	}
	
}
