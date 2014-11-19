
package bu.met.cs.cs673.pm.jaxrs.mapper;

import bu.met.cs.cs673.pm.jaxrs.model.Story;
/*
 * Daniel Abramowitz
 */


public class StoryMapper {
	
	public static Story mapStory(bu.met.cs.cs673.pm.dto.Story storyDTO)
	{
		Story story= new Story();
		
		story.setDueDate(storyDTO.getDueDate());
		story.setProjectid(storyDTO.getProjectid());
		story.setStatus(storyDTO.getStatus());
		story.setDescription(storyDTO.getDescription());
		story.setName(storyDTO.getName());
		
		return story;
	}
	
	public static bu.met.cs.cs673.pm.dto.Story mapStory(Story storyWS)
	
	{
		bu.met.cs.cs673.pm.dto.Story story = new bu.met.cs.cs673.pm.dto.Story();
		
		story.setDueDate(storyWS.getDueDate());
		story.setProjectid(storyWS.getProjectid());
		story.setStatus(storyWS.getStatus());
		story.setDescription(storyWS.getDescription());
		story.setName(storyWS.getName());
		
		return story;
	}
}

