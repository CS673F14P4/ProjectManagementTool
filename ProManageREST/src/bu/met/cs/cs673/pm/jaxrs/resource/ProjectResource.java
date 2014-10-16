package bu.met.cs.cs673.pm.jaxrs.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.ProjectMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Project;


@Path("/project")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource 
{
	
	@GET
	public String test()
	{
		System.out.println("test");
		return "test";
	}

	@GET
	@Path("{id}")
	public Response getProject(@PathParam("id") String id)
	{
		System.out.println(">>> getProject");
		
		Project project = null;
		
		ProjectDAO dao = new ProjectDAO();
		bu.met.cs.cs673.pm.dto.Project projectDTO = dao.getProject(Integer.parseInt(id));
		
		
		project = ProjectMapper.mapProject(projectDTO); 
		
		System.out.println("<<< getProject");
		
		return Response.ok(project).type("text/xml").build();
	}
	
	@PUT
	public boolean addProject(
			@QueryParam("name") String name, 
			@QueryParam("description") String description, 
			@QueryParam("startdate") String startDate, 
			@QueryParam("enddate") String endDate)
	{
		boolean success = false;
		
		
		
		return success;
	}
}
