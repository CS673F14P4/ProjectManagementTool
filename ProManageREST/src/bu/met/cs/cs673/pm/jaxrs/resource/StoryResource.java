package bu.met.cs.cs673.pm.jaxrs.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import bu.met.cs.cs673.pm.dao.StoryDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.StoryMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Story;


@Path("/story")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class StoryResource 
{
	
	@GET
	@Path("{id}")
	public Story getStory(@PathParam("id") String id)
	{
		System.out.println(">>> getStory");
		
		Story story = null;
		
		StoryDAO dao = new StoryDAO();
		bu.met.cs.cs673.pm.dto.Story StoryDTO = dao.getStory(Integer.parseInt(id));
		
		
		story = StoryMapper.mapStory(StoryDTO); 
		
		System.out.println("<<< getGet");
		
		return story;
	}
	
	@PUT
	public boolean addStory(
			@QueryParam("name") String name, 
			@QueryParam("projectid") int projectid, 
			@QueryParam("description") String description, 
			@QueryParam("dueDate") String dueDate)
	{
		boolean success = false;
		
		
		
		return success;
	}
}
