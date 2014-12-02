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

import bu.met.cs.cs673.pm.dao.StoryDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.StoryMapper;
import bu.met.cs.cs673.pm.jaxrs.model.Story;
import bu.met.cs.cs673.pm.util.UserUtil;

@Path("{projectid}/story")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoryResource 
{

	@GET
	@Path("/{id}")
	public Story getStory(@PathParam("id") String id) 
	{
		System.out.println(">>> getStory");

		Story story = null;

		StoryDAO dao = new StoryDAO();
		bu.met.cs.cs673.pm.dto.Story StoryDTO = dao.getStory(Integer
				.parseInt(id));

		story = StoryMapper.mapStory(StoryDTO);

		System.out.println("<<< getStory");

		return story;
	}

	@GET
	public List<Story> getStories(@PathParam("projectid") int projectid) 
	{
		System.out.println(">>> getStories");
		
		List<Story> stories = new ArrayList<Story>();

		StoryDAO storyDAO = new StoryDAO();
		List<bu.met.cs.cs673.pm.dto.Story> storiesByProject = 
				storyDAO.storyByProject(projectid);

		if (storiesByProject != null && storiesByProject.size() > 0)
		{
			for (bu.met.cs.cs673.pm.dto.Story storyDTO : storiesByProject) 
			{
				Story story = StoryMapper.mapStory(storyDTO);
				stories.add(story);
			}
		}

		System.out.println("<<< getStories");
		
		return stories;
	}
	
	@PUT
	public boolean editStory(Story story, @Context SecurityContext sc) 
	{

		System.out.println(">>> editStory");
		
		if (story.getId() < 1) 
		{
			throw new IllegalStateException(
					"The id need to be greater than zero.");
		}

		//get userId
		String userName = sc.getUserPrincipal().getName();
		int userId = UserUtil.getUserId(userName);

		bu.met.cs.cs673.pm.dto.Story storyDTO = StoryMapper.mapStory(story);
		storyDTO.setLastModifiedUser(userId);

		StoryDAO storyDAO = new StoryDAO();
		int rows = storyDAO.updateStory(story.getId(), storyDTO);

		System.out.println("<<< editStory");
		
		return rows > 0;
	}

	@POST
	public boolean addStory(Story story, @Context SecurityContext sc) 
	{
		System.out.println(story.getProjectid());

		String userName = sc.getUserPrincipal().getName();
		int userId = UserUtil.getUserId(userName);
		

		bu.met.cs.cs673.pm.dto.Story storyDTO = StoryMapper.mapStory(story);
		storyDTO.setCreateUser(userId);
		storyDTO.setLastModifiedUser(userId);

		StoryDAO storyDAO = new StoryDAO();
		int createStory = storyDAO.createStory(storyDTO);

		return createStory > 1;
	}

}
