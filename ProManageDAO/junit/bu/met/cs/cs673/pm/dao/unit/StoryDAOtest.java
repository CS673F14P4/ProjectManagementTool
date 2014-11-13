package bu.met.cs.cs673.pm.dao.unit;

import junit.framework.TestCase;

import org.junit.Test;


import bu.met.cs.cs673.pm.dao.StoryDAO;
import bu.met.cs.cs673.pm.dto.Story;

/**
 * Daniel Abramowitz
 */
public class StoryDAOtest extends TestCase 
{

	private Story story;
	
	@Override
    protected void setUp() throws Exception
    {
        story = new Story();
        
        story.setProjectid(1);
        story.setName("StoryTest");
        story.setDescription("HelloEverybody");
        story.setDueDate(new java.util.Date());
        story.setCreateUser(1);
        story.setLastModifiedUser(1);
        
        StoryDAO dao = new StoryDAO();
		dao.createStory(story);
        
    }

	/*
	@Test
	public void testCreateStory()
	{
		StoryDAO dao = new StoryDAO();
		int storyId = dao.createStory(story);
		
		System.out.println("id: " + storyId);
		
		
		assertTrue(storyId > 0);
		
		boolean success = dao.deleteStory(storyId);
		assertTrue(success);
	}
	*/
	
	
	@Test
	public void testGetStory()
	{
		Story getStory=new Story();
		
		StoryDAO dao = new StoryDAO();
		
		getStory=dao.getStory(4);
		
		System.out.println("Name:"+ getStory.getName());
		System.out.println("Description:"+ getStory.getDescription());
		System.out.println("projectId:"+ getStory.getProjectid());
		
	}
	
	public void testGetByProject()
	{
		
	}
	
	
	
}
